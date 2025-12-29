package library.sp1ta4le1ex1;

import java.util.Objects;

public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        // Fer equals case-insensitive per ser consistent amb hashCode
        return Objects.equals(title.toLowerCase(), book.title.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase());
    }
}