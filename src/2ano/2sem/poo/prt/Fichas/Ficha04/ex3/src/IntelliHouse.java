import java.util.ArrayList;
import java.util.List;

public class IntelliHouse {
    private List<Lamp> lampList = new ArrayList<>();

    public IntelliHouse(){
        setLampList(new ArrayList<>());
    }

    public IntelliHouse(List<Lamp> lampList) {
        this.lampList = lampList;
    }

    public IntelliHouse(IntelliHouse intelliHouse){
        setLampList(intelliHouse.getLampList());
    }

    public void addLamp(Lamp lamp){
        this.lampList.add(lamp.clone());
    }

    public void lampON(int i){
        this.lampList.get(i).lampON();
    }

    public void lampOFF(int i){
        this.lampList.get(i).lampOFF();
    }

    public void lampECO(int i){
        this.lampList.get(i).lampECO();
    }

    public int numEco(){
        int count = 0;
        for(Lamp lamp : this.lampList)
            if(lamp.getSwitches().get(lamp.getSwitches().size()-1).getY().equals(Lamp.State.ECO))
                count++;
        return count;
    }

    public void removeLamp(int i){
        this.lampList.remove(i);
    }

    public void turnAllECO(){
        for(Lamp lamp : this.lampList)
            if(!lamp.getState().equals(Lamp.State.ECO))
                lamp.lampECO();
    }

    public void turnAllON(){
        for(Lamp lamp : this.lampList)
            if(!lamp.getState().equals(Lamp.State.ON))
                lamp.lampON();
    }

    /**
     * Calculates the total expense since
     * last reset off all lamps
     *
     * @return total expense
     */
    public double totalExpense(){
        return this.lampList.stream().mapToDouble(Lamp::lastExpense).sum();
    }

    public void reset(){
        this.lampList.forEach(Lamp::reset);
    }

    public List<Lamp> getLampList() {
        List<Lamp> newArr = new ArrayList<>();
        for(Lamp crt : this.lampList)
            newArr.add(crt.clone());
        return newArr;
    }

    public void setLampList(List<Lamp> lampList) {
        List<Lamp> newArr = new ArrayList<>();
        for(Lamp crt : lampList)
            newArr.add(crt.clone());
        this.lampList = newArr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntelliHouse that = (IntelliHouse) o;

        return getLampList() != null ? getLampList().equals(that.getLampList()) : that.getLampList() == null;
    }

    @Override
    public int hashCode() {
        return getLampList() != null ? getLampList().hashCode() : 0;
    }

    @Override
    protected IntelliHouse clone() {
        return new IntelliHouse(this);
    }

    @Override
    public String toString() {
        return "IntelliHouse{" +
                "lampList=" + lampList +
                '}';
    }
}
