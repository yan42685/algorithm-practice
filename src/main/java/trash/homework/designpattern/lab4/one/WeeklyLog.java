package trash.homework.designpattern.lab4.one;

public class WeeklyLog implements Cloneable {

    private String author;
    private String date;
    private String content;

    @Override
    public WeeklyLog clone() {
        WeeklyLog clonedLog = null;
        try {
            clonedLog = (WeeklyLog) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone failure");
        }
        return clonedLog;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
