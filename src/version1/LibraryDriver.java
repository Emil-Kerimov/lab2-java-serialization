package version1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryDriver {


    public static void serializeObject(String fileName, Object obj){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new
                    FileOutputStream(fileName));
            os.writeObject(obj);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object deSerializeObject(String fileName){
        Object obj = null;
        try {
            ObjectInputStream is = new ObjectInputStream(new
                    FileInputStream(fileName));
            obj = is.readObject();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static void main(String[] args) {
        Author author1 = new Author("Name1", "LastName1");
        Author author2 = new Author("Name2", "LastName2");

        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        Book book1 = new Book("title1", authors, 2000, 1);

        BookStore bookStore = new BookStore("bookStore");
        bookStore.addBook(book1);

        BookReader reader = new BookReader("readerName", "readerLastName", 1);

        Library lib = new Library("lib1");
        lib.addBookStore(bookStore);
        lib.addReader(reader);
        LibraryDriver.serializeObject("lib.ser", lib);
        Object deserlib = LibraryDriver.deSerializeObject("lib.ser");
        System.out.println("Deserialized: " + deserlib);

    }
}