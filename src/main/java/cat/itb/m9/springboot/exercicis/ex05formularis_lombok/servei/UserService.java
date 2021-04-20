package cat.itb.m9.springboot.exercicis.ex05formularis_lombok.servei;


import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat.Usuari;

import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.repository.RepositoriUsuaris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private RepositoriUsuaris repository ;

    @PostConstruct
    public void init(){
//        repository.addAll(
////                Arrays.asList(
////                         new Usuari("oscar",BCrypt.hashpw("oscar",BCrypt.gensalt(7)),"ADMIN"),
////                        new Usuari("raul",BCrypt.hashpw("raul",BCrypt.gensalt(7)),"USER"))
////                );
////
        repository.save(new Usuari("oscar",BCrypt.hashpw("oscar",BCrypt.gensalt(7)),"ADMIN"));
        repository.save(new Usuari("raul",BCrypt.hashpw("raul",BCrypt.gensalt(7)),"USER"));
    }

    public Usuari consultaPerId(String s) {
        
        return repository.findById(s).orElse(null);
    }

    public void afegirUsuari(Usuari usuari){
        usuari.setPassword(BCrypt.hashpw(usuari.getPassword(),BCrypt.gensalt(7)));
        usuari.setRol("USER");
        repository.save(usuari);
    }





}
