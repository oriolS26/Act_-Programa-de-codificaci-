import java.util.Scanner;

public class Conversions {
    public static void main(String[] args) {
        Conversions Program = new Conversions();
        Program.inici();
    }
    public String Detector(String numero) {
        // Comprovem els tipus de numeros
        if (numero.equals("0")) {
            return "error0"; //per controlar errors mes tard

        } else if (numero.length() > 1 && numero.charAt(0) == '0' && numero.charAt(1) == 'b') {
            return "binari";
        } else if (numero.length() > 1 && numero.charAt(0) == '0' && numero.charAt(1) == 'x') {
            return "hexadecimal";
        } else {
            return "decimal";
        }
    }
    
}
