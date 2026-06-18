package com.example.demo.serviceImpls;

import com.example.demo.dto.OneToOneRequestDto;
import com.example.demo.services.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    @Autowired
    private RestClient restClient;

    @Override
    public List<OneToOneRequestDto> getAllEmployees() {
        List<OneToOneRequestDto> users = restClient.get()
                .uri("checkoto/getoto")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
        return users;
    }
}
