package au.com.healthsutra.dao;

import au.com.healthsutra.model.Subjects;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SubjectsDAOImpl extends AbstractDAO implements SubjectsDAO {

    @Transactional
    public List<Subjects> findAll() {
        Session session = getSession();
        return session.createQuery("from Subjects").list();
    }
}
