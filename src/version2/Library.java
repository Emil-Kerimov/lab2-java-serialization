package version2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {
    private String name;
    private List<BookStore> bookStores;
    transient private List<BookReader> readers;
    private static final long serialVersionUID = 1L;

    public Library(String name){
        this.name = name;
        this.bookStores = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    public void addBookStore(BookStore bookStore){
        bookStores.add(bookStore);
    }

    public void addReader(BookReader reader){
        readers.add(reader);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookStore> getBookStores() {
        return bookStores;
    }

    public void setBookStores(List<BookStore> bookStores) {
        this.bookStores = bookStores;
    }

    public List<BookReader> getReaders() {
        return readers;
    }

    public void setReaders(List<BookReader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return "Library " +
                  name +
                ", bookStores = " + bookStores +
                ", readers = " + readers +
                '}';
    }

    private void writeObject(ObjectOutputStream out)throws IOException {
        out.defaultWriteObject();

        out.writeInt(readers.size());

        for (BookReader br: readers) {

            out.writeInt(br.getBorrowedBooks().size());

            for (Book b: br.getBorrowedBooks()) {

                out.writeInt(b.getAuthors().size());

                for (Author a:b.getAuthors()) {
                    out.writeObject(a.getName());
                    out.writeObject(a.getLastName());
                }

                out.writeObject(b.getTitle());
                out.writeInt(b.getNumber());
                out.writeInt(b.getYear());
            }



            out.writeObject(br.getName());
            out.writeObject(br.getLastName());
            out.writeLong(br.getNum());
        }
    }

    private void readObject(ObjectInputStream in)throws IOException ,ClassNotFoundException{
        in.defaultReadObject();
         readers = new ArrayList<>();

        int size = in.readInt();

        for (int i = 0; i < size; i++) {
            ArrayList<Book> books = new ArrayList<>();

            int sizeBooks = in.readInt();

            for (int j = 0; j < sizeBooks; j++) {

                int authorSize = in.readInt();

                List<Author> authors = new ArrayList<>();

                for (int k = 0; k < authorSize; k++) {
                    authors.add(new Author((String) in.readObject(),(String) in.readObject()));
                }

                books.add(new Book((String) in.readObject(),authors,in.readInt(),in.readInt()));
            }


            readers.add(new BookReader((String) in.readObject(),(String) in.readObject(),in.readInt()));

        }
    }
}
