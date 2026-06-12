package com.example.demo.controllers;

import com.example.demo.dto.DemoDto;
import com.example.demo.dto.DemoRecordDto;
import com.example.demo.dto.DtoMainObj;
import com.example.demo.dto.RecordMainObj;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/getStr")
    public String getFirstCall() {
        return "Hello This is First Api";
    }

    @GetMapping("/getArr")
    public List<String> getSecond() {
        List<String> str = new ArrayList<>();
        str.add("Vinod");
        str.add("Kumar");
        str.add("Suman");
        str.add("Praveen");
        str.add("Hepsi");
        return str;
    }

    @GetMapping("/getObj")
    public Map<Object, Object> getObj() {
        Map<Object, Object> obj = new HashMap<>();
        obj.put("name", "Vinod");
        obj.put("age", 29);
        obj.put(22, "Forcc");
        obj.put("isMarried", false);
        return obj;
    }

    @GetMapping("/getArrObj")
    public List<Map<Object, Object>> getArrObj() {
        List<Map<Object, Object>> list = new ArrayList<>();
        Map<Object, Object> obj1 = new HashMap<>();
        obj1.put("name", "Vinod");
        obj1.put("age", 29);
        obj1.put(22, "Forcc");
        obj1.put("isMarried", false);

        Map<Object, Object> obj2 = new HashMap<>();
        obj2.put("name", "Kumar");
        obj2.put("age", 30);
        obj2.put(22, "Hello");
        obj2.put("isMarried", true);
        list.add(obj1);
        list.add(obj2);
        return list;
    }

    @GetMapping("/isAdult/{id}")
    public String checkAdult(@PathVariable Integer id) {
        if (id > 17) {
            return "Is Adult " + id;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Age must be 18+");
        }
    }

    @GetMapping("/checkport/{id}/port/{name}/check/{item}")
    public String checkMorePaths(@PathVariable Integer id, @PathVariable String name, @PathVariable String item) {
        return "Hello Order Id is- " + id + " Item Is -" + item + " Name is-" + name;
    }

    @PostMapping("/postNewString")
    public String checkPosts(@RequestBody String name) {
        return "New Record Added Successfully -" + name;
    }

    @GetMapping("/getParams")
    public String getParams(@RequestParam String name, @RequestParam Long num) {
        return "My Name is " + name + " Number is " + num;
    }

    @PostMapping("/newPost")
    public Map<String, Object> checkPost(@RequestBody Map<String, Object> body) {
        /*{
            "name": "Vinod Kumar",
            "email": "vinod58627@gmail.com",
            "age": 28
            "location": "Kurnool"
            if location is null then it will throw an error
        }*/
        System.out.println(body.get("name"));
        System.out.println(body.get("email"));
        System.out.println(body.get("age"));
        if (body.get("location") == null || body.get("location") == "") {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Location Should Not be Null");
        }
        return body;
    }

    @PostMapping("/checkDto")
    public DemoDto checkDto(@Valid @RequestBody DemoDto demoDto) {
        System.out.println("Check DTO " + demoDto.getEmail());
        System.out.println("Check DTO " + demoDto.getName());
        System.out.println("Check DTO " + demoDto.getLocation());

        return demoDto;
    }

    @PostMapping("/checkRecord")
    public DemoRecordDto checkDto(@Valid @RequestBody DemoRecordDto demoRecordDto) {
        System.out.println("Check DTO " + demoRecordDto.name());
        System.out.println("Check DTO " + demoRecordDto.location());
        System.out.println("Check DTO " + demoRecordDto.email());

        return demoRecordDto;
    }

    @PostMapping("/objOfObj")
    public DtoMainObj checkObjOfObj(@Valid @RequestBody DtoMainObj dtoMainObj) {
        System.out.println(dtoMainObj);
        return dtoMainObj;
    }

    @PostMapping("/objOfObjRecord")
    public RecordMainObj checkObjOfObj(@Valid @RequestBody RecordMainObj recordMainObj) {
        System.out.println(recordMainObj);
        return recordMainObj;
    }

    @GetMapping("/checkResponseEntity")
    public ResponseEntity<String> checkStr() {
        return ResponseEntity.ok("SuccessFull Checked");
    }
    @GetMapping("/checkResponseWithBody")
    public ResponseEntity<String> checkDtr() {
        return new ResponseEntity<>("Created", HttpStatus.OK);
    }
}
