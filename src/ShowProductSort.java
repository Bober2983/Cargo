import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowProductSort {
    private ObservableList<Product> prodData = FXCollections.observableArrayList();
    private ObservableList<Shop> ShopData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button show;

    @FXML
    private TableView<Shop> tableSh;

    @FXML
    private TableColumn<Shop, Integer> idsh;

    @FXML
    private TableColumn<Shop, String> address1;

    @FXML
    private TableView<Product> tableProduct;

    @FXML
    private TableColumn<Product, Integer> id;

    @FXML
    private TableColumn<Product, String> product;

    @FXML
    private TableColumn<Product, Integer> idshop;

    @FXML
    void initialize() {
        DatabaseHandler base = new DatabaseHandler();
        ShopData = base.ShowShop();

        idsh.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("id"));
        address1.setCellValueFactory(new PropertyValueFactory<Shop, String>("address"));
        tableSh.setItems(ShopData);
        show.setOnAction(event -> {
            Shop sh = tableSh.getSelectionModel().getSelectedItem();

            prodData = base.SortProd(sh.getId());
            // устанавливаем тип и значение которое должно хранится в колонке
            id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
            product.setCellValueFactory(new PropertyValueFactory<Product, String>("product"));
            idshop.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id_shop"));

            tableProduct.setItems(prodData);
        });

    }
}
