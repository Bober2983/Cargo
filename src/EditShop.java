import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditShop {
    private ObservableList<Shop> ShopData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button address;

    @FXML
    private Button email;

    @FXML
    private TextArea error;

    @FXML
    private TextField newval;

    @FXML
    private TableView<Shop> tableSh;

    @FXML
    private TableColumn<Shop, Integer> idsh;

    @FXML
    private TableColumn<Shop, String> address1;

    @FXML
    private TableColumn<Shop, String> email1;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ShopData = dbHandler.ShowShop();

        idsh.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("id"));
        address1.setCellValueFactory(new PropertyValueFactory<Shop, String>("address"));
        email1.setCellValueFactory(new PropertyValueFactory<Shop, String>("email"));

        tableSh.setItems(ShopData);

        address.setOnAction(event -> {
            Shop sh = tableSh.getSelectionModel().getSelectedItem();
            String value = newval.getText().trim();
            if (!value.equals("")) {

                dbHandler.Edit("shop", "address", "idshop", sh.getId(), value);
                error.setText("информация исправлена!");

            }
            else
                error.setText("заполните поле");

        });
        email.setOnAction(event -> {
            Shop sh = tableSh.getSelectionModel().getSelectedItem();
            String value = newval.getText().trim();
            if (!value.equals("")) {
                dbHandler.Edit("shop", "email", "idshop", sh.getId(), value);
                error.setText("информация исправлена!");
            }
            else
                error.setText("заполните поле");
        });

    }
}
