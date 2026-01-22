package project;

public class Transaction {
    private static int nextId = 1;
    private int transactionId;
    private Member member;
    private Book book;
    private String issueDate;
    private String returnDate;

    public Transaction(Member member, Book book, String issueDate) {
        this.transactionId = nextId++;
        this.member = member;
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = null;
    }

    public int getTransactionId() { return transactionId; }
    public Member getMember() { return member; }
    public Book getBook() { return book; }
    public String getIssueDate() { return issueDate; }
    public String getReturnDate() { return returnDate; }
    public void setReturnDate(String returnDate) { this.returnDate = returnDate; }
}
