package com.demoproject.employeeWEB;

import com.demoproject.employeeWEB.model.Employee;
import com.demoproject.employeeWEB.model.Employees;
import com.demoproject.employeeWEB.service.APIClientService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HTMLController {

    private static String BASE_URL= "http://localhost:8081";
    private static String SAVE_EMPLOYEE = "/saveEmployee";
    private static String ALL_EMPLOYEES = "/allEmployees";
    private static String DELETE_EMPLOYEE = "/deleteEmployee";
    private APIClientService apiClientService;

    @Autowired
    public HTMLController(final APIClientService apiClientService){
        this.apiClientService=apiClientService;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }


    @PostMapping("/showAfterSave")
    public String sendInfoToSave(@ModelAttribute Employee employee, Model model){
        String employeeURL = BASE_URL + SAVE_EMPLOYEE;
        apiClientService.postEmployee(employee, employeeURL);

        ResponseEntity<Employees> response = apiClientService.getAllEmployees(BASE_URL + ALL_EMPLOYEES);
        List<Employee> employees = Objects.requireNonNull(response.getBody()).getEmployees();
        model.addAttribute("employees", employees);
        return "allEmployees";
    }



    @GetMapping("/allEmployees")
    public String employeeDetails(Model model) {
        ResponseEntity<Employees> response = apiClientService.getAllEmployees(BASE_URL + ALL_EMPLOYEES);
        List<Employee> employees = Objects.requireNonNull(response.getBody()).getEmployees();
        model.addAttribute("employees", employees);
        return "allEmployees";
    }


    @GetMapping("/deleteEmployee")
    public String deleteEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "deleteEmployee";
    }

    @PostMapping("/deleteEmployee")
    public String employeeToDelete(@ModelAttribute Employee employee){
        String employeeURL = BASE_URL + DELETE_EMPLOYEE;
        apiClientService.postEmployee(employee, employeeURL);
        return "allEmployees";
    }


    @PostMapping("/showAfterDelete")
    public String sendInfoToDelete(@ModelAttribute Employee employee, Model model){
        String employeeURL = BASE_URL + DELETE_EMPLOYEE;
        apiClientService.postEmployee(employee, employeeURL);

        ResponseEntity<Employees> response = apiClientService.getAllEmployees(BASE_URL + ALL_EMPLOYEES);
        List<Employee> employees = Objects.requireNonNull(response.getBody()).getEmployees();
        model.addAttribute("employees", employees);
        return "allEmployees";
    }


}
