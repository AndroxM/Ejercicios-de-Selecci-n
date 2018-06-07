import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class conversorromanos {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String continuar = "S";
        String ER = ("[1-9][0-9]{0,3}");
        String erSino = "(S|N)";
        String s;
        boolean b;
        int i;

        do{
            do {
                System.out.println("Introduce un número entero entre el 1 y el 1000");
                s = sc.nextLine();
                Pattern p = Pattern.compile(ER);
                Matcher m = p.matcher(s);
                b = m.matches();
                if (!b) System.out.println("Error en la entrada de datos");
            }while (!b);

            i = Integer.parseInt(s);
            System.out.println("El número "+ i +" en Romano es: "+ conversor(i));
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

    public static String conversor(int numero){
        String Romano = "";
        int u,d,c,m;

        m = numero / 1000;
        c = (numero % 1000)/100;
        d = ((numero % 1000) % 100) / 10;
        u = (((numero % 1000) % 100) % 10);

        switch (m){
            case 1:
                Romano += "M";
                break;
        }
        switch (c){
            case 1:
                Romano += "C";
                break;
            case 2:
                Romano += "CC";
                break;
            case 3:
                Romano += "CCC";
                break;
            case 4:
                Romano += "CD";
                break;
            case 5:
                Romano += "D";
                break;
            case 6:
                Romano += "DC";
                break;
            case 7:
                Romano += "DCC";
                break;
            case 8:
                Romano += "DCCC";
                break;
            case 9:
                Romano += "CM";
                break;
        }
        switch (d){
            case 1:
                Romano += "X";
                break;
            case 2:
                Romano += "XX";
                break;
            case 3:
                Romano += "XXX";
                break;
            case 4:
                Romano += "XL";
                break;
            case 5:
                Romano += "L";
                break;
            case 6:
                Romano += "LX";
                break;
            case 7:
                Romano += "LXX";
                break;
            case 8:
                Romano += "LXXX";
                break;
            case 9:
                Romano += "XC";
                break;
        }
        switch (u){
            case 1:
                Romano += "I";
                break;
            case 2:
                Romano += "II";
                break;
            case 3:
                Romano += "III";
                break;
            case 4:
                Romano += "IV";
                break;
            case 5:
                Romano += "V";
                break;
            case 6:
                Romano += "VI";
                break;
            case 7:
                Romano += "VII";
                break;
            case 8:
                Romano += "VIII";
                break;
            case 9:
                Romano += "IX";
                break;
        }

        return Romano;
    }
}