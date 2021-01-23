import java.sql.*;
import java.util.Scanner;

public class LogisticWorker extends Worker {
    public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    public static String username = "c##student";
    public static String password = "student";
    int numberOfMaterials = 0;
    Material[] material = new Material[100];
    Scanner scan = new Scanner(System.in);

    public void  addNewWarehouse() throws ClassNotFoundException, SQLException {

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

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "INSERT INTO warehouse" + " VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, warehouse[numberOfWarehouse].getIdWarehouse());
        stmt.setInt(2, warehouse[numberOfWarehouse].getCapacity());

        stmt.executeUpdate();
        conn.close();

        numberOfWarehouse++;
    }

    protected void deleteWarehouse() throws ClassNotFoundException, SQLException {
        System.out.print("Podaj id magazynu: ");
        Integer c = scan.nextInt();
        for(int i = 0; i < numberOfWarehouse; i++) {
            if(warehouse[i].getIdWarehouse() == c){
                warehouse[i] = new Warehouse();
                System.out.println("Magazyn o id: " + c + " został usunięty");
            }
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM warehouse where idwarehouse = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, c);
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

        while(rs.next()){
            warehouse[numberOfWarehouse].setIdWarehouse(rs.getInt(1));
            warehouse[numberOfWarehouse].setCapacity(rs.getInt(2));
            numberOfWarehouse++;
        }

        conn.close();
    }

    public void  addNewMaterial() throws ClassNotFoundException, SQLException {
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
        for (int i = 0; i < warehouse.length; i++){

            if(warehouse[i].getIdWarehouse()== f && warehouse[i]!=null ){
                warehouseT = warehouse[i];
                break;
            }

        }
        if(!calculateWarehouseCapacityM(material[numberOfMaterials],warehouseT)){
            System.out.print("zamala pojemnosc");
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

    protected void deleteMaterial() throws ClassNotFoundException, SQLException {
        System.out.print("Podaj id materiału: ");
        Integer c = scan.nextInt();
        for(int i = 0; i < numberOfMaterials; i++) {
            if(material[i].getIdMaterial() == c){
                material[i] = new Material();
                System.out.println("Materiał o id: " + c + " został usunięty");
            }
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM material where idmaterial = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, c);
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
        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i].getIdWarehouse() == b && warehouse[i] != null) {
                warehouseT = warehouse[i];
                break;
            }
        }

        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i].getIdWarehouse() == castT.getIdWarehouse()) {// warehouseXD[i] ten z którego wyszukujemy
                int castVolume = getCastSize(castT) * castT.getAmount();
                warehouse[i].setCapacity(warehouse[i].getCapacity() + castVolume);
                warehouse[i].setCastAmount(warehouse[i].getCastAmount() - castT.getAmount());
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

