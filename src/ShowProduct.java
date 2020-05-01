import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowProduct {
    Controller shdis = new Controller();
    private ObservableList<Product> prodData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Product> tableProduct;

    @FXML
    private TableColumn<Product, Integer> id;

    @FXML
    private TableColumn<Product, String> product;

    @FXML
    private TableColumn<Product, Integer> idshop;

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
        DatabaseHandler base = new DatabaseHandler();
        prodData = base.ShowProduct();
        // устанавливаем тип и значение которое должно хранится в колонке
        id.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        product.setCellValueFactory(new PropertyValueFactory<Product, String>("product"));
        idshop.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id_shop"));

        tableProduct.setItems(prodData);

        Del.setOnAction(event -> {
            Product produc = tableProduct.getSelectionModel().getSelectedItem();
            base.Del("product", produc.getId());
        });

        Add.setOnAction(event -> {

            shdis.show_display("/sample/addproduct.fxml");
        });
        update.setOnAction(event -> {
            prodData = base.ShowProduct();
            tableProduct.setItems(prodData);
        });
        Edit.setOnAction(event -> {

            shdis.show_display("/sample/editproduct.fxml");
        });


    }
}
