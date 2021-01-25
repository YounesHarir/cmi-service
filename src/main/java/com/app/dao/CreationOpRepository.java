package com.app.dao;

import com.app.entity.CreationOp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreationOpRepository extends MongoRepository<CreationOp,String> {

}
