package com.example.demo.serviceImpls;

import com.example.demo.dto.ParentChildRequestDto;
import com.example.demo.entities.ParentAddress;
import com.example.demo.entities.ParentChild;
import com.example.demo.repositories.ParentAddressRepo;
import com.example.demo.repositories.ParentChildRepo;
import com.example.demo.services.ParentChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParentChildServiceImpl implements ParentChildService {
    @Autowired
    private ParentChildRepo parentChildRepo;

    @Override
    public String saveParent(ParentChildRequestDto request) {
        System.out.println(request);

        ParentChild parent = new ParentChild();
        parent.setName(request.getName());
        parent.setEmail(request.getEmail());
        parent.setCreatedBy(14458110);
        parent.setCreatedDate(LocalDateTime.now());
        parent.setUpdatedBy(14458110);
        parent.setUpdatedDate(LocalDateTime.now());

        ParentAddress address = new ParentAddress();
        address.setHouseNo(request.getParentAddress().getHouseNo());
        address.setStreet(request.getParentAddress().getStreet());
        address.setDistName(request.getParentAddress().getDistName());
        address.setPinCode(request.getParentAddress().getPinCode());
        address.setCreatedBy(14458110);
        address.setCreatedDate(LocalDateTime.now());
        address.setUpdatedBy(14458110);
        address.setUpdatedDate(LocalDateTime.now());
        parent.setParentAddress(address);
        try {
            ParentChild saved = parentChildRepo.save(parent);
            return "Successfully Saved " + saved.getName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
