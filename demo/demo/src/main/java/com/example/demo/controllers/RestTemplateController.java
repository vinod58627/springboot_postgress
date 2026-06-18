package com.example.demo.controllers;

import com.example.demo.dto.OneToOneRequestDto;
import com.example.demo.services.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplateService rts;

    Logger logger = LoggerFactory.getLogger(RestTemplateController.class);


    @GetMapping("/getUser")
    public Object getUser() {
        String url = "https://jsonplaceholder.typicode.com/users/2";
        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<OneToOneRequestDto>> getAllEmployees() {
        try {
            List<OneToOneRequestDto> message = rts.getAllEmployees();
            logger.error("ERROR LOG");
            logger.warn("WARN LOG");
            logger.info("INFO LOG");
            logger.debug("DEBUG LOG");
            logger.trace("TRACE LOG");
            logger.debug("Successfully create new employee in createNewEmployee");
            logger.trace("Create new employee in createNewEmployee: {}", message);

            return ResponseEntity.ok().body(message);
        } catch (Exception e) {
            logger.error("Exception occurred in createNewEmployee", e);
            throw new RuntimeException(e);
        }
    }

//    Post Method Structure
//
//    public EmployeeDto createNewEmployee(EmployeeDto input) {
//        try {
//            ApiResponse<EmployeeDto> employeeDto = restClient
//                    .post()
//                    .uri("/employees")
//                    .body(input)
//                    .retrieve()
//                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
//                        System.out.println(new String(res.getBody().readAllBytes()));
//                        throw new ResourceNotFoundException("Employee not found");
//                    })
//                    .body(new ParameterizedTypeReference<>() {
//
//                    });
//
//            return employeeDto.getData();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}
