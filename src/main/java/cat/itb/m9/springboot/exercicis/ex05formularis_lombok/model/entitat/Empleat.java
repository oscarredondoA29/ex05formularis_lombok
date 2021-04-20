package cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@NoArgsConstructor

@Entity
public class Empleat {
    @Id
    private int id;
    private String nom;
    private String email;
    private String telefon;
    private Boolean directiu;


    public Empleat(int id, String nom, String email, String telefon, Boolean directiu) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telefon = telefon;
        this.directiu = directiu;
    }
}
