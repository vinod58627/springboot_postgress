package com.example.demo.serviceImpls;

import com.example.demo.dto.DemoPsDto;
import com.example.demo.entities.DemoPsEntity;
import com.example.demo.repositories.DemoPsRepo;
import com.example.demo.services.DemoPsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoPsServiceImpl implements DemoPsService {
    @Autowired
    private DemoPsRepo demoPsRepo;

    public List<DemoPsEntity> getAllData() {
        return demoPsRepo.findAll();
    }

    public DemoPsDto saveNewRe(@Valid @RequestBody DemoPsDto demoPsDto) {
        System.out.println(demoPsDto);
        DemoPsEntity demoPsEntity = new DemoPsEntity();
        demoPsEntity.setName(demoPsDto.getName());
        demoPsEntity.setEmail(demoPsDto.getEmail());
        demoPsEntity.setAge(demoPsDto.getAge());
        demoPsEntity.setLocation(demoPsDto.getLocation());
        demoPsEntity.setIsAdult(demoPsDto.getIsAdult());
//        demoPsEntity.setPsId(demoPsDto.getId());
        demoPsEntity.setMobile(demoPsDto.getMobile());
        var saveRe = demoPsRepo.save(demoPsEntity);

        return new DemoPsDto(saveRe.getPsId(), saveRe.getName(), saveRe.getEmail(), saveRe.getIsAdult(), saveRe.getAge(), saveRe.getMobile(), saveRe.getLocation());
    }

    public DemoPsDto getByMail(String mail) {
        DemoPsEntity data = demoPsRepo.findByEmail(mail);
        DemoPsDto ddo = new DemoPsDto(data.getPsId(), data.getName(), data.getEmail(), data.getIsAdult(), data.getAge(), data.getMobile(), data.getLocation());
        System.out.println(ddo);
        return ddo;
    }

    public List<DemoPsDto> getByLoc(String mail) {
        List<DemoPsEntity> d = demoPsRepo.findByLocation(mail);
        List<DemoPsDto> list = new ArrayList<>();

        list = d.stream().map(this::mapToResponse).collect(Collectors.toList());
        /*for (DemoPsEntity data : d) {

            DemoPsDto dto = new DemoPsDto(data.getPsId(), data.getName(), data.getEmail(), data.getIsAdult(), data.getAge(), data.getMobile(), data.getLocation());
            list.add(dto);
        }*/
        System.out.println(list);
        return list;
    }

    private DemoPsDto mapToResponse(DemoPsEntity data) {
        return  new DemoPsDto(data.getPsId(), data.getName(), data.getEmail(), data.getIsAdult(), data.getAge(), data.getMobile(), data.getLocation());

    }

}
