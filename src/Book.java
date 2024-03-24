import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class Book implements Externalizable {
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
    public Book() {}

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
        return "title: " + title + " Authors: " + authors + ", Year: " + year + ", Number: " + number;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeInt(year);
        out.writeInt(number);

        out.writeInt(authors.size());
        for (Author e: authors) {
            e.writeExternal(out);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        year = in.readInt();
        number = in.readInt();

        authors = new ArrayList<>();

        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            Author author = new Author();
            author.readExternal(in);
            authors.add(author);
        }
    }
}
