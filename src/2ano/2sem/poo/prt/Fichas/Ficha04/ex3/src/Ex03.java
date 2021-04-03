public class Ex03 {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();

        lamp.lampON();
        lamp.lampOFF();

        IntelliHouse intelliHouse = new IntelliHouse();

        System.out.println(intelliHouse.toString());
        intelliHouse.addLamp(lamp);
        System.out.println(intelliHouse.toString());
        intelliHouse.lampON(0);
        System.out.println(intelliHouse.toString());
    }
}
