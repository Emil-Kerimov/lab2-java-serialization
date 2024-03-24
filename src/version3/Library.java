package version3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library implements Externalizable {
    private String name;
    private List<BookStore> bookStores;
    transient private List<BookReader> readers;
    private static final long serialVersionUID = 1L;

    public Library(String name){
        this.name = name;
        this.bookStores = new ArrayList<>();
        this.readers = new ArrayList<>();
    }
    public Library(){}

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
        return "version3.Library " +
                  name +
                ", bookStores = " + bookStores +
                ", readers = " + readers +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(bookStores.size());
        for (BookStore bs: bookStores) {
            bs.writeExternal(out);
        }
        out.writeInt(readers.size());
        for (BookReader br: readers) {
            br.writeExternal(out);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        bookStores = new ArrayList<>();
        readers = new ArrayList<>();

        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            BookStore bookStore = new BookStore();
            bookStore.readExternal(in);
            bookStores.add(bookStore);
        }
        int sizeR = in.readInt();
        for (int i = 0; i < sizeR; i++) {
            BookReader bookReader = new BookReader();
            bookReader.readExternal(in);
            readers.add(bookReader);
        }
    }
}
