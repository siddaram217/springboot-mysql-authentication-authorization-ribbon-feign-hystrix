package com.candidate.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidate.feign.client.EmployeeFeignProxyService;
import com.candidate.feign.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/employeeservice")
@PreAuthorize(value = "hasAnyRole('ADMIN')")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeFeignProxyService employeeFeignProxyService;
	
	@GetMapping("/getAllEmployee")
	@HystrixCommand(fallbackMethod = "getAllEmployeeFallback")
	public Collection<Employee> getAllEmployee() {
		logger.info("CandidateRest.getAllEmployee() ");
		return employeeFeignProxyService.getAll();
	}

	public Collection<Employee> getAllEmployeeFallback() {
		Collection<Employee> list = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("fallback");
		list.add(employee);
		return list;
	}

	@PostMapping(value = "/createEmployee")
	public String create(@RequestBody List<Employee> emp) {
		logger.debug("Saving employees.");
		employeeFeignProxyService.create(emp);
		return "Employee records created.";
	}

	@GetMapping(value = "/getEmployeeeById/{employee-id}")
	public Optional<Employee> getById(@PathVariable(value = "employee-id") int id) {
		logger.debug("Getting employee with employee-id= {}.", id);
		return employeeFeignProxyService.getById(id);
	}

	@PutMapping(value = "/updateEmployee/{employee-id}")
	public String update(@PathVariable(value = "employee-id") int id, @RequestBody Employee e) {
		logger.debug("Updating employee with employee-id= {}.", id);
		e.setId(id);
		employeeFeignProxyService.update(id, e);
		return "Employee record for employee-id= " + id + " updated.";
	}

	@DeleteMapping(value = "/deleteEmployee/{employee-id}")
	public String delete(@PathVariable(value = "employee-id") int id) {
		logger.debug("Deleting employee with employee-id= {}.", id);
		employeeFeignProxyService.delete(id);
		return "Employee record for employee-id= " + id + " deleted.";
	}


}
