import java.sql.*;
import java.util.Scanner;

public class LogisticWorker extends Worker {
    public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    public static String username = "c##student";
    public static String password = "student";
    int numberOfMaterials = 0;
    Material[] material = new Material[100];
    Scanner scan = new Scanner(System.in);

    public void  addNewWarehouse(int id, int capacity) throws ClassNotFoundException, SQLException {

        if(numberOfWarehouse == 0){
            for(int i = numberOfWarehouse; i < warehouse.length; i++) {
                warehouse[i] = new Warehouse();
            }
        }

        warehouse[numberOfWarehouse].setIdWarehouse(id);

        warehouse[numberOfWarehouse].setCapacity(capacity);

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "INSERT INTO warehouse " + " VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, warehouse[numberOfWarehouse].getIdWarehouse());
        stmt.setInt(2, 0);
        stmt.setInt(3, 0);
        stmt.setInt(4, warehouse[numberOfWarehouse].getCapacity());

        stmt.executeUpdate();
        conn.close();

        numberOfWarehouse++;
    }

    protected void deleteWarehouse(int id) throws ClassNotFoundException, SQLException {

        for(int i = 0; i < numberOfWarehouse; i++) {
            if(warehouse[i].getIdWarehouse() == id){
                warehouse[i] = new Warehouse();
            }
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM warehouse where idwarehouse = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);
        stmt.executeUpdate();

        conn.close();
        numberOfWarehouse--;
        repairArrayObjectWarehouse();
    }

    void repairArrayObjectWarehouse(){
        for(int i = 0; i < numberOfWarehouse; i++) {
            if(warehouse[i].getIdWarehouse() == 0){
                if((i+1) < numberOfWarehouse){
                    for(int j = i; j < numberOfWarehouse; j++){
                        warehouse[j].setIdWarehouse(warehouse[j+1].getIdWarehouse());
                        warehouse[j].setCapacity(warehouse[j+1].getCapacity());
                    }
                }
            }
        }
    }

    public String showWarehouseList(){
        String text ="Magazyn: \n";
        for(int i = 1; i < numberOfWarehouse+1; i++) {
            if(warehouse[i-1].getIdWarehouse() > 0) {
                text+= warehouse[i - 1].warehouseList();
            }
        }
        return text;
    }

    public void loadWarehouse() throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "c##student";
        String password = "student";
        if(numberOfWarehouse == 0){
            for(int i = numberOfWarehouse; i < warehouse.length; i++) {
                warehouse[i] = new Warehouse();
            }
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from warehouse");
        numberOfWarehouse=0;
        while(rs.next()){
            warehouse[numberOfWarehouse].setIdWarehouse(rs.getInt(1));
            warehouse[numberOfWarehouse].setCastAmount(rs.getInt(2));
            warehouse[numberOfWarehouse].setMaterials(rs.getInt(3));
            warehouse[numberOfWarehouse].setCapacity(rs.getInt(4));

            numberOfWarehouse++;
        }

        conn.close();
    }

