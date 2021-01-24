public class Material {
    private int idMaterial;
    private String name;
    private int size;
    private int amount;
    private int price;
    private int idWarehouse;

    public Material(){}

    public Material(int idMaterial,String name,int size, int amount, int price,int idWarehouse){
        this.setIdMaterial(idMaterial);
        this.setName(name);
        this.setSize(size);
        this.setAmount(amount);
        this.setPrice(price);
        this.setIdWarehouse(idWarehouse);

    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String materialList(){
        return ("ID: " + idMaterial + " | nazwa: " + name +  " | waga: " + size + " | ilość: " + amount + " | cena: " + price + " | ID magazynu: " + idWarehouse + "\n" );
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }
}
