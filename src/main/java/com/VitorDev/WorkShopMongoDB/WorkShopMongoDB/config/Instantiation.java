package com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.config;

import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Repository.PostRepository;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Repository.UserRepository;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.Post;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.User;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.dto.AuthorDTO;
import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {


    @Autowired
    UserRepository ur;

    @Autowired
    PostRepository pr;


    @Override
    public void run(String... args) throws Exception {

         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        ur.deleteAll();
        pr.deleteAll();

        User maria = new User("Maria brown2","maria@gmail.com");
        User alex = new User("Alex Green","Alex@gmail.com");
        User bob = new User("Bob Grey","bob@gmail.com");

        ur.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(sdf.parse("21/03/2018"),"Partiu viagem","Vou viajar para São Paulo",new AuthorDTO(maria));
        Post post2 = new Post(sdf.parse("21/03/2018"),"Parti ","Teste",new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!",sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite",sdf.parse("22/03/2018"),new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().add(c3);

        pr.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        ur.save(maria);
    }
}
