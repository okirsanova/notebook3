package javacourses;

public class Alarm extends Note {
    private String time;

    @Override
    public void askUserData() {
        String text = Main.askString("Enter text message");
        String time = Main.askString("Enter time");

        setText(text);
        setTime(time);
    }

    @Override
    public boolean contains(String part) {
        return getTime().contains(part)
                || getText().contains(part);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
