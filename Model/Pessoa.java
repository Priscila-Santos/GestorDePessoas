package Model;

import Model.Contatos.ContatoPessoal;
import Model.Contatos.ContatoProfissional;
import Model.ListaDeTarefas.Projeto;
import Model.ListaDeTarefas.Tarefa;
import Util.ScannerUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Controller.GerenciarContatos.contatos;

public class Pessoa {
    private String nome;
    private String documento;
    private List<Projeto> projetos = new ArrayList<>();
    private List<Tarefa> tarefas = new ArrayList<>();

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

    @Override
    public String toString() {
        return nome;
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

    public String adicionarContatoPessoal() {
        try {
            String telefone = ScannerUtil.ler("Digite o telefone: ");
            String endereco = ScannerUtil.ler("Digite o endereço: ");
            String email = ScannerUtil.ler("Digite o email: ");
            String aniversario = ScannerUtil.ler("Digite o aniversario: ");
            String instagram = ScannerUtil.ler("Digite o instagram: ");
            ContatoPessoal contatoPessoal = new ContatoPessoal(telefone, endereco, email, aniversario, instagram) {
                @Override
                public String toString() {
                    return String.format("Nome: %s\nTelefone: %s\nEndereço: %s\nEmail: %s",
                            ContatoPessoal.getTelefone(),
                            ContatoPessoal.getEndereco(),
                            ContatoPessoal.getEmail());
                }
            };
            contatos.add(contatoPessoal);
            return "Contato adicionado com sucesso!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

}
