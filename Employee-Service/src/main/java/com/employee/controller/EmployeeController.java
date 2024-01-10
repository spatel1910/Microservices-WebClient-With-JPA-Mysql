package com.employee.controller;

import com.employee.model.EmpAddress;
import com.employee.model.Employee;
import com.employee.model.EmployeeResponse;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private WebClient webClient;

    @Autowired
    private EmployeeResponse employeeResponse;
   @PostMapping("/employee")
    public String addNewEmployee(@RequestBody  Employee employee){
        employeeRepository.save(employee);
        return "A new Employee has been created";
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponse> fetchNewEmpoyeeWithAddress(@PathVariable int id){
       Optional<Employee> employee=employeeRepository.findById(id);
        Consumer<Employee> consumer=(Employee emp) ->{
                employeeResponse.setId(emp.getId());
                employeeResponse.setName(emp.getName());
                employeeResponse.setEmail(emp.getEmail());
                employeeResponse.setAge(emp.getAge());

            };

       employee.ifPresent(consumer);
        //you can use exchange() method in the place of retrieve(), but explicitly you need to subscribe()
       Mono<EmpAddress> address= webClient.get().uri("/address/"+id).retrieve().bodyToMono(EmpAddress.class);
       employeeResponse.setAddress(address.block());
       return  ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

}
