import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Parque {
    private String name;
    private Map<String,Lugar> parqueMap;

    public Parque(){
        this.name = "";
        this.parqueMap = new HashMap<>();
    }

    public Parque(String name, Map<String, Lugar> parqueMap) {
        this.name = name;
        setParqueMap(parqueMap);
    }

    public Parque(Parque parque){
        this.name = parque.getName();
        this.parqueMap = parque.getParqueMap();
    }

    public List<String> getAllMatriculas(){
        return new ArrayList<>(this.parqueMap.keySet());
    }

    public void parkCar(Lugar lugar){
        this.parqueMap.put(lugar.getMatricula(), lugar.clone());
    }

    public void unparkCar(String matricula){
        this.parqueMap.remove(matricula);
    }

    public void changeTime(String matricula, int time){
        Lugar newLugar = this.parqueMap.get(matricula);
        newLugar.setMinutos(time);
        this.parqueMap.put(matricula, newLugar);
    }

    public int getTotalMinutes(){
        return this.parqueMap.values().stream().mapToInt(Lugar::getMinutos).sum();
//        int acc = 0;
//        for(Lugar crt : this.parqueMap.values()){
//            acc += crt.getMinutos();
//        }
//        return acc;
    }

    public boolean hasMatricula(String matricula){
        return this.parqueMap.containsKey(matricula);
    }

    public List<String> getMatriculasTimed(int time){
        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Lugar> mat : this.parqueMap.entrySet()){
            if(mat.getValue().getMinutos() > time && mat.getValue().isPermanente())
                res.add(mat.getKey());
        }
        return res;
    }

    public List<Lugar> getAllLugares(){
        return this.parqueMap.values().stream().map(Lugar::clone).collect(Collectors.toList());
//        List<Lugar> res = new ArrayList<>();
//        for(Lugar crt : this.parqueMap.values())
//            res.add(crt.clone());
//        return res;
    }

    public Lugar getLugarInfo(String matricula){
        if(!hasMatricula(matricula))
            return null;
        return this.parqueMap.get(matricula).clone();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Lugar> getParqueMap() {
        Map<String,Lugar> newParqueMap = new HashMap<>();
        for(Map.Entry<String, Lugar> mat : this.parqueMap.entrySet())
            newParqueMap.put(mat.getKey(), mat.getValue().clone());
        return newParqueMap;
    }

    public void setParqueMap(Map<String, Lugar> parqueMap) {
        Map<String,Lugar> newParqueMap = new HashMap<>();
        for(Map.Entry<String, Lugar> mat : this.parqueMap.entrySet())
            newParqueMap.put(mat.getKey(), mat.getValue().clone());
        this.parqueMap = newParqueMap;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Parque{");
        sb.append("name='").append(name).append('\'');
        sb.append(", parqueMap=").append(parqueMap);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parque parque = (Parque) o;

        if (name != null ? !name.equals(parque.name) : parque.name != null) return false;
        return parqueMap != null ? parqueMap.equals(parque.parqueMap) : parque.parqueMap == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (parqueMap != null ? parqueMap.hashCode() : 0);
        return result;
    }

    @Override
    public Object clone(){
        return new Parque(this);
    }
}
