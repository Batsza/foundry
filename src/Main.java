import javax.swing.*;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        /*
        Worker w = new Worker();
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj ID: ");
        w.setIdWorker(sc.nextInt()) ;

        System.out.println("Podaj odlew: ");
        w.setCast(sc.nextInt());

        System.out.println("Podaj magazyn: ");
        w.setWarehouse(sc.nextInt());
        System.out.println("Podaj sekcja: ");
        w.setSection(sc.next());

        System.out.println(w.getIdWorker());
        System.out.println(w.getCast());
        System.out.println(w.getWarehouse());
        System.out.println(w.getSection());
         */
        Manager manager = new Manager();
        for(int i = 0; i < 2; i++){
            manager.addWorker();
        }
        manager.showWorkersList();
    }
}
