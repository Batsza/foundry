public class Transport {
    private int idTransport;
    private int capacity;
    private int availableWeight;
    private int idCast;
    private boolean status;

    public Transport(){}

    public Transport(int idTransport, int capacity, int availableWeight, int idCast, boolean status){
        this.setIdTransport(idTransport);
        this.setCapacity(capacity);
        this.setAvailableWeight(availableWeight);
        this.setIdCast(idCast);
        this.setStatus(status);
    }

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

    public int getAvailableWeight() {
        return availableWeight;
    }

    public void setAvailableWeight(int availableWeight) {
        this.availableWeight = availableWeight;
    }

    public String transportList(){
        return ("ID: " + idTransport + " | ilość: " + capacity + " | waga: " + availableWeight + "\n");
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
}

