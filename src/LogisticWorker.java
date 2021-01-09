import java.util.Scanner;

public class LogisticWorker extends Worker {
    int numberOfMaterials = 0;
    Material[] material = new Material[100];
    Scanner scan = new Scanner(System.in);

    public void  addNewWarehouse(){

        if(numberOfWarehouse == 1){ //jak się usunie z maina to co jest dane z bomby to 1 zmienic na 0
            for(int i = numberOfWarehouse; i < warehouseXD.length; i++) {
                warehouseXD[i] = new Warehouse();
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj id magzynu: ");
        Integer a = scan.nextInt();
        warehouseXD[numberOfWarehouse].setIdWarehouse(a);
        System.out.print("Podaj pojemnosc: ");
        Integer b = scan.nextInt();
        warehouseXD[numberOfWarehouse].setCapacity(b);
        numberOfWarehouse++;
    }

    public void showWarehouseList(){
        System.out.println("Magazyn:");
        for(int i = 1; i < numberOfWarehouse+1; i++) {
            warehouseXD[i-1].warehouseList();
        }
    }

    public void  addNewMaterial(){
        Warehouse warehouseT = new Warehouse();

        if(numberOfMaterials == 0){
            for(int i = numberOfMaterials; i < material.length; i++) {
                material[i] = new Material();
            }
        }

        System.out.print("Podaj id materiału: ");
        Integer a = scan.nextInt();
        material[numberOfMaterials].setIdMaterial(a);
        System.out.print("Podaj nazwę: ");
        String b = scan.next();
        material[numberOfMaterials].setName(b);
        System.out.print("Podaj wagę: ");
        Integer c = scan.nextInt();
        material[numberOfMaterials].setSize(c);
        System.out.print("Podaj ilosc: ");
        Integer d = scan.nextInt();
        material[numberOfMaterials].setAmount(d);
        System.out.print("Podaj cenę: ");
        Integer e = scan.nextInt();
        material[numberOfMaterials].setPrice(e);
        System.out.print("Podaj id magazynu: ");
        Integer f = scan.nextInt();
        material[numberOfMaterials].setIdWarehouse(f);
        for (int i = 0; i <warehouseXD.length; i++){

            if(warehouseXD[i].getIdWarehouse()== f && warehouseXD[i]!=null ){
                warehouseT = warehouseXD[i];
                break;
            }

        }
        if(!calculateWarehouseCapacityM(material[numberOfMaterials],warehouseT)){
            System.out.print("zamala pojemnosc");
        }
        numberOfMaterials++;
    }
    public void showMaterialList(){
        System.out.println("Materiały: ");
        for(int i = 1; i < numberOfMaterials+1; i++) {
            if(material[i-1].getIdMaterial() > 0) {
                material[i-1].materialList();
            }
        }
    }


    protected void deleteMaterial(){
        System.out.print("Podaj id materiału: ");
        Integer c = scan.nextInt();
        for(int i = 0; i < numberOfMaterials; i++) {
            if(material[i].getIdMaterial() == c){
                material[i] = new Material();
                System.out.println("Materiał o id: " + c + " został usunięty");
            }
        }
        numberOfMaterials--;
        repairArrayObject();
    }

    void repairArrayObject(){
        for(int i = 0; i < numberOfMaterials; i++) {
            if(material[i].getIdMaterial() == 0){
                if((i+1) < numberOfMaterials){
                    for(int j = i; j < numberOfMaterials; j++){
                        material[j].setIdMaterial(material[j+1].getIdMaterial()-1);
                        material[j].setName(material[j+1].getName());
                        material[j].setSize(material[j+1].getSize());
                        material[j].setAmount(material[j+1].getAmount());
                        material[j].setPrice(material[j+1].getPrice());
                    }
                }
            }
        }
    }
    public void changeStorageLocation() {
        Cast castT = new Cast();
        Warehouse warehouseT = new Warehouse();
        System.out.print("podaj id odlewu do zmiany: ");
        Integer a = scan.nextInt();
        System.out.print("podaj id magazynu docelowego: ");
        Integer b = scan.nextInt();

        for (int i = 0; i < cast.length; i++) {
            if (cast[i].getIdCast() == a && cast[i] != null) {
                castT = cast[i];
                break;
            }
        }
        for (int i = 0; i < warehouseXD.length; i++) {
            if (warehouseXD[i].getIdWarehouse() == b && warehouseXD[i] != null) {
                warehouseT = warehouseXD[i];
                break;
            }
        }

        for (int i = 0; i < warehouseXD.length; i++) {
            if (warehouseXD[i].getIdWarehouse() == castT.getIdWarehouse()) {// warehouseXD[i] ten z którego wyszukujemy
                int castVolume = getCastSize(castT) * castT.getAmount();
                warehouseXD[i].setCapacity(warehouseXD[i].getCapacity() + castVolume);
                warehouseXD[i].setCastAmount(warehouseXD[i].getCastAmount() - castT.getAmount());
                  break;
            }


        }
        if (!calculateWarehouseCapacity(castT, warehouseT)) {
            System.out.print("zamala pojemnosc");
        }


        castT.setIdWarehouse(b);

    }
/*



    public showRequestMaterials(){

    }





 */
}

