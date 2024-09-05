package Util;

import java.io.InputStream;
import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner scanner = new Scanner(System.in);

    private ScannerUtil(InputStream in) {
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static String ler(String questao) {
        System.out.println(questao);
        return scanner.nextLine();
    }
}
