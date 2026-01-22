package project;

import java.util.ArrayList;
import java.util.List;

public class LibraryOfUST {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public LibraryOfUST() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public void removeBook(Book book) { books.remove(book); }
    public void addMember(Member member) { members.add(member); }
    public void removeMember(Member member) { members.remove(member); }
    public ArrayList<Book> getBooks() { return books; }
    public ArrayList<Member> getMembers() { return members; }

    // دالة بحث مبسطة
    public List<Book> searchBooks(String type, String keyword) {
        List<Book> results = new ArrayList<>();
        keyword = keyword.toLowerCase();
        for (Book b : books) {
            switch (type) {
                case "اسم الكتاب":
                    if (b.getTitle().toLowerCase().contains(keyword)) results.add(b);
                    break;
                case "المؤلف":
                    if (b.getAuthor().toLowerCase().contains(keyword)) results.add(b);
                    break;
                case "الباركود":
                    if (b.getBarcode().toLowerCase().contains(keyword)) results.add(b);
                    break;
                case "المجال":
                    if (b.getCategory().toLowerCase().contains(keyword)) results.add(b);
                    break;
                case "سنة النشر":
                    if (Integer.toString(b.getYear()).contains(keyword)) results.add(b);
                    break;
            }
        }
        return results;
    }
}
