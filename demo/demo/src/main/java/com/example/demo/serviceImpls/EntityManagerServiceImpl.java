package com.example.demo.serviceImpls;

import com.example.demo.dto.EntityManagerUpdateDto;
import com.example.demo.dto.OneToOneRequestDto;
import com.example.demo.dto.OneToOneResponseRecordDto;
import com.example.demo.entities.OneToOneChild;
import com.example.demo.entities.OneToOneEntity;
import com.example.demo.repositories.OneToOneRepo;
import com.example.demo.services.EntityManagerService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EntityManagerServiceImpl implements EntityManagerService {
    @Autowired
    private OneToOneRepo oneToOneRepo;

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public String saveNewUser(OneToOneRequestDto otpd) {
        OneToOneEntity oto = new OneToOneEntity();
        try {
            oto.setId(otpd.id());
            oto.setName(otpd.name());
            oto.setAge(otpd.age());
            oto.setNationality(otpd.nationality());
            oto.setEmail(otpd.email());
            oto.setPincode(otpd.pinCode());

            OneToOneChild otc = new OneToOneChild();
            otc.setFatherName(otpd.family().fatherName());
            otc.setMotherName(otpd.family().motherName());
            otc.setMobile(otpd.family().mobile());
            oto.setFamily(otc);

            if (otpd.id() == null) {
                entityManager.persist(oto);// Returns Void
                return "User Created Successfully " + otpd.name();
            } else {
                entityManager.merge(oto);// Returns Void
                return "User Updated Successfully " + otpd.name();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public String updateUser(EntityManagerUpdateDto otpd) {
        OneToOneEntity oto = entityManager.find(OneToOneEntity.class, otpd.id());
        oto.setName(otpd.userName());
        oto.setPincode(otpd.pinCode());
        oto.getFamily().setMobile(otpd.mobile());
        System.out.println(oto);
        return "User Updated " + otpd.userName();
    }

    @Transactional
    @Override
    public String updateEmail(Integer id, String email) {
        System.out.println(id + "  " + email);
        String jpql = "UPDATE OneToOneEntity oto SET email = :email WHERE oto.id = :id";
        int rows = entityManager.createQuery(jpql)
                .setParameter("id", id)
                .setParameter("email", email)
                .executeUpdate();

        return rows + " Rows are Updated";
    }


    @Override
    public List<OneToOneEntity> getAllUsers() {
        List<OneToOneEntity> data = entityManager.createQuery("SELECT o FROM OneToOneEntity o ORDER BY o.id").getResultList();
        System.out.println(data);
        if (data != null) {
            return data;
        }
        return null;
    }

    @Transactional
    @Override
    public List<Map<String, Object>> getAllUsersWithNativeQuery() {
        List<Object[]> rows = entityManager.createNativeQuery("select oto.id as id, oto.name as name, oto.age as age, oto.email as email, otoc.father_name as fatherName, otoc.mother_name as motherName, otoc.mobile as mobile from sprbt.one_to_one oto left join sprbt.one_to_one_child otoc  on oto.c_sno =otoc.sno").getResultList();
        List<Map<String, Object>> result = rows.stream()
                .map(row -> Map.of(
                        "id", row[0],
                        "name", row[1],
                        "age", row[2],
                        "email", row[3],
                        "fatherName", row[4],
                        "motherName", row[5],
                        "mobile", row[6]
                ))
                .toList();

        return result;
    }

    @Override
    public List<OneToOneResponseRecordDto> detailsFromQuery() {
        String sql = """
                select
                    oto.id as id,
                    oto.name as name,
                    oto.age as age,
                    oto.email as email,
                    otoc.father_name as fatherName,
                    otoc.mother_name as motherName,
                    otoc.mobile as mobile
                from sprbt.one_to_one oto
                left join sprbt.one_to_one_child otoc
                    on oto.c_sno = otoc.sno
                """;
        List<Object[]> results = entityManager
                .createNativeQuery(sql)
                .getResultList();
        List<OneToOneResponseRecordDto> users = results.stream()
                .map(row -> new OneToOneResponseRecordDto(
                        ((Number) row[0]).intValue(),
                        (String) row[1],
                        ((Number) row[2]).intValue(),
                        (String) row[3],
                        (String) row[4],
                        (String) row[5],
                        (String) row[6]
                ))
                .toList();
        return users;
    }
}
