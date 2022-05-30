package tokens_javaToSql.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class ControllerInicio {

    ObservableList<String> entrad = FXCollections.observableArrayList();

    @FXML
    private TextArea entrada;

    @FXML
    private Label salida;

    @FXML
    void iniciar(MouseEvent event) {
        String[] sa = entrada.getText().split(" ");

        //guardando al array
        for (int i = sa.length-1; i>=0; i--){
            entrad.add(sa[i]);
        }

        System.out.println(entrad);
    }

}
