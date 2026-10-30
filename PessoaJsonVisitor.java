package padroescomportamentais.visitor;

public class PessoaJsonVisitor implements Visitor {

    public String exibir(Pessoa pessoa) {
        return pessoa.aceitar(this);
    }

    @Override
    public String exibirAluno(Aluno aluno) {
        return "{" +
                "\"tipo\":\"Aluno\"," +
                "\"matricula\":" + aluno.getMatricula() + "," +
                "\"nome\":" + texto(aluno.getNome()) + "," +
                "\"curso\":" + texto(aluno.getNomeCurso()) +
                "}";
    }

    @Override
    public String exibirProfessor(Professor professor) {
        return "{" +
                "\"tipo\":\"Professor\"," +
                "\"matricula\":" + professor.getMatricula() + "," +
                "\"nome\":" + texto(professor.getNome()) + "," +
                "\"titulacao\":" + texto(professor.getTitulacao()) +
                "}";
    }

    @Override
    public String exibirFuncionario(Funcionario funcionario) {
        return "{" +
                "\"tipo\":\"Funcionario\"," +
                "\"codigo\":" + funcionario.getCodigo() + "," +
                "\"nome\":" + texto(funcionario.getNome()) + "," +
                "\"salario\":" + funcionario.getSalario() +
                "}";
    }

    // Converte um texto Java em string JSON, escapando aspas e barras
    private String texto(String valor) {
        if (valor == null) {
            return "null";
        }
        return "\"" + valor.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }
}
