package version2;
import java.util.ArrayList;
import java.util.List;

public class BookReader extends Human  {
    private int num;
    private List<Book> borrowedBooks;
    public BookReader(String name, String lastName, int num) {
        super(name, lastName);
        this.num = num;
        this.borrowedBooks = new ArrayList<>();
    }

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
}
