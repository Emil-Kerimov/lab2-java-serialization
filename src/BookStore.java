import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookStore implements Serializable {
    private static final long serialVersionUID = 1L;
    private  String name;
    transient private List<Book> books;

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
    private void writeObject(ObjectOutputStream out)throws IOException{
        out.defaultWriteObject();
        out.writeInt(books.size());
        for (Book b: books) {

            out.writeInt(b.getAuthors().size());

            for (Author a:b.getAuthors()) {
                out.writeObject(a.getName());
                out.writeObject(a.getLastName());
            }

            out.writeObject(b.getTitle());
            out.writeInt(b.getYear());
            out.writeInt(b.getNumber());
        }
    }

    private void readObject(ObjectInputStream in)throws IOException ,ClassNotFoundException{
        in.defaultReadObject();
        books = new ArrayList<>();

        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            int authorSize = in.readInt();

            List<Author> authors = new ArrayList<>();

            for (int j = 0; j < authorSize; j++) {
                authors.add(new Author((String) in.readObject(),(String) in.readObject()));
            }

            books.add(new Book((String) in.readObject(),authors,in.readInt(),in.readInt()));
        }
    }

}
