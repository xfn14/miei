import java.time.LocalDateTime;

public class Ex05 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Ticket ticket = new Ticket(
                "fef",
                now,
                "feffwefef",
                "ferfw",
                null,
                null,
                null
        );

        Support support = new Support();
        support.addTicket(ticket);
        System.out.println(support.toString());
        support.resolveTicket(ticket, "andreubita", "Resolvido");
        System.out.println(support.toString());
        System.out.println(support.resolved());
        System.out.println(support.topHandler());
    }
}
