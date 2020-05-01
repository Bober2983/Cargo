import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class ShowEmSort {
    private ObservableList<Empl_addr> empData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Empl_addr> tableEmp;

    @FXML
    private TableColumn<Empl_addr, String> full_name;

    @FXML
    private TableColumn<Empl_addr, String> position;

    @FXML
    private TableColumn<Empl_addr, String> address;

    @FXML
    private Button update;

    @FXML
    private TextField zp;

    @FXML
    private TextArea error;

    @FXML
    void initialize() {
        DatabaseHandler db = new DatabaseHandler();
        update.setOnAction(event -> {
            String zpp = zp.getText().trim();
            if (zpp.equals("")) {
                String zp_ = "NiNo";
            }

            empData = db.SortEmp(zpp);
            full_name.setCellValueFactory(new PropertyValueFactory<Empl_addr, String>("full_name"));
            position.setCellValueFactory(new PropertyValueFactory<Empl_addr, String>("position"));
            address.setCellValueFactory(new PropertyValueFactory<Empl_addr, String>("address"));

            tableEmp.setItems(empData);
        });
    }
}
