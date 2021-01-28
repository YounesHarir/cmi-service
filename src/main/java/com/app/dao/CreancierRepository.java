package com.app.dao;

import com.app.entity.Creancier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreancierRepository extends MongoRepository<Creancier,String> {
}
