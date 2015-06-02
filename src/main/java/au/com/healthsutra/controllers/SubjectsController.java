package au.com.healthsutra.controllers;

import au.com.healthsutra.model.Subjects;
import au.com.healthsutra.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/subjects")
public class SubjectsController {

    @Autowired
    SubjectsService subjects;

    //TODO: Piyush: Change this to POST later
    @RequestMapping(value = {"/listAll"}, method = RequestMethod.GET)
    public ModelAndView lisAllSubjects() {

        List<Subjects> subjectList = subjects.findAll();
        ModelAndView model = new ModelAndView();
        model.addObject("subjectList", subjectList);
        model.setViewName("subjects");
        return model;
    }
}
