package org.sdek.web;

import org.sdek.dao.NamesDao;
import org.sdek.entities.NameEntity;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;


@RestController
public class WebController {
    private final NamesDao namesDao;
    private ArrayList<NameEntity> searchResult;

//    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @Autowired
    public WebController(NamesDao namesDao) {
        this.namesDao = namesDao;
        this.searchResult = new ArrayList<>();
    }

    @GetMapping("/")
    public ModelAndView start() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("start");
        return mav;
    }

    @GetMapping("/insert")
    public ModelAndView insert(String userText) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("start");
        namesDao.save(userText);
        return mav;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(value = "userText", defaultValue = "")  String userText) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("search");
        searchResult = new ArrayList<>(namesDao.findAll());
        ArrayList<NameEntity> namesList;
        if (userText == "") {
            namesList = searchResult;
        } else {
            namesList = new ArrayList<>();
            for (NameEntity n : searchResult) {
                if (n.getName().contains(userText)) {
                    namesList.add(n);
                }
            }
            mav.addObject("namesList", namesList);
        }
        return mav;
    }
}
