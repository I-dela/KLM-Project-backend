package Klm1.KLMLineMaintenanceServer;

import Klm1.KLMLineMaintenanceServer.controllers.UserController;
import Klm1.KLMLineMaintenanceServer.models.*;
import Klm1.KLMLineMaintenanceServer.repositories.*;
import Klm1.KLMLineMaintenanceServer.repositories.interfaces.UserRepository;
import Klm1.KLMLineMaintenanceServer.repositories.interfaces.UserRequestRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.jupiter.api.Assertions.*;


//is used to provide a bridge between Spring Boot test features and JUnit.Whenever we are using any Spring Boot testing features in our JUnit tests, this annotation will be required.
@RunWith(SpringRunner.class)
// specify the main applcication class(optional)
@SpringBootTest(classes = KlmLineMaintenanceServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class YassineTest {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Autowired
    private EquipmentRepositoryJpa equipmentRepositoryJpa;

    @Autowired
    private EquipmentTypeRepositoryJpa equipmentTypeRepositoryJpa;

    @Autowired
    private UserRequestRepository userRequestRepository;

    @Autowired
    private RequestRepositoryJpa requestRepositoryJpa;

    @Autowired
    private UserController userController;

    @Autowired
    private LocationRepositoryJpa locationRepositoryJpa;

    @Autowired
    private AircraftRepositoryJpa aircraftRepositoryJpa;
    @Test
    void createUserWithJWTK() {
        /* this method tests te methods of users repo and controller */
        // make object of user
        ArrayList<User> users = new ArrayList<>();

        User user = new User();
        // set attributes
        user.setName("Test");
        user.setRole("RUN");
        user.setPassword("12345");
        user.setStatus("OFF");
        User user1 = new User();

        // set attributes
        user1.setName("Test1");
        user1.setRole("RUN");
        user1.setPassword("12345");
        user1.setStatus("OFF");

        users.add(user);
        users.add(user1);
        // post the user
        String messageAdd = this.userController.postUsers(user);
        String message1Add = this.userController.postUsers(user1);

        // check if the user is saved successfully
        Assert.assertEquals("User saved succesfully", messageAdd);
        Assert.assertEquals("User saved succesfully", message1Add);

        assertEquals(users.size(), 2);

        System.out.println("-------------" + user.getId());
        users.remove(user);
        String messageDelete = this.userController.deleteUser(user.getId());
        Assert.assertEquals("Delete is successfull", messageDelete);
        assertEquals(users.size(), 1);


    }

    @Test
    public void testRepo_save() {
        /* Test the logic of the repository by testing a couple of methods like  save  */

        //Initialize empty list of the requests of the equipment, because  the constructor needs this
        List<Request> requests = new ArrayList<>();
        Request request = new Request();
        requests.add(request);
        Aircraft aircraft = new Aircraft(requests, 3, "KLM", Aircraft.Type.NA, "Klm1");
        Aircraft savedAircarft = this.aircraftRepositoryJpa.save(aircraft);
        //check if save is successful by checking attributes
        System.out.println(aircraft.getManufacturer());
        Assert.assertEquals("Klm1", savedAircarft.getManufacturer());
    }
    @Test
    public void testRepo_deleteUser() {
        /* Test the logic of the repository by testing a couple of methods like  save  */

        //Initialize empty list of the requests of the equipment, because  the constructor needs this
        List<Request> requests = new ArrayList<>();

        Request request = new Request();

        requests.add(request);

        Aircraft aircraft = new Aircraft(requests, 3, "KLM", Aircraft.Type.NA, "Klm1");

        Aircraft savedAircarft = this.aircraftRepositoryJpa.save(aircraft);

        aircraftRepositoryJpa.delete(savedAircarft);

        Aircraft DeletedAircarft =  aircraftRepositoryJpa.findById(savedAircarft.getId());
        Assert.assertNull(DeletedAircarft);


    }

    @Test
    public void findAlleLocation() {

        ArrayList<Request> requests = new ArrayList<>();
        Location location = new Location(requests, "A34", Location.Type.Buffer);
        Location location1 = new Location(requests, "A33", Location.Type.Buffer);
        Location location2 = new Location(requests, "B42", Location.Type.Buffer);
        Location location3 = new Location(requests, "C42", Location.Type.Buffer);
        Location location4 = new Location(requests, "A41", Location.Type.Buffer);
        locationRepositoryJpa.save(location);
        locationRepositoryJpa.save(location1);
        locationRepositoryJpa.save(location2);
        locationRepositoryJpa.save(location3);
        locationRepositoryJpa.save(location4);
        assertEquals(locationRepositoryJpa.findById(location2.getLocation()).getLocation(),"B42");

    }

    @Test
    void authenticateUser() {
    }
}

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = KlmLineMaintenanceServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestMockYassine{

    @Mock
    private UserRepository mockUserRepo;


    @Test
    public void testMockMethod(){

    }



}
