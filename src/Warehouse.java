
public class Warehouse {
    private int idWarehouse;
    private int cast;
    private int materials;
    private int capacity;

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public int getCast() {
        return cast;
    }

    public void setCast(int cast) {
        this.cast = cast;
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


