package version3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class BookReader extends Human implements Externalizable {
    private int num;
    private List<Book> borrowedBooks;
    public BookReader(String name, String lastName, int num) {
        super(name, lastName);
        this.num = num;
        this.borrowedBooks = new ArrayList<>();
    }
    public BookReader(){}
    public void borrowBook(Book book){
        borrowedBooks.add(book);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString(){
        return " num: " + num + " Books: " + borrowedBooks;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeObject(getName());
        out.writeObject(getLastName());
        out.writeInt(num);

        out.writeInt(borrowedBooks.size());
        for (Book b:borrowedBooks) {
            b.writeExternal(out);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setName((String) in.readObject());
        setLastName((String) in.readObject());
        setNum(in.readInt());

        borrowedBooks = new ArrayList<>();

        int size = in.readInt();

        for (int i = 0; i < size; i++) {
            Book book = new Book();
            book.readExternal(in);
            borrowedBooks.add(book);
        }
    }
}
