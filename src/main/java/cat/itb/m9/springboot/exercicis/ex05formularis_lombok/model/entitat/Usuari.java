package cat.itb.m9.springboot.exercicis.ex05formularis_lombok.model.entitat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuari {

    @Id
    private String username;
    private String password;
    private String rol;


    public Usuari(String username, String password) {
        this.username = username;
        this.password = password;
        rol = "USER";
    }
}
