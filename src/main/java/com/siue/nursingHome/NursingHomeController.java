package com.siue.nursingHome;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NursingHomeController {
    @Autowired
    private NursingHomeDAO nursingDAOImpl;
    Map<String, String> stateList = Constants.STATE_LIST;

    @RequestMapping(value = "/employee",method=RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("employee") NursingHome nursingHome)
    {
        try
        {
            if(nursingDAOImpl.getNursingHomeById(nursingHome.getProvider_number()) != null){
                nursingDAOImpl.updateNursingHome(nursingHome,nursingHome.getProvider_number());
            }
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("inside catch");
            nursingDAOImpl.saveNursingHome(nursingHome);
        }
        return new ModelAndView("redirect:/employees");
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@ModelAttribute("employee") NursingHome nursingHome, @PathVariable(value =
            "id", required = false) String id) {
        if(nursingHome.getProvider_number()==null){
            nursingHome.setProvider_number(id);
        }
        nursingDAOImpl.updateNursingHome(nursingHome,id);
        return new ModelAndView("redirect:/employees");
    }

    @RequestMapping(value = "/deficiency", method = RequestMethod.POST)
    public ModelAndView searchDefiency(@ModelAttribute("deficiency") Deficiency deficiency) {
        ModelAndView model = new ModelAndView("deficiency");
        List<Deficiency> deficienyData = nursingDAOImpl.getDeficienyData(deficiency.getName(), deficiency
                .getTotal_defiencies(), deficiency.getInspection_cycle());
        model.addObject("deficienyData", deficienyData);
//        System.out.println("deficienyData = " + deficienyData);

        return model;
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editEmployee(@ModelAttribute("employee") NursingHome employee, @PathVariable("id") String id) {
        ModelAndView model = new ModelAndView("employees");

        employee = nursingDAOImpl.getNursingHomeById(id);
        List<NursingHome> employeeList = nursingDAOImpl.getAllNursingHomes();

        model.addObject("employee", employee);
        model.addObject("employeeList", employeeList);
        model.addObject("id", id);

        return model;

    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView updateNursingHome(@ModelAttribute("employee") NursingHome employee, @PathVariable("id")
            String id) {
        nursingDAOImpl.deleteNursingHome(id);

        return new ModelAndView("redirect:/employees");
    }

    @RequestMapping(value = "/employees")
    public ModelAndView listEmployees(@ModelAttribute("employee") NursingHome employee) {
        ModelAndView model = new ModelAndView("employees");

        List<NursingHome> employeeList = nursingDAOImpl.getAllNursingHomes();
        model.addObject("employeeList", employeeList);

        return model;
    }

    @RequestMapping(value = "/deficiency")
    public ModelAndView viewDeficiency(@ModelAttribute("deficiency") Deficiency deficiency) {
        ModelAndView model = new ModelAndView("deficiency");
        List<Deficiency> deficienyData = nursingDAOImpl.getDeficienyData("", 10, 1);
        model.addObject("deficienyData", deficienyData);
//        System.out.println("deficienyData = " + deficienyData);

        return model;
    }


    @RequestMapping(value = "/fines")
    public ModelAndView viewFines(@ModelAttribute("fines") Fines fines) {
        ModelAndView model = new ModelAndView("fines");
        List<Fines> finesData = nursingDAOImpl.getFinesData("", "", "", 1, 1);
        model.addObject("finesData", finesData);
//        System.out.println("deficienyData = " + deficienyData);

        return model;
    }


    @RequestMapping(value = "/fines", method = RequestMethod.POST)
    public ModelAndView searchFines(@ModelAttribute("fines") Fines fines) {
        ModelAndView model = new ModelAndView("fines");
        if (fines != null) {
            List<Fines> finesData = nursingDAOImpl.getFinesData(fines.getNumber(), fines.getName(), fines.getType(),
                    fines.getOrating(), fines.getSrating());
            model.addObject("finesData", finesData);
        }
//        System.out.println("deficienyData = " + deficienyData);

        return model;
    }

    @RequestMapping(value = "/topnursing")
    public ModelAndView listEmployees(@RequestParam(value = "searchState", required = false) String searchState) {
        ModelAndView model = new ModelAndView("topNursingHome");
        model.addObject("stateList", stateList);
        if (searchState != null) {
            List<TopNursingHome> topNursingHomes = nursingDAOImpl.getStateListSearchData(searchState);
            model.addObject("topNursingHomes", topNursingHomes);
        }

        return model;
    }


}
