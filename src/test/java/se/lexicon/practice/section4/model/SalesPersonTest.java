package se.lexicon.practice.section4.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SalesPersonTest {
    private SalesPerson testObject;

    private String testName = "Test Testsson";
    private LocalDate hiredDate = LocalDate.parse("2000-01-25");

    @Before
    public void setUp() {
        testObject = new SalesPerson(1,"Test Testsson", LocalDate.parse("2000-01-25"), new String[0], 0);

    }

    @Test
    public void isSalesPersonCreatedCorrectly(){

        //Assert
        assertEquals(1, testObject.getId());
        assertEquals(testName, testObject.getName());
        assertEquals(hiredDate, testObject.getDateHired());
        assertEquals(0, testObject.getClients().length);
        assertEquals(0, testObject.getAcquiredClients());
        assertEquals(25_000, testObject.getSalary(), 0.001);
    }

    @Test
    public void test_constructor_should_generateId_when_IdNotSpecified(){

        //Act
        SalesPerson salesPerson = new SalesPerson(null, null, null, 0);

        //Assert
        assertTrue(salesPerson.getId() != 0);


    }

    @Test
    public void test_recruitANewClient_should_increaseSalary(){
        //Arrange
        double expectedSalary = 27_000;

        //Act
        testObject.recruitANewClient();
        testObject.recruitANewClient();

        //Assert
        assertEquals(expectedSalary, testObject.getSalary(), 0.001);

    }

    @Test
    public void test_addClient_should_calculateSalary_When_clientsAdded(){

        //Arrange
        double expectedSalary = 26_000;

        //Act
        testObject.addClient("Test1");
        testObject.addClient("Test2");

        //Assert
        assertEquals(expectedSalary, testObject.getSalary(), 0.001);

    }

    @Test
    public void test_setClient_should_calculateSalary_When_clientsChanges(){

        //Arrange
        double expectedSalary = 26_500;
        String[] newClients = {"test1", "test2", "test3"};

        //Act
        testObject.setClients(newClients);

        //Assert
        assertEquals(expectedSalary, testObject.getSalary(), 0.001);

    }

    @Test
    public void test_setClient_should_addClientToArray(){
        //Arrange
        String[] newClients = {"test1", "test2", "test3"};

        //Act
        testObject.setClients(newClients);

        //Assert
        assertSame(testObject.getClients(), newClients);
    }

    @Test
    public void test_setAcquired_should_setANDCalculateSalary(){

        int expected = 5;

        testObject.setAcquiredClients(5);

        assertEquals(expected, testObject.getAcquiredClients());


    }

    @Test
    public void test_toString(){
        //Arrange & Act
        String toString = testObject.toString();

        //Assert
        assertTrue(toString.contains(Arrays.toString(testObject.getClients())));
        assertTrue(toString.contains("0"));

    }


}