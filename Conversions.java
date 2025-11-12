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
    public int binariAdecimal(String numero) {
        int decimal = 0;
        for (int posicio = 0; posicio < numero.length(); posicio++) {
            char caracter = numero.charAt(posicio);

            if (!((posicio == 0 && caracter == '0') || (posicio == 1 && caracter == 'b'))) {
                if (caracter == '1') {
                    decimal = decimal * 2 + 1;
                }
                else if (caracter == '0') {
                    decimal = decimal * 2 + 0;
                }
                else {
                    System.out.println("Número binari invàlid (només 0 o 1)");
                    return -1;  
                }
            }
        }
        return decimal;
    }
}
