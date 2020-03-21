import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class PersonTest {

    String expectedName;
    LocalDate expectedBday;
    String expectedGender;
    String expectedEmail;
    Person test;

    @Before
    public void init(){
        expectedName = "bob";
        expectedBday = LocalDate.of(1991, 8, 14);
        expectedGender = "MALE";
        expectedEmail = "test@test.test";
        test = new Person(expectedName, Person.Sex.MALE, expectedBday, expectedEmail);
    }

    @Test
    public void getAgeTest(){
        Integer expectedAge = 28;

        Integer actualAge = test.getAge();

        assertEquals(expectedAge, actualAge);
    }

    @Test
    public void printTest(){
        test.printPerson();
    }

    @Test
    public void testTest(){
        assertFalse(test.test(test));
    }
}