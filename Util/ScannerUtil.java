package Util;

import java.io.InputStream;
import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner sc = new Scanner(System.in);

    private ScannerUtil(InputStream in) {
    }

    public static Scanner getScanner() {
        return sc;
    }

    public static String ler(String questao) {
        System.out.println(questao);
        return sc.nextLine();
    }

    public static int lerInt(String pergunta) {
        System.out.println(pergunta);
        while (!sc.hasNextInt()) {
            System.out.println("Insira um número inteiro!");
        }
        return sc.nextInt();
    }

    //adicionar ler double

    //ler data - no formato padrão BR
}
