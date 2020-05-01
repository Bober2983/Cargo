import java.net.URL;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;

public class AddProduct {

    Controller shdis = new Controller();

    private ObservableList<Shop> ShopData = FXCollections.observableArrayList();

    @FXML

    private ResourceBundle resources;

    @FXML

    private URL location;

    @FXML

    private TextField product;

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

            String product_ = product.getText().trim();

            if (!product_.equals("")) {

                dbHandler.AddProduct(product_, sh.getId());

                error.setText("продукт добавлен!");

                ShopData = dbHandler.ShowShop();

                tableSh.setItems(ShopData);

            }

            else

                error.setText("заполните все поля");

        });

    }

}
