package br.com.fiap.escolaMusica.tests;

import br.com.fiap.escolaMusica.enums.NivelCurso;
import br.com.fiap.escolaMusica.interfaces.Exibivel;
import br.com.fiap.escolaMusica.models.Aluno;
import br.com.fiap.escolaMusica.models.Curso;
import br.com.fiap.escolaMusica.models.Professor;
import br.com.fiap.escolaMusica.models.Relatorios;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de ponto de entrada (Main) projetada para orquestrar os testes do sistema,
 * demonstrando orientação a objetos aplicada: herança, interfaces, polimorfismo,
 * encapsulamento, tratamento de listas, tratamento de enums e boas práticas de estruturação.
 */
public class TestePessoa {
    /**
     * Método de execução principal.
     *
     * @param args Argumentos de linha de comando
     */
    public static void main(String[] args) {
        System.out.println("=======================================================");
        System.out.println("      SISTEMA DE GERENCIAMENTO DA ESCOLA DE MÚSICA     ");
        System.out.println("=======================================================\n");

        // 1. Instanciando Professores (Requisito: Pelo menos 1)
        System.out.println("[Instanciando Professores...]");
        Professor profChopin = new Professor(
                "Frédéric Chopin",
                "123.456.789-00",
                "chopin@escolademusica.com",
                "Piano"
        );

        Professor profHendrix = new Professor(
                "Jimi Hendrix",
                "987.654.321-11",
                "hendrix@escolademusica.com",
                "Guitarra"
        );
        System.out.println("Professores criados com sucesso.\n");

        // 2. Instanciando Alunos (Requisito: Pelo menos 2)
        System.out.println("[Instanciando Alunos...]");
        Aluno alunoMozart = new Aluno(
                "Wolfgang Amadeus Mozart",
                "111.222.333-44",
                "mozart@escolademusica.com",
                18
        );

        Aluno alunoBeethoven = new Aluno(
                "Ludwig van Beethoven",
                "555.666.777-88",
                "beethoven@escolademusica.com",
                22
        );

        Aluno alunoBonham = new Aluno(
                "John Bonham",
                "999.888.777-66",
                "bonham@escolademusica.com",
                25
        );
        System.out.println("Alunos criados com sucesso.\n");

        // 3. Instanciando Cursos (Requisito: Pelo menos 1 curso com alunos e professor)
        System.out.println("[Instanciando Cursos...]");
        Curso cursoPiano = new Curso(
                "Piano Clássico",
                NivelCurso.AVANCADO,
                profChopin
        );

        Curso cursoViolao = new Curso(
                "Violão e Guitarra Iniciante",
                NivelCurso.INICIANTE,
                profHendrix
        );
        System.out.println("Cursos criados com sucesso.\n");

        // 4. Matriculando alunos em cursos (Uso de listas e relacionamento bidirecional)
        System.out.println("[Realizando matrículas...]");
        // Mozart e Beethoven fazem piano
        cursoPiano.matricularAluno(alunoMozart);
        cursoPiano.matricularAluno(alunoBeethoven);

        // Beethoven e Bonham fazem violão/guitarra
        cursoViolao.matricularAluno(alunoBeethoven);
        cursoViolao.matricularAluno(alunoBonham);
        System.out.println("Matrículas registradas com consistência bidirecional.\n");

        // 5. Demonstrando Polimorfismo através do método exibirInformacoes()
        // Uma lista que armazena referências da interface Exibivel
        List<Exibivel> elementosParaExibir = new ArrayList<>();
        elementosParaExibir.add(profChopin);
        elementosParaExibir.add(profHendrix);
        elementosParaExibir.add(alunoMozart);
        elementosParaExibir.add(alunoBeethoven);
        elementosParaExibir.add(alunoBonham);
        elementosParaExibir.add(cursoPiano);
        elementosParaExibir.add(cursoViolao);

        System.out.println("-------------------------------------------------------");
        System.out.println("     DEMONSTRAÇÃO DE POLIMORFISMO (Interface Exibivel) ");
        System.out.println("-------------------------------------------------------");
        for (Exibivel elemento : elementosParaExibir) {
            elemento.exibirInformacoes();
            System.out.println(); // Salto de linha para legibilidade
        }

        // 6. Relatório Alunos x Cursos
        // Chamada ao método customizado solicitado
        List<Aluno> todosOsAlunos = List.of(alunoMozart, alunoBeethoven, alunoBonham);
        exibirRelatorioAlunosCursos(todosOsAlunos);
    }

    /**
     * Método estático específico de exibição que consolida a relação Aluno x Cursos.
     * Atende ao requisito: 'Elabore pelo menos um método que exiba os alunos e os cursos em que estão matriculados'.
     *
     * @param alunos Lista de alunos a serem incluídos no relatório
     */
    public static void exibirRelatorioAlunosCursos(List<Aluno> alunos) {
        System.out.println("=============================================================");
        System.out.println("                RELATÓRIO: ALUNOS X CURSOS MATRICULADOS       ");
        System.out.println("=============================================================");
        if (alunos == null || alunos.isEmpty()) {
            System.out.println("Nenhum aluno informado para geração do relatório.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.printf("Aluno: %-25s | Idade: %d anos\n", aluno.getNome(), aluno.getIdade());
                System.out.print("  Cursos Matriculados: ");
                List<Curso> cursos = aluno.getCursosMatriculados();
                if (cursos == null || cursos.isEmpty()) {
                    System.out.println("[Nenhum curso matriculado]");
                } else {
                    List<String> nomesCursosComNivel = new ArrayList<>();
                    for (Curso curso : cursos) {
                        nomesCursosComNivel.add(curso.getNome() + " (" + curso.getNivel().getDescricao() + ")");
                    }
                    System.out.println(String.join(", ", nomesCursosComNivel));
                }
                System.out.println("-------------------------------------------------------------");
            }
        }
        System.out.println("=============================================================\n");


    }


}
