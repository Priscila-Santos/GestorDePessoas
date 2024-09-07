import Controller.GerenciarContatos;
import Model.Contatos.Contato;
import View.Menu;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Contato> contatos = new ArrayList<>();

        Menu menu = new Menu();
        menu.menuIniciar();

    }
}
