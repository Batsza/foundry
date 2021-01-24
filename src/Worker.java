import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Worker {
    public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    public static String username = "c##student";
    public static String password = "student";
    private int idWorker;
    private int section;
    static public Project[] project = new Project[100];
    static public Cast[] cast = new Cast[100];
    static public Warehouse[] warehouse = new Warehouse[100];
    static public Form[] form = new Form[100];
    int numberOfWarehouse = 0;

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

    public String workerList(){return ("Id: " + idWorker + " | sekcja: " + section + "\n");}

    static public boolean calculateWarehouseCapacity(Cast cast, Warehouse warehouse) throws ClassNotFoundException, SQLException {

        int MaxCapacity = warehouse.getCapacity();
        int castAm = cast.getAmount();
        int castSe = getCastSize(cast);
        int castVolume = castAm * castSe;
        if(MaxCapacity < castVolume){

            return false;
        }

        warehouse.setCapacity(MaxCapacity-castVolume);
        warehouse.setCastAmount(warehouse.getCastAmount() + castAm);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "UPDATE warehouse SET castamount=?, capacity= ?  where idwarehouse = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, warehouse.getCastAmount());
        stmt.setInt(2, warehouse.getCapacity());
        stmt.setInt(3, warehouse.getIdWarehouse());
        stmt.executeUpdate();

        conn.close();
        return true;
    }

    static public boolean calculateWarehouseCapacityM(Material material, Warehouse warehouse) throws SQLException, ClassNotFoundException {
        int MaxCapacity = warehouse.getCapacity();
        int materialAm = material.getAmount();
        int materialSe = material.getSize();
        int materialVolume = materialAm * materialSe;
        if(MaxCapacity < materialVolume){

            return false;
        }
        warehouse.setCapacity(MaxCapacity-materialVolume);
        warehouse.setMaterials(warehouse.getMaterials() + materialAm);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "UPDATE warehouse SET materials=?, capacity= ?  where idwarehouse = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, warehouse.getMaterials());
        stmt.setInt(2, warehouse.getCapacity());
        stmt.setInt(3, warehouse.getIdWarehouse());
        stmt.executeUpdate();

        conn.close();
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
            if(project[i].getIdProject() == cast.getIdProject())
                return project[i].getSize();
        }
        return -1;
    }

    public static int getCastWeight(Cast cast){
        for (int i = 0; i < project.length;i++){
            if(project[i].getIdProject() == cast.getIdProject())
                return project[i].getWeight();
        }
        return -1;
    }
}