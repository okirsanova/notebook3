package javacourses;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class Alarm extends Note {
    private LocalTime time;



    @Override
    public void askUserData() {
            super.askUserData();
LocalTime time = Main.askTime("Enter time: ");
        setTime(time);}

    @Override
    public boolean contains(String part) {
        String strTime = Main.TIME_FORMATTER.format(time);
        return strTime.contains(part)
                || super.contains(part);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

        @Override
    public String toString() {
        return "Alarm{" +
                "id=" + getId() +
                ", text=" + getText() +
                ", time='" + time + '\'' +
                '}';
    }
}
