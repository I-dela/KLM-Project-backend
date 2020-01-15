/**
 * User tests of the UserRepositoryJpa class
 * @Author Raymond Splinter - IS204 - 500778433
 */

package Klm1.KLMLineMaintenanceServer.repositories;

import Klm1.KLMLineMaintenanceServer.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryJpaTest {
    @Autowired
    private UserRepositoryJpa repository;

    List<User> users;
    User user;

    @BeforeEach
    void setUp() {
        if (repository != null) {
            getUsers();
        }

        user = new User(null, "KLM123456", "John", "GE", "12345", "OFF");
    }

    private void getUsers() {
        users = repository.findAll();
    }

    @Test
    void repositoryNotNull() {
        assertNotNull(repository);
    }

    @Test
    void findAll() {
        assertNotNull(users);
        assertTrue(users.size() > 0);
    }

    @Test
    void findById() {
        String id = "KLM00001";
        User user = repository.findById("KLM00001");

        assertNotNull(user);

        System.out.printf("The user is %s", user.getName());

        assertEquals(user.getId(), id);
    }

    @Test
    void addUser() {
        int listSize = users.size();

        repository.save(user);

        getUsers();

        assertEquals(listSize + 1, users.size());
        assertEquals(user, users.get(users.size() - 1));
    }

    @Test
    void editUser() {
        int listSize = users.size();
        String newName = "Jan";

        repository.save(user);
        getUsers();

        User editedUser = user;

        assertNotEquals(user.getName(), newName);

        editedUser.setName(newName);
        repository.save(editedUser);

        getUsers();

        User updatedUser = users.get(users.size() - 1);

        assertEquals(listSize, users.size());
        assertNotSame(updatedUser, user);
        assertEquals(newName, updatedUser.getName());

        repository.delete(updatedUser);
    }

    @Test
    void delete() {
        int listSize = users.size();

        repository.save(user);
        getUsers();

        assertEquals(listSize + 1, users.size());
        assertEquals(user, users.get(listSize));

        repository.delete(user);
        getUsers();

        assertEquals(listSize, users.size());
        assertNotEquals(user, users.get(listSize - 1));
    }
}