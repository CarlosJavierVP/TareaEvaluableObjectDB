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

    @Id
    private String correo;
    private String nombre;

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Comentario> comentarios = new ArrayList<>();


    public void addComentario(Comentario c) {
        comentarios.add(c);
        c.setUsuario(this);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", comentarios=" + comentarios +
                '}';
    }
}
