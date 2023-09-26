package com.uco.managewood.procesadormanagewood.service.jwt;

//import com.uco.managewood.apimanagewood.domain.colaborador.Colaborador;
//import com.uco.managewood.apimanagewood.repository.colaborador.IColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IColaboradorRepository colaboradorRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Colaborador user = colaboradorRepository.findByCorreo(correo);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + correo);
        }
        return new org.springframework.security.core.userdetails.User(user.getCorreo(), user.getPassword(),
                new ArrayList<>());
    }

    public Colaborador save(Colaborador colaborador) {
        colaborador.setPassword(bcryptEncoder.encode(colaborador.getPassword()));
        return colaboradorRepository.save(colaborador);
    }

}
*/
