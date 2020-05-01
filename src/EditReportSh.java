import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class EditReportSh {
    private ObservableList<Shop> ShopData = FXCollections.observableArrayList();
    private ObservableList<ReportShop> ReportShopData = FXCollections.observableArrayList();

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
    private Button expen;

    @FXML
    private Button date1;

    @FXML
    private Button profit1;


    @FXML
    private TableView<ReportShop> tableReportSh;

    @FXML
    private TableColumn<ReportShop, Integer> idshop;

    @FXML
    private TableColumn<ReportShop, String> date;

    @FXML
    private TableColumn<ReportShop, Integer> id;



    @FXML
    void initialize() {
        DatabaseHandler base = new DatabaseHandler();
        ReportShopData = base.ShowReportSh();

        id.setCellValueFactory(new PropertyValueFactory<ReportShop, Integer>("id"));
        idshop.setCellValueFactory(new PropertyValueFactory<ReportShop, Integer>("idshop"));
        date.setCellValueFactory(new PropertyValueFactory<ReportShop, String>("date"));
        tableReportSh.setItems(ReportShopData);

        ShopData = base.ShowShop();
        idsh.setCellValueFactory(new PropertyValueFactory<Shop, Integer>("id"));
        address1.setCellValueFactory(new PropertyValueFactory<Shop, String>("address"));
        tableSh.setItems(ShopData);

        expen.setOnAction(event -> {
            ReportShop em = tableReportSh.getSelectionModel().getSelectedItem();
            String value = newval.getText().trim();
            if (!value.equals("")) {
                base.Edit("report_shop", "expenses", "idreport_shop", em.getId(), value);
                error.setText("информация исправлена!");
            }
            else
                error.setText("заполните поле");
        });
        profit1.setOnAction(event -> {
            ReportShop em = tableReportSh.getSelectionModel().getSelectedItem();
            String value = newval.getText().trim();
            if (!value.equals("")) {
                base.Edit("report_shop", "profit", "idreport_shop", em.getId(), value);
                error.setText("информация исправлена!");
            }
            else
                error.setText("заполните поле");
        });
        date1.setOnAction(event -> {
            ReportShop em = tableReportSh.getSelectionModel().getSelectedItem();
            String value = newval.getText().trim();
            if (!value.equals("")) {
                base.Edit("report_shop", "date", "idreport_shop", em.getId(), value);
                error.setText("информация исправлена!");
            }
            else
                error.setText("заполните поле");
        });

        idshop1.setOnAction(event -> {
            ReportShop em = tableReportSh.getSelectionModel().getSelectedItem();
            Shop sh = tableSh.getSelectionModel().getSelectedItem();
            int id = sh.getId();
            String b = String.valueOf(id);
            base.Edit("report_shop", "idshop", "idreport_shop", em.getId(), b);
            error.setText("информация исправлена!");
        });

    }
}
