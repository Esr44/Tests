package project;

public class Librarian extends User {
    public Librarian(int userId, String name) {
        super(userId, name);
    }

    public void addBook(LibraryOfUST library, Book book) {
        library.addBook(book);
    }

    public void removeBook(LibraryOfUST library, Book book) {
        library.removeBook(book);
    }
}
