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

public class EditEmployee {
    private ObservableList<Shop> ShopData = FXCollections.observableArrayList();
    private ObservableList<Employee> empData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button idshop1;

    @FXML
    private Button salary1;

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
    private Button name;

    @FXML
    private Button posit;

    @FXML
    private Button age1;

    @FXML
    private TableView<Employee> tableEmp;

    @FXML
    private TableColumn<Employee, Integer> idemp;

    @FXML
    private TableColumn<Employee, String> full_name;


    @FXML
    void initialize() {
        DatabaseHandler base = new DatabaseHandler();
        empData = base.ShowEmployee();
        // устанавливаем тип и значение которое должно хранится в колонке
        idemp.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        full_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("full_name"));
        tableEmp.setItems(empData);
        ShopData = base.ShowShop();

        idsh.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("id"));
        address1.setCellValueFactory(new PropertyValueFactory<Shop, String>("address"));
        tableSh.setItems(ShopData);
        age1.setOnAction(event -> {
            Employee em = tableEmp.getSelectionModel().getSelectedItem();
            String value = newval.getText().trim();
            if (!value.equals("")) {
                base.Edit("employee", "age", "idemployee", em.getId(), value);
                error.setText("информация исправлена!");
            }
            else
                error.setText("заполните поле");
        });
        posit.setOnAction(event -> {
            Employee em = tableEmp.getSelectionModel().getSelectedItem();
            String value = newval.getText().trim();
            if (!value.equals("")) {
                base.Edit("employee", "position", "idemployee", em.getId(), value);
                error.setText("информация исправлена!");
            }
            else
                error.setText("заполните поле");
        });
        name.setOnAction(event -> {
            Employee em = tableEmp.getSelectionModel().getSelectedItem();
            String value = newval.getText().trim();
            if (!value.equals("")) {
                base.Edit("employee", "full_name", "idemployee", em.getId(), value);
                error.setText("информация исправлена!");
            }
            else
                error.setText("заполните поле");
        });
        salary1.setOnAction(event -> {
            Employee em = tableEmp.getSelectionModel().getSelectedItem();
            String value = newval.getText().trim();
            if (!value.equals("")) {
                base.Edit("employee", "salary", "idemployee", em.getId(), value);
                error.setText("информация исправлена!");
            }
            else
                error.setText("заполните поле");
        });
        idshop1.setOnAction(event -> {
            Employee em = tableEmp.getSelectionModel().getSelectedItem();
            Shop sh = tableSh.getSelectionModel().getSelectedItem();
            int id = sh.getId();
            String b = String.valueOf(id);
            base.Edit("employee", "idshop", "idemployee", em.getId(), b);
            error.setText("информация исправлена!");
        });

    }
}
