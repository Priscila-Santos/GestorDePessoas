package Util;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerUtil {
    private static final Scanner sc = new Scanner(System.in);

    private ScannerUtil(InputStream in) {
    }

    public static Scanner getScanner() {
        return sc;
    }

    public static String ler(String pergunta) {
        System.out.println(pergunta);
        return sc.nextLine();
    }

    public static int lerInt(String pergunta) {
        System.out.println(pergunta);
        while (!sc.hasNextInt()) {
            System.out.println("Insira um número inteiro!");
        }
        return sc.nextInt();
    }


    public static String lerData(String pergunta) {
        System.out.println(pergunta);
        String data;

        String regex = "\\d{2}/\\d{2}/\\d{4}";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            data = sc.nextLine();
            Matcher matcher = pattern.matcher(data);

            if (matcher.matches()) {
                return data;
            } else {
                System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
            }
        }
    }


}
