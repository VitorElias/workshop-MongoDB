package com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Resources;


import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Service.UserService;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserService us;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {return ResponseEntity.ok().body(us.findAll());}



}
