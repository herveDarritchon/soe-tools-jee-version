package com.hervedarritchon.rpg.mongo_consumer.repositories;

import com.hervedarritchon.rpg.mongo_consumer.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: Hervé Darritchon
 * Date: 09/05/2014
 * Time: 12:15
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:**/application-context.xml"})
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void readsFirstPageCorrectly() {

        Page<User> persons = userRepository.findAll(new PageRequest(0, 10));
        assertThat(persons.isFirstPage(), is(true));
    }

    @Test
    public void insertAUser() {
        final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

        User u= new User();
        u.setName("Darritchon");
        u.setAge(43);
        mongoTemplate.insert(u);

        User found=mongoTemplate.findById(u.getId(), User.class);
        log.info("User found : {}",found);
        assertNotNull(found);
    }
}
