import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Person implements CheckPerson{

    public enum Sex {
        MALE, FEMALE
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name, Sex gender, LocalDate birthday, String emailAddress){
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.emailAddress = emailAddress;
    }

    public Person(){}

    public int getAge(){
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public void printPerson(){
        System.out.printf("Name: %1s\nGender: %2s\nBirthday: %3s\nEmail: %4s\n",
                name, gender.toString(),
                birthday.format(DateTimeFormatter.ISO_LOCAL_DATE), emailAddress);
    }

    public boolean test(Person p) {
        if(p.getAge() > 24 && p.gender == Sex.FEMALE)
            return true;
        else
            return false;
    }
}
