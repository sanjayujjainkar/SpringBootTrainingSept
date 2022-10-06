package com.rabbit;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rabbit.config.MessagingConfig;
import com.rabbit.entity.Employee;
import com.rabbit.entity.EmployeeStatus;

@RequestMapping("/employee")
@RestController
public class Controller {
	
	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/")
	public String saveEntity(@RequestBody Employee emp) {
		emp.setId(UUID.randomUUID().toString());
		
		EmployeeStatus employeeStatus = new EmployeeStatus(emp, "Joined", "Going through induction:");
		template.convertAndSend(MessagingConfig.EXCHANGENAME, MessagingConfig.ROUNTING_KEY, employeeStatus);
		return "Success";
		
	}

}
