import java.util.ArrayList;
import java.util.List;

public class Supervisor extends Tecnico{
    private List<String> equipa;

    public Supervisor(List<String> equipa) {
        this.equipa = equipa;
    }

    public Supervisor(String ident, String nome, int numTickets, List<String> equipa) {
        super(ident, nome, numTickets);
        this.equipa = equipa;
    }

    public Supervisor(Tecnico tecnico, List<String> equipa) {
        super(tecnico);
        this.equipa = equipa;
    }

    public Supervisor(Supervisor supervisor){
        super(supervisor.getIdent(), supervisor.getNome(), supervisor.getNumTickets());
        this.equipa = supervisor.getEquipa();
    }

    public List<String> getEquipa() {
        return new ArrayList<>(this.equipa);
    }

    public void setEquipa(List<String> equipa) {
        this.equipa = new ArrayList<>(equipa);
    }

    public Supervisor clone(){
        return new Supervisor(this);
    }
}
