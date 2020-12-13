import java.util.*;

public class Main {
    public static void main (String[] args) {
        Manager manager = new Manager();
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Menu: ");
            System.out.println("1 - dodaj pracownika");
            System.out.println("2 - wyświetl pracowników");
            System.out.println("3 - usuń pracownika");
            System.out.println("4 - zakończ program");
            Integer menu = scan.nextInt();
            try {
                switch (menu) {
                    case 1:
                        manager.addWorker();
                        break;
                    case 2:
                        manager.showWorkersList();
                        break;
                    case 3:
                        manager.deleteWorker();
                    case 4:
                        System.exit(0);
                    default:
                        System.exit(0);
                }
            } catch(NumberFormatException e) {}
        } while(true);
    }
}
