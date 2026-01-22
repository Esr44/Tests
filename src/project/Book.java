package project;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String barcode;
    private int year;
    private String category;
    private boolean isAvailable;

    public Book(int bookId, String title, String author, String barcode, int year, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.barcode = barcode;
        this.year = year;
        this.category = category;
        this.isAvailable = true;
    }

    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getBarcode() { return barcode; }
    public int getYear() { return year; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
}
