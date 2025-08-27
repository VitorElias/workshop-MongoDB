package com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.Repository;

import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
