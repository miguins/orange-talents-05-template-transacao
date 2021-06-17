package zup.ot5.lucasmiguins.transacao.cartao;

public class EventoCartao {

    private String id;

    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "EventoCartao{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }
}
