package com.mycompany.libraryofust;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // ضبط الترميز الافتراضي على UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        LibraryOfUST library = new LibraryOfUST();

        // إضافة كتب باستخدام الكونستركتور الجديد مع barcode وcategory
        Book book1 = new Book(1, "Java Programming", "James Gosling", "BK1001", 2015, "برمجة", true);
        Book book2 = new Book(2, "OOP Concepts", "Alan Turing", "BK1002", 2018, "ذكاء صناعي", true);
        library.addBook(book1);
        library.addBook(book2);

        // إضافة عضو جديد
        Member member1 = new Member(1, "Ali Hasan", "ali@email.com", "0551234567", "2025-09-29");
        library.addMember(member1);

        // استعارة كتاب
        member1.borrowBook(book1, "2025-09-29");

        // طباعة حالة الكتب بعد الاستعارة
        for (Book b : library.getBooks()) {
            System.out.println(b.getTitle() + " | متوفر؟ " + b.isAvailable());
        }

        // إرجاع كتاب
        member1.returnBook(book1, "2025-10-01");

        // طباعة حالة الكتب بعد الإرجاع
        for (Book b : library.getBooks()) {
            System.out.println(b.getTitle() + " | متوفر؟ " + b.isAvailable());
        }
    }
}
