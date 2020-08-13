import java.time.LocalDate;
import java.time.Period;


public class Book {
    private String title;
    private LiveCoding3 author;
    private LocalDate publicationDate;


    public Book (Book book){
        this(book.title, book.author, book.publicationDate);
    }



    public Book (String title, LiveCoding3 author, LocalDate publicationDate){
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public String getTitle(){
        return this.title;
    }

    public LiveCoding3 getAuthor() {
        return this.author;
    }

    public LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    public String toString() {
        String format = "Book[%s, %s, %s] ";
        return String.format(format, getAuthor(), getPublicationDate(), getTitle());
    }
}
