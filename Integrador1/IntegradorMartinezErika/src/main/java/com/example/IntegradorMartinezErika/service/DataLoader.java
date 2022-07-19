package com.example.IntegradorMartinezErika.service;


import com.example.IntegradorMartinezErika.model.Usuario;
import com.example.IntegradorMartinezErika.model.UsuarioRol;
import com.example.IntegradorMartinezErika.repository.UsuarioRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;

    public DataLoader(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        String password1 =  passwordEncoder1.encode("password1");

        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String password2 =  passwordEncoder2.encode("password2");


        Usuario usuario1 = new Usuario("Admin", "admin", "admin@dh.com", password1, UsuarioRol.ADMIN);
        Usuario usuario2 = new Usuario("User", "user", "user@dh.com", password2, UsuarioRol.USER);
        this.usuarioRepository.save(usuario1);
        this.usuarioRepository.save(usuario2);
    }
}
