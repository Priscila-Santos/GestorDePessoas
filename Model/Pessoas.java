package Model;

import Model.Contatos.Contatos;
import Model.ListaDeTarefas.ListaDeTarefas;

public class Pessoas {
    private String nome;
    private String documento;
    private Contatos contatos;
    private ListaDeTarefas listaDeTarefas;

    private void adicionarTarefa(){

    }

    private String listarTarefa(){
    return listaDeTarefas.toString();
    }
}
