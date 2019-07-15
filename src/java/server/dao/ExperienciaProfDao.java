package server.dao;

import server.crud.JpaUtil;
import server.dominio.ExperienciaProfissional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ExperienciaProfDao extends DaoGenerico{

    public ExperienciaProfDao(Class classe) {
        super(classe);
    }

    public List<ExperienciaProfissional> getExperienciaByCandidato(int candidato){
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "select ex from ExperienciaProfissional ex "
                + "inner join Candidato c "
                + "on c.id = :parametro "
                + "and ex.candidato.id = c.id";
        Query query = em.createQuery(jpql, ExperienciaProfissional.class);
        query.setParameter("parametro", candidato);
        return query.getResultList();
    }
}
