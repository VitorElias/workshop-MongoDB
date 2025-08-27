package com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Service;

import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Repository.UserRepository;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository ur;

    public List<User> findAll() {return ur.findAll();}
}
