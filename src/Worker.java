public class Worker {
    private int idWorker;
    private int section;
    public Project[] proj = new Project[5];
    public Cast[] cast = new Cast[5];
    public Warehouse[] warehouseXD = new Warehouse[5];
    int numberOfWarehouse = 1; //jak się usunie z maina to co jest dane z bomby to 1 zmienic na 0



    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public void workerList(){
        System.out.println("Id: " + idWorker + " | sekcja: " + section);
    }

    static public boolean calculateWarehouseCapacity(Cast cast, Warehouse warehouse, Project project){

        int MaxCapacity = warehouse.getCapacity();
        System.out.println( "pojem " + MaxCapacity);
        int castAm = cast.getAmount();
        System.out.println( "ilosc " + castAm);
        int castSe = project.getSize();
        System.out.println( "waga " + castSe);
        int castVolume = castAm * castSe;
        if(MaxCapacity < castVolume)
            return false;
        warehouse.setCapacity(MaxCapacity-castVolume);
        warehouse.setCastAmount(warehouse.getCastAmount() + castAm);
        return true;
    }

    static public boolean calculateWarehouseCapacity(Material material, Warehouse warehouse){
        int MaxCapacity = warehouse.getCapacity();
        System.out.println( "pojem " + MaxCapacity);
        int materialAm = material.getAmount();
        System.out.println( "ilosc " + materialAm);
        int materialSe = material.getSize();
        System.out.println( "waga " + materialSe);
        int materialVolume = materialAm * materialSe;
        if(MaxCapacity < materialVolume)
            return false;
        warehouse.setCapacity(MaxCapacity-materialVolume);
        warehouse.setMaterials(warehouse.getMaterials() + materialAm);
        return true;
    }

}