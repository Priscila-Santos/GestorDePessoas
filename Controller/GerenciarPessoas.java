package Controller;

import Model.Pessoa;
import Util.*;
import java.util.List;

public class GerenciarPessoas {
    private List<Pessoa> pessoas;

    public void adicionarPessoa(){
        String nome = ScannerUtil.ler("Digite o nome da pessoa: ");
        Pessoa pessoa = new Pessoa(nome);
        pessoas.add(pessoa);
        System.out.println("Pessoa adicionada com sucesso!");

    }

}
