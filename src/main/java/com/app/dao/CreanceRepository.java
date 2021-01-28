package com.app.dao;

import com.app.entity.Creance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreanceRepository extends MongoRepository<Creance,String> {
}
