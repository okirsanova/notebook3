package javacourses;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reminder extends Alarm implements Expirable {
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
    public boolean isExpired() {
        LocalDateTime nowDT = LocalDateTime.now();
        LocalDateTime dt = getDate().atTime(getTime());
        return dt.isBefore(nowDT);
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
