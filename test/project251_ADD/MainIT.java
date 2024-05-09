/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project251_ADD;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Lames_ASB
 */
public class MainIT {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final ArrayList<GolfCar> GolfCars = new ArrayList<>();
    private final GolfCar golfCar = new GolfCar(1, 1, 2, "Gate1", "8:00 AM");

    public MainIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(out));
        GolfCars.add(golfCar); 
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Test of PrintSchedule_forTest method, of class Main.
     */
    @Test
    public void testPrintSchedule() {
        Main.PrintSchedule(GolfCars);
        String expectedOutput = "-------------------------------------------------" + System.lineSeparator()
                + "                Golf Car Schedule                " + System.lineSeparator()
                + "-------------------------------------------------" + System.lineSeparator()
                + "GolfTripNO | GolfCarNO | Destination | Time     | Seats Number" + System.lineSeparator()
                + "------------------------------------------------------------" + System.lineSeparator()
                + String.format("%-11d| %-10d| %-12s| %-9s| %-13d%n",
                        golfCar.getGolfTripNum(), golfCar.getGolf_Number(), golfCar.getDestination(),
                        golfCar.getTime(), golfCar.getSeats())
                + "------------------------------------------------------------" + System.lineSeparator();
        assertEquals(expectedOutput, out.toString());
    }

    /**
     * Test of CreateReservation method, of class Main.
     */
    @Test
    public void testCreateReservation() {
        // Create a sample GolfCar object
        GolfCar golfCar = new GolfCar(1, 22, 6, "Gate 2", "08:00");
        // Create a sample Student object
        Student student = new Student(1234567, "Lames");
        // Redirect System.in and System.out to simulate user input and output
        String input = "4\n"; // Simulate user input for number of seats to book
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //String expectedOutput = "Booking successful! Your Reservation Number: reserve.getReservationNum())\n";
        // Call the method to be tested
        Main.CreateReservation(golfCar, student);
        // Verify if the reservation was done correctly
        assertTrue(out.toString().contains("Booking successful!")); // Check if success message is printed
    }

    /**
     * Test of checkSeats method, of class Main.
     */
    @Test
    public void testCheckStudentId() {
        System.out.println("CheckStudentId");
        int StudentID = 2210510;
        boolean result = Main.CheckStudentId(StudentID);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testCheckStudentId_false() { //<7
        System.out.println("CheckStudentId");
        int StudentID = 22105;
        boolean result = Main.CheckStudentId(StudentID);
        assertFalse(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of CancelReservation method, of class Main.
     */
    @Test
    public void testCancelReservation() {
        System.out.println("CancelReservation");
        Main.CancelReservation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ModifyReservation method, of class Main.
     */
    @Test
    public void testModifyReservation() {
        System.out.println("ModifyReservation");
        Main.ModifyReservation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
