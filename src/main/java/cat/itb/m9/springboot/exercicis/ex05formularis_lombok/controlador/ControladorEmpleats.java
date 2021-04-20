package cat.itb.m9.springboot.exercicis.ex05formularis_lombok.controlador;


import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat.Empleat;
import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat.Usuari;
import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.servei.EmpleatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorEmpleats {

    @Autowired
    public EmpleatServices service;

    @GetMapping("/empleats/list")
    public String llistar(Model m){
        m.addAttribute("llistaEmpleats",service.llistat());
        return "llistat";
    }

    //ordenats per nomm
    @GetMapping("/empleats/listOrdenat")
    public String llistarOrdenat(Model m){
        m.addAttribute("llistaEmpleats",service.llistatOrdenatPerNom());
        return "llistatOrdenatPerNom";
    }

    //ordenats per email
    @GetMapping("/empleats/listOrdenatEmail")
    public String llistarOrdenatperemail(Model m){
        m.addAttribute("llistaEmpleats",service.llistatOrdenatPerCorreu());
        return "llistatOrdenatPerCorreo";
    }

    @GetMapping("/empleats/directius")
    public String llistarDirectius(Model m){
        m.addAttribute("llistaEmpleats",service.llistatMostrarDirectius());
        return "llistatDirectius";
    }
    //eliminar ex5
    @GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int id){
        service.eliminarPerId(id);

        return "redirect:/empleats/list";
    }

    @GetMapping("/empleats/edit/{id}")
    public String modificarMaker(@PathVariable("id")  int  id){
        Empleat  empleat= service.consultaPerId(id);
        service.eliminarPerId(id);


        return "redirect:/empleats/modificar";
    }
    @GetMapping("/modificar/sumbit/{id}")
    public String modificar(@PathVariable("id") int id){



        return "redirect:/empleats/list";
    }

    @GetMapping("/empleats/modificar")
    public String modificarEmpleat(Model m){
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
        m.addAttribute("empleatForm",new Empleat());
        return "afegirusuari";
    }



    /* inici de l'aplicació. Anem a afegir Empleats amb un formulari*/
    @GetMapping("/empleats/new")
    public String afegirEmpleat(Model m){
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
       m.addAttribute("empleatForm",new Empleat());
        return "afegirusuari";
    }


    //ex4
    @PostMapping("/empleats/new/submit")
    //empleatForm és el nom de l'objecte que es recull al formulari, el CommandObject (bean)
    //https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html#handling-the-command-object
    public String afegirSubmit(@ModelAttribute("empleatForm") Empleat emp){

        if (emp.getId()==0){
            emp.setId(service.llistat().size()+1);
            service.afegir(emp);
        }else {
            service.eliminarPerId(emp.getId());
            service.subsistuir(emp);
        }

      return "redirect:/empleats/list";
    }
}
