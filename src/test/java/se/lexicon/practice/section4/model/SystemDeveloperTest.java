package se.lexicon.practice.section4.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.practice.section4.sequencer.EmployeeSequencer;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SystemDeveloperTest {

    SystemDeveloper testObject;

    private final int id = 1;
    private final String fullName = "Test Testsson";
    private final LocalDate hiredDate = LocalDate.of(2000,3, 18);
    private final String[] certificates = {"OCA", "OCP"};
    private final String[] languages = {"Java", "JavaScript", "HTML", "C#", "C++"};
    private final double expectedSalary = 34500;

    @Before
    public void setUp() {
        testObject = new SystemDeveloper(fullName, hiredDate, certificates, languages);
    }

    @After
    public void tearDown() {
        EmployeeSequencer.resetSequencer();
    }

    @Test
    public void successfullyCreated(){

        //Assert
        assertEquals(id, testObject.getId());
        assertEquals(fullName, testObject.getName());
        assertEquals(hiredDate, testObject.getDateHired());
        assertArrayEquals(certificates, testObject.getCertificates());
        assertArrayEquals(languages, testObject.getProgrammingLanguages());
        assertEquals(expectedSalary, testObject.getSalary(), 0.0001);
    }

    @Test
    public void calculateSalary() {

        //Act

    }

    @Test
    public void setCertificates() {
    }

    @Test
    public void addCertificate() {
    }

    @Test
    public void setProgrammingLanguages() {
    }

    @Test
    public void addProgrammingLanguage() {
    }

    @Test
    public void testToString() {

        //Arrange & Act
        String toString = testObject.toString();

        //Assert
        assertTrue(toString.contains(Arrays.toString(testObject.getCertificates())));
        assertTrue(toString.contains(Arrays.toString(testObject.getProgrammingLanguages())));

    }
}