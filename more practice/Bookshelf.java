import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public final class Bookshelf {
    private ArrayList<Book> books;

    public Bookshelf(Bookshelf bookshelf){
        this.books = new ArrayList<>(bookshelf.books);
    }

    public Bookshelf(Book... books){
        this.books = new ArrayList<>(Arrays.asList(books));
    }

    public void add(Book book){
        this.books.add(book);
    }

    public boolean remove(Book book){
        return this.books.remove(book); // returns true if it removes a book from Arraylists otherwise false
    }

    public boolean contains(Book book){
        return this.books.contains(book);
    }

    public String toString(){
        String format = "Bookshelf%s";

        return String.format(format, this.books);
    }

    public static void main(String[] args){
        var arham = new LiveCoding3("Arham", "Sanjay", "Hundia", 18);
        var arham2 = new LiveCoding3(arham);
        var book = new Book("Life of pi" , arham , LocalDate.now());
        var bookshelf = new Bookshelf(book);

        System.out.println(bookshelf);
    }
}
