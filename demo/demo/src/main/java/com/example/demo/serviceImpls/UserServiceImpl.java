package com.example.demo.serviceImpls;

import com.example.demo.dto.AddPostRequestDto;
import com.example.demo.dto.UserNdAddressUpdateDto;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entities.UserAddress;
import com.example.demo.entities.UserEntity;
import com.example.demo.entities.UserFamilyEntity;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepo userRepo;

    @Override
    public String saveUser(UserRequestDto userRequestDto) {

        UserEntity user = new UserEntity();

        user.setUserName(userRequestDto.name());
        user.setEmail(userRequestDto.email());
        user.setAge(userRequestDto.age());
        user.setLocation(userRequestDto.location());
        user.setPhone(userRequestDto.phone());

        UserAddress uadd = new UserAddress();

        uadd.setHNo(userRequestDto.address().hno());
        uadd.setDistrict(userRequestDto.address().district());
        uadd.setPinCode(userRequestDto.address().pinCode());
        uadd.setStreet(userRequestDto.address().street());
        user.setAddress(uadd);

        List<UserFamilyEntity> ufe = new ArrayList<>();
        for (UserRequestDto.FamilyMemberDto family : userRequestDto.familyMembers()) {
            UserFamilyEntity member = new UserFamilyEntity();
            member.setAge(family.age());
            member.setMobile(family.mobile());
            member.setRelation(family.relationName());
            member.setName(family.memberName());
            member.setUser(user);
            ufe.add(member);
        }
        user.setFamilyMembers(ufe);
        try {
            var savedUser = userRepo.save(user);
            System.out.println("Saved User ->" + savedUser);
            return "Created User name with " + savedUser.getUserName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<UserResponseDto> getAllUsers() {


        return userRepo.getAllUsers();
    }

    @Override
    public List<String> fetchAll() {
        return userRepo.fetchAll();
    }

    @Override
    public String updateUser(@Valid UserNdAddressUpdateDto dto) {
        System.out.println("dto" + dto);
        UserEntity user = userRepo.findById(dto.getUserId()).orElseThrow(() ->
                new RuntimeException("User not found")
        );
        user.setLocation(dto.getLocation());
        user.setPhone(dto.getPhone());
        if (user.getAddress() != null) {
            user.getAddress().setStreet(dto.getStreet());
            user.getAddress().setHNo(dto.getHouseNo());
        }
        try {
            var updateUser = userRepo.save(user);
            return "User Updated " + updateUser.getUserName();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public String createPost(AddPostRequestDto dto) {
        System.out.println("Dto " + dto);
        return "Image Posted Successfully";
    }


}
