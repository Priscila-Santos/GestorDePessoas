package Model;

import Model.Contatos.ContatoPessoal;
import Model.Contatos.ContatoProfissional;
import Model.ListaDeTarefas.Projeto;
import Model.ListaDeTarefas.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private String documento;
    private List<Projeto> projetos;
    private List<Tarefa> tarefas;
    private ContatoProfissional contatoProfissional;
    private ContatoPessoal contatoPessoal;

    public Pessoa(String nome) {
        this.nome = nome;
        this.projetos = new ArrayList<>();
        this.tarefas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }



}
