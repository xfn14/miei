package com.andreubita.poo.ficha3;

public class OrderLine {
    private String ref;
    private String desc;
    private double grossPrice;
    private int qnt;
    private double tax;
    private double rebate;

    public OrderLine(){
        this.ref = "#000000";
        this.desc = "ProfJam's Album";
        this.grossPrice = 9.99;
        this.qnt = 100;
        this.tax = 13.45;
        this.rebate = 2;
    }

    public OrderLine(String ref, String desc, double grossPrice,
                     int qnt, double tax, double rebate) {
        this.ref = ref;
        this.desc = desc;
        this.grossPrice = grossPrice;
        this.qnt = qnt;
        this.tax = (0 <= tax && tax <= 100) ? tax : 0;
        this.rebate = (0 <= rebate && rebate <= 100) ? rebate : 0;
    }

    public OrderLine(OrderLine orderLine){
        setRef(orderLine.getRef());
        setDesc(orderLine.getDesc());
        setGrossPrice(orderLine.getGrossPrice());
        setQnt(orderLine.getQnt());
        setTax(orderLine.getTax());
        setRebate(orderLine.getRebate());
    }

    public double calcValueInLine(){
        return getGrossPrice() - getTaxValue() + getRebateValue();
    }

    public double getTaxValue(){
        return getGrossPrice() * getQnt() * (getTax()/100);
    }

    public double getRebateValue(){
        return getGrossPrice() * getQnt() * (getRebate()/100);
    }

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
}
