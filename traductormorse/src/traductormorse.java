import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class traductormorse {

    // Vector de los caracteres alfanuméricos en morse
    static String morse[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....",
            "--...", "---..", "----.", "-----"};

    // Vector de los caracteres alfanuméricos
    static String abc123[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
            "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0"};


    public static void main(String[] args) {
        //Creación de variables
        Scanner sc = new Scanner(System.in);
        String opcion;
        String palabra;
        String resultado;
        String continuar = "S";
        String erUnodos = "(1|2)";
        String erSino   = "(S|N)";
        String erAlfanum = "([A-Z|a-z|0-9]+[\\s]{0,1})*";
        String erMorse = "([\\.|-]{1,5}[\\s]?|[\\s]{3})*";
        boolean b;

        do{
            //Despliegue de menú en el CLI
            do {
                System.out.println("PalabraMorse == 1");
                System.out.println("MorsePalabra == 2");
                opcion = sc.nextLine();
                Pattern p = Pattern.compile(erUnodos);
                Matcher m = p.matcher(opcion);
                b = m.matches();
                if (!b) System.out.println("Error en la entrada de datos");
            } while (!b);

            int num = Integer.parseInt(opcion);
            b = false;

            if (num == 1) {
                do {
                    System.out.println("Introduce el texto a traducir a Morse");
                    palabra = sc.nextLine();
                    Pattern p = Pattern.compile(erAlfanum);
                    Matcher m = p.matcher(palabra);
                    b = m.matches();
                    if (!b) System.out.println("Error en la entrada de datos");

                } while (!b);

                resultado = textoamorse(palabra.toLowerCase());
                System.out.println("La palabra en morse es: " + resultado);
            } else if (num == 2) {
                do {
                    System.out.println("Introduce el texto a traducir a ");
                    palabra = sc.nextLine();
                    Pattern p = Pattern.compile(erMorse);
                    Matcher m = p.matcher(palabra);
                    b = m.matches();
                    if (!b) System.out.println("Error en la entrada de datos");

                } while (!b);

                System.out.println(morseatexto(palabra));
            }

            do{
                System.out.println("¿Desea continuar? S/N");
                continuar = sc.nextLine().toUpperCase();
                Pattern p = Pattern.compile(erSino);
                Matcher m = p.matcher(continuar);
                b = m.matches();
                if (!b) System.out.println("Error en la entrada de datos");
            }while (!b);
            if (continuar.equals("N")) b = false;
        }while (b);

    }

    public static String textoamorse(String palabra) {
        // Declaración de variable
        String producto = "";

        //Ciclo que recorre la palabra
        for (int f = 0; f < palabra.length(); f++) {
            //Detección del espacio en blanco
            if (Character.isWhitespace(palabra.charAt(f))) producto += "  ";

            //Ciclo de búsqueda en el vector alfanumérico para convertir a morse
            for (int i = 0; i < abc123.length; i++) {
                if (abc123[i].equals(String.valueOf(palabra.charAt(f)))) {
                    if (f + 1 < palabra.length()) {
                        producto += morse[i] + " ";
                        break;
                    } else {
                        producto += morse[i];
                    }
                }
            }
        }
        return producto;
    }

    public static String morseatexto(String palabra) {
        String pmorse = "";
        String producto = "";

        // Reccorrido de la palabra
        for (int f = 0; f < palabra.length(); f++) {
            if (!Character.isWhitespace(palabra.charAt(f))) pmorse += String.valueOf(palabra.charAt(f));

            // Validación del espacio
            if (Character.isWhitespace(palabra.charAt(f))) {
                for (int i = 0; i < morse.length; i++) {
                    if (morse[i].equals(pmorse)) {
                        producto += abc123[i];
                        pmorse = "";
                    }
                }
                if (Character.isWhitespace(palabra.charAt(f+1)) && Character.isWhitespace(palabra.charAt(f+2))){
                    producto += " ";
                    f = f+2;
                }
            }

            if (f + 1 == palabra.length()) {
                for (int i = 0; i < morse.length; i++) {
                    if (morse[i].equals(pmorse)) producto += abc123[i];
                }
            }
        }
        return producto;
    }
}
