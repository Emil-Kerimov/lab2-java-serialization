package version3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryDriver {


    public static void serializeObject(String fileName, Externalizable ex){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            ex.writeExternal(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Library deSerializeObject(String fileName){
        Library library = new Library();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
            library.readExternal(inputStream);
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return library;
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
        LibraryDriver.serializeObject("libVer3.ser", lib);
        Object deserlib = LibraryDriver.deSerializeObject("libVer3.ser");
        System.out.println("Deserialized: " + deserlib);

    }
}