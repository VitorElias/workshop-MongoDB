package com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Service;

import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Repository.PostRepository;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository pr;

    public Post findById(String id){

        Optional<Post> p = pr.findById(id);

        return p.get();
    }

    public List<Post> findAll(){

        return pr.findAll();
    }

    public List<Post> findByTitle(String title){

        return pr.searchTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){

        maxDate = new Date(maxDate.getTime() + 24 *60 * 60 *1000);

        return pr.fullSearch(text,minDate,maxDate);

    }

}
