package au.com.healthsutra.dao;

import au.com.healthsutra.model.Subjects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SubjectsDAOImpl extends AbstractDAO implements SubjectsDAO{

    /**
     * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
     * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
     */
    @Transactional
    public List<Subjects> findAll() {
        Session session = getSession();
        List subjects = session.createQuery("from Subjects").list();
        return subjects;
    }
}
