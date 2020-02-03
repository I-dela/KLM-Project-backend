package Klm1.KLMLineMaintenanceServer;

import Klm1.KLMLineMaintenanceServer.controllers.AuthenticateController;
import Klm1.KLMLineMaintenanceServer.controllers.UserController;
import Klm1.KLMLineMaintenanceServer.models.Aircraft;
import Klm1.KLMLineMaintenanceServer.models.Location;
import Klm1.KLMLineMaintenanceServer.models.Request;
import Klm1.KLMLineMaintenanceServer.models.User;
import Klm1.KLMLineMaintenanceServer.repositories.*;
import Klm1.KLMLineMaintenanceServer.repositories.interfaces.UserRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Duration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests for UserRepo
 * @author Yassine el Aatiaoui, 500767860
 * Test rest endpoint User Controller
 */
@SpringBootTest(classes = KlmLineMaintenanceServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Autowired
    AuthenticateController authenticateController;

    @Autowired
    private TestRestTemplate rest;

    @BeforeEach
    void setUp() {

    }

    // test rest point get All Users
    @Test
    void geAllUsers() {
        // forced timeout error with 1 second run time per run
        assertTimeoutPreemptively(Duration.ofSeconds(5) , () -> {
            ResponseEntity<User[]> response = rest.getForEntity(
                    "http://localhost:8080/users",
                    User[].class);
            // check if HTTP request is ok
            assertEquals(HttpStatus.OK, response.getStatusCode());
        });
    }























    //    @Autowired
//    private UserController userController;
//
//
//    @Autowired
//    private LocationRepositoryJpa locationRepositoryJpa;
//
//    @Autowired
//    private AircraftRepositoryJpa aircraftRepositoryJpa;


//
//    @Test
//    void save() {
//        /* this method tests te methods of users repo and controller */
//        // make object of user
//        assertEquals(userRepositoryJpa.findAll().size(), 11);
//        User savedEmplyee= this.userRepositoryJpa.save(user3);
//        assertEquals("YSN" ,savedEmplyee.getName());
//        assertEquals(userRepositoryJpa.findAll().size(), 11);
//        System.out.println("--------------------------------------------------------");
//        System.out.println(userRepositoryJpa.findAll());
//
//    }
//
//    @Test
//    public void testRepo_save() {
//        /* Test the logic of the repository by testing a couple of methods like  save  */
//
//        //Initialize empty list of the requests of the equipment, because  the constructor needs this
//        List<Request> requests = new ArrayList<>();
//        Request request = new Request();
//        requests.add(request);
//        Aircraft aircraft = new Aircraft(requests, 3, "KLM", Aircraft.Type.NA, "Klm1");
//        Aircraft savedAircarft = this.aircraftRepositoryJpa.save(aircraft);
//        //check if save is successful by checking attributes
//        System.out.println(aircraft.getManufacturer());
//        assertEquals("Klm1", savedAircarft.getManufacturer());
//    }
//
//    @Test
//    public void testRepo_deleteUser() {
//        /* Test the logic of the repository by testing a couple of methods like  save  */
//
//        //Initialize empty list of the requests of the equipment, because  the constructor needs this
//        List<Request> requests = new ArrayList<>();
//
//        Request request = new Request();
//
//        requests.add(request);
//
//        Aircraft aircraft = new Aircraft(requests, 3, "KLM", Aircraft.Type.NA, "Klm1");
//
//        Aircraft savedAircarft = this.aircraftRepositoryJpa.save(aircraft);
//
//        aircraftRepositoryJpa.delete(savedAircarft);
//
//        Aircraft DeletedAircarft = aircraftRepositoryJpa.findById(savedAircarft.getId());
//        assertNull(DeletedAircarft);
//
//
//    }
//
//    @Test
//    public void findAlleLocation() {
//
//        ArrayList<Request> requests = new ArrayList<>();
//        Location location = new Location(requests, "A34", Location.Type.Buffer);
//        Location location1 = new Location(requests, "A33", Location.Type.Buffer);
//        Location location2 = new Location(requests, "B42", Location.Type.Buffer);
//        Location location3 = new Location(requests, "C42", Location.Type.Buffer);
//        Location location4 = new Location(requests, "A41", Location.Type.Buffer);
//        locationRepositoryJpa.save(location);
//        locationRepositoryJpa.save(location1);
//        locationRepositoryJpa.save(location2);
//        locationRepositoryJpa.save(location3);
//        locationRepositoryJpa.save(location4);
//        assertEquals(locationRepositoryJpa.findById(location2.getLocation()).getLocation(), "B42");
//
//    }
//
//    @Test
//    void authenticateUser() {
//    }
}

@SpringBootTest(classes = KlmLineMaintenanceServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestMockYassine {

    @Mock
    private UserRepository mockUserRepo;


    @Test
    public void testMockMethod() {

    }


}
