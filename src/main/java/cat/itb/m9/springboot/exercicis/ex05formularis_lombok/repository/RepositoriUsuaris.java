package cat.itb.m9.springboot.exercicis.ex05formularis_lombok.repository;

import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat.Usuari;
import org.springframework.data.repository.CrudRepository;

public interface RepositoriUsuaris extends CrudRepository<Usuari,String> {

}

