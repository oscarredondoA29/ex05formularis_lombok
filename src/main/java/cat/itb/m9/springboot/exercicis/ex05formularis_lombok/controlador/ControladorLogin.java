package cat.itb.m9.springboot.exercicis.ex05formularis_lombok.controlador;

import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat.Empleat;
import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat.Usuari;
import cat.itb.m9.springboot.exercicis.ex05formularis_lombok.servei.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLogin {


    @Autowired
    private UserService userService;

//
    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/error")
    public String error(){
        return "error.html";
    }

    /* inici de l'aplicació. Anem a afegir Empleats amb un formulari*/
    @GetMapping("/register/new")
    public String afegirEmpleat(Model m){
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
        m.addAttribute("usuariForm",new Usuari());
        return "afegir";
    }


    //ex4
    @PostMapping("/register/new/submit")
    public String afegirUsuari(@ModelAttribute("usuariForm") Usuari usuari){
        userService.afegirUsuari(usuari);

        return "redirect:/";
    }




}
