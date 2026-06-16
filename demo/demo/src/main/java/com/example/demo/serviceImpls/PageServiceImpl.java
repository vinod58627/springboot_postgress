package com.example.demo.serviceImpls;

import com.example.demo.dto.AddPageRequestDto;
import com.example.demo.dto.PageAllResponseDto;
import com.example.demo.entities.PageEntity;
import com.example.demo.repositories.PageRepo;
import com.example.demo.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageRepo pageRepo;

    @Override
    public List<PageAllResponseDto> getAll() {

        return pageRepo.getAll();
    }

    @Override
    public String newRecord(AddPageRequestDto dto) {
        try {
            PageEntity checkExist = pageRepo.findByEmpId(dto.empId());
            if (checkExist == null) {
                PageEntity page = new PageEntity();
                page.setSlNo(dto.id());
                page.setName(dto.name());
                page.setEmail(dto.email());
                page.setBranch(dto.branch());
                page.setEmpId(dto.empId());
                page.setSalary(dto.salary());
                page.setCreatedBy(14458110);
                page.setCreatedDate(LocalDateTime.now());
                page.setUpdatedBy(14458110);
                page.setUpdatedDate(LocalDateTime.now());
                var user = pageRepo.save(page);
                return "User Created Successfully" + user.getName();
            } else {
                throw new RuntimeException("Employee already exists");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Page<PageEntity> allGet(Integer pageNo) {

        Pageable pageable = PageRequest.of(pageNo, 3);
        Page<PageEntity> recordsTen = pageRepo.findAll(pageable);
        System.out.println(recordsTen.getContent());
        System.out.println(recordsTen.getTotalElements());
        System.out.println(recordsTen.getTotalPages());
        return recordsTen;
    }

    @Override
    public List<PageEntity> getThreeWithRecordsOnly(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 3);
        Page<PageEntity> recordsTen = pageRepo.findAll(pageable);
        System.out.println(recordsTen.getContent());
        System.out.println(recordsTen.getTotalElements());
        System.out.println(recordsTen.getTotalPages());
        return recordsTen.getContent();
    }

    @Override
    public List<PageEntity> pagingNdSorting(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 3, Sort.by("salary").descending());
        Page<PageEntity> recordsTen = pageRepo.findAll(pageable);
        return recordsTen.getContent();
    }
}
