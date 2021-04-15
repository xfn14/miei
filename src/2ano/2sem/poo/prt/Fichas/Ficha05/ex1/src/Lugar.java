public class Lugar {
    private String matricula;
    private String nome;
    private int minutos;
    private boolean permanente;

    public Lugar(){
        this.matricula = "";
        this.nome = "";
        this.minutos = 0;
        this.permanente = false;
    }

    public Lugar(String matricula, String nome, int minutos, boolean permanente) {
        this.matricula = matricula;
        this.nome = nome;
        this.minutos = minutos;
        this.permanente = permanente;
    }

    public Lugar(Lugar lugar){
        this.matricula = lugar.getMatricula();
        this.nome = lugar.getNome();
        this.minutos = lugar.getMinutos();
        this.permanente = lugar.isPermanente();
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public boolean isPermanente() {
        return this.permanente;
    }

    public void setPermanente(boolean permanente) {
        this.permanente = permanente;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lugar{");
        sb.append("matricula='").append(matricula).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", minutos=").append(minutos);
        sb.append(", permanente=").append(permanente);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lugar lugar = (Lugar) o;

        if (minutos != lugar.minutos) return false;
        if (permanente != lugar.permanente) return false;
        if (matricula != null ? !matricula.equals(lugar.matricula) : lugar.matricula != null) return false;
        return nome != null ? nome.equals(lugar.nome) : lugar.nome == null;
    }

    @Override
    public Lugar clone() {
        return new Lugar(this);
    }
}
