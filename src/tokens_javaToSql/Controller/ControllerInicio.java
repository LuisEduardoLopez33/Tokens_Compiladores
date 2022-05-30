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
    ObservableList<String> incorrectos = FXCollections.observableArrayList();

    @FXML
    private TextArea entrada;

    @FXML
    private Label salida;

    @FXML
    private TextArea result;

    @FXML
    void iniciar(MouseEvent event) {
        entrad.clear();
        reservados.clear();
        delimitadores.clear();
        signos.clear();
        numeros.clear();
        palabra.clear();
        incorrectos.clear();

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
        System.out.println(delimitadores);
        System.out.println(palabra);
        System.out.println(signos);
        System.out.println(numeros);
        System.out.println(incorrectos);

        resultados();
    }
    void comprobarReservados(String dato){
        boolean aux = false;
        if(expresiones.validarPalabrasRecervadas(dato)){
            reservados.add(dato);
            aux = true;
        }else {
            comprobarPalabras(dato);
        }

    }
    void comprobarPalabras(String dato){
        if(expresiones.validarLetras(dato)){
            palabra.add(dato);
        }else{
            comprobarDelimitadores(dato);
        }
    }

    void comprobarDelimitadores(String dato){
        if(expresiones.validarDelimitadores(dato)){
            delimitadores.add(dato);
        }else{
            comprobarSignos(dato);
        }
    }

    void comprobarSignos(String dato){
        if(expresiones.validarSignos(dato)){
            signos.add(dato);
        }else{
            comprobarNumeros(dato);
        }
    }

    void comprobarNumeros(String dato){
        if(expresiones.validarNumeros(dato)){
            numeros.add(dato);
        }else{
            datoIncorreto(dato);
        }
    }

    void datoIncorreto(String dato){
        incorrectos.add(dato);
    }

    void resultados(){
        result.setText("Palabras Reservadas --> "+ reservados + "\n" + "Palabras --> " + palabra + "\n"
                + "Numeros --> " + numeros + "\n" + "Delimitadores --> "
                + delimitadores + "\n" + "Signos --> " + signos + "\n" + "Erroneos --> " + incorrectos);
//        result.setText("Palabras --> " + palabra);
//        result.setText("Numeros --> " + numeros);
//        result.setText("Delimitadores --> " + delimitadores);
//        result.setText("Signos --> " + signos);
    }


}
