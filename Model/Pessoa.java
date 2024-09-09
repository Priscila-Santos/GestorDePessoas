package Model;

import Model.Contatos.Contato;
import Model.ListaDeTarefas.Projeto;
import Model.ListaDeTarefas.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private String documento;
    private List<Projeto> projetos = new ArrayList<>();
    private List<Tarefa> tarefasIndependentes = new ArrayList<>();
    private List<Contato> contatos = new ArrayList<>();

    public Pessoa(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
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




    public void adicionarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }


    public List<Projeto> getProjetos() {
        return projetos;
    }


    public void adicionarTarefaIndependente(Tarefa tarefa) {
        tarefasIndependentes.add(tarefa);
    }


    public List<Tarefa> getTarefasIndependentes() {
        return tarefasIndependentes;
    }




    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }


    public void removerContato(int index) {
        if (index >= 0 && index < contatos.size()) {
            contatos.remove(index);
        } else {
            System.out.println("Contato não encontrado.");
        }
    }



    public List<Contato> getContatos() {
        return contatos;
    }


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
