package com.hervedarritchon.rpg.mongo_consumer.repositories;

import com.hervedarritchon.rpg.mongo_consumer.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,String> {

}
