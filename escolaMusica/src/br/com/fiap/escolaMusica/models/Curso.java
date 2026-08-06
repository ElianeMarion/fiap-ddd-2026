package br.com.fiap.escolaMusica.models;

import br.com.fiap.escolaMusica.enums.NivelCurso;
import br.com.fiap.escolaMusica.interfaces.Exibivel;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa um Curso de música oferecido na escola.
 * Possui nome, nível do curso, professor responsável e lista de alunos matriculados.
 * Implementa diretamente a interface Exibivel.
 */
public class Curso implements Exibivel {

    private String nome;
    private NivelCurso nivel;
    private Professor professorResponsavel;
    private List<Aluno> listaAlunos;

    /**
     * Construtor para inicialização de um Curso.
     * A lista de alunos matriculados é inicializada internamente como um ArrayList.
     *
     * @param nome                 Nome do instrumento/curso (ex: Aula de Piano)
     * @param nivel                Nível técnico (Enum NivelCurso)
     * @param professorResponsavel Professor encarregado das aulas
     */
    public Curso(String nome, NivelCurso nivel,
                 Professor professorResponsavel) {
        this.nome = nome;
        this.nivel = nivel;
        this.professorResponsavel = professorResponsavel;
        this.listaAlunos = new ArrayList<>();
    }
    /**
     * Método lógico de negócio para matricular um aluno.
     * Garante de forma consistente a integridade bidirecional da relação Aluno-Curso,
     * adicionando o aluno ao curso.
     *
     * @param aluno Aluno a ser matriculado
     */
    public void matricularAluno(Aluno aluno){
        if(!this.listaAlunos.contains(aluno)) {
            listaAlunos.add(aluno);
        }
    }
    /**
     * Desvincula um aluno de um curso e ajusta a lista correspondente do aluno.
     *
     * @param aluno Aluno a ser removido
     */
    public void desmatricularAluno(Aluno aluno){
        if(aluno != null && this.listaAlunos.contains(aluno)){
            this.listaAlunos.remove(aluno);
        }
    }

    /**
     * Implementação polimórfica de exibirInformacoes() herdado de Exibivel.
     * Mostra metadados do curso e lista os nomes dos estudantes frequentes.
     */
    @Override
    public void exibirInformacoes() {
        System.out.println("===================== DETALHES DO CURSO ==================");
        System.out.println("Nome: " + nome);
        System.out.println("Nível: " + nivel);
        System.out.println("Professor responsável: " + professorResponsavel);
        System.out.println("Número de alunos da turma:  " + listaAlunos.size());
        System.out.println("Alunos matriculados:");
        if(listaAlunos.isEmpty()){
            System.out.println("Nenhum aluno cadastrado");
        }
        else{
            System.out.println("-------------------------");
            for (Aluno aluno : listaAlunos){
                System.out.println(" - " + aluno.getNome() + " (" + aluno.getIdade() + ") anos"  );
            }
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelCurso getNivel() {
        return nivel;
    }

    public void setNivel(NivelCurso nivel) {
        this.nivel = nivel;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
}
