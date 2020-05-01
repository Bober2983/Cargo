
import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;

import javafx.scene.control.TextArea;

import javafx.scene.control.TextField;

public class AddPosition {

    @FXML

    private ResourceBundle resources;

    @FXML

    private URL location;

    @FXML

    private TextField position;

    @FXML

    private Button add;

    @FXML

    private TextArea error;

    @FXML

    void initialize() {

        add.setOnAction(even -> {

            DatabaseHandler db = new DatabaseHandler();

            String position_ = position.getText().trim();

            if (!position_.equals("")) {

                db.AddPosit(position_);

                error.setText("должность добавленa!");

                FXMLLoader loader_ = new FXMLLoader();

                add.getScene().getWindow().hide();

            }

            else

                error.setText("заполните все поля");

        });

    }

}