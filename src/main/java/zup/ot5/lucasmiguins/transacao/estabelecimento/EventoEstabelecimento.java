package zup.ot5.lucasmiguins.transacao.estabelecimento;

public class EventoEstabelecimento {

    private String nome;

    private String cidade;

    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "EventoEstabelecimento{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome,cidade, endereco);
    }
}
