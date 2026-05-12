package com.ilian.authcore.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "permission")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
