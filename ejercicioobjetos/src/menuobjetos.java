import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class menuobjetos {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String ER = ("[0-9]+\\.?[0-9]*");
        String ER2 = ("[0-2]");
        String M = ("[0-6]");
        String d = "";
        boolean b;
        int c = 0;
        int l = 0;
        cuadrado cuad = new cuadrado();
        cubo cub = new cubo();

        do{
            switch (c) {
                case 0:
                    do {
                        System.out.println("Introducir Dato");
                        d = sc.nextLine();
                        Pattern p = Pattern.compile(ER);
                        Matcher m = p.matcher(d);
                        b = m.matches();
                        if (!b) System.out.println("¡El dato introducido no es válido");
                    } while (!b);
                    l = Integer.parseInt(d);
                    c = 1;

                case 1:
                    do {
                        System.out.println("Dato introducido: " + l);
                        System.out.println("Introduzca un número dependiendo de la opción a utilizar");
                        System.out.println("0 = Introducir Dato");
                        System.out.println("1 = Menú Principal");
                        System.out.println("2 = Área Cuadrado");
                        System.out.println("3 = Perímetro Cuadrado");
                        System.out.println("4 = Volumen Cubo");
                        System.out.println("5 = Perímetro Cubo");
                        System.out.println("6 = Salir del programa");
                        d = sc.nextLine();
                        Pattern p = Pattern.compile(M);
                        Matcher m = p.matcher(d);
                        b = m.matches();
                        if (!b) System.out.println("¡El dato introducido no es válido");
                    } while (!b);
                    c = Integer.parseInt(d);
                    break;

                case 2:

                        System.out.println("Dato introducido: " + l);
                        System.out.println("El Área del cuadrado es: "+ cuad.calcularArea(l));
                        System.out.println();
                    do {
                        System.out.println("Introduzca un número dependiendo de la opción a utilizar");
                        System.out.println("0 = Introducir Dato");
                        System.out.println("1 = Menú Principal");
                        d = sc.nextLine();
                        Pattern p = Pattern.compile(ER2);
                        Matcher m = p.matcher(d);
                        b = m.matches();
                        if (!b) System.out.println("¡El dato introducido no es válido");
                    } while (!b);
                    c = Integer.parseInt(d);
                    break;

                case 3:

                    System.out.println("Dato introducido: " + l);
                    System.out.println("El perimetro del cuadrado es: "+ cuad.calcularPerimetro(l));
                    System.out.println();
                    do {
                        System.out.println("Introduzca un número dependiendo de la opción a utilizar");
                        System.out.println("0 = Introducir Dato");
                        System.out.println("1 = Menú Principal");
                        d = sc.nextLine();
                        Pattern p = Pattern.compile(ER2);
                        Matcher m = p.matcher(d);
                        b = m.matches();
                        if (!b) System.out.println("¡El dato introducido no es válido");
                    } while (!b);
                    c = Integer.parseInt(d);
                    break;

                case 4:

                    System.out.println("Dato introducido: " + l);
                    System.out.println("El volumen del cubo es: "+ cub.calcularVolumen(l));
                    System.out.println();
                    do {
                        System.out.println("Introduzca un número dependiendo de la opción a utilizar");
                        System.out.println("0 = Introducir Dato");
                        System.out.println("1 = Menú Principal");
                        d = sc.nextLine();
                        Pattern p = Pattern.compile(ER2);
                        Matcher m = p.matcher(d);
                        b = m.matches();
                        if (!b) System.out.println("¡El dato introducido no es válido");
                    } while (!b);
                    c = Integer.parseInt(d);
                    break;

                case 5:

                    System.out.println("Dato introducido: " + l);
                    System.out.println("El perimetro del cubo es: "+ cub.calcularPerimetro(l));
                    System.out.println();
                    do {
                        System.out.println("Introduzca un número dependiendo de la opción a utilizar");
                        System.out.println("0 = Introducir Dato");
                        System.out.println("1 = Menú Principal");
                        d = sc.nextLine();
                        Pattern p = Pattern.compile(ER2);
                        Matcher m = p.matcher(d);
                        b = m.matches();
                        if (!b) System.out.println("¡El dato introducido no es válido");
                    } while (!b);
                    c = Integer.parseInt(d);
                    break;
            }
        }while (c<6);
    }
}


