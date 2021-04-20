package cat.itb.m9.springboot.exercicis.ex05formularis_lombok.repository;

import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat.Empleat;
import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat.Usuari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoriEmpleats extends JpaRepository<Empleat,Integer> {
    public List<Empleat> findAllByOrderByNomAsc();
    public List<Empleat> findAllByOrderByEmailAsc();
    public List<Empleat> findAllByDirectiuIsTrue();
}
