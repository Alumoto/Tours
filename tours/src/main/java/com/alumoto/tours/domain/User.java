package com.alumoto.tours.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Collection;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "users")
@Data
//@ToString(exclude = "tours")
public class User  implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_user_id_seq")
    @SequenceGenerator(
        name = "user_user_id_seq",
        sequenceName = "user_user_id_seq",
        initialValue = 1,
        allocationSize = 1)
    @Column(nullable = false, unique = true)
    private Integer userId;

    @NotNull
    @Column(nullable = false)
    private String userName;

    @JsonIgnore
    private String encodedPassword;

    @Column(nullable=false, updatable=false)
    private Date createdAt;
 
    @Column(nullable=false)
    private Date updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    @Override
    public String getUsername() {
        return this.userName;
    }

    public boolean isAccountNonExpired() {
        return true;
    }
 
    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return this.encodedPassword;
    }
}