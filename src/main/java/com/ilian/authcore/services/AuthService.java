package com.ilian.authcore.services;

import com.ilian.authcore.dto.LoginRequestDto;
import com.ilian.authcore.dto.LoginResponseDto;
import com.ilian.authcore.dto.RegisterRequestDto;
import com.ilian.authcore.dto.RegisterResponseDto;
import com.ilian.authcore.models.RefreshToken;
import com.ilian.authcore.models.User;
import com.ilian.authcore.models.UserRole;
import com.ilian.authcore.repositories.RefreshTokenRepository;
import com.ilian.authcore.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final RefreshTokenRepository refreshRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepo, RefreshTokenRepository refreshRepo, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.userRepo = userRepo;
        this.refreshRepo = refreshRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public RegisterResponseDto register(RegisterRequestDto dto){

        User userToRegister = new User();
        Optional<User> isUserPresent = userRepo.findByEmail(dto.getEmail());

        if(isUserPresent.isPresent()){
            throw new RuntimeException("User already exist");
        }

        try{

            userToRegister.setFirstName(dto.getFirstName());
            userToRegister.setLastName(dto.getLastName());
            userToRegister.setEmail(dto.getEmail());
            userToRegister.setPassword(passwordEncoder.encode(dto.getPassword()));
            userToRegister.setBirthdate(dto.getBirthdate());
            userToRegister.setAddress(dto.getAddress());
            userToRegister.setCity(dto.getCity());
            userToRegister.setCountry(dto.getCountry());
            userToRegister.setPhoneNumber(dto.getPhoneNumber());
            userToRegister.setRole(UserRole.USER);
            userToRegister.setEnabled(true);

            User savedUser = userRepo.save(userToRegister);
            RegisterResponseDto registeredUser = new RegisterResponseDto();
            registeredUser.setEmail(savedUser.getEmail());
            registeredUser.setFirstName(savedUser.getFirstName());
            registeredUser.setLastName(savedUser.getLastName());

            System.out.println("===== User successfully registered =====");
            return registeredUser;

        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to register a new user");
        }
    }

    public LoginResponseDto login(LoginRequestDto dto){

        try{
            User user = userRepo.findByEmail(dto.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
            if(passwordEncoder.matches(dto.getPassword(), user.getPassword())){
                // Délivrer le token ?
                String token = jwtService.generateToken(user);

                LoginResponseDto loginDto = new LoginResponseDto();
                RefreshToken refreshToken = new RefreshToken();
                refreshToken.setToken(UUID.randomUUID().toString());
                refreshToken.setUser(user);
                refreshToken.setExpiresAt(LocalDateTime.now().plusDays(7));
                refreshToken.setUsed(false);
                refreshToken.setRevoked(false);
                loginDto.setToken(token);
                loginDto.setRefreshToken(refreshToken.getToken());

                refreshRepo.save(refreshToken);
                return loginDto;
            }
            throw new RuntimeException("Identifiants invalides");
        } catch (RuntimeException e) {
            throw new RuntimeException("Error during login");
        }

    }


}
