import java.io.*;
import java.time.LocalDateTime;

public class EletrodomesticoInteligente extends Eletrodomesticos{
    private LocalDateTime ligar;
    private LocalDateTime desligar;

    public EletrodomesticoInteligente(String ident, double consumo, LocalDateTime ligar, LocalDateTime desligar) {
        super(ident, consumo);
        this.ligar = ligar;
        this.desligar = LocalDateTime.of(1,1,1,8,20,0);
//        while(true){
//            LocalTime now = LocalTime.now();
//            if(now.getHour() == this.ligar.getHour()
//            && now.getMinute() == this.ligar.getMinute()
//            && now.getSecond() == this.ligar.getSecond())
//                super.eletrodomesticoOn();
//
//            if(now.getHour() == this.desligar.getHour()
//            && now.getMinute() == this.desligar.getMinute()
//            && now.getSecond() == this.desligar.getSecond())
//                super.eletrodomesticoOff();
//        }
    }

    public void turnOn(LocalDateTime ligar, LocalDateTime desligar){
        this.ligar = LocalDateTime.of(
                ligar.getYear(),
                ligar.getMonth(),
                ligar.getDayOfMonth(),
                ligar.getHour(),
                ligar.getMinute(),
                ligar.getSecond()
        );
        this.desligar = LocalDateTime.of(
                desligar.getYear(),
                desligar.getMonth(),
                desligar.getDayOfMonth(),
                desligar.getHour(),
                desligar.getMinute(),
                desligar.getSecond()
        );
        if(LocalDateTime.now().isBefore(this.ligar) && LocalDateTime.now().isAfter(this.desligar))
            super.eletrodomesticoOff();

        if(LocalDateTime.now().isAfter(this.ligar) && LocalDateTime.now().isBefore(this.desligar))
            super.eletrodomesticoOn();
    }

    public void turnOff(LocalDateTime desligar){
        this.desligar = LocalDateTime.of(
                desligar.getYear(),
                desligar.getMonth(),
                desligar.getDayOfMonth(),
                desligar.getHour(),
                desligar.getMinute(),
                desligar.getSecond()
        );
        if(LocalDateTime.now().equals(desligar))
            super.eletrodomesticoOff();
    }

    public void grava(String fileName) throws IOException {
        FileOutputStream fileInputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectInputStream = new ObjectOutputStream(fileInputStream);
        objectInputStream.writeObject(objectInputStream);
        objectInputStream.flush();
        objectInputStream.close();
    }
}
