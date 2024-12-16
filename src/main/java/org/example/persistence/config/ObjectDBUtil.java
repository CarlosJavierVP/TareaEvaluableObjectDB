package org.example.persistence.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObjectDBUtil {

    private static EntityManagerFactory emf;


    static{
        emf = Persistence.createEntityManagerFactory("data.odb");
    }

    public static EntityManagerFactory getEmf(){
        return emf;
    }

}
