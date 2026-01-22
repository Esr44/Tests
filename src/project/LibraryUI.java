package project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LibraryUI {

    public static void openAsStudent(Stage stage, LibraryOfUST library, Member member) {
        TableView<Book> table = new TableView<>();
        TableColumn<Book, Integer> idCol = new TableColumn<>("الباركود"); idCol.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        TableColumn<Book, String> titleCol = new TableColumn<>("العنوان"); titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Book, String> availCol = new TableColumn<>("متوفر؟"); availCol.setCellValueFactory(cell -> FXCollections.observableValue(cell.getValue().isAvailable() ? "نعم" : "لا"));
        table.getColumns().addAll(idCol, titleCol, availCol);
        table.setItems(FXCollections.observableArrayList(library.getBooks()));

        Button borrowBtn = new Button("استعارة");
        borrowBtn.setOnAction(e -> {
            Book b = table.getSelectionModel().getSelectedItem();
            if (b != null && b.isAvailable()) {
                member.borrowBook(b, "اليوم");
                table.refresh();
            }
        });

        VBox vbox = new VBox(10, table, borrowBtn);
        vbox.setPadding(new Insets(20));
        stage.setScene(new Scene(vbox, 500, 400));
        stage.setTitle("واجهة الطالب");
        stage.show();
    }

    public static void openAsStaff(Stage stage, LibraryOfUST library) {
        TableView<Book> table = new TableView<>();
        TableColumn<Book, Integer> idCol = new TableColumn<>("الباركود"); idCol.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        TableColumn<Book, String> titleCol = new TableColumn<>("العنوان"); titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        TableColumn<Book, String> availCol = new TableColumn<>("متوفر؟"); availCol.setCellValueFactory(cell -> FXCollections.observableValue(cell.getValue().isAvailable() ? "نعم" : "لا"));
        table.getColumns().addAll(idCol, titleCol, availCol);
        table.setItems(FXCollections.observableArrayList(library.getBooks()));

        VBox vbox = new VBox(10, table);
        vbox.setPadding(new Insets(20));
        stage.setScene(new Scene(vbox, 500, 400));
        stage.setTitle("واجهة الموظف");
        stage.show();
    }
}
