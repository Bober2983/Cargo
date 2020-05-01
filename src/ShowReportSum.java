import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowReportSum {
    private ObservableList<Employee> EmpData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button show;

    @FXML
    private TableView<Employee> tableEmp;

    @FXML
    private TableColumn<Employee, Integer> idemp;

    @FXML
    private TableColumn<Employee, String> full_name;

    @FXML
    private TableColumn<Employee, String> position;

    @FXML
    private TextArea rez;
    @FXML
    void initialize() {
        DatabaseHandler base = new DatabaseHandler();
        EmpData = base.ShowEmployee();
        // устанавливаем тип и значение которое должно хранится в колонке
        idemp.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        full_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("full_name"));
        position.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));

        tableEmp.setItems(EmpData);
        show.setOnAction(event -> {
            Employee em = tableEmp.getSelectionModel().getSelectedItem();
            int sum;
            sum = base.SortReport(em.getId());
            // устанавливаем тип и значение которое должно хранится в колонке
            String sum_ = "" + sum;
            rez.setText(sum_);
        });

    }
}
