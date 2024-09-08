package Model;

import Model.Contatos.Contato;
import Model.ListaDeTarefas.Projeto;
import Model.ListaDeTarefas.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private String documento;
    private List<Projeto> projetos = new ArrayList<>();  // Lista de projetos da pessoa
    private List<Tarefa> tarefasIndependentes = new ArrayList<>();  // Lista de tarefas independentes
    private List<Contato> contatos = new ArrayList<>();  // Lista de contatos da pessoa

    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    // Getters e Setters
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

    // Métodos de Projetos e Tarefas

    // Método para adicionar um projeto
    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }

    // Método para retornar a lista de projetos
    public List<Projeto> getProjetos() {
        return projetos;
    }

    // Método para adicionar uma tarefa independente
    public void adicionarTarefaIndependente(Tarefa tarefa) {
        tarefasIndependentes.add(tarefa);
    }

    // Método para retornar a lista de tarefas independentes
    public List<Tarefa> getTarefasIndependentes() {
        return tarefasIndependentes;
    }

    // Métodos de Contatos

    // Método para adicionar um contato
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    // Método para remover um contato por índice
    public void removerContato(int index) {
        if (index >= 0 && index < contatos.size()) {
            contatos.remove(index);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    // Método para retornar a lista de contatos
    public List<Contato> getContatos() {
        return contatos;
    }

    // Método para exibir todos os contatos
    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            System.out.println("Lista de Contatos:");
            for (int i = 0; i < contatos.size(); i++) {
                System.out.println((i + 1) + ". " + contatos.get(i).toString());
            }
        }
    }
}
