package com.example.demo.serviceImpls;

import com.example.demo.dto.OneToManySaveDto;
import com.example.demo.dto.OneToOneRequestDto;
import com.example.demo.dto.OneToOneResponseDto;
import com.example.demo.dto.UpdatePinMobileRequestDto;
import com.example.demo.entities.OneToManyChildEntity;
import com.example.demo.entities.OneToManyEntity;
import com.example.demo.entities.OneToOneChild;
import com.example.demo.entities.OneToOneEntity;
import com.example.demo.repositories.OneToManyRepo;
import com.example.demo.repositories.OneToOneRepo;
import com.example.demo.services.OneToOneService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneToOneServiceImpl implements OneToOneService {

    @Autowired
    private OneToOneRepo oneToOneRepo;

    @Autowired
    private OneToManyRepo oneToManyRepo;

    @Override
    public String oneToOneSave(OneToOneRequestDto user) {
        try {
            OneToOneEntity one = new OneToOneEntity();
            one.setId(user.id());
            one.setName(user.name());
            one.setAge(user.age());
            one.setEmail(user.email());
            one.setPincode(user.pinCode());
            one.setNationality(user.nationality());
            OneToOneChild child = new OneToOneChild();
            child.setSno(user.family().sno());
            child.setFatherName(user.family().fatherName());
            child.setMotherName(user.family().motherName());
            child.setMobile(user.family().mobile());
            one.setFamily(child);
            var savedValue = oneToOneRepo.save(one);
            return "User Saves Successfully with " + savedValue.getName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<OneToOneRequestDto> oneToOneGet() {
        try {
            List<OneToOneEntity> allUser = oneToOneRepo.findAll();

            List<OneToOneRequestDto> users = allUser.stream().map(user -> new OneToOneRequestDto(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getAge(),
                    user.getPincode(),
                    user.getNationality(),
                    new OneToOneRequestDto.OneToOneRequestChildDto(
                            user.getFamily().getSno(),
                            user.getFamily().getFatherName(),
                            user.getFamily().getMobile(),
                            user.getFamily().getMotherName()
                    )

            )).toList();
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OneToOneResponseDto> getFromQuery() {

        List<OneToOneResponseDto> allMembers = oneToOneRepo.dataFromQuery();
        return allMembers;
    }

    @Override
    @Transactional
    public String updatePinNdMobile(UpdatePinMobileRequestDto dto) {
        try {
            OneToOneEntity user = oneToOneRepo.findById(dto.id()).orElseThrow(() -> new RuntimeException("User not found"));
            user.setPincode(dto.pin());
            OneToOneChild child = user.getFamily();
            child.setMobile(dto.mobile());
            child.setFatherName(dto.fatherName());
            user.setFamily(child);
            return "User Successfully updated";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String saveOtm(OneToManySaveDto otmDto) {
        try {
            OneToOneEntity user = oneToOneRepo.findById(otmDto.userId()).orElseThrow(() -> new RuntimeException("User not found"));
            if (user != null) {
                OneToManyEntity otm = new OneToManyEntity();
                otm.setName(otmDto.name());
                otm.setEmail(user.getEmail());
                otm.setMobile(otmDto.mobileNumber());
                otm.setUserId(otmDto.userId());
                List<OneToManyChildEntity> otmc = otmDto.qualification()
                        .stream()
                        .map(q -> {
                            OneToManyChildEntity child = new OneToManyChildEntity();
                            child.setCourse(q.course());
                            child.setYear(q.year());
                            child.setPercentage(q.percentage());
                            return child;
                        })
                        .toList();
                otm.setStudy(otmc);
                var savedDetails = oneToManyRepo.save(otm);
                return "User Details Saved Successfully " + savedDetails.getName();
            }
            return "User Not Found";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
