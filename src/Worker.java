public class Worker {
    private int idWorker;
    private int section;
    static public Project[] project = new Project[100];
    static public Cast[] cast = new Cast[100];
    static public Warehouse[] warehouseXD = new Warehouse[100];
    static public Form[] form = new Form[100];
    static public Warehouse[] warehouse = new Warehouse[100];
    int numberOfWarehouse = 1; //jak się usunie z maina to co jest dane z bomby to 1 zmienic na 0
    public Worker(){}
    public Worker(int idWorker, int section){
        this.setIdWorker(idWorker);
        this.setSection(section);
    }


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

    static public boolean calculateWarehouseCapacity(Cast cast, Warehouse warehouse){

        int MaxCapacity = warehouse.getCapacity();
        int castAm = cast.getAmount();
        int castSe = getCastSize(cast);
        int castVolume = castAm * castSe;
        if(MaxCapacity < castVolume){
            System.out.println("Nie udało się dodać odlewu, brak miejsca w magazynie!\n");
            return false;
        }

        warehouse.setCapacity(MaxCapacity-castVolume);
        warehouse.setCastAmount(warehouse.getCastAmount() + castAm);
        return true;
    }

    static public boolean calculateWarehouseCapacityM(Material material, Warehouse warehouse){
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

   /* static public boolean calculateWarehouseCapacityT(Cast cast, Transport transport){
        int MaxCapacity = transport.getCapacity();
        int MaxWeight = transport.getAvailableweight();
        int castAm = cast.getAmount();
        int castSe = getCastSize(cast);

        int materialVolume = castAm * castSe;

        if ()

        warehouse.setCapacity(MaxCapacity-materialVolume);
        warehouse.setCastAmount(warehouse.getCastAmount() - castAm);
        return true;
    }*/

    public static int getCastSize(Cast cast){
        for (int i = 0; i < project.length;i++){
            if(project[i].getIdProject() == cast.getIdProj())
                return project[i].getSize();
        }
        return -1;
    }

    public static int getCastWeight(Cast cast){
        for (int i = 0; i < project.length;i++){
            if(project[i].getIdProject() == cast.getIdProj())
                return project[i].getWeight();
        }
        return -1;
    }
}