package kz.hovo.sso.entity;

import jakarta.persistence.*;
import kz.hovo.sso.entity.BaseEntity.BaseEntity;
import kz.hovo.sso.entity.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(unique = true, updatable = true)
    private String username;
    @Column(nullable = false)
    private String lastname;
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "text")
    private String bio;
    @Column(length = 3000)
    private String password;

    @ElementCollection(targetClass = ERole.class)
    @CollectionTable(name = "users_role",
    joinColumns = @JoinColumn(name = "users_id"))
    private Set<ERole> roles = new HashSet<>();

    @Transient
    private Collection<? extends GrantedAuthority> authorities;

}
