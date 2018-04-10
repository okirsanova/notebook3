package javacourses;

public class Note extends Record {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "Note{" +
                "id=" + getId() +
                ", text='" + text + '\'' +
                ", comment='" + text + '\'' +
                '}';
    }

    @Override
    public void askUserData() {
        String text = Main.askString("Enter note's text: ");
        setText(text);
    }

    @Override
    public boolean contains(String part) {
        return text.contains(part);
    }
}
