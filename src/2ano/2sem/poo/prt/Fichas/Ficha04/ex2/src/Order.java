import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private String name; // nome
    private int nif; // numero de identificaçao fiscal
    private String address; // morada
    private int orderId; // numero de encomenda
    private LocalDateTime orderTime; // data da encomenda
    private List<OrderLine> orderLineList; // lista de linhas de encomendas

    // Construtor vazio
    public Order(){
        this.name = "André";
        this.nif = 777;
        this.address = "Portugal";
        this.orderId = 1;
        this.orderTime = LocalDateTime.now();
        this.orderLineList = new ArrayList<>(10);
    }

    // Construtor parametrizado
    public Order(String name, int nif, String address, int orderId,
                 LocalDateTime orderTime, List<OrderLine> orderLineList) {
        this.name = name;
        this.nif = nif;
        this.address = address;
        this.orderId = orderId;
        this.orderTime = orderTime;
        setOrderLineList(orderLineList);
    }

    // Construtor de clone
    public Order(Order order){
        setName(order.getName());
        setNif(order.getNif());
        setAddress(order.getAddress());
        setOrderId(order.getOrderId());
        setOrderTime(order.getOrderTime());
        setOrderLineList(order.getOrderLineList());
    }

    /**
     * Metodo que calcula o valor total
     * da encomenda.
     *
     * @return valor total da encomenda
     */
    public double calcTotalValue(){
        return getOrderLineList().stream().mapToDouble(OrderLine::calculaValorLinhaEnc).sum();
//        int total = 0;
//        for(OrderLine orderLine : getOrderLineList())
//            total += orderLine.calcValueInLine();
//        return total;
    }

    /**
     * Calcula o valor total dos descontos
     * obtidos nos diferentes produtos
     * encomendados.
     *
     * @return valor total dos descontos obtidos
     */
    public double calcTotalRebate(){
        return getOrderLineList().stream().mapToDouble(OrderLine::calculaValorDesconto).sum();
    }

    /**
     * Metodo que determina o numero total
     * de produtos a receber
     *
     * @return quantidade total de produtos
     */
    public double calcTotalQnt(){
        return getOrderLineList().stream().mapToDouble(OrderLine::getQnt).sum();
    }

    /**
     * Metodo que determina se um produto
     * vai ser encomendado.
     *
     * @param ref referencia do produto
     * @return existencia de um produto
     */
    public boolean containsProduct(String ref){
        for(OrderLine orderLine : getOrderLineList())
            if(orderLine.getRef().equals(ref)) return true;
        return false;
    }

    /**
     * Metodo que adiciona uma nova linha
     * de encomenda.
     *
     * @param orderLine linha de encomenda a adicionar
     */
    public void addOrderLine(OrderLine orderLine){
        List<OrderLine> orderLines = new ArrayList<>(getOrderLineList());
        orderLines.add(orderLine.clone());
        this.orderLineList = orderLines;
    }

    /**
     * Metodo que remove uma linha de
     * encomenda.
     *
     * @param orderLine linha de encomenda a remover
     */
    public void remOrderLine(OrderLine orderLine){
        List<OrderLine> orderLines = new ArrayList<>(getOrderLineList());
        orderLines.remove(orderLine);
        this.orderLineList = orderLines;
    }

    /**
     * Metodo que remove uma linha de
     * encomenda, atraves da sua referencia
     *
     * @param ref referencia da linha de encomenda a remover
     */
    public void remRefProd(String ref){
        for(OrderLine orderLine : getOrderLineList())
            if(orderLine.getRef().equals(ref)){
                remOrderLine(orderLine);
                break;
            }
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderLine> getOrderLineList() {
        List<OrderLine> newArr = new ArrayList<>();
        for(OrderLine crt : this.orderLineList)
            newArr.add(crt.clone());
        return newArr;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        List<OrderLine> newArr = new ArrayList<>();
        for(OrderLine crt : orderLineList)
            newArr.add(crt.clone());
        this.orderLineList = newArr;
    }
    ///////////////////////////////////////////////

    @Override
    public Order clone(){
        return new Order(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", nif=" + nif +
                ", address='" + address + '\'' +
                ", orderId=" + orderId +
                ", orderTime=" + orderTime +
                ", orderLineList=" + orderLineList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getNif() == order.getNif() &&
                getOrderId() == order.getOrderId() &&
                Objects.equals(getName(), order.getName()) &&
                Objects.equals(getAddress(), order.getAddress()) &&
                Objects.equals(getOrderTime(), order.getOrderTime()) &&
                Objects.equals(getOrderLineList(), order.getOrderLineList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getNif(), getAddress(), getOrderId(), getOrderTime(), getOrderLineList());
    }
}
