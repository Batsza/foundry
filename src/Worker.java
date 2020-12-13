import java.util.Scanner;

public class Worker {
    private int idWorker;
    private int warehouse;
    private int cast;
    private int section;

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    public int getCast() {
        return cast;
    }

    public void setCast(int cast) {
        this.cast = cast;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public void workerList(){
            System.out.println("Id: " + idWorker);
            System.out.println("Sekcja: " + section);
    }
}