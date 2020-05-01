import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class ShowShop {
    Controller shdis = new Controller();
    private ObservableList<Shop> ShopData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Shop> tableSh;

    @FXML
    private TableColumn<Shop, Integer> idsh;

    @FXML
    private TableColumn<Shop, String> address;

    @FXML
    private TableColumn<Shop, String> email;

    @FXML
    private Button Add;

    @FXML
    private Button Del;

    @FXML
    private Button Edit;

    @FXML
    private Button update;

    @FXML
    void initialize() {
        DatabaseHandler show = new DatabaseHandler();
        ShopData = show.ShowShop();
        tableSh.setEditable(true);
        idsh.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("id"));
        address.setCellFactory(TextFieldTableCell.forTableColumn());
        address.setCellValueFactory(new PropertyValueFactory<Shop, String>("address"));
        email.setCellValueFactory(new PropertyValueFactory<Shop, String>("email"));

        tableSh.setItems(ShopData);

        update.setOnAction(event -> {
            ShopData = show.ShowShop();
            tableSh.setItems(ShopData);
        });
        Add.setOnAction(event -> {
            shdis.show_display("/sample/addshop.fxml");
        });
        Del.setOnAction(event -> {
            Shop shop = tableSh.getSelectionModel().getSelectedItem();
            show.Del("shop", shop.getId());
        });

        Edit.setOnAction(event -> {
            shdis.show_display("/sample/EditShop.fxml");
        });
    }
}
