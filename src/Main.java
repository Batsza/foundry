import java.util.*;

public class Main {
    public static void main (String[] args) {
        Manager manager = new Manager();
        LogisticWorker lworker = new LogisticWorker();
        ShippingWorker sworker = new ShippingWorker();
        CastWorker cworker = new CastWorker();
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Menu: ");
            System.out.println("1 - dodaj pracownika");
            System.out.println("2 - wyświetl pracowników");
            System.out.println("3 - usuń pracownika");
            System.out.println("4 - zakończ program");
            System.out.println("5 - dodaj materiał");
            System.out.println("6 - wyświetl liste materiałów");
            System.out.println("7 - usuń materiał");
            System.out.println("8 - dodaj magazyn");
            System.out.println("9 - wyświetl liste magazynów");
            System.out.println("10 - dodaj transport");
            System.out.println("11 - wyświetl liste transportów");
            System.out.println("12 - dodaj odlew");
            System.out.println("13 - dodaj projekt");
            System.out.println("14 - wyświetl listę odlewów");
            System.out.println("15 - wyświetl listę projektów");
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
                        break;
                    case 4:
                        System.exit(0);
                    case 5:
                        lworker.addNewMaterial();
                        break;
                    case 6:
                        lworker.showMaterialList();
                        break;
                    case 7:
                        lworker.deleteMaterial();
                        break;
                    case 8:
                        lworker.addNewWarehouse();
                        break;
                    case 9:
                        lworker.showWarehouseList();
                        break;
                    case 10:
                        sworker.orderTransport();
                        break;
                    case 11:
                        sworker.showTransportList();
                        break;
                    case 12:
                        cworker.addNewCasting();
                        break;
                    case 13:
                        cworker.addNewProject();
                        break;
                    case 14:
                        cworker.showCastList();
                        break;
                    case 15:
                        cworker.showProjectList();
                        break;
                    default:
                        System.exit(0);
                }
            } catch(NumberFormatException e) {}
        } while(true);
    }
}
