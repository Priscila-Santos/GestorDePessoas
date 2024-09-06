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
    private List<Projeto> projetos = new ArrayList<>();
    private List<Tarefa> tarefas = new ArrayList<>();

    public Pessoa(String nome) {
        this.nome = nome;
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

    // Gerenciar projetos
    public List<Projeto> getProjetos() {
        return projetos;
    }
    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }
    // Gerenciar tarefas
    public List<Tarefa> getTarefas() {
        return tarefas;
    }
    public void adicionarTarefas(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

}
