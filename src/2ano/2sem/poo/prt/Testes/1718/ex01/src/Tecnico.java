public class Tecnico {
    private String ident;
    private String nome;
    private int numTickets;

    public Tecnico(){
        this.ident = "";
        this.nome = "";
        this.numTickets = 0;
    }

    public Tecnico(String ident, String nome, int numTickets) {
        this.ident = ident;
        this.nome = nome;
        this.numTickets = numTickets;
    }

    public Tecnico(Tecnico tecnico){
        this.ident = tecnico.getIdent();
        this.nome = tecnico.getNome();
        this.numTickets = tecnico.getNumTickets();
    }

    public String getIdent() {
        return this.ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumTickets() {
        return this.numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public Tecnico clone() {
        return new Tecnico(this);
    }
}
