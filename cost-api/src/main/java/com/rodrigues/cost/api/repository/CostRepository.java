package com.rodrigues.cost.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rodrigues.cost.api.document.Cost;

@Repository
public interface CostRepository extends MongoRepository<Cost, String> {

}
