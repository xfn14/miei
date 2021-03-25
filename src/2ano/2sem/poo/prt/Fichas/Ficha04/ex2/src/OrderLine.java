import java.util.Objects;

public class OrderLine {
    private String ref; // referencia
    private String desc; // descriçao
    private double grossPrice; // preço bruto
    private int qnt; // quantidade
    private double tax; // imposto (em percentagem)
    private double rebate; // desconto (em percentagem)

    // Construtor vazio
    public OrderLine(){
        this.ref = "#000000";
        this.desc = "ProfJam's Album";
        this.grossPrice = 9.99;
        this.qnt = 100;
        this.tax = 23;
        this.rebate = 5;
    }

    // Construtor parametrizado
    public OrderLine(String ref, String desc, double grossPrice,
                     int qnt, double tax, double rebate) {
        this.ref = ref;
        this.desc = desc;
        this.grossPrice = grossPrice;
        this.qnt = qnt;
        this.tax = (0 <= tax && tax <= 100) ? tax : 0;
        this.rebate = (0 <= rebate && rebate <= 100) ? rebate : 0;
    }

    // Construtor para clone
    public OrderLine(OrderLine orderLine){
        setRef(orderLine.getRef());
        setDesc(orderLine.getDesc());
        setGrossPrice(orderLine.getGrossPrice());
        setQnt(orderLine.getQnt());
        setTax(orderLine.getTax());
        setRebate(orderLine.getRebate());
    }

    /**
     * Metodo que determina o valor da venda
     * ja considerados os impostos e os descontos
     *
     * @return valor total da venda
     */
    public double calculaValorLinhaEnc(){
        return (getGrossPrice()*getQnt() - calculaValorDesconto()) * ((100+getTax())/100);
    }

    /**
     * Valor total em descontos
     *
     * @return valor dos descontos
     */
    public double calculaValorDesconto(){
        return getGrossPrice() * getQnt() * (getRebate()/100);
    }

//    /**
//     * Metodo que calcula o valor total da
//     * linha de encomenda, após imposto e
//     * descontos.
//     *
//     * @return valor total da linha de encomenda
//     */
//    public double calculaValorLinhaEnc() {
//        double total = this.qnt * this.grossPrice;
//        total -= total*this.rebate;
//        total *= 1+this.tax;
//        return total;
//    }
//
//    /**
//     * Metodo que calcula o valor total de
//     * desconto da linha de encomenda.
//     *
//     * @return valor do desconto
//     */
//    public double calculaValorDesconto() {
//        double value = this.qnt * this.grossPrice;
//        value *= this.tax;
//        return this.calculaValorLinhaEnc()-value;
//    }

    // Getters e Setters
    public String getRef() {
        return this.ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getGrossPrice() {
        return this.grossPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }

    public int getQnt() {
        return this.qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public double getTax() {
        return this.tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getRebate() {
        return this.rebate;
    }

    public void setRebate(double rebate) {
        this.rebate = rebate;
    }
    ///////////////////////////////////////////////

    @Override
    public OrderLine clone(){
        return new OrderLine(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return getGrossPrice() == orderLine.getGrossPrice() &&
                getQnt() == orderLine.getQnt() &&
                orderLine.getTax() == getTax() &&
                orderLine.getRebate() == getRebate() &&
                getRef().equals(orderLine.getRef()) &&
                getDesc().equals(orderLine.getDesc());
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "ref='" + ref + '\'' +
                ", desc='" + desc + '\'' +
                ", grossPrice=" + grossPrice +
                ", qnt=" + qnt +
                ", tax=" + tax +
                ", rebate=" + rebate +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRef(), getDesc(), getGrossPrice(), getQnt(), getTax(), getRebate());
    }
}
