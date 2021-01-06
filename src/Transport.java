
public class Transport {
    private int idTransport;
    private int capacity;
    private int availableweight;

    public int getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(int idTransport) {
        this.idTransport = idTransport;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableweight() {
        return availableweight;
    }

    public void setAvailableweight(int availableweight) {
        this.availableweight = availableweight;
    }

    public void transportList(){
        System.out.println("Id: " + idTransport + " | ilosc: " + capacity + " | waga: " + availableweight);
    }
/*
    public showTransportInformations(){

    }

    public static findTransport(){

    }*/
}

