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
    private String birthday;


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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public LocalDate getBirthday() {
        return birthday();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday() = birthday();
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

    @Override
    public boolean contains(String part) {
        String birthday = Main.DATE_FORMATTER.format(birthday);
        {
            return super.contains(part)
                    || birthday.contains(part);
        }

        @Override
        public static LocalDate askDate(String message) {
            String getBirthday = Main.askDate(message + "(" + DATE_FORMAT + ")");
            LocalDate getBirthday = Main.askDate("Enter birthday date: ");
            withbirthday();
            LocalDate date = LocalDate.parse(birthday, DATE_FORMATTER);
            setBirthday(birthday);
        }

        @Override
        public void askUserData ();
        {
            String firstName = Main.askString("First Name: ");
            String lastName = Main.askString("Last Name: ");
            String phone = Main.askString("Phone: ");
            String email = Main.askString("Email: ");

            setFirstName(firstName);
            setLastName(lastName);
            setPhone(phone);
            setEmail(email);

        }
    }
}

//    @Override
//    public void askUserData() {
//        super.askUserData();
//        LocalDate birthday = Main.askDate("Enter date: ");
//        setBirthday(birthday);
//    }


//
//    @Override
//    public boolean contains(String part) {
//        return firstName.contains(part)
//                || lastName.contains(part)
//                || phone.contains(part)
//                || email.contains(part);
//                || birthday.contains(part);
//    }


//    @Override
//    public boolean isExpired() {
//        LocalDate nowDT = LocalDate.now();
//        LocalDate dt = getBirthday();
//        return dt.isBefore(nowDT);
//    }