    public void  addNewMaterial(int id, String name, int weight, int amount, int price, int idwarehouse  ) throws ClassNotFoundException, SQLException {
        Warehouse warehouseT = new Warehouse();

        if(numberOfMaterials == 0){
            for(int i = numberOfMaterials; i < material.length; i++) {
                material[i] = new Material();
            }
        }


        material[numberOfMaterials].setIdMaterial(id);

        material[numberOfMaterials].setName(name);

        material[numberOfMaterials].setSize(weight);

        material[numberOfMaterials].setAmount(amount);

        material[numberOfMaterials].setPrice(price);

        material[numberOfMaterials].setIdWarehouse(idwarehouse);
        for (int i = 0; i < warehouse.length; i++){

            if(warehouse[i].getIdWarehouse()== idwarehouse && warehouse[i]!=null ){
                warehouseT = warehouse[i];
                break;
            }

        }
        if(!calculateWarehouseCapacityM(material[numberOfMaterials],warehouseT)){
            //System.out.print("zamala pojemnosc");
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "INSERT INTO material " + " VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);


        stmt.setInt(1, material[numberOfMaterials].getIdMaterial());
        stmt.setString(2, material[numberOfMaterials].getName());
        stmt.setInt(3, material[numberOfMaterials].getSize());
        stmt.setInt(4, material[numberOfMaterials].getAmount());
        stmt.setInt(5, material[numberOfMaterials].getPrice());
        stmt.setInt(6, material[numberOfMaterials].getIdWarehouse());

        stmt.executeUpdate();
        //System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4));

        conn.close();
        numberOfMaterials++;
    }

    protected void deleteMaterial(int id) throws ClassNotFoundException, SQLException {

        for(int i = 0; i < numberOfMaterials; i++) {
            if(material[i].getIdMaterial() == id){
                material[i] = new Material();

            }
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM material where idmkaterial = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);
        stmt.executeUpdate();
        //System.out.println(rs.getInt(1)+"  "+rs.getInt(2));

        conn.close();
        //loadMaterial();
        numberOfMaterials--;
        repairArrayObjectMaterial();
    }

    void repairArrayObjectMaterial(){
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

    public String showMaterialList(){
        String text =("Materiały: ");
        for(int i = 1; i < numberOfMaterials+1; i++) {
            if(material[i-1].getIdMaterial() > 0) {
                text += material[i-1].materialList();
            }
        }
        return text;
    }

    public void loadMaterial() throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "c##student";
        String password = "student";

        if(numberOfMaterials == 0){
            for(int i = numberOfMaterials; i < material.length; i++) {
                material[i] = new Material();
            }
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from MATERIAL");
        numberOfMaterials=0;
        while(rs.next()){
            material[numberOfMaterials].setIdMaterial(rs.getInt(1));
            material[numberOfMaterials].setName(rs.getString(2));
            material[numberOfMaterials].setSize(rs.getInt(3));
            material[numberOfMaterials].setAmount(rs.getInt(4));
            material[numberOfMaterials].setPrice(rs.getInt(5));
            material[numberOfMaterials].setIdWarehouse(rs.getInt(6));
            numberOfMaterials++;
        }

        //System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4));
        conn.close();
    }

    public void changeStorageLocation(int idcast, int idwarehouse) throws SQLException, ClassNotFoundException {
        Cast castT = new Cast();
        Warehouse warehouseT = new Warehouse();



        for (int i = 0; i < cast.length; i++) {
            if (cast[i].getIdCast() == idcast && cast[i] != null) {
                castT = cast[i];
                break;
            }
        }
        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i].getIdWarehouse() == idwarehouse && warehouse[i] != null) {
                warehouseT = warehouse[i];
                break;
            }
        }

        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i].getIdWarehouse() == castT.getIdWarehouse()) {// warehouseXD[i] ten z którego wyszukujemy
                int castVolume = getCastSize(castT) * castT.getAmount();
                warehouse[i].setCapacity(warehouse[i].getCapacity() + castVolume);
                warehouse[i].setCastAmount(warehouse[i].getCastAmount() - castT.getAmount());
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection conn = DriverManager.getConnection(url, username, password);

                String sql = "UPDATE warehouse SET castamount=?, capacity= ?  where idwarehouse = ?";

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, warehouse[i].getCastAmount());
                stmt.setInt(2, warehouse[i].getCapacity());
                stmt.setInt(3, warehouse[i].getIdWarehouse());
                stmt.executeUpdate();

                conn.close();
                  break;
            }


        }
        if (!calculateWarehouseCapacity(castT, warehouseT)) {
            System.out.print("zamala pojemnosc");
        }


        castT.setIdWarehouse(idwarehouse);

    }

    /*
    public showRequestMaterials(){

    }
    */
}

