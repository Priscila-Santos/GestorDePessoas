# Projeto Final do Módulo de Programação Orientada a Objeto I

## Gestor de Pessoas
Este projeto é uma evolução da agenda de contatos desenvolvida no módulo anterior do curso Santander Coders Back-End ministrado pela Ada Tech. O sistema em Java foi aprimorado para incluir funcionalidades adicionais para gerenciar pessoas, projetos, tarefas e contatos. O projeto foi desenvolvido em grupo, cujo os membros Priscila Silva dos Santos, Antonia Débora Dos Santos Pontes Rocha, Lucas Alecsander Ataide Gomes Da Silva, Matheus Gomes e Lucas Salvador Do Carmo desenvolveram o projeto de forma colaborativa e seguindo os requisitos funcionais e não funcionais especificados.

## Funcionalidades de Aplicação
## Requisitos Funcionais
1.	**Adicionar Pessoa:** Permite adicionar novas pessoas à agenda
2.	**Editar Pessoa:** Permite editar detalhes das pessoas existentes, incluindo projetos, tarefas e contatos associados.
3.	**Excluir Pessoa:** Permite remover pessoas da agenda.
4.	**Detalhar Pessoa:** Exibe todos os projetos, tarefas e contatos registrados para a pessoa selecionada.
5.	**Sair:** Encerra a aplicação.

## Opções de Edição
1.	**Exibir Projetos e Tarefas:** Mostra todos os projetos e tarefas associados à pessoa.
2.	**Editar Projetos e Tarefas:** Permite editar detalhes dos projetos e tarefas existentes.
3.	**Adicionar Projetos e Tarefas:** Permite adicionar novos projetos e tarefas à pessoa.
4.	**Exibir Contatos:** Mostra todos os contatos associados à pessoa.
5.	**Editar Contatos:** Permite editar detalhes dos contatos existentes.
6.	**Adicionar Contatos:** Permite adicionar novos contatos à pessoa.

## Requisitos Não Funcionais
1.	**Classe para Usuários:** Implementa uma classe para representar os usuários do cadastro com seus atributos.
2.	**Encapsulamento:** Utiliza encapsulamento para proteger os atributos das classes, oferecendo getters e setters apropriados.
3.	**Tratamento de Erros:** O sistema trata possíveis erros e fornece mensagens claras sobre o que está acontecendo para o usuário.
4.	**Herança:** Usa herança nas classes principais, sobrescreve pelo menos um método da classe pai e adiciona pelo menos um novo atributo na classe filha.

## Colaboração no Git
Para garantir que todos os membros da equipe pudessem colaborar de forma eficiente, seguimos os seguintes passos no Git:
1.	**Criação do Repositório:** Um repositório foi criado no GitHub para o projeto.
2.	**Criação de uma Branch:** Uma branch chamada 'release' foi criada para que a equipe colocasse o código em uma “branch de trabalho” antes de passar o projeto completo para a branch main
3.	**Clonagem do Repositório:** Cada membro da equipe clonou o repositório para suas máquinas locais.

    fork (feito no github) \
    git clone URL_DO_REPOSITORIO \
    git checkout release \
    git add . \
    git commit -m "Descrição do commit" \
    git push origin release \
    Sync fork (feito no github) \
    git pull origin release 

5.	**Adição, Commit e Push:** Comandos feitos para enviar as modificações feitas para o repositório remoto
6.	**Sync fork e git pull:** Para atualizar o repositório do github e para atualizar os códigos na máquina local de cada membro da equipe
7.	**Revisão e Merge:** As pull requests eram revisadas por outros membros da equipe antes de serem mescladas na branch principal.

## Estrutura da Aplicação 
```plaintext
                    ============================================================
                    |                      MENU PRINCIPAL                      |
                    ============================================================
                    | 1 - Gerenciar Pessoas                                    |
                    | 2 - Gerenciar Projetos e Tarefas                         |
                    | 3 - Gerenciar Contatos                                   |
                    | 4 - Sair                                                 |
                    ============================================================
                    
                    ============================================================
                    |                GERENCIAR PROJETOS E TAREFAS              |
                    ============================================================
                    | 1 - Adicionar Projeto                                    |
                    | 2 - Adicionar Tarefa                                     |
                    | 3 - Exibir Projetos e Tarefas                            |
                    | 4 - Alterar Status de Tarefa                             |
                    | 5 - Voltar                                               |
                    ============================================================

                        +-----  +--------------------  +---------------  +
                        | ID    | Nome                 | Documento       |
                        +-----  +--------------------  +---------------  +
                        | 1     | Lucas Carmo          | 123456789       |
                        | 2     | Priscila Santos      | 987456321       |
                        | 3     | Matheus Gomes        | 789456321       |
                        | 4     | Débora Rocha         | 654789321       |
                        | 5     | Lucas Silva          | 369852147       |
                        +-----  +--------------------  +---------------  +

```

