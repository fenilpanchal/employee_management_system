//package com.stevenhornghub.promotionrequest.controllers;
//
//import com.stevenhornghub.promotionrequest.models.Managers;
//import models.com.example.employeemgmt.User;
//import services.com.example.employeemgmt.EmployeeService;
//import com.stevenhornghub.promotionrequest.services.ManagerService;
//import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//
///**
// * @author Fenil P
// */
//
//
//@RestController
//public class ManagerController {
//
//    private final ManagerService managerService;
//    private final EmployeeService employeeService;
//
//    public ManagerController(ManagerService managerService, EmployeeService employeeService) {
//        this.managerService = managerService;
//        this.employeeService = employeeService;
//    }
//
//
//    //Create employees
//    @PostMapping("/manager/create-employee")
//    public User saveEmployee(@RequestBody User user) {
//        return employeeService.saveEmployee(user);
//
//    }
//
//    //Create for Managers only
//    @PostMapping("/manager")
//    public Managers saveUser(@Valid @RequestBody Managers managers) {
//        return managerService.saveUser(managers);
//    }
//
////    //Read for Managers only
////    @GetMapping("/manager/manager-list")
////    public ResponseEntity<List<Managers>> fetchManagerList(@Valid @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
////        return new ResponseEntity<>(managerService.fetchManagerList(pageNumber, pageSize), HttpStatus.OK);
////    }
//
//    //Read all Users
//    @GetMapping("/manager/user-list")
//    public ResponseEntity<Page<User>> findAllUsers(@Valid @RequestParam int pageNumber, @RequestParam int pageSize) {
//        return new ResponseEntity<>(managerService.fetchUserLists(pageNumber, pageSize), HttpStatus.OK);
//    }
//
//
//    //Update for Managers only
//    @PutMapping("/manager/{id}")
//    public ResponseEntity<Managers> updateUser(@Valid @PathVariable(value = "id") Long id,
//                                               @RequestBody Managers managers) {
//        managers.setId(id);
//        managerService.updateUser(managers);
//        return ResponseEntity.ok(managers);
//    }
//
//    //Update for Employees
//    @PutMapping("/manager/update-employee/{id}")
//    public ResponseEntity<User> updateEmployee(@Valid @PathVariable(value = "id") Long id,
//                                                    @RequestBody User user) {
//        user.setId(id);
//        employeeService.updateEmployee(user);
//        return ResponseEntity.ok(user);
//    }
//
//    //Delete for Managers only
//    @DeleteMapping("manager/{id}")
//    public String deleteManagerById(@Valid @PathVariable("id") Long id) {
//        managerService.deleteManagerById(id);
//        return "Deleted Successfully";
//    }
//
//    //Delete for Employees
//    @DeleteMapping("manager/delete-employee/{id}")
//    public String deleteEmployeeById(@PathVariable("id") Long id) {
//        employeeService.deleteEmployeeById(id);
//        return "Deleted Successfully";
//    }
//}
