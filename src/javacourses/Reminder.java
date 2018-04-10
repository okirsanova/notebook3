package javacourses;

import java.time.LocalDate;

public class Reminder extends Alarm {
    private LocalDate date;

    @Override
    public void askUserData() {
        super.askUserData();
        LocalDate date = Main.askDate("Enter date");
        setDate(date);
    }

    @Override
    public boolean contains(String part) {
        String strDate = Main.DATE_FORMATTER.format(date);
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
        String strDate = Main.DATE_FORMATTER.format(date);
        return "Alarm{" +
                "id=" + getId() +
                ", text=" + getText() +
                ", time='" + getTime() + '\'' +
                ", date='" + strDate + '\'' +
                '}';
    }

}
