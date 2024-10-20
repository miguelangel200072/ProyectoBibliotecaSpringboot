package com.example.biblioteca.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Collection;

@Entity
public class UsuarioModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String role;

    // Agrega otros campos según sea necesario

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Devuelve los roles del usuario aquí
        return null; // Puedes retornar roles si los tienes
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Lógica de expiración de la cuenta
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Lógica de bloqueo de la cuenta
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Lógica de expiración de credenciales
    }

    @Override
    public boolean isEnabled() {
        return true; // Lógica de habilitación del usuario
    }

    // Getters y Setters para los campos adicionales
}

