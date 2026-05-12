package com.ilian.authcore.repositories;

import com.ilian.authcore.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
