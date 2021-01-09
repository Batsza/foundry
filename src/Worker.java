public class Worker {
    private int idWorker;
    private int section;
    static public Project[] proj = new Project[5];
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
        int castAm = cast.getAmount();
        int castSe = project.getSize();
        int castVolume = castAm * castSe;
        if(MaxCapacity < castVolume){
            System.out.println("Nie udało się dodać odlewu, brak miejsca w magazynie!\n");
            return false;
        }

        warehouse.setCapacity(MaxCapacity-castVolume);
        warehouse.setCastAmount(warehouse.getCastAmount() + castAm);
        return true;
    }

    static public boolean calculateWarehouseCapacity(Material material, Warehouse warehouse){
        int MaxCapacity = warehouse.getCapacity();
        int materialAm = material.getAmount();
        int materialSe = material.getSize();
        int materialVolume = materialAm * materialSe;
        if(MaxCapacity < materialVolume){
            System.out.println("Nie udało się dodać materiału, brak miejsca w magazynie!\n");
            return false;
        }
        warehouse.setCapacity(MaxCapacity-materialVolume);
        warehouse.setMaterials(warehouse.getMaterials() + materialAm);
        return true;
    }

    static public boolean calculateWarehouseCapacityT(Cast cast, Warehouse warehouse, Project project){
        int MaxCapacity = warehouse.getCapacity();
        int castAm = cast.getAmount();
        int castSe = project.getSize();
        int materialVolume = -castAm * castSe;
        warehouse.setCapacity(MaxCapacity-materialVolume);
        warehouse.setCastAmount(warehouse.getCastAmount() - castAm);
        return true;
    }

    public static int getCastSize(Cast cast){
        for (int i = 0; i < proj.length;i++){
            if(proj[i].getIdProject() == cast.getIdProj())
                return proj[i].getSize();
        }
        return -1;
    }
}