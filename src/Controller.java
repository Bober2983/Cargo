import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Employee;

    @FXML
    private Button Shop;

    @FXML
    private Button reportshop;

    @FXML
    private Button ok;
    @FXML
    private Button ok1;
    @FXML
    private Button ok2;
    @FXML
    private Button ok11;

    @FXML
    private Button position;

    @FXML
    private Button product;


    @FXML
    void initialize() {
        Employee.setOnAction(event -> {
            show_display("/sample/showemployee.fxml");

        });
        Shop.setOnAction(event -> {
            show_display("/sample/showshop.fxml");

        });
        reportshop.setOnAction(event -> {
            show_display("/sample/showreportshop.fxml");

        });

        ok.setOnAction(event -> {
            show_display("/sample/showeplsort.fxml");


        });

        ok1.setOnAction(event -> {
            show_display("/sample/showproductsort.fxml");


        });
        ok2.setOnAction(event -> {
            show_display("/sample/showsortemppos.fxml");


        });
        ok11.setOnAction(event -> {
            show_display("/sample/showreportsum.fxml");


        });

        position.setOnAction(event -> {
            show_display("/sample/showposition.fxml");

        });
        product.setOnAction(event -> {
            show_display("/sample/showproduct.fxml");

        });

    }
    void show_display(String name){
        FXMLLoader delFx = new FXMLLoader();
        delFx.setLocation(getClass().getResource(name));

        try {
            delFx.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root_ = delFx.getRoot();
        Stage show = new Stage();
        show.setScene(new Scene(root_));
        show.showAndWait();
    }
}
