import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main (String[] args) throws SQLException, ClassNotFoundException {
        Manager manager = new Manager();
        LogisticWorker lworker = new LogisticWorker();
        ShippingWorker sworker = new ShippingWorker();
        CastWorker cworker = new CastWorker();
        Worker worker = new Worker();
        Scanner scan = new Scanner(System.in);

        manager.loadWorker();
        lworker.loadMaterial();
        cworker.loadCast();
        cworker.loadProject();
        cworker.loadForm();
        lworker.loadWarehouse();
        sworker.loadTransport();

        do {
            System.out.println("Menu: ");
            System.out.println("1 - dodaj pracownika");
            System.out.println("2 - wyświetl pracowników");
            System.out.println("3 - usuń pracownika");
            System.out.println("4 - dodaj materiał");
            System.out.println("5 - wyświetl liste materiałów");
            System.out.println("6 - usuń materiał");
            System.out.println("7 - dodaj magazyn");
            System.out.println("8 - wyświetl liste magazynów");
            System.out.println("9 - dodaj transport");
            System.out.println("10 - wyświetl liste transportów");
            System.out.println("11 - usuń transport");
            System.out.println("12 - dodaj odlew");
            System.out.println("13 - wyświetl listę odlewów");
            System.out.println("14 - usuń odlew");
            System.out.println("15 - dodaj projekt");
            System.out.println("16 - wyświetl listę projektów");
            System.out.println("17 - usuń projekt");
            System.out.println("18 - zmien magazyn odlewu");
            System.out.println("19 - usuń magazyn");
            System.out.println("20 - dodaj forme");
            System.out.println("21 - wyświetl listę form");
            System.out.println("22 - usuń forme");
            System.out.println("23 - zakończ program");
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
                        lworker.addNewMaterial();
                    case 5:
                        lworker.showMaterialList();
                        break;
                    case 6:
                        lworker.deleteMaterial();
                        break;
                    case 7:
                        lworker.addNewWarehouse();
                        break;
                    case 8:
                        lworker.showWarehouseList();
                        break;
                    case 9:
                        sworker.orderTransport();
                        break;
                    case 10:
                        sworker.showTransportList();
                        break;
                    case 11:
                        sworker.deleteTransport();
                        break;
                    case 12:
                        cworker.addNewCasting();
                        break;
                    case 13:
                        cworker.showCastList();
                        break;
                    case 14:
                        cworker.deleteCast();
                        break;
                    case 15:
                        cworker.addNewProject();
                        break;
                    case 16:
                        cworker.showProjectList();
                        break;
                    case 17:
                        cworker.deleteProject();
                        break;
                    case 18:
                        lworker.changeStorageLocation();
                        break;
                    case 19:
                        lworker.deleteWarehouse();
                        break;
                    case 20:
                        cworker.addNewForm();
                        break;
                    case 21:
                        cworker.showFormList();
                        break;
                    case 22:
                        cworker.deleteForm();
                        break;
                    case 23:
                        System.exit(0);
                        break;
                    default:
                        System.exit(0);
                }
            } catch(NumberFormatException e) {}
        } while(true);
    }
}
