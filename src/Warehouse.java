
public class Warehouse {
    private int idWarehouse;
    private int castAmount;
    private int materials;
    private int capacity;

    public Warehouse(){}
    public Warehouse(int idWarehouse, int cast, int materials, int capacity){
        this.setIdWarehouse(idWarehouse);
        this.setCastAmount(cast);
        this.setMaterials(materials);
        this.setCapacity(capacity);
    }


    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public int getCastAmount() {
        return castAmount;
    }

    public void setCastAmount(int castAmount) {
        this.castAmount = castAmount;
    }

    public int getMaterials() {
        return materials;
    }

    public void setMaterials(int materials) {
        this.materials = materials;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void warehouseList(){
        System.out.println("Id: " + idWarehouse + " | ilosc: " + capacity);
    }
/*

    public showWarehouseInformations(){

    }

    private calculateCapacity(){

    }

    public static findWarehouse(){

    }*/
}


