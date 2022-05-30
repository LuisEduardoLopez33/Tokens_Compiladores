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
    expresionesRegulares expresiones = new expresionesRegulares();
    ObservableList<String> entrad = FXCollections.observableArrayList();
    ObservableList<String> reservados = FXCollections.observableArrayList();
    ObservableList<String> delimitadores = FXCollections.observableArrayList();
    ObservableList<String> signos = FXCollections.observableArrayList();
    ObservableList<String> numeros = FXCollections.observableArrayList();
    ObservableList<String> palabra = FXCollections.observableArrayList();

    @FXML
    private TextArea entrada;

    @FXML
    private Label salida;

    @FXML
    void iniciar(MouseEvent event) {

        //guardando al array


        StringTokenizer st = new StringTokenizer(entrada.getText());
            while (st.hasMoreTokens()) {
            //System.out.println(st.nextToken());
            entrad.add(st.nextToken());
        }
//        System.out.println(entrad);

        for (int i = 0; i < entrad.size(); i++){
            comprobarReservados(entrad.get(i));
        }
        System.out.println(reservados);
    }

    void comprobarPalabras(String dato){
        if(expresiones.validarPalabrasRecervadas(dato)){
            System.out.println("si es valido pa");
            palabra.add(dato);
            entrad.remove(dato);
        }
    }

    void comprobarDelimitadores(String dato){
        if(expresiones.validarPalabrasRecervadas(dato)){
            System.out.println("si es valido pa");
            delimitadores.add(dato);
            entrad.remove(dato);
        }
    }

    void comprobarSignos(String dato){
        if(expresiones.validarPalabrasRecervadas(dato)){
            System.out.println("si es valido pa");
            signos.add(dato);
            entrad.remove(dato);
        }
    }

    void comprobarNumeros(String dato){
        if(expresiones.validarPalabrasRecervadas(dato)){
            System.out.println("si es valido pa");
            numeros.add(dato);
            entrad.remove(dato);
        }
    }

    void comprobarReservados(String dato){
        if(expresiones.validarPalabrasRecervadas(dato)){
            System.out.println("si es valido pa");
            reservados.add(dato);
            entrad.remove(dato);
        }
    }

}
