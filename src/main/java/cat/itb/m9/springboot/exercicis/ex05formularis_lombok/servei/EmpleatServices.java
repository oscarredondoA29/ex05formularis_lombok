package cat.itb.m9.springboot.exercicis.ex05formularis_lombok.servei;

import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat.Empleat;
import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.repository.RepositoriEmpleats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class EmpleatServices {
    @Autowired
    private RepositoriEmpleats repositori;
    public void afegir(Empleat e) {
        repositori.save(e);
    }
    public List<Empleat> llistat() {
        return (List<Empleat>) repositori.findAll();
    }
    public List<Empleat> llistatOrdenatPerNom() {
        return repositori.findAllByOrderByNomAsc();
    }
    public List<Empleat> llistatMostrarDirectius() {
        return repositori.findAllByDirectiuIsTrue();
    }

    public List<Empleat> llistatOrdenatPerCorreu() {
        return repositori.findAllByOrderByEmailAsc();
    }
//    }
    public Empleat consultaPerId(int id){
       return repositori.findById(id).orElse(null);
    }
    public void eliminarPerId(int  id){
        repositori.deleteById(id);

    }



    public void subsistuir(Empleat e){
        repositori.save(e);
    }

    @PostConstruct
    public void init() {

            repositori.save(new Empleat(1, "Montse Madridejos", "montse@itb.cat", "777123456",true));
              repositori.save(new Empleat(2, "Alberto Vila", "alberto@itb.cat", "699876543",true));
                       repositori.save(new Empleat(3, "Robert López", "robert@bbc.com", "123456789",false));

    }
}
