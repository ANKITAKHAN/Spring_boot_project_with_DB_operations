package com.example.controller;


import com.example.objectmodel.Employee;
import com.example.repository.AssignmentRepository;
import com.example.service.AssignmentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    @Autowired
    AssignmentRepository assignmentRepository;

    @GetMapping(path = "/async")
    public String invoke_async() {
        assignmentService.async_method();
        return "Async";
    }

    @RequestMapping("/getAllEmp")
    @ResponseBody
    public List<Employee> getAllEmployee(){
        return assignmentRepository.getAllEmp();
    }

    @RequestMapping("/getAllEmployee")
    @ResponseBody
    public List<Employee> getAllEmployeeWithoutCache(){
        return assignmentRepository.getAllEmployee();
    }

    @RequestMapping("/getEmp")
    @ResponseBody
    public Employee getEmployee(@RequestBody int id){
        return assignmentRepository.getEmp(id);
    }

    @RequestMapping("/getEmpById")
    @ResponseBody
    public Employee getEmployeeById(@RequestBody int id){
        return assignmentRepository.getEmpById(id);
    }

    @RequestMapping("/addEmp")
    @ResponseBody
    public String addEmployee(@RequestBody Employee emp){
        if(assignmentRepository.addEmp(emp) >= 1){
            return String.format("Employee Record Added Successfully: "+emp);
        }else{
            return "Something went wrong !";
        }
    }
    @RequestMapping("/deleteEmp")
    @ResponseBody
    public String deleteEmployee(@RequestBody int id){
        if(assignmentRepository.deleteEmp(id) >= 1){
            return String.format("Employee Record Deleted Successfully With ID: "+id);
        }else{
            return "Something went wrong !";
        }
    }

    @RequestMapping("/updateEmp")
    @ResponseBody
    public String updateEmployee(@RequestBody Employee emp){
        if(assignmentRepository.updateEmp(emp) >= 1){
            return String.format("Employee Record Updated Successfully : "+emp);
        }else{
            return "Something went wrong !";
        }
    }
}