package com.biblioteca.user;

import com.biblioteca.book.Book;
import com.biblioteca.token.Token;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

  @Id
  @GeneratedValue
  private Integer id_usuario;
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  @Builder.Default
  @Enumerated(EnumType.STRING)
  private Role role = Role.USER;
  @OneToMany(mappedBy = "user")
  private List<Token> tokens;
  @OneToOne(mappedBy = "lentTo")
  private Book borrowedBook;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (role != null) {
      return role.getAuthorities();
    }
    return Collections.emptyList();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
