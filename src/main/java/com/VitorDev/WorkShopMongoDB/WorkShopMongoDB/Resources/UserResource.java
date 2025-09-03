package com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Resources;


import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Service.UserService;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.Post;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.User;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    UserService us;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {return ResponseEntity.ok().body(us.findAll());}

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(us.findById(id));
    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User obj = us.findByIdUser(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody User user){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO user,@PathVariable String id){

        return ResponseEntity.ok().body(us.update(user,id));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable String id){
        us.delete(id);
        return ResponseEntity.noContent().build();
    }




}
