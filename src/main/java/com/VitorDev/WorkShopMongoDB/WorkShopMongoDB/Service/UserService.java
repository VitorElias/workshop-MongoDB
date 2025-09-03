package com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Service;

import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Repository.UserRepository;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Service.Exceptions.ObjectNotFoundException;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.User;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository ur;

    public List<UserDTO> findAll() {
        List<User> users = ur.findAll();
        List<UserDTO> us = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return us;
    }

    public UserDTO findById(String id) {
        Optional<User> user = ur.findById(id);
        if(user.isEmpty()){
            throw new ObjectNotFoundException("Objeto Não encontrado");
        }
        return new UserDTO(user.get());
    }

    public User findByIdUser(String id) {
        Optional<User> user = ur.findById(id);
        if(user.isEmpty()){
            throw new ObjectNotFoundException("Objeto Não encontrado");
        }
        return user.get();
    }

    public UserDTO create(User user){
        return new UserDTO(ur.save(user));
    }

    public UserDTO update(UserDTO user,String id){

        Optional<User> user2 = ur.findById(id);
        User u = user2.get();

        u.setNome(user.getNome());
        u.setEmail(user.getEmail());

        return new UserDTO(u);
    }

    public void delete(String id){
        findById(id);
        ur.deleteById(id);
    }
}
