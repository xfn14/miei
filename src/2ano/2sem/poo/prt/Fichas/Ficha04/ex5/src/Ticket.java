import java.time.LocalDateTime;

public class Ticket {
    private String author;
    private LocalDateTime startTime;
    private String title;
    private String desc;

    private String handler;
    private LocalDateTime doneTime;
    private String response;

    public Ticket(){
        this.author = null;
        this.startTime = LocalDateTime.now();
        this.title = "";
        this.desc = "";
        this.handler = null;
        this.doneTime = null;
        this.response = null;
    }

    public Ticket(String author, LocalDateTime startTime, String title,
                  String desc, String handler, LocalDateTime doneTime,
                  String response) {
        this.author = author;
        setStartTime(startTime);
        this.title = title;
        this.desc = desc;
        this.handler = handler;
        setDoneTime(doneTime);
        this.response = response;
    }

    public Ticket(Ticket ticket){
        setAuthor(ticket.getAuthor());
        setStartTime(ticket.getStartTime());
        setTitle(ticket.getTitle());
        setDesc(ticket.getDesc());
        setHandler(ticket.getHandler());
        setDoneTime(ticket.getDoneTime());
        setResponse(ticket.getResponse());
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getStartTime() {
        if(this.startTime == null) return null;
        return LocalDateTime.of(
                this.startTime.getYear(),
                this.startTime.getMonth(),
                this.startTime.getDayOfMonth(),
                this.startTime.getHour(),
                this.startTime.getMinute(),
                this.startTime.getSecond(),
                this.startTime.getNano()
        );
    }

    public void setStartTime(LocalDateTime startTime) {
        if(startTime == null){
            this.startTime = null;
            return;
        }
        this.startTime = LocalDateTime.of(
                startTime.getYear(),
                startTime.getMonth(),
                startTime.getDayOfMonth(),
                startTime.getHour(),
                startTime.getMinute(),
                startTime.getSecond(),
                startTime.getNano()
        );
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHandler() {
        return this.handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public LocalDateTime getDoneTime() {
        if(this.doneTime == null) return null;
        return LocalDateTime.of(
                this.doneTime.getYear(),
                this.doneTime.getMonth(),
                this.doneTime.getDayOfMonth(),
                this.doneTime.getHour(),
                this.doneTime.getMinute(),
                this.doneTime.getSecond(),
                this.doneTime.getNano()
        );
    }

    public void setDoneTime(LocalDateTime doneTime) {
        if(doneTime == null){
            this.doneTime = null;
            return;
        }
        this.doneTime = LocalDateTime.of(
                doneTime.getYear(),
                doneTime.getMonth(),
                doneTime.getDayOfMonth(),
                doneTime.getHour(),
                doneTime.getMinute(),
                doneTime.getSecond(),
                doneTime.getNano()
        );
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (getAuthor() != null ? !getAuthor().equals(ticket.getAuthor()) : ticket.getAuthor() != null) return false;
        if (getStartTime() != null ? !getStartTime().equals(ticket.getStartTime()) : ticket.getStartTime() != null) return false;
        if (getTitle() != null ? !getTitle().equals(ticket.getTitle()) : ticket.getTitle() != null) return false;
        if (getDesc() != null ? !getDesc().equals(ticket.getDesc()) : ticket.getDesc() != null) return false;
        if (getHandler() != null ? !getHandler().equals(ticket.getHandler()) : ticket.getHandler() != null) return false;
        if (getDoneTime() != null ? !getDoneTime().equals(ticket.getDoneTime()) : ticket.getDoneTime() != null) return false;
        return getResponse() != null ? getResponse().equals(ticket.getResponse()) : ticket.getResponse() == null;
    }

    @Override
    public int hashCode() {
        int result = getAuthor() != null ? getAuthor().hashCode() : 0;
        result = 31 * result + (getStartTime() != null ? getStartTime().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getDesc() != null ? getDesc().hashCode() : 0);
        result = 31 * result + (getHandler() != null ? getHandler().hashCode() : 0);
        result = 31 * result + (getDoneTime() != null ? getDoneTime().hashCode() : 0);
        result = 31 * result + (getResponse() != null ? getResponse().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "author='" + author + '\'' +
                ", startTime=" + startTime +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", handler='" + handler + '\'' +
                ", doneTime=" + doneTime +
                ", response='" + response + '\'' +
                '}';
    }

    @Override
    protected Ticket clone() {
        return new Ticket(this);
    }
}
