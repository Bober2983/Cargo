import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.util.ResourceBundle;

public class AddReportShop {

    Controller shdis = new Controller();

    private ObservableList<Shop> ShopData = FXCollections.observableArrayList();

    @FXML

    private ResourceBundle resources;

    @FXML

    private URL location;

    @FXML

    private TextField profit;

    @FXML

    private TextField expenses;

    @FXML

    private TextField date;

    @FXML

    private Button add;

    @FXML

    private TextArea error;

    @FXML

    private TableView<Shop> tableSh;

    @FXML

    private TableColumn<Shop, Integer> idsh;

    @FXML

    private TableColumn<Shop, String> address;

    @FXML

    private TableColumn<Shop, String> email;

    @FXML

    void initialize() {

        DatabaseHandler dbHandler = new DatabaseHandler();

        ShopData = dbHandler.ShowShop();

        idsh.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("id"));

        address.setCellValueFactory(new PropertyValueFactory<Shop, String>("address"));

        email.setCellValueFactory(new PropertyValueFactory<Shop, String>("email"));

        tableSh.setItems(ShopData);

        add.setOnAction(even -> {

            Shop sh = tableSh.getSelectionModel().getSelectedItem();

            String prof = profit.getText().trim();

            String expen = expenses.getText().trim();

            String dat = date.getText().trim();

            if (!prof.equals("") && !expen.equals("") && !dat.equals("")) {

                if (prof.matches("[-+]?\\d+") == true && expen.matches("[-+]?\\d+") == true && dat.matches("[-+]?\\d+") == true){

                    dbHandler.AddReportSh(prof, expen, sh.getId(), dat);

                    error.setText("oтчет добавлен!");

                }

                else

                    error.setText("только цифры");}

            else

                error.setText("заполните все поля");

        });

    }

}