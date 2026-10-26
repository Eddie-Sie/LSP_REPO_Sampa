package org.howard.edu.lsp.midterm.crccards;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/** Manages the library's collection and borrowing limit.
 * @author Edward Sie
 */
public class Library {
    private final Map<String, Book> books = new HashMap<>();
    private int borrowedCount = 0;
    /** Adds a new book.
     * @param book book to add
     * @throws IllegalArgumentException if the ISBN is already present
     */
    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn()))
            throw new IllegalArgumentException("Duplicate ISBN");
        books.put(book.getIsbn(), book);
    }
    /** Finds a book by ISBN.
     * @param isbn ISBN to find
     * @return matching book, or null
     */
    public Book findBook(String isbn) { return books.get(isbn); }
    /** Borrows a book when possible.
     * @param isbn ISBN to borrow
     * @throws IllegalArgumentException if ISBN does not exist
     * @throws IllegalStateException if unavailable or limit reached
     */
    public void borrowBook(String isbn) {
        Book book = findBook(isbn);
        if (book == null) throw new IllegalArgumentException("Book not found");
        if (!book.isAvailable()) throw new IllegalStateException("Already borrowed");
        if (borrowedCount >= 3) throw new IllegalStateException("Limit reached");
        book.borrowBook();
        borrowedCount++;
    }
    /** Returns a borrowed book.
     * @param isbn ISBN to return
     * @throws IllegalArgumentException if ISBN does not exist
     * @throws IllegalStateException if book is already available
     */
    public void returnBook(String isbn) {
        Book book = findBook(isbn);
        if (book == null) throw new IllegalArgumentException("Book not found");
        book.returnBook();
        borrowedCount--;
    }
    /** @return all currently available books */
    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values())
            if (book.isAvailable()) result.add(book);
        return result;
    }
    /** Finds books by exact author name.
     * @param author author to find (case-sensitive)
     * @return matching books, including borrowed books
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books.values())
            if (book.getAuthor().equals(author)) result.add(book);
        return result;
    }
    /** @return all books sorted by ISBN ascending */
    public List<Book> getBooksSortedByIsbn() {
        List<Book> result = new ArrayList<>(books.values());
        result.sort((a, b) -> a.getIsbn().compareTo(b.getIsbn()));
        return result;
    }
    /** @return number of books currently borrowed */
    public int getBorrowedBookCount() { return borrowedCount; }
}
