package com.andreubita.poo.ficha3;

import java.util.Arrays;

public class Telemovel {

    // Object variables ----------------------
    private String brand;
    private String model;

    private int displayX;
    private int displayY;

    // Values represented in bytes
    private int storageTotal;
    private int storagePhotos;
    private int storageMessages;
    private int storageApps;

    private String[] messages;
    private String[] apps;

    private int numPhotos;
    private int numMessages;
    private int numApps;
    // ---------------------------------------

    // Empty constructor
    public Telemovel(){
        this.brand = "OnePlus";
        this.model = "7T";

        this.displayX = 1080;
        this.displayY = 2400;

        this.storageTotal = 128000; // imagine 128gb
        this.storagePhotos = 0;
        this.storageMessages = 0;
        this.storageApps = 0;

        this.messages = new String[10];
        this.apps = new String[10];

        this.numPhotos = 0;
        this.numMessages = 0;
        this.numApps = 0;
    }

    // Full variable constructor
    public Telemovel(String brand, String model, int displayX, int displayY, int storageTotal,
                     int storagePhotos, int storageMessages, int storageApps, String[] messages,
                     String[] apps, int numPhotos, int numMessages, int numApps) {
        this.brand = brand;
        this.model = model;

        this.displayX = displayX;
        this.displayY = displayY;

        this.storageTotal = storageTotal;
        this.storagePhotos = storagePhotos;
        this.storageMessages = storageMessages;
        this.storageApps = storageApps;

        setMessages(messages);
        setApps(apps);

        this.numPhotos = numPhotos;
        this.numMessages = numMessages;
        this.numApps = numApps;
    }

    // Clone constructor
    public Telemovel(Telemovel telemovel){
        this.brand = telemovel.getBrand();
        this.model = telemovel.getModel();

        this.displayX = telemovel.getDisplayX();
        this.displayY = telemovel.getDisplayY();

        this.storageTotal = telemovel.getStorageTotal();
        this.storagePhotos = telemovel.getStoragePhotos();
        this.storageMessages = telemovel.getStorageMessages();
        this.storageApps = telemovel.getStorageApps();

        setMessages(telemovel.getMessages());
        setApps(telemovel.getApps());

        this.numPhotos = telemovel.getNumPhotos();
        this.numMessages = telemovel.getNumMessages();
        this.numApps = telemovel.getNumApps();
    }

    public boolean hasSpace(int bytes){
        return getStorageTotal() >= (getStorageOccupied() + bytes);
    }

    public void installApp(String name, int size){
        // Check if phone has space to install app or if the app is already installed
        if(!hasSpace(size) || hasApp(name)) return;

        // Realloc apps array in case it doesn't have space
        if(this.numApps >= this.apps.length)
            this.apps = Arrays.copyOf(this.apps, this.apps.length*2);

        // Install app
        this.apps[this.numApps++] = name;
        this.storageApps += size;
    }

    public void receiveMessage(String msg){
        if(this.numMessages >= this.messages.length)
            this.messages = Arrays.copyOf(this.messages, this.messages.length);
        this.messages[this.numMessages++] = msg;
    }

    public void receiveMessage(String msg, int size){
        receiveMessage(msg);
        this.storageMessages += size;
    }

    public double appMedSize(){
        return (double) getStorageApps() / getNumApps();
    }

    public String biggestMessage(){
        String msg = "";
        for (int i = 0; i < getNumMessages(); i++) {
            if(this.messages[i].length() > msg.length()){
                msg = this.messages[i];
            }
        }
        return msg;
    }

    public void removeApp(String name, int size){
        // Check if app is installed
        if(!hasApp(name)) return;

        // Remove app from array
        boolean found = false;
        for (int i = 0; i < this.numApps; i++) {
            if(this.apps[i].equals(name)) found = true;

            if(found && i == (this.numApps-1)) this.apps[i] = null;
            else if(found) this.apps[i] = this.apps[i+1];
        }

        this.numApps--;
        this.storageApps -= size;
    }

    public double getStorageOccupied(){
        return getStorageApps() + getStoragePhotos() + getStorageMessages();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDisplayX() {
        return displayX;
    }

    public void setDisplayX(int displayX) {
        this.displayX = displayX;
    }

    public int getDisplayY() {
        return displayY;
    }

    public void setDisplayY(int displayY) {
        this.displayY = displayY;
    }

    public int getStorageTotal() {
        return storageTotal;
    }

    public void setStorageTotal(int storageTotal) {
        this.storageTotal = storageTotal;
    }

    public int getStoragePhotos() {
        return storagePhotos;
    }

    public void setStoragePhotos(int storagePhotos) {
        this.storagePhotos = storagePhotos;
    }

    public int getStorageMessages() {
        return storageMessages;
    }

    public void setStorageMessages(int storageMessages) {
        this.storageMessages = storageMessages;
    }

    public int getStorageApps() {
        return storageApps;
    }

    public void setStorageApps(int storageApps) {
        this.storageApps = storageApps;
    }

    public String[] getMessages() {
        return Arrays.copyOf(this.messages, this.numMessages);
    }

    public void setMessages(String[] messages) {
        this.messages = Arrays.copyOf(messages, messages.length);
    }

    public String[] getApps() {
        return Arrays.copyOf(this.apps, this.numApps);
    }

    public void setApps(String[] apps) {
        this.apps = Arrays.copyOf(apps, apps.length);
    }

    public boolean hasApp(String name){
        for (int i = 0; i < this.numApps; i++) {
            if(this.apps[i].equals(name)) return true;
        }
        return false;
    }

    public int getNumPhotos() {
        return numPhotos;
    }

    public void setNumPhotos(int numPhotos) {
        this.numPhotos = numPhotos;
    }

    public int getNumMessages() {
        return numMessages;
    }

    public void setNumMessages(int numMessages) {
        this.numMessages = numMessages;
    }

    public int getNumApps() {
        return numApps;
    }

    public void setNumApps(int numApps) {
        this.numApps = numApps;
    }

    @Override
    public Telemovel clone(){
        return new Telemovel(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telemovel telemovel = (Telemovel) o;
        return getDisplayX() == telemovel.getDisplayX() &&
                getDisplayY() == telemovel.getDisplayY() &&
                getStorageTotal() == telemovel.getStorageTotal() &&
                getStoragePhotos() == telemovel.getStoragePhotos() &&
                getStorageMessages() == telemovel.getStorageMessages() &&
                getStorageApps() == telemovel.getStorageApps() &&
                getNumPhotos() == telemovel.getNumPhotos() &&
                getNumMessages() == telemovel.getNumMessages() &&
                getNumApps() == telemovel.getNumApps() &&
                getBrand().equals(telemovel.getBrand()) &&
                getModel().equals(telemovel.getModel()) &&
                Arrays.equals(getMessages(), telemovel.getMessages()) &&
                Arrays.equals(getApps(), telemovel.getApps());
    }

    @Override
    public String toString() {
        return "Telemovel{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", displayX=" + displayX +
                ", displayY=" + displayY +
                ", storageTotal=" + storageTotal +
                ", storagePhotos=" + storagePhotos +
                ", storageMessages=" + storageMessages +
                ", storageApps=" + storageApps +
                ", messages=" + Arrays.toString(messages) +
                ", apps=" + Arrays.toString(apps) +
                ", numPhotos=" + numPhotos +
                ", numMessages=" + numMessages +
                ", numApps=" + numApps +
                '}';
    }
}
