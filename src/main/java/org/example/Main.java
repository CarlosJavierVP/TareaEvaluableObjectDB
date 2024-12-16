package org.example;

import org.example.entities.Comentario;
import org.example.entities.Usuario;
import org.example.persistence.config.ObjectDBUtil;
import org.example.persistence.dao.Services;

public class Main {
    public static void main(String[] args) {


        Services s = new Services(ObjectDBUtil.getEmf());

        /**
         * 1ª Historia de Usuario - ej práctico
         */
        /*
        Usuario u = new Usuario();
        u.setNombre("CarlosJavier");
        u.setCorreo("jajauja@correo.com");

        //s.saveUser(u);

        System.out.println(u.getNombre());

         */

        /**
         * 2ª Historia de Usuario - ej práctico
         */

        s.comentariosByValoracion(7).forEach(System.out::println);

        /**
         * 3ª Historia de Usuario - ej práctico
         */
        /*
        Usuario u2 = new Usuario();
        u2.setNombre("Francisco");
        u2.setCorreo("francisco@correo.com");

        s.saveUser(u2);

        Comentario c = new Comentario();
        c.setTextoComentario("No es un examen");
        c.setValoracion(9);

        u2.addComentario(c);
        s.saveComentario(u2);

        System.out.println(u2);

         */

        /**
         * 4ª Historia de Usuario - ej práctico
         */

        //s.deleteTrolls(1L);











    }
}