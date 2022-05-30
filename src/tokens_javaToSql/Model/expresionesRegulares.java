package tokens_javaToSql.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class expresionesRegulares {
    public boolean letras(String dato){
        Pattern pat = Pattern.compile("[A-Za-z]+");
        Matcher mat = pat.matcher(dato);

        return mat.matches();
    }

    public boolean validarNumeros(String dato){
        Pattern pat = Pattern.compile("[0-9]+");
        Matcher mat = pat.matcher(dato);

        return mat.matches();
    }
}
