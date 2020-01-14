package Klm1.KLMLineMaintenanceServer;

/*
Made By : Ilias Delawar
 */

import Klm1.KLMLineMaintenanceServer.controllers.*;
import Klm1.KLMLineMaintenanceServer.models.*;
import Klm1.KLMLineMaintenanceServer.repositories.*;
import Klm1.KLMLineMaintenanceServer.repositories.interfaces.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//is used to provide a bridge between Spring Boot test features and JUnit.Whenever we are using any Spring Boot testing features in our JUnit tests, this annotation will be required.
@RunWith(SpringRunner.class)
// specify the main applcication class(optional)
@SpringBootTest(classes = KlmLineMaintenanceServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestIlias {

    @Autowired
    private EquipmentRepositoryJpa equipmentRepositoryJpa;

    @Autowired
    private EquipmentTypeRepositoryJpa equipmentTypeRepositoryJpa;

    @Autowired
    private RequestRepositoryJpa requestRepositoryJpa;

    @Autowired
    private AircraftRepositoryJpa aircraftRepositoryJpa;

    @Autowired
    private LocationRepositoryJpa locationRepositoryJpa;

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Autowired
    private UserRequestRepositoryJpa userRequestRepositoryJpa;

    @Autowired
    private EquipmentController equipmentControllerTest;

    @Autowired
    private RequestController requestController;

    @Autowired
    private LocationController locationController;

    @Autowired
    private UserController userController;

    @Autowired
    AircraftController aircraftController;


    @Test
    @DirtiesContext
    public void testRepo_save() {
        /* Test the logic of the repository by testing a couple of methods like  save  */

        //Initialize empty list of the requests of the equipment, because  the constructor needs this
        List<Request> requests = new ArrayList<>();

        //Add a equipment
        Equipment equipment = new Equipment(requests, "TestSerial", "TestId", equipmentTypeRepositoryJpa.findById(1), Equipment.Status.Usable, "Good");

        Equipment savedEquipment = equipmentRepositoryJpa.save(equipment);

        //check if save is successful by checking attributes
        System.out.println(savedEquipment.getSerialNumber());

        Assert.assertEquals("TestSerial", savedEquipment.getSerialNumber());

        Assert.assertEquals("TestId", savedEquipment.getId());


    }


    @Test
    public void testRepo_deleteEquipmentBySerialNumber() {
        //Initialize empty list of the requests of the equipment, because  the constructor needs this
        List<Request> requests = new ArrayList<>();

        //Add a equipment
        Equipment equipment = new Equipment(requests, "TestSerial", "TestId", equipmentTypeRepositoryJpa.findById(1), Equipment.Status.Usable, "Good");


        Equipment savedEquipment = equipmentRepositoryJpa.save(equipment);
        // check if deleteById method works
        equipmentRepositoryJpa.deleteById(savedEquipment.getSerialNumber());

        // find previously deleted entry and check if the method return null. (it should return null because the entry should be deleted in the database)
        Equipment equipmentDeleted = equipmentRepositoryJpa.findBySerialNumber("TestSerial");
        Assert.assertNull(equipmentDeleted);
    }


    @Test
    public void testRepo_SetEquipmentStatus() {
        /* Test the setEquipmentStatus() method of the repo*/

        // find the equipment you want to change the status from
        Equipment equipment = equipmentRepositoryJpa.findBySerialNumber("KL142246");

        // change the status

        equipmentRepositoryJpa.setEquipmentStatus(equipment.getSerialNumber(), Equipment.Status.Usable);

        // FIND EQUIPMENT AGAIN

        equipment = equipmentRepositoryJpa.findBySerialNumber(equipment.getSerialNumber());
        // CHECK IF THE EQUIPMENT FOUND HAS THE STATUS

        // check if the status of the equipment is actually changed
        Assert.assertEquals(Equipment.Status.Usable, equipment.getStatus());

        //change it back to its original value
        equipmentRepositoryJpa.setEquipmentStatus(equipment.getSerialNumber(), Equipment.Status.Inuse);

    }


    @Test
    public void request_tests() {

        /* method to test methods of the RequestJpaRepo and the Requestcontroller */


        // Make object of request
        EquipmentType equipmentType = this.equipmentTypeRepositoryJpa.findById(5);
        Aircraft aircraft = this.aircraftRepositoryJpa.findById(2);
        Location location = this.locationRepositoryJpa.findById("A33");
        Equipment equipment = this.equipmentRepositoryJpa.findBySerialNumber("116195");

        User user = this.userRepositoryJpa.findById("KLM00005");

        Request requestPost = this.requestController.postRequest(new Request(Request.Status.OP, equipmentType, aircraft, location, equipment, new Date(), "3"), user.getId());

        // get the request to work with by using the findById method
        Request requestGet = this.requestRepositoryJpa.findById(requestPost.getId());

        // set the request status to In Progress
        this.requestRepositoryJpa.setRequestStatus(requestGet.getId(), Request.Status.IP);

        // check wheter the request in the database is changed to (In progress )
        Assert.assertThat(this.requestRepositoryJpa.findById(requestGet.getId()).getStatus(), is(Request.Status.IP));

        // cancel the request(it should then return to open(OP))
        this.requestRepositoryJpa.cancelRequestRun(requestGet.getId());

        // check whether the status is changed back to open OP
        Assert.assertThat(this.requestRepositoryJpa.findById(requestGet.getId()).getStatus(), is(Request.Status.OP));

    }


    @Test
    public void equipment_tests() {
        List<Request> requests = new ArrayList<>();

        //Add a equipment
        Equipment equipment = new Equipment(requests, "TestSerial", "TestId", equipmentTypeRepositoryJpa.findById(1), Equipment.Status.Usable, "Good");

        //post the equipment
        ResponseEntity equipmentResponseEntity = this.equipmentControllerTest.postEquipment(equipment);

        // check if the equipment is created by checking the statusCode
        Assert.assertEquals(HttpStatus.CREATED, equipmentResponseEntity.getStatusCode());

        // retrieve the saved equipment
        Equipment savedEquipment = this.equipmentControllerTest.getEquipment(equipment.getSerialNumber());

        // Check if the equipment that was saved is the same as the equipment object we made in the beginning
        Assert.assertSame(equipment.getSerialNumber(), savedEquipment.getSerialNumber());

        this.equipmentControllerTest.deleteEquipment(equipment.getSerialNumber());

        Assert.assertNull(this.equipmentControllerTest.getEquipment(equipment.getSerialNumber()));

    }


    @Test
    public void find_requests_order_by_departureTest() {
        // get the list of requests that is ordered by departure datetime
        List<Request> orderdRequests = this.requestRepositoryJpa.find_requests_order_by_departure();

        // get the list of the requests unordered to loop over
        List<Request> requests = this.requestRepositoryJpa.findAll();
        // initialize priorityRequest to test wheter the first element in the list is actually the element that needs to departure FIRST
        Request priorityRequest = null;

        // loop trough all the requests
        for (Request orderdRequest : requests) {

            // if the priority request is null or the departuretime of the priorityrequest is after the request ->
            if (priorityRequest == null || priorityRequest.getDeparture().after(orderdRequest.getDeparture())) {
                //assign  priorityRequest to the request we now are iterating over
                priorityRequest = orderdRequest;
            }
            System.out.println(orderdRequest.getDeparture());
        }

        System.out.println("--------------------------");
        System.out.println(priorityRequest != null ? priorityRequest.getDeparture() : null);

        // check whether the first element in the list is actually the Request that needs to be handled first because of the departure time
        assert priorityRequest != null;
        Assert.assertEquals(orderdRequests.get(0).getDeparture(), priorityRequest.getDeparture());
    }




    @Test

    public void location_tests() {
        /* test if the update method of the location controller works */

        // first get the location we want to update
        Location location = locationRepositoryJpa.findById("A33");

        // then make a new locationobject with the same id
        Location locationUpdate = new Location(location.getRequests(), "A33", Location.Type.Buffer);

        // call the updateLocation method  and put the message  in a String
        String message = locationController.updateLocation(locationUpdate);

        // if the string contains the "updates successfully message" the update is successfull
        Assert.assertEquals("updated successfully", message);

        /*  check post method of the locationController */

        // init the initial size of the list of locations
        int initialLocationsSize = this.locationController.getLocation().size();

        // add a new location to the list of locations
        this.locationController.postLocation(new Location(new ArrayList<>(), "A50", Location.Type.Pier));

        // check if the list that getLocation() gives back has increased after adding a location
        Assert.assertTrue(this.locationController.getLocation().size() > initialLocationsSize);

        /* Finally test if the delete method works in the locationController */
        this.locationController.deleteLocation("A50");

        // find previously deleted entry and check if the method return null. (it should return null because the entry should be deleted in the database)
        Assert.assertNull(this.locationController.getLocationById("A50"));
    }


    @Test
    public void user_tests() {
        /* this method tests te methods of users repo and controller */

        // make object of user
        User user = new User();

        // set attributes
        user.setName("Test");
        user.setRole("RUN");
        user.setPassword("12345");
        user.setStatus("OFF");

        // post the user
        String message = this.userController.postUsers(user);

        // check if the user is saved successfully
        Assert.assertEquals("User saved succesfully", message);

        // get the posted user from the database
        User getPostedUser = this.userController.getUserById(user.getId());

        // check if users are the same by  comparing their name
        Assert.assertEquals("Test", getPostedUser.getName());
    }


    @Test
    public void aircraft_tests(){
        /* test methods from the aircraft controller and jparepo  */


        // make aircraft object
        Aircraft aircraft = aircraftController.getAircraft(1);
        aircraft.setId(20);
        aircraft.setType(Aircraft.Type.Wide_body);
        aircraft.setName("iliasVlieg");

        //post the aircraft to the database
      ResponseEntity responseEntity =  aircraftController.postAircraft(aircraft);

      // check if the statuscode that is given back in the responseidentity is indeed the correct one
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // get the aircraft that wasd posted
        aircraft = aircraftController.getAircraft(aircraft.getId());

        // check if the airccraft has a property that is named name and check if the value of 'name' is eqial to iliasVlieg
        assertThat(aircraft, hasProperty("name", equalTo("iliasVlieg")));

        //finally delete the aircraft from the database
        this.aircraftRepositoryJpa.delete(aircraft);

        // check if the aircraft that is deleted is requested again that it gives null as an result
        Assert.assertNull(this.aircraftController.getAircraft(aircraft.getId()));
    }
}


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = KlmLineMaintenanceServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestMockIlias{


    @Mock
    private UserRepository mockUserRepo;


    @Test
    public void testMockMethod(){
        // Given

        User user = new User();


        Mockito.when(mockUserRepo.findById(Mockito.anyString())).thenReturn(user);

        // When


        User result = mockUserRepo.findById("KLM00005");

        // Then
        // you are expecting mockRepo to return an object that is an User instance
        assertThat( result, is(sameInstance(user)));



    }



}



