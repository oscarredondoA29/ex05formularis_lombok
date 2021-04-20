package cat.itb.m9.springboot.exercicis.ex05formularis_lombok.rest;


import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat.Empleat;
import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.servei.EmpleatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRest {

    @Autowired
    private EmpleatServices servei;


    //ex5
    @GetMapping ("modificarrest/{id}/{nom}/{email}/{telefon}/{directiu}")
    public String modificarRest(@PathVariable("id") int id,@PathVariable("nom")  String nom,
                                @PathVariable("email")String email, @PathVariable("telefon")String telefon,@PathVariable("directiu")Boolean directiu) {
        Empleat emp = new Empleat(id, nom, email, telefon, directiu);
        if (emp.getId() == 0) {
            emp.setId(servei.llistat().size() + 1);
            servei.afegir(emp);
        } else {
            servei.eliminarPerId(emp.getId());
            servei.subsistuir(emp);
        }

        return emp.toString() +"  modificado"  ;
    }


}
