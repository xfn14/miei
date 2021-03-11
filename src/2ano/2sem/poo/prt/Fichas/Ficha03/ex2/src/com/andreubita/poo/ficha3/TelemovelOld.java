package com.andreubita.poo.ficha3;

import java.time.LocalDateTime;
import java.util.Arrays;

public class TelemovelOld {
    private String marca;
    private String modelo;
    private int displayX;
    private int displayY;
    private int dimTotal;
    private int dimOcupada;
    private String[] mensagens;
    private int dimMensagens;
    private int dimFotos;
    private int dimApps;
    private String[] nomeApps;
    private LocalDateTime horaDeCriacao;

    public TelemovelOld(){
        this.marca = "RAW";
        this.modelo = "k1";
        this.displayX = 1920;
        this.displayY = 1080;
        this.dimTotal = 1000;
        this.dimOcupada = 0;
        this.mensagens = new String[100];
        this.dimMensagens = 0;
        this.dimFotos = 0;
        this.dimApps = 0;
        this.nomeApps = new String[100];
    }

    public TelemovelOld(String marca, String modelo, int displayX, int displayY, int dimTotal,
                        int dimOcupada, String[] mensagens, int dimMensagens, int dimFotos,
                        int dimApps, String[] nomeApps){
        this.marca = marca;
        this.modelo = modelo;
        this.displayX = displayX;
        this.displayY = displayY;
        this.dimTotal = dimTotal;
        this.dimOcupada = dimOcupada;
        setMensagens(mensagens);
        this.dimMensagens = dimMensagens;
        this.dimFotos = dimFotos;
        this.dimApps = dimApps;
        setNomeApps(nomeApps);

        horaDeCriacao = LocalDateTime.now();
    }

    public TelemovelOld(TelemovelOld t){
        setMarca(t.getMarca());
        setModelo(t.getModelo());
        setDisplayX(t.getDisplayX());
        setDisplayY(t.getDisplayY());
        setDimTotal(t.getDimTotal());
        setDimOcupada(t.getDimOcupada());
        setMensagens(t.getMensagens());
        setDimMensagens(t.getDimMensagens());
        setDimFotos(t.getDimFotos());
        setDimApps(t.getDimApps());
        setNomeApps(t.getNomeApps());
    }

    public boolean existeEspaço(int numeroBytes){
        return getDimTotal() >= (getDimOcupada() + numeroBytes);
    }

    public void instalaApp(String nome, int tamanho){
        if(!(existeEspaço(tamanho) || (containsNomeApp(nome) != -1))) {
            addNomeApps(nome);
            this.dimOcupada += tamanho;
        }
    }

    public void recebeMsg(String msg){
        addMensagem(msg);
    }

    public double tamMedioApps(){
        return (double) getDimOcupada() / getDimApps();
    }

    public String maiorMsg(){
        String maior = "";
        for (int i = 0; i < getDimMensagens(); i++) {
            if(this.mensagens[i].length() > maior.length()){
                // maior = new String(this.mensagens[i]); é desnecessario
                maior = this.mensagens[i];
            }
        }
        return maior;
    }

    public void removeApp(String nome, int tamanho){
        int exists = containsNomeApp(nome);
        if(exists != -1){
//            for (int i = exists; i < getDimApps(); i++) {
//                this.nomeApps[i] = this.nomeApps[i+1];
//            }
            if (getDimApps() - exists >= 0)
                System.arraycopy(this.nomeApps, exists + 1, this.nomeApps, exists, getDimApps() - exists);
            this.dimApps--;
        }
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getDisplayX() {
        return this.displayX;
    }

    public void setDisplayX(int displayX) {
        this.displayX = displayX;
    }

    public int getDisplayY() {
        return this.displayY;
    }

    public void setDisplayY(int displayY) {
        this.displayY = displayY;
    }

    public int getDimTotal() {
        return this.dimTotal;
    }

    public void setDimTotal(int dimTotal) {
        this.dimTotal = dimTotal;
    }

    public int getDimOcupada() {
        return this.dimOcupada;
    }

    public void setDimOcupada(int dimOcupada) {
        this.dimOcupada = dimOcupada;
    }

    public String[] getMensagens() {
        return Arrays.copyOf(this.mensagens, this.mensagens.length);
    }

    public void setMensagens(String[] mensagens) {
        this.mensagens = Arrays.copyOf(mensagens, mensagens.length);
    }

    public void addMensagem(String mensagem){
        if(this.dimMensagens == this.mensagens.length)
            this.mensagens = Arrays.copyOf(this.mensagens, this.mensagens.length*2);
        this.mensagens[this.dimMensagens++] = mensagem;
    }

    public int getDimMensagens() {
        return this.dimMensagens;
    }

    public void setDimMensagens(int dimMensagens) {
        this.dimMensagens = dimMensagens;
    }

    public int getDimFotos() {
        return this.dimFotos;
    }

    public void setDimFotos(int dimFotos) {
        this.dimFotos = dimFotos;
    }

    public int getDimApps() {
        return this.dimApps;
    }

    public void setDimApps(int dimApps) {
        this.dimApps = dimApps;
    }

    public String[] getNomeApps() {
        return Arrays.copyOf(this.nomeApps, this.nomeApps.length);
    }

    public void setNomeApps(String[] nomeApps) {
        this.nomeApps = Arrays.copyOf(nomeApps, nomeApps.length);
    }

    public int containsNomeApp(String nome){
        for (int i = 0; i < getDimApps(); i++) {
            if(getNomeApps()[i].equals(nome)){
                return i;
            }
        }
        return -1;
    }

    public void addNomeApps(String nome){
        if(this.dimApps == this.nomeApps.length)
            this.nomeApps = Arrays.copyOf(this.nomeApps, this.nomeApps.length*2);
        this.nomeApps[this.dimApps++] = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelemovelOld telemovel = (TelemovelOld) o;
        return getDisplayX() == telemovel.getDisplayX() &&
                getDisplayY() == telemovel.getDisplayY() &&
                getDimTotal() == telemovel.getDimTotal() &&
                getDimOcupada() == telemovel.getDimOcupada() &&
                getDimMensagens() == telemovel.getDimMensagens() &&
                getDimFotos() == telemovel.getDimFotos() &&
                getDimApps() == telemovel.getDimApps() &&
                getMarca().equals(telemovel.getMarca()) &&
                getModelo().equals(telemovel.getModelo()) &&
                Arrays.equals(getMensagens(), telemovel.getMensagens()) &&
                Arrays.equals(getNomeApps(), telemovel.getNomeApps());
    }

    @Override
    public Object clone() {
        return new TelemovelOld(this);
    }

    @Override
    public String toString() {
        return "Telemovel{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", displayX=" + displayX +
                ", displayY=" + displayY +
                ", dimTotal=" + dimTotal +
                ", dimOcupada=" + dimOcupada +
                ", mensagens=" + Arrays.toString(mensagens) +
                ", dimMensagens=" + dimMensagens +
                ", dimFotos=" + dimFotos +
                ", dimApps=" + dimApps +
                ", nomeApps=" + Arrays.toString(nomeApps) +
                '}';
    }
}
