package org.howard.edu.lsp.midterm.crccards;
/** Stores one book's information and controls its borrowing state.
 * @author Edward Sie
 */
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private boolean available;
    /** Creates an available book.
     * @param isbn unique book ISBN
     * @param title book title
     * @param author book author
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }
    /** @return the ISBN */
    public String getIsbn() { return isbn; }
    /** @return the title */
    public String getTitle() { return title; }
    /** @return the author */
    public String getAuthor() { return author; }
    /** @return true when the book is available */
    public boolean isAvailable() { return available; }
    /** Marks the book borrowed.
     * @throws IllegalStateException if already borrowed
     */
    public void borrowBook() {
        if (!available) throw new IllegalStateException("Book already borrowed");
        available = false;
    }
    /** Marks the book available.
     * @throws IllegalStateException if already available
     */
    public void returnBook() {
        if (available) throw new IllegalStateException("Book already available");
        available = true;
    }
    /** @return formatted book information and availability */
    @Override public String toString() {
        return isbn + " " + title + " by " + author +
                (available ? " [AVAILABLE]" : " [BORROWED]");
    }
}
