package com.candidate.feign.client;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.candidate.feign.config.FeignClientConfiguration;
import com.candidate.feign.model.Employee;

@RibbonClient(name = "employee-service")
@FeignClient(name = "employee-service", configuration = FeignClientConfiguration.class)
public interface EmployeeFeignProxyService {

	@GetMapping(value = "/employee/getAll")
	public Collection<Employee> getAll();

	@GetMapping(value = "/getById/{employee-id}")
	public Optional<Employee> getById(@PathVariable(value = "employee-id") int id);

	@PostMapping(value = "/create")
	public String create(@RequestBody List<Employee> emp);
	
	@PutMapping(value= "/update/{employee-id}")
    public String update(@PathVariable(value= "employee-id") int id, @RequestBody Employee e);
	
	@DeleteMapping(value= "/delete/{employee-id}")
    public String delete(@PathVariable(value= "employee-id") int id);

}
