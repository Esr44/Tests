package project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginUI extends Application {
    private LibraryOfUST library;

    public LoginUI() {
        library = new LibraryOfUST();
        library.addBook(new Book(1, "Java Programming", "James Gosling", "BK1001", 2015, "برمجة"));
        library.addBook(new Book(2, "OOP Concepts", "Alan Turing", "BK1002", 2018, "ذكاء صناعي"));
        library.addMember(new Member("Ali Hasan", "2025"));
        library.addMember(new Member("Sara Ahmed", "2026"));
    }

    @Override
    public void start(Stage stage) {
        ToggleGroup roleGroup = new ToggleGroup();
        RadioButton studentBtn = new RadioButton("طالب");
        RadioButton staffBtn = new RadioButton("موظف");
        studentBtn.setToggleGroup(roleGroup);
        staffBtn.setToggleGroup(roleGroup);
        studentBtn.setSelected(true);

        TextField userField = new TextField();
        userField.setPromptText("الرقم الجامعي");
        PasswordField passField = new PasswordField();
        passField.setPromptText("كلمة السر");
        Label msgLabel = new Label();

        Button loginBtn = new Button("دخول");
        loginBtn.setOnAction(e -> {
            String role = ((RadioButton) roleGroup.getSelectedToggle()).getText();
            String input = userField.getText().trim();

            if (role.equals("طالب")) {
                Member m = null;
                for (Member member : library.getMembers()) {
                    if (member.getId().equals(input)) { m = member; break; }
                }
                if (m != null) {
                    LibraryUI.openAsStudent(stage, library, m);
                } else { msgLabel.setText("الطالب غير موجود!"); }
            } else {
                LibraryUI.openAsStaff(stage, library);
            }
        });

        VBox vbox = new VBox(10, studentBtn, staffBtn, userField, passField, loginBtn, msgLabel);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(vbox, 400, 300));
        stage.setTitle("دخول المكتبة");
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
