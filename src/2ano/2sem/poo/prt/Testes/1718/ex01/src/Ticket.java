import java.time.LocalDateTime;

public class Ticket{
    private String nomeO;
    private LocalDateTime horaOcorrencia;
    private String assunto;
    private String descricao;
    private String indetTecnico;
    private LocalDateTime horaFecho;

    public Ticket(){
        this.nomeO = "";
        this.horaOcorrencia = LocalDateTime.now();
        this.assunto = "";
        this.descricao = "";
        this.indetTecnico = "";
        this.horaFecho = LocalDateTime.now();
    }

    public Ticket(String nomeO, LocalDateTime horaOcorrencia, String assunto, String descricao, String indetTecnico, LocalDateTime horaFecho) {
        this.nomeO = nomeO;
        this.horaOcorrencia = horaOcorrencia;
        this.assunto = assunto;
        this.descricao = descricao;
        this.indetTecnico = indetTecnico;
        this.horaFecho = horaFecho;
    }

    public Ticket(Ticket ticket){
        this.nomeO = ticket.getNomeO();
        this.horaOcorrencia = ticket.getHoraOcorrencia();
        this.assunto = ticket.getAssunto();
        this.descricao = ticket.getDescricao();
        this.indetTecnico = ticket.getIndetTecnico();
        this.horaFecho = ticket.getHoraFecho();
    }

    public void executaTarefa(String ident){
        setIndetTecnico(ident);
        setHoraFecho(LocalDateTime.now());
    }

    public String getNomeO() {
        return this.nomeO;
    }

    public void setNomeO(String nomeO) {
        this.nomeO = nomeO;
    }

    public LocalDateTime getHoraOcorrencia() {
        return LocalDateTime.of(
                this.horaOcorrencia.getYear(),
                this.horaOcorrencia.getMonth(),
                this.horaOcorrencia.getDayOfMonth(),
                this.horaOcorrencia.getHour(),
                this.horaOcorrencia.getMinute(),
                this.horaOcorrencia.getSecond()
        );
    }

    public void setHoraOcorrencia(LocalDateTime horaOcorrencia) {
        this.horaOcorrencia = LocalDateTime.of(
                horaOcorrencia.getYear(),
                horaOcorrencia.getMonth(),
                horaOcorrencia.getDayOfMonth(),
                horaOcorrencia.getHour(),
                horaOcorrencia.getMinute(),
                horaOcorrencia.getSecond()
        );
    }

    public String getAssunto() {
        return this.assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIndetTecnico() {
        return this.indetTecnico;
    }

    public void setIndetTecnico(String indetTecnico) {
        this.indetTecnico = indetTecnico;
    }

    public LocalDateTime getHoraFecho() {
        return LocalDateTime.of(
                this.horaFecho.getYear(),
                this.horaFecho.getMonth(),
                this.horaFecho.getDayOfMonth(),
                this.horaFecho.getHour(),
                this.horaFecho.getMinute(),
                this.horaFecho.getSecond()
        );
    }

    public void setHoraFecho(LocalDateTime horaFecho) {
        this.horaFecho = LocalDateTime.of(
                horaFecho.getYear(),
                horaFecho.getMonth(),
                horaFecho.getDayOfMonth(),
                horaFecho.getHour(),
                horaFecho.getMinute(),
                horaFecho.getSecond()
        );
    }

    public Ticket clone(){
        return new Ticket(this);
    }
}
