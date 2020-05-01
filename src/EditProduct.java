import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditProduct {
    private ObservableList<Shop> ShopData = FXCollections.observableArrayList();
    private ObservableList<Product> prodData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button idshop1;


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
    private Button product;

    @FXML
    private TableView<Product> tableProduct;

    @FXML
    private TableColumn<Product, Integer> id;

    @FXML
    private TableColumn<Product, String> product1;

    @FXML
    private TableColumn<Product, Integer> idshop;


    @FXML
    void initialize() {
        DatabaseHandler base = new DatabaseHandler();
        prodData = base.ShowProduct();
        // устанавливаем тип и значение которое должно хранится в колонке
        id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        product1.setCellValueFactory(new PropertyValueFactory<Product, String>("product"));
        idshop.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id_shop"));
        tableProduct.setItems(prodData);

        ShopData = base.ShowShop();
        idsh.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("id"));
        address1.setCellValueFactory(new PropertyValueFactory<Shop, String>("address"));
        tableSh.setItems(ShopData);

        product.setOnAction(event -> {
            Product pr = tableProduct.getSelectionModel().getSelectedItem();
            String value = newval.getText().trim();
            if (!value.equals("")) {
                base.Edit("product", "product", "idproduct", pr.getId(), value);
                error.setText("информация исправлена!");
            }
            else
                error.setText("заполните поле");
        });

        idshop1.setOnAction(event -> {
            Product pr = tableProduct.getSelectionModel().getSelectedItem();
            Shop sh = tableSh.getSelectionModel().getSelectedItem();
            int id = sh.getId();
            String b = String.valueOf(id);
            base.Edit("product", "idshop", "idproduct", pr.getId(), b);
            error.setText("информация исправлена!");
        });

    }
}
