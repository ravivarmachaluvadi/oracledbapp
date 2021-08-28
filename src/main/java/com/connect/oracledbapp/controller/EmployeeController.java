package com.connect.oracledbapp.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@RestController
public class EmployeeController {

    @Autowired
    EntityManager entityManager;

    @GetMapping("users")
    public String getAll() {
        Map<String, JSONObject> jsonObjectMap = new HashMap<>();
        Query query = entityManager.createNativeQuery("select * from employees");
        List<Object[]> resultList= query.getResultList();

        resultList.stream().forEach(objects -> {
            if(!jsonObjectMap.containsKey(objects[6])){
                JSONObject jsonObject = new JSONObject();
                JSONArray jsonObjects = new JSONArray();
                jsonObject.put(String.valueOf(objects[6]),String.valueOf(objects[10]));
            JSONObject jsonObjectChild = new JSONObject();
            jsonObjectChild.put(String.valueOf(objects[1]),String.valueOf(objects[2]));
            jsonObjects.put(jsonObjectChild);
            jsonObject.put("Child",jsonObjects);
                jsonObjectMap.put(String.valueOf(objects[6]),jsonObject);
            }

          else if(jsonObjectMap.containsKey(objects[6])){
                JSONObject jsonObject = jsonObjectMap.get(objects[6]);
                JSONArray jsonObjects = (JSONArray) jsonObject.get("Child");
                JSONObject jsonObjectChild = new JSONObject();
                jsonObjectChild.put(String.valueOf(objects[1]),String.valueOf(objects[2]));
                jsonObjects.put(jsonObjectChild);
                jsonObjectMap.put(String.valueOf(objects[6]),jsonObject);
            }
        });
        JSONArray resultArray = new JSONArray(jsonObjectMap.values());
        return resultArray.toString();
    }

}
