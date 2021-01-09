
public class Transport {
    private int idTransport;
    private int capacity;
    private int availableweight;
    private int idCast;
    private boolean status;

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

    public int getIdCast() {
        return idCast;
    }

    public void setIdCast(int idCast) {
        this.idCast = idCast;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
/*
    public showTransportInformations(){

    }

    public static findTransport(){

    }*/
}

