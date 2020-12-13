
public class Transport {
    private int idTransport;
    private int capacity;
    private int weight;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void transportList(){
        System.out.println("Id: " + idTransport);
        System.out.println("ilosc: " + capacity);
        System.out.println("waga: " + weight );


    }
/*
    public showTransportInformations(){

    }

    public static findTransport(){

    }*/
}

