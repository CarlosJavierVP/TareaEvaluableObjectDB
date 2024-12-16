package org.example.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;
    private String textoComentario;
    private int valoracion;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "correo")
    private Usuario usuario;


    @Override
    public String toString() {
        return "Comentario{" +
                "idComentario=" + idComentario +
                ", textoComentario='" + textoComentario + '\'' +
                ", valoracion=" + valoracion +
                ", usuario=" + usuario.getNombre() +
                '}';
    }
}
