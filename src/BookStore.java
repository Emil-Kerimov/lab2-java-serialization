import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookStore implements Serializable {
    private  String name;
    private List<Book> books;

    public BookStore(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookStore: " + name + "Books: " + books;
    }
}
