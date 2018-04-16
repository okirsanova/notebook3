package javacourses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pet extends Person implements WithBirthday, ThisMonth {
    private String firstName;
    private String specie;
    private LocalDate birthday;


    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSpecie() { return specie; }
    public void setSpecie(String specie) { this.specie = specie;}

    public LocalDate getBirthday() { return birthday; }

    public void setBirthday(LocalDate birthday) { this.birthday = birthday;}

    @Override
    public boolean contains(String part) {
        String strBirthday = Main.DATE_FORMATTER.format(birthday);
        return firstName.contains(part)
                || specie.contains(part)
                || strBirthday.contains(part);
    }

    @Override
    public boolean withbirthday() {
        return false;
    }

    @Override
    public void askUserData ()
    {
        String firstName = Main.askString("Pet Name: ");
        String specie = Main.askString("Pet specie: ");
        LocalDate birthday = Main.askDate("Set birthday: ");

        setFirstName(firstName);
        setSpecie(firstName);
        setBirthday(birthday);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", specie='" + specie + '\'' +
                ", birthday='" + birthday + '\'' +
                "}";
    }

    @Override
    public boolean thisMonth() {
        return false;
    }

//    @Override
////    public boolean thisMonth() {
////        LocalDate month = LocalDate.ofEpochDay();  // check how to set month
////    LocalDate dt = getBirthday();
////        return dt.isBefore(month);
//}

}