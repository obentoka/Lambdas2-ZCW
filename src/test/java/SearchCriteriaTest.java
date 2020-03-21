import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class SearchCriteriaTest {
    SocialNetwork<Person> network;
    Person han;
    Person von;
    Person kev;
    Person moe;

    @Before
    public void init(){
        han = new Person("han",
                Person.Sex.FEMALE,
                LocalDate.of(1994, 10, 15),
                "test@Test.test");
        von = new Person("von",
                Person.Sex.MALE,
                LocalDate.of(1991, 8, 14),
                "test2@Test.test");
        kev = new Person("kev",
                Person.Sex.MALE,
                LocalDate.of(1988, 5, 18),
                "test3@Test.test");
        moe = new Person("moe",
                Person.Sex.MALE,
                LocalDate.of(1989, 7, 21),
                "test4@Test.test");
        network = new SocialNetwork<>(new Person[]{han, von, kev, moe});
    }

    @Test
    public void olderThanTest(){
        SearchCriteria.printPersonsOlderThan(network, 27);
    }

    @Test
    public void withAgeRange(){
        SearchCriteria.printPersonsWithinAgeRange(network, 30, 35);
    }

    @Test
    public void printPerson(){
        Person test = new Person();
        SearchCriteria.printPersons(network, test);
    }

    @Test
    public void anonymousTest(){
        SearchCriteria.printPersons(network, new Person(){
            @Override
            public boolean test(Person p) {
                if(p.getAge() > 25 && p.getGender() == Sex.MALE)
                    return true;
                else
                    return false;
            }
        });
    }

    @Test
    public void lambdaTest(){
        CheckPerson test = p -> p.getAge() > 25;
        SearchCriteria.printPersons(network, test);
    }
}