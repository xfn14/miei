import java.util.*;
import java.util.stream.Collectors;

public class SistemaTickets {
    private Map<String, Tecnico> funcionarios;
    private List<Ticket> ticketsPorResolver;
    private List<Ticket> ticketsResolvidos;

    public void adicionaTickets(Ticket t){
        if(t == null) return;
        if(t.getIndetTecnico() == null || !this.funcionarios.containsKey(t.getIndetTecnico()))
            this.ticketsPorResolver.add(t.clone());
        else this.ticketsResolvidos.add(t.clone());
    }

    public void resolveTicket(String ident) throws TecnicoNaoExisteException{
        if(!this.funcionarios.containsKey(ident)) throw new TecnicoNaoExisteException();
        else{
            Ticket ticket = this.ticketsPorResolver.get(0).clone();
            this.ticketsPorResolver.remove(0);
            ticket.executaTarefa(ident);
            this.ticketsResolvidos.add(ticket);
        }
    }

    public Map<String, List<Ticket>> ticketsPorTecnico(){
        Map<String, List<Ticket>> newMap = new HashMap<>();
        for(Ticket ticket : this.ticketsResolvidos){
            List<Ticket> l = newMap.containsKey(ticket.getIndetTecnico()) ? newMap.get(ticket.getIndetTecnico()) : new ArrayList<>();
            l.add(ticket.clone());
            newMap.put(ticket.getIndetTecnico(), l);
        }
        return newMap;
    }

    public String supervisorTop(){
        if(this.funcionarios.isEmpty()) return "";
        return this.funcionarios.values().stream()
                .max(Comparator.comparing(Tecnico::getNumTickets))
                .get().getIdent();

//        Map<String,Integer> top = new HashMap<>();
//        for(Ticket ticket : this.ticketsResolvidos)
//            if(top.containsKey(ticket.getIndetTecnico()))
//                top.put(ticket.getIndetTecnico(), top.get(ticket.getIndetTecnico())+1);
//            else top.put(ticket.getIndetTecnico(), 1);
//
//        String newTop = ""; int val = 0;
//        for(Map.Entry<String, Integer> crt : top.entrySet())
//            if(crt.getValue() > val){
//                newTop = crt.getKey();
//                val = crt.getValue();
//            }
//        return newTop;
    }

    public Map<String, Tecnico> getFuncionarios() {
        Map<String, Tecnico> newMap = new HashMap<>();
        for(Map.Entry<String, Tecnico> crt : this.funcionarios.entrySet())
            newMap.put(crt.getKey(), crt.getValue().clone());
        return newMap;
    }

    public void setFuncionarios(Map<String, Tecnico> funcionarios) {
        Map<String, Tecnico> newMap = new HashMap<>();
        for(Map.Entry<String, Tecnico> crt : funcionarios.entrySet())
            newMap.put(crt.getKey(), crt.getValue().clone());
        this.funcionarios = newMap;
    }

    public List<Ticket> getTicketsPorResolver() {
        return this.ticketsPorResolver.stream()
                .map(Ticket::clone)
                .collect(Collectors.toList());
    }

    public void setTicketsPorResolver(List<Ticket> ticketsPorResolver) {
        this.ticketsPorResolver = ticketsPorResolver.stream()
                .map(Ticket::clone)
                .collect(Collectors.toList());
    }

    public List<Ticket> getTicketsResolvidos() {
        return this.ticketsResolvidos.stream()
                .map(Ticket::clone)
                .collect(Collectors.toList());
    }

    public void setTicketsResolvidos(List<Ticket> ticketsResolvidos) {
        this.ticketsResolvidos = ticketsResolvidos.stream()
                .map(Ticket::clone)
                .collect(Collectors.toList());
    }
}
