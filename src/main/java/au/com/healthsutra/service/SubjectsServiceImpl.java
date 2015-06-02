package au.com.healthsutra.service;

import au.com.healthsutra.dao.SubjectsDAO;
import au.com.healthsutra.model.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SubjectsServiceImpl implements SubjectsService {

    @Autowired
    private SubjectsDAO subjectsDao;

    public List<Subjects> findAll() {
        return subjectsDao.findAll();
    }
}
