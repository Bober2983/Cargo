import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class editposition {
    private ObservableList<Position> Pos_data = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button position1;

    @FXML
    private TextArea error;

    @FXML
    private TextField newval;

    @FXML
    private TableView<Position> tablePos;

    @FXML
    private TableColumn<Position, Integer> id;

    @FXML
    private TableColumn<Position, String> position;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Pos_data = dbHandler.ShowPosition();
        id.setCellValueFactory(new PropertyValueFactory<Position, Integer>("id"));
        position.setCellValueFactory(new PropertyValueFactory<Position, String>("position"));
        tablePos.setItems(Pos_data);

        position1.setOnAction(event -> {
            Position pos = tablePos.getSelectionModel().getSelectedItem();
            String value = newval.getText().trim();
            if (!value.equals("")) {

                dbHandler.Edit("position", "position", "idposition", pos.getId(), value);
                error.setText("информация исправлена!");
            }
            else
                error.setText("заполните поле");

        });


    }
}
