package Controller;

import Model.Contatos.Contato;
import Model.Contatos.ContatoPessoal;
import Model.Contatos.ContatoProfissional;
import Model.Pessoa;
import Util.ScannerUtil;
import exception.ContatoNaoEncontradoException;
import exception.TelefoneInvalidoException;

public class GerenciarContatos {

    // Método para adicionar contato pessoal
    public void adicionarContatosPessoais(Pessoa pessoa) throws TelefoneInvalidoException {
        ContatoPessoal contatoPessoal = new ContatoPessoal();
        String telefone = ScannerUtil.ler("Digite o telefone: ");
        contatoPessoal.setTelefone(telefone);

        String endereco = ScannerUtil.ler("Digite o endereço: ");
        String email = ScannerUtil.ler("Digite o email: ");
        String aniversario = ScannerUtil.ler("Digite o aniversário: ");
        String instagram = ScannerUtil.ler("Digite o Instagram: ");

        // Adiciona o contato pessoal à lista de contatos da pessoa
        pessoa.adicionarContato(contatoPessoal);
        System.out.println("Contato pessoal adicionado com sucesso!");
    }

    // Método para adicionar contato profissional
    public void adicionarContatosProfissionais(Pessoa pessoa) throws TelefoneInvalidoException {
        String telefone = ScannerUtil.ler("Digite o telefone: ");
        String endereco = ScannerUtil.ler("Digite o endereço: ");
        String email = ScannerUtil.ler("Digite o email: ");
        String empresa = ScannerUtil.ler("Digite a empresa: ");
        String cargo = ScannerUtil.ler("Digite o cargo: ");

        // Criação do contato profissional com possível lançamento de exceção
        ContatoProfissional contatoProfissional = new ContatoProfissional(telefone, endereco, email, empresa, cargo);
        pessoa.adicionarContato(contatoProfissional);  // Adiciona o contato à lista de contatos da pessoa
        System.out.println("Contato profissional adicionado com sucesso!");
    }

    // Exibir contatos da pessoa
    public void exibirContatos(Pessoa pessoa) {
        if (pessoa.getContatos().isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            System.out.println("Lista de contatos:");
            for (int i = 0; i < pessoa.getContatos().size(); i++) {
                Contato contato = pessoa.getContatos().get(i);
                System.out.println((i + 1) + ". " + contato.getTelefone() + " - " + contato.getEmail());
            }
        }
    }

    // Editar contato pessoal ou profissional
    public void editarContato(Pessoa pessoa) throws TelefoneInvalidoException {
        exibirContatos(pessoa);
        try {
            int index = Integer.parseInt(ScannerUtil.ler("Digite o número do contato para editar: ")) - 1;
            if (index >= 0 && index < pessoa.getContatos().size()) {
                Contato contato = pessoa.getContatos().get(index);
                if (contato instanceof ContatoPessoal contatoPessoal) {
                    contatoPessoal.setTelefone(ScannerUtil.ler("Digite o novo telefone: "));
                    contatoPessoal.setEndereco(ScannerUtil.ler("Digite o novo endereço: "));
                    contatoPessoal.setEmail(ScannerUtil.ler("Digite o novo email: "));
                    contatoPessoal.setInstagram(ScannerUtil.ler("Digite o novo Instagram: "));
                    System.out.println("Contato pessoal editado com sucesso!");
                } else if (contato instanceof ContatoProfissional contatoProfissional) {
                    contatoProfissional.setTelefone(ScannerUtil.ler("Digite o novo telefone: "));
                    contatoProfissional.setEndereco(ScannerUtil.ler("Digite o novo endereço: "));
                    contatoProfissional.setEmail(ScannerUtil.ler("Digite o novo email: "));
                    contatoProfissional.setEmpresa(ScannerUtil.ler("Digite a nova empresa: "));
                    contatoProfissional.setCargo(ScannerUtil.ler("Digite o novo cargo: "));
                    System.out.println("Contato profissional editado com sucesso!");
                }
            } else {
                System.out.println("Número inválido. Nenhum contato foi editado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido.");
        }
    }

    // Remover contato
    public void removerContato(Pessoa pessoa) throws ContatoNaoEncontradoException {
        exibirContatos(pessoa);
        try {
            int index = Integer.parseInt(ScannerUtil.ler("Digite o ID do contato para remover: ")) - 1;
            if (index >= 0 && index < pessoa.getContatos().size()) {
                pessoa.removerContato(index);
                System.out.println("Contato removido com sucesso!");
            } else {
                throw new ContatoNaoEncontradoException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido.");
        }
    }
}
