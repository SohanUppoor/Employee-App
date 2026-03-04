package com.example.employeeapp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
}


// @RestController
// @RequestMapping("/employees")
// @CrossOrigin (origins = "http://localhost:5173")
// public class EmployeeController {

//     private List<Employee> employeeList = new ArrayList<>();
//     private Long idCounter = 1L;

//     // GET all employees
//     @GetMapping
//     public List<Employee> getAllEmployees() {
//         return employeeList;
//     }

//     // POST add employee
//     @PostMapping
//     public Employee addEmployee(@RequestBody Employee employee) {
//         employee.setId(idCounter++);
//         employeeList.add(employee);
//         return employee;
//     }
// }