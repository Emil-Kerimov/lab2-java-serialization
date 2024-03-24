package version3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookStore implements Externalizable {
    private static final long serialVersionUID = 1L;
    private  String name;
    transient private List<Book> books;

    public BookStore(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    public BookStore(){}

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
        return "version3.BookStore: " + name + "Books: " + books;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(books.size());

        for (Book b: books) {
            b.writeExternal(out);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        int size = in.readInt();

        books = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Book book = new Book();
            book.readExternal(in);
            books.add(book);
        }
    }

}
