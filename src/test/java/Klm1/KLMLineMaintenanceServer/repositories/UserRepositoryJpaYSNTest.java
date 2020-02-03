package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.KlmLineMaintenanceServerApplication;
import Klm1.KLMLineMaintenanceServer.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests for UserRepo
 * @author Yassine el Aatiaoui, 500767860
 * Here is test CRUD oprations on User Repository JPA save, deleteById , findById , findAll
 */
@SpringBootTest(classes = KlmLineMaintenanceServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserRepositoryJpaYSNTest {
    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    ArrayList<User> users = new ArrayList<>();
    User user = new User("KLM00013","Jone","RUN","12345");
    User user2 = new User("KLM00011","Mark","ADM","54321");
    User user3 = new User("KLM00015","YSN","GE","12585");

    @BeforeEach
    void setUp() {
        this.userRepositoryJpa.save(user);
        this.userRepositoryJpa.save(user2);

    }
    //check if we can get all user
    @Test
    void findAll() {
        int expected = userRepositoryJpa.findAll().toArray().length;
        List<User> users = userRepositoryJpa.findAll();
        int actual = users.size();
        assertEquals(expected, actual);
    }
    //check if we can remove the user
    @Test
    void delete() {
        this.userRepositoryJpa.delete(user3);
        assertNull (this.userRepositoryJpa.findById(user3.getId()));
    }

    //check if we can get a user based on his id
    @Test
    void findById() {
        User userId = this.userRepositoryJpa.findById("KLM00011");
        assertEquals("Mark", userId.getName());
    }
    //test if we can save a new user
    @Test
    void save() {
        User savedEmplyee= this.userRepositoryJpa.save(user3);
        assertEquals("YSN" ,savedEmplyee.getName());
        assertEquals(userRepositoryJpa.findAll().size(), 13);
        System.out.println("--------------------------------------------------------");
        System.out.println(userRepositoryJpa.findAll());
    }
}
