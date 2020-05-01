import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowPosition {
    Controller shdis = new Controller();
    private ObservableList<Position> Pos_data = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Position> tablePos;

    @FXML
    private TableColumn<Position, Integer> id;

    @FXML
    private TableColumn<Position, String> position;

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
        Pos_data = base.ShowPosition();
        // устанавливаем тип и значение которое должно хранится в колонке
        id.setCellValueFactory(new PropertyValueFactory<Position, Integer>("id"));
        position.setCellValueFactory(new PropertyValueFactory<Position, String>("position"));

        tablePos.setItems(Pos_data);

        Del.setOnAction(event -> {
            Position pos = tablePos.getSelectionModel().getSelectedItem();
            base.Del("position", pos.getId());
        });

        Add.setOnAction(event -> {

            shdis.show_display("/sample/addposition.fxml");
        });
        update.setOnAction(event -> {
            Pos_data = base.ShowPosition();
            tablePos.setItems(Pos_data);
        });
        Edit.setOnAction(event -> {

            shdis.show_display("/sample/editposition.fxml");
        });


    }
}
