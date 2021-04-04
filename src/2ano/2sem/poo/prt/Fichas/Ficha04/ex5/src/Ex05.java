import java.time.LocalDateTime;

public class Ex05 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Ticket ticket = new Ticket(
                "fn14",
                now,
                "???: new Ticket(this)",
                "Pq nao usar (Ticket) super.clone() ???",
                null,
                null,
                null
        );

        Support support = new Support();
        support.addTicket(ticket);
        System.out.println(support.toString());
        support.resolveTicket(ticket, "andreubita", "...", now.plusMinutes(10));
        System.out.println(support.toString());
        System.out.println(support.resolved());
        System.out.println(support.topHandler());
        System.out.println(support.averageDoneTime());
    }
}
