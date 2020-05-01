import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ShowReportShop {
    Controller shdis = new Controller();
    private ObservableList<ReportShop> ReportShopData = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ReportShop> tableReportSh;

    @FXML
    private TableColumn<ReportShop, Integer> idshop;

    @FXML
    private TableColumn<ReportShop, String> profit;

    @FXML
    private TableColumn<ReportShop, String> expenses;

    @FXML
    private TableColumn<ReportShop, String> date;
    @FXML
    private TableColumn<ReportShop, Integer> id;

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
        DatabaseHandler show = new DatabaseHandler();
        ReportShopData = show.ShowReportSh();

        id.setCellValueFactory(new PropertyValueFactory<ReportShop, Integer>("id"));
        idshop.setCellValueFactory(new PropertyValueFactory<ReportShop, Integer>("idshop"));
        profit.setCellValueFactory(new PropertyValueFactory<ReportShop, String>("profit"));
        expenses.setCellValueFactory(new PropertyValueFactory<ReportShop, String>("expenses"));
        date.setCellValueFactory(new PropertyValueFactory<ReportShop, String>("date"));

        tableReportSh.setItems(ReportShopData);

        update.setOnAction(event -> {
            ReportShopData = show.ShowReportSh();
            tableReportSh.setItems(ReportShopData);
        });
        Del.setOnAction(event -> {
            ReportShop Rshop = tableReportSh.getSelectionModel().getSelectedItem();
            show.Del("report_shop", Rshop.getId());
        });
        Add.setOnAction(event -> {
            shdis.show_display("/sample/addreportshop.fxml");
        });
        Edit.setOnAction(event -> {
            shdis.show_display("/sample/editReportSh.fxml");
        });

    }
}
