import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowSortEmpPos {
    private ObservableList<Position> pozData = FXCollections.observableArrayList();
    private ObservableList<Employee> EmpData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button show;
    @FXML
    private TableView<Position> tablePos;

    @FXML
    private TableColumn<Position, Integer> id;

    @FXML
    private TableColumn<Position, String> position1;

    @FXML
    private TableView<Employee> tableEmp;

    @FXML
    private TableColumn<Employee, Integer> idemp;

    @FXML
    private TableColumn<Employee, String> full_name;

    @FXML
    private TableColumn<Employee, String> position;

    @FXML
    void initialize() {
        DatabaseHandler base = new DatabaseHandler();
        pozData = base.ShowPosition();
        id.setCellValueFactory(new PropertyValueFactory<Position, Integer>("id"));
        position1.setCellValueFactory(new PropertyValueFactory<Position, String>("position"));

        tablePos.setItems(pozData);

        show.setOnAction(event -> {
            Position ps = tablePos.getSelectionModel().getSelectedItem();

            EmpData = base.SortEmpPos(ps.getId());
            // устанавливаем тип и значение которое должно хранится в колонке
            idemp.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
            full_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("full_name"));
            position.setCellValueFactory(new PropertyValueFactory<Employee, String>("position"));

            tableEmp.setItems(EmpData);
        });

    }
}
