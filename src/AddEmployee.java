
import java.net.URL;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;

public class AddEmployee {

    Controller shdis = new Controller();

    private ObservableList<Shop> ShopData = FXCollections.observableArrayList();

    @FXML

    private ResourceBundle resources;

    @FXML

    private URL location;

    @FXML

    private TextField full_name;

    @FXML

    private TextField position;

    @FXML

    private Button add;

    @FXML

    private TextArea error;

    @FXML

    private TableView<Shop> tableSh;

    @FXML

    private TableColumn<Shop, Integer> idsh;

    @FXML

    private TableColumn<Shop, String> address;

    @FXML

    private TableColumn<Shop, String> email;

    @FXML

    private TextField age;

    @FXML

    private TextField salary;

    private ObservableList<Position> Pos_data = FXCollections.observableArrayList();

    @FXML

    private TableView<Position> tablePos;

    @FXML

    private TableColumn<Position, Integer> id;

    @FXML

    private TableColumn<Position, String> position1;

    @FXML

    void initialize() {

        DatabaseHandler dbHandler = new DatabaseHandler();

        Pos_data = dbHandler.ShowPosition();

// устанавливаем тип и значение которое должно хранится в колонке

        id.setCellValueFactory(new PropertyValueFactory<Position, Integer>("id"));

        position1.setCellValueFactory(new PropertyValueFactory<Position, String>("position"));

        tablePos.setItems(Pos_data);

        ShopData = dbHandler.ShowShop();

        idsh.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("id"));

        address.setCellValueFactory(new PropertyValueFactory<Shop, String>("address"));

        email.setCellValueFactory(new PropertyValueFactory<Shop, String>("email"));

        tableSh.setItems(ShopData);

        add.setOnAction(even -> {

            Shop sh = tableSh.getSelectionModel().getSelectedItem();

            Position ps = tablePos.getSelectionModel().getSelectedItem();

            String name = full_name.getText().trim();

            String age_ = age.getText().trim();

            String salary_ = salary.getText().trim();

            if (!name.equals("") && !age_.equals("") && !salary_.equals("")) {

                if (salary_.matches("[-+]?\\d+") == true && age_.matches("[-+]?\\d+") == true){

                    dbHandler.AddEmployee(name, ps.getPosition(), sh.getId(), age_, salary_, ps.getId());

                    error.setText("сотрудник добавлен!");

                    ShopData = dbHandler.ShowShop();

                    tableSh.setItems(ShopData);}

                else

                    error.setText("ЗП,Возраст - только числа");

            }

            else

                error.setText("заполните все поля");

        });

    }

}