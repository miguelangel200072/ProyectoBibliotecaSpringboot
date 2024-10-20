package com.example.biblioteca.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.biblioteca.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UsuarioService usuarioService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/auth/**") // Ignorar CSRF para rutas de autenticación
            )
            .authorizeRequests()
            .requestMatchers("/auth/**").permitAll() // Permitir acceso a las rutas de autenticación
            .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
            .and()
            .formLogin() // Habilitar el inicio de sesión con formulario
            .and()
            .logout()
            .logoutUrl("/auth/logout") // URL para cerrar sesión
            .logoutSuccessUrl("/auth/login?logout=true") // URL de redirección después de cerrar sesión
            .invalidateHttpSession(true) // Invalidar sesión
            .clearAuthentication(true) // Limpiar autenticación
            .permitAll();

        return http.build();
    }





    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Para encriptar contraseñas
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}
