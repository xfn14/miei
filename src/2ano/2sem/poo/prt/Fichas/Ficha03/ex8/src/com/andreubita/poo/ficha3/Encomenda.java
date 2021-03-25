package com.andreubita.poo.ficha3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Encomenda {
    private String nome;
    private int nif;
    private String morada;
    private int orderId;
    private LocalDateTime orderTime;

    // Dependency over Ex7
    private List<OrderLine> orderLineList;

    public Encomenda(){
        this.nome = "André";
        this.nif = 777;
        this.morada = "Portugal";
        this.orderId = 1;
        this.orderTime = LocalDateTime.now();
        this.orderLineList = new ArrayList<>(10);
    }

    public Encomenda(String nome, int nif, String morada, int orderId,
                     LocalDateTime orderTime, List<OrderLine> orderLineList) {
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.orderId = orderId;
        this.orderTime = orderTime;
        setOrderLineList(orderLineList);
    }

    public Encomenda(Encomenda order){
        setNome(order.getNome());
        setNif(order.getNif());
        setMorada(order.getMorada());
        setOrderId(order.getOrderId());
        setOrderTime(order.getOrderTime());
        setOrderLineList(order.getOrderLineList());
    }

    public double calculaValorDesconto(){
        return getOrderLineList().stream().mapToDouble(OrderLine::calcValueInLine).sum();
//        int total = 0;
//        for(OrderLine orderLine : getOrderLineList())
//            total += orderLine.calcValueInLine();
//        return total;
    }

    public double calcTotalRebate(){
        return getOrderLineList().stream().mapToDouble(OrderLine::getRebateValue).sum();
    }

    public double calcTotalQnt(){
        return getOrderLineList().stream().mapToDouble(OrderLine::getQnt).sum();
    }

    public boolean containsProduct(String ref){
        for(OrderLine orderLine : getOrderLineList())
            if(orderLine.getRef().equals(ref)) return true;
        return false;
    }

    public void addOrderLine(OrderLine orderLine){
        List<OrderLine> orderLines = new ArrayList<>(getOrderLineList());
        orderLines.add(orderLine.clone());
        this.orderLineList = orderLines;
    }

    public void remOrderLine(OrderLine orderLine){
        List<OrderLine> orderLines = new ArrayList<>(getOrderLineList());
        orderLines.remove(orderLine);
        this.orderLineList = orderLines;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
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

    @Override
    public Encomenda clone(){
        return new Encomenda(this);
    }

    @Override
    public String toString() {
        return "Encomenda{" +
                "name='" + nome + '\'' +
                ", nif=" + nif +
                ", address='" + morada + '\'' +
                ", orderId=" + orderId +
                ", orderTime=" + orderTime +
                ", orderLineList=" + orderLineList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return getNif() == encomenda.getNif() &&
                getOrderId() == encomenda.getOrderId() &&
                Objects.equals(getNome(), encomenda.getNome()) &&
                Objects.equals(getMorada(), encomenda.getMorada()) &&
                Objects.equals(getOrderTime(), encomenda.getOrderTime()) &&
                Objects.equals(getOrderLineList(), encomenda.getOrderLineList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getNif(), getMorada(), getOrderId(), getOrderTime(), getOrderLineList());
    }
}
