package server.dao;

import server.crud.JpaUtil;
import server.dominio.Acesso;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AcessoDao extends DaoGenerico{

    public AcessoDao(Class classe) {
        super(classe);
    }

//    public int getSequence(){
//        EntityManager em = JpaUtil.getEntityManager();
//
//        String jpql = "select currval('acesso_id_seq') ";
//
//        Query query = em.createQuery(jpql, Acesso.class);
//
//        Object result = query.getSingleResult();
//
//
//
//    }
}
