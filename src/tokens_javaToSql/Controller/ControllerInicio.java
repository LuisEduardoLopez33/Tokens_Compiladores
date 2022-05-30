package tokens_javaToSql.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import tokens_javaToSql.Model.expresionesRegulares;
import java.util.StringTokenizer;

public class ControllerInicio {

    ObservableList<String> entrad = FXCollections.observableArrayList();

    @FXML
    private TextArea entrada;

    @FXML
    private Label salida;

    @FXML
    void iniciar(MouseEvent event) {
        expresionesRegulares expresiones = new expresionesRegulares();

        //guardando al array


        StringTokenizer st = new StringTokenizer(entrada.getText());
            while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
            //entrad.add(st.nextToken());
        }
            if(expresiones.validarPalabrasRecervadas(entrada.getText())){
                System.out.println("si es valido pa");
            }
            else{
                System.out.println("yo creo que no se va a poder mi pa");
            }
    }

}
