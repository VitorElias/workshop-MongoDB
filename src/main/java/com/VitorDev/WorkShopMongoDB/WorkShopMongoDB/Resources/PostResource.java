package com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Resources;


import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Resources.Util.URL;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Service.PostService;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    PostService ps;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){

        return ResponseEntity.ok().body(ps.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){

        return ResponseEntity.ok().body(ps.findAll());
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text",defaultValue = "") String text){

        text = URL.decodeParam(text);
        List<Post> titles = ps.findByTitle(text);
        return ResponseEntity.ok().body(titles);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullsearch(@RequestParam(value="text",defaultValue = "") String text,
                                                 @RequestParam(value="minDate",defaultValue = "") String minDate,
                                                 @RequestParam(value="maxDate",defaultValue = "") String maxDate){

        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> list = ps.fullSearch(text,min,max);

        return ResponseEntity.ok().body(list);
    }
}
