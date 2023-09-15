package com.api.rest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
public class User {

    @Id
    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(length = 50)
    private String email;

    @Column(nullable = false)
    private Boolean locked;

    @Column(nullable = false)
    private Boolean disabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRole> roles;
}