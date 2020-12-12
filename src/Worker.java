import java.util.Scanner;

public class Worker {
    private int idWorker;
    private int warehouse;
    private int cast;
    private int section;
    private static int numberOfWorker = 0;

    Worker worker[] = new Worker[2];

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

    public void dodajdotablicy(int a, int b) {
        worker[1].setData(a, b);
    }

    public void setData(int a, int b){
        this.idWorker = a;
        this.section = b;
    }

    public void wyswietlzawartosctablicy() {
        System.out.println("Id = "+ idWorker + ", section = " + section);
    }

    public void workerList(){
        for(int i = 0; i < numberOfWorker; i++){
            System.out.println("Id: " + idWorker);
            System.out.println("Sekcja: " + section);
        }
    }

    public static int increseNumberOfWorker(){
        return numberOfWorker++;
    }

    public void wyswietl(){
        System.out.println("Pracownik o id: " + idWorker + " w sekcji: " + section);
    }

    public void wyswietliloscpracownikow() {
        System.out.println("Ilosc pracownikow: " + numberOfWorker);
    }

}