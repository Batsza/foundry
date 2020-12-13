import java.util.Scanner;

public class LogisticWorker extends Worker {


    int numberOfWarehouse = 0;
    Warehouse[] warehouse = new Warehouse[5];
    public void  addNewWarehouse(){
        if(numberOfWarehouse == 0){
            for(int i = numberOfWarehouse; i < warehouse.length; i++) {
                warehouse[i] = new Warehouse();
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj id magzynu: ");
        Integer a = scan.nextInt();
        warehouse[numberOfWarehouse].setIdWarehouse(a);
        System.out.print("Podaj pojemnosc: ");
        Integer b = scan.nextInt();
        warehouse[numberOfWarehouse].setCapacity(b);

        numberOfWarehouse++;
    }
    public void showWarehouseList(){
        for(int i = 1; i < numberOfWarehouse+1; i++) {
            System.out.println("Magazyn ");
            warehouse[i-1].warehouseList();
        }
    }

    /*
    public increseMaterial(){

    }

    public changeStorageLocation(){

    }

    public showRequestMaterials(){

    }

    public requestTransport(){

    }

 */
}

