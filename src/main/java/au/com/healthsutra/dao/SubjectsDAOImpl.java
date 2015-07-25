package au.com.healthsutra.dao;

import au.com.healthsutra.model.Subjects;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class SubjectsDAOImpl extends AbstractDAO implements SubjectsDAO {

    @Transactional
    public List<Subjects> findAll() {
        return getEntityManager().createQuery("from Subjects").getResultList();
    }

    @Transactional
    public List<Subjects> findAll2() {
        CriteriaQuery<Subjects> criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery(Subjects.class);
        criteriaQuery.select(criteriaQuery.from(Subjects.class));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

}
