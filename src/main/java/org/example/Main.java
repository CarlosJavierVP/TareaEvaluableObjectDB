package org.example;

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




    }
}