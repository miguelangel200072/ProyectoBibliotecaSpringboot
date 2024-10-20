package com.example.biblioteca.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.UsuarioModel;
import com.example.biblioteca.repository.UsuarioRepository;
import com.example.biblioteca.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UsuarioModel findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel usuario = findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        return usuario; // Asegúrate de que UsuarioModel implemente UserDetails
    }


    public UsuarioModel save(UsuarioModel usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword())); // Encriptar contraseña
        return usuarioRepository.save(usuario);
    }
}
