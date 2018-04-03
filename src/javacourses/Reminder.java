package javacourses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reminder extends Alarm {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final DateTimeFormatter DATE_FORMATTER
                        = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private LocalDate date;

    @Override
    public void askUserData() {
        super.askUserData();
        String strDate = Main.askString("Enter date (" + DATE_FORMAT + "): ");
        LocalDate date = LocalDate.parse(strDate, DATE_FORMATTER);
        setDate(date);
    }

    @Override
    public boolean contains(String part) {
        String strDate = DATE_FORMATTER.format(date);
        return super.contains(part)
                || strDate.contains(part);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String strDate = DATE_FORMATTER.format(date);
        return "Alarm{" +
                "id=" + getId() +
                ", text=" + getText() +
                ", time='" + getTime() + '\'' +
                ", date='" + strDate + '\'' +
                '}';
    }

}
