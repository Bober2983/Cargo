import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;

import javafx.scene.control.TextArea;

import javafx.scene.control.TextField;

public class AddShop {

    @FXML

    private ResourceBundle resources;

    @FXML

    private URL location;

    @FXML

    private TextField address;

    @FXML

    private TextField email;

    @FXML

    private Button add;

    @FXML

    private TextArea error;

    @FXML

    void initialize() {

        add.setOnAction(even -> {

            DatabaseHandler db = new DatabaseHandler();

            String address_ = address.getText().trim();

            String email_ = email.getText().trim();

            if (!address_.equals("") && !email_.equals("")) {

                db.AddShop(address_, email_);

                error.setText("магазин добавлен!");

                FXMLLoader loader_ = new FXMLLoader();

                loader_.setLocation(getClass().getResource("/sample/sample.fxml"));

                add.getScene().getWindow().hide();

            }

            else

                error.setText("заполните все поля");

        });

    }

}