package org.example.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Usuario implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String correo;
    private String nombre;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios = new ArrayList<>();


    public void addComentario(Comentario c) {
        comentarios.add(c);
        c.setUsuario(this);
    }

}
