package javacourses;

public class Note extends Record {
    private String text;
    private String comment;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        String comment = Main.askString("Enter comment: ");
        setText(text);
        setComment(comment);
    }

    @Override
    public boolean contains(String part) {
        return text.contains(part) || comment.contains(part);
    }
}
