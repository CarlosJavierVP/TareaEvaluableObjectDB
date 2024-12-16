package org.example.persistence.dao;

import org.example.entities.Comentario;
import org.example.entities.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class Services {

    private static EntityManagerFactory emf;

    public Services(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * 1ªHistoria de usuario
     * Metodo guardar usuario
     * @param user usuario
     */
    public void saveUser(Usuario user) {
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            emf.close();
        }
    }


    /**
     * 2ª Historia de Usuario
     * @param puntuacion puntuacion
     * @return lista de comentarios puntuados segun parámetro
     */
    public List<Comentario> comentariosByValoracion(int puntuacion) {
        List<Comentario> comentarios = null;
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            TypedQuery<Comentario> query = em.createQuery("SELECT c FROM Comentario c WHERE c.valoracion >= :valor", Comentario.class);
            query.setParameter("valor", puntuacion);
            comentarios = query.getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return comentarios;
    }

    /**
     * 3ª Historia de Usuario
     * @param u usuario
     */
    public void saveComentario(Usuario u) {
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            emf.close();
        }
    }

    /**
     * 4ª Historia de Usuario
     * @param id id de usuario
     */
    public void deleteTrolls(Long id) {

        Usuario user = null;
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            user = em.find(Usuario.class, id);
            em.remove(user);

            em.getTransaction().commit();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            emf.close();
        }
    }






    public void saveUserAndComent(Usuario user) {
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            if(!user.getComentarios().isEmpty()){
                for(Comentario c : user.getComentarios()){
                    if(c.getIdComentario() > 0){
                        em.merge(c);
                    }else{
                        em.persist(c);
                    }
                }
            }
            em.persist(user);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            emf.close();
        }
    }
}
