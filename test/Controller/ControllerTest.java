/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Ballot;
import Entities.Voter;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author flippynipz
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addVoterToDB method, of class Controller.
     */
    @Test
    public void testAddVoterToDB() throws SQLException {
        System.out.println("addVoterToDB");
        Voter voter = null;
        Controller instance = new Controller();
        instance.addVoterToDB(voter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createVoter method, of class Controller.
     */
    @Test
    public void testCreateVoter() throws Exception {
        System.out.println("createVoter");
        String fName = "";
        String lName = "";
        String vSoc = "";
        int vID = 0;
        Controller instance = new Controller();
        instance.createVoter(fName, lName, vSoc, vID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBallot method, of class Controller.
     */
    @Test
    public void testAddBallot() {
        System.out.println("addBallot");
        Ballot ballot = null;
        Controller.addBallot(ballot);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBallot method, of class Controller.
     */
    @Test
    public void testCreateBallot() {
        System.out.println("createBallot");
        int selection = 0;
        Controller.createBallot(selection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
