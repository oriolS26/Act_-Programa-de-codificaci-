import java.util.Scanner;

public class Conversions {
    public static void main(String[] args) {
        Conversions Program = new Conversions();
        Program.inici();
    }
    public void inici() {
        Scanner scanner = new Scanner(System.in);
        String entrada;

        do {
            try {
                System.out.println("Introdueix un número (binari: 0b..., hexadecimal: 0x..., decimal: ...). Escriu 'exit' per acabar:");
                entrada = scanner.nextLine().trim();

                if (entrada.equalsIgnoreCase("exit")) {
                    System.out.println("Sortint del programa.");
                    break;
                }

                if (entrada.length() == 0) {
                    System.out.println("Error: no pots deixar el camp buit.\n");
                    continue;
                }

                String tipus = Detector(entrada);

                if (tipus.equals("error0")) {
                    System.out.println("Error: no pots introduir només un 0.\n");
                    continue;
                }

                int valorDecimal = 0;

                if (tipus.equals("binari")) {
                    valorDecimal = binariAdecimal(entrada);
                    if (valorDecimal == -1) continue;
                } else if (tipus.equals("hexadecimal")) {
                    valorDecimal = hexadecimalAdecimal(entrada);
                    if (valorDecimal == -1) continue;
                } else { // decimal
                    if (!entrada.matches("[0-9]+")) {
                        System.out.println("Error: número decimal invàlid (només dígits 0-9).\n");
                        continue;
                    }
                    valorDecimal = Integer.parseInt(entrada);
                }

                System.out.println("\n=== RESULTATS ===");
                System.out.println("Decimal: " + valorDecimal);
                System.out.println("Binari: " + decimalABinari(valorDecimal));
                System.out.println("Hexadecimal: " + decimalAHexadecimal(valorDecimal));
                System.out.println();

            } catch (Exception e) {
                System.out.println("S'ha produït un error inesperat. Torna-ho a provar.\n");
            }

        } while (true); // continuem fins que l'usuari escrigui "exit"
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
    public int hexadecimalAdecimal(String numero) {
        int decimal = 0;
        for (int posicio = 0; posicio < numero.length(); posicio++) {
            char caracter = numero.charAt(posicio);

            if (!((posicio == 0 && caracter == '0') || (posicio == 1 && caracter == 'x'))) {
                decimal = decimal * 16;
                if (caracter >= '0' && caracter <= '9') {
                    decimal += caracter - '0';
                } else if (caracter >= 'A' && caracter <= 'F') {
                    decimal += caracter - 'A' + 10;
                } else if (caracter >= 'a' && caracter <= 'f') {
                    decimal += caracter - 'a' + 10;
                } else {
                    System.out.println("Número hexadecimal invàlid (només dígits 0-9 i lletres A-F)");
                    return -1;  
                }
            }
        }
        return decimal;
    }
    
}
