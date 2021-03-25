public class Ex02 {
    public static void main(String[] args) {
        Order order = new Order();
        OrderLine orderLine = new OrderLine();
        order.addOrderLine(orderLine);
        System.out.println(order.toString());
        System.out.println("Valor total: " + order.calcTotalValue());
        System.out.println("Valor de desconto: " + order.calcTotalRebate());
        System.out.println("Quantidade de produtos: " + order.calcTotalQnt());
        System.out.println("Contem produto (#000000)? " + order.containsProduct("#000000"));
        System.out.println("Contem produto (#ffffff)? " + order.containsProduct("#ffffff"));
        order.remRefProd("#000000");
//        encomendaEficiente.remOrderLine(linhaEncomenda);
        System.out.println(order.toString());
    }
}
