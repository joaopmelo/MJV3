package server.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JpaUtil {

    private static final EntityManagerFactory ENF;
    private static EntityManager em;

    static {

        try {

            ENF = Persistence.createEntityManagerFactory("jpaHibernate201901PU");

        } catch (Throwable ex) {
            // Log exception!
            System.out.println("Erro: "+ex.getMessage());
        }
    }

    public static EntityManager getEntityManager() {

        em = ENF.createEntityManager();

        return em;
    }
}
