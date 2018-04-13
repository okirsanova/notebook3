package javacourses;

import org.relaxng.datatype.DatatypeException;
import sun.util.calendar.LocalGregorianCalendar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Person extends Record implements WithBirthday {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                "}";
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean contains(String part) {
        String strBirthday = Main.DATE_FORMATTER.format(birthday);
        return firstName.contains(part)
                || lastName.contains(part)
                || phone.contains(part)
                || email.contains(part)
                || strBirthday.contains(part);
    }

    @Override
    public void askUserData ()
    {
        String firstName = Main.askString("First Name: ");
        String lastName = Main.askString("Last Name: ");
        String phone = Main.askString("Phone: ");
        String email = Main.askString("Email: ");
        LocalDate birthday = Main.askDate("Set birthday: ");

        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setEmail(email);
        setBirthday(birthday);
    }

    @Override
    public boolean withbirthday() {
        return false;
    }
}


//    @Override
//    public boolean isExpired() {
//        LocalDate nowDT = LocalDate.now();
//        LocalDate dt = getBirthday();
//        return dt.isBefore(nowDT);
//    }
