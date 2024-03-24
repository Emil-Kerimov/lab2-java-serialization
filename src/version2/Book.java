package version2;
import java.io.Serializable;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private int year;
    private int number;

    public Book(String title, List<Author> authors, int year, int number){
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "title: " + title + "Authors: " + authors + ", Year: " + year + ", Number: " + number;
    }
}
