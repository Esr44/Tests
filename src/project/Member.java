package project;

import java.util.ArrayList;

public class Member extends User {
    private String universityNumber;
    private boolean canBorrow;
    private int borrowedCount;
    private ArrayList<Transaction> transactions;

    public Member(String name, String universityNumber) {
        super(0, name);
        this.universityNumber = universityNumber;
        this.canBorrow = true;
        this.borrowedCount = 0;
        this.transactions = new ArrayList<>();
    }

    public String getId() { return universityNumber; }
    public boolean canBorrow() { return canBorrow; }
    public int getBorrowedCount() { return borrowedCount; }

    public void borrowBook(Book book, String issueDate) {
        if (book.isAvailable()) {
            Transaction t = new Transaction(this, book, issueDate);
            transactions.add(t);
            book.setAvailable(false);
            borrowedCount++;
        }
    }

    public void returnBook(Book book, String returnDate) {
        for (Transaction t : transactions) {
            if (t.getBook().equals(book) && t.getReturnDate() == null) {
                t.setReturnDate(returnDate);
                book.setAvailable(true);
                borrowedCount--;
            }
        }
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
