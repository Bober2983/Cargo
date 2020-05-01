import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowEmployee {
    Controller shdis = new Controller();
    private ObservableList<Employee> empData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Employee> tableEmp;

    @FXML
    private TableColumn<Employee, Integer> idemp;

    @FXML
    private TableColumn<Employee, String> full_name;

    @FXML
    private TableColumn<Employee, String> position;

    @FXML
    private TableColumn<Employee, Integer> idshop;
    @FXML
    private TableColumn<Employee, String> age;

    @FXML
    private TableColumn<Employee, String> salary;

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
        empData = base.ShowEmployee();
        // устанавливаем тип и значение которое должно хранится в колонке
        idemp.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        full_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("full_name"));
        position.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));
        idshop.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id_shop"));
        age.setCellValueFactory(new PropertyValueFactory<Employee, String>("age"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee, String>("salary"));
        // выводим в табл
        tableEmp.setItems(empData);

        Del.setOnAction(event -> {
            Employee emp = tableEmp.getSelectionModel().getSelectedItem();
            base.Del("employee",emp.getId());
        });

        Add.setOnAction(event -> {

            shdis.show_display("/sample/addempl.fxml");
        });
        update.setOnAction(event -> {
            empData = base.ShowEmployee();
            tableEmp.setItems(empData);
        });
        Edit.setOnAction(event -> {

            shdis.show_display("/sample/editEmployee.fxml");
        });


    }
}
