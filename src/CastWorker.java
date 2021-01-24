import java.sql.*;
import java.util.Scanner;

public class CastWorker extends Worker {
    int numberOfProject = 0;
    int numberOfCast = 0;
    int numberOfForm = 0;
    public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    public static String username = "c##student";
    public static String password = "student";

    Scanner scan = new Scanner(System.in);

    public void  addNewCasting(int id, int amount, String quality, String state, int idproj, int idwarehouse) throws ClassNotFoundException, SQLException {
        Warehouse warehouseT = new Warehouse();
        if(numberOfCast == 0){
        for(int i = numberOfCast; i < cast.length; i++) {
            cast[i] = new Cast();
        }
    }
    Scanner scan = new Scanner(System.in);

        cast[numberOfCast].setIdCast(id);

        cast[numberOfCast].setAmount(amount);

        cast[numberOfCast].setQuality(quality);

        cast[numberOfCast].setStatus(state);

        cast[numberOfCast].setIdProject(idproj);

        for(int i = 0; i < numberOfProject; i++) {
             if(project[i].getIdProject() == idproj){
                 cast[numberOfCast].setIdMaterial(project[i].getIdMaterial());
             };
        }

        cast[numberOfCast].setIdWarehouse(idwarehouse);

        for (int i = 0; i < warehouse.length; i++){

            if(warehouse[i].getIdWarehouse()== idwarehouse && warehouse[i]!=null ){
                warehouseT = warehouse[i];
                break;
            }

        }

        if(!calculateWarehouseCapacity(cast[numberOfCast],warehouseT)) {
            System.out.print("zamala pojemnosc");
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "INSERT INTO cast" + " VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);


        stmt.setInt(1, cast[numberOfCast].getIdCast());
        stmt.setInt(2, cast[numberOfCast].getAmount());
        stmt.setString(3, cast[numberOfCast].getQuality());
        stmt.setString(4, cast[numberOfCast].getStatus());
        stmt.setInt(5, cast[numberOfCast].getIdProject());
        stmt.setInt(6, cast[numberOfCast].getIdWarehouse());

        stmt.executeUpdate();
        conn.close();
        numberOfCast++;
    }

    protected void deleteCast(int id) throws ClassNotFoundException, SQLException {

        for(int i = 0; i < numberOfCast; i++) {
            if(cast[i].getIdCast() == id){
                cast[i] = new Cast();

            }
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM cast where idcast = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);
        stmt.executeUpdate();

        conn.close();
        numberOfCast--;
        repairArrayObjectCast();
    }

    void repairArrayObjectCast(){
        for(int i = 0; i < numberOfCast; i++) {
            if(cast[i].getIdCast() == 0){
                if((i+1) < numberOfCast){
                    for(int j = i; j < numberOfCast; j++){
                        cast[j].setIdCast(cast[j+1].getIdCast());
                        cast[j].setAmount(cast[j+1].getAmount());
                        cast[j].setQuality(cast[j+1].getQuality());
                        cast[j].setStatus(cast[j+1].getStatus());
                        cast[j].setIdProject(cast[j+1].getIdProject());
                        cast[j].setIdWarehouse(cast[j+1].getIdWarehouse());
                    }
                }
            }
        }
    }

    public String showCastList(){
        String text ="Lista odlewów: \n";
        for(int i = 1; i < numberOfCast+1; i++) {
            if(cast[i-1].getIdCast() > 0) {
                text += cast[i - 1].castList();
            }
        }
        return text;
    }

    public void loadCast() throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "c##student";
        String password = "student";
        if(numberOfCast == 0){
            for(int i = numberOfCast; i < cast.length; i++) {
                cast[i] = new Cast();
            }
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from CAST");
        numberOfCast=0;
        while(rs.next()){
            cast[numberOfCast].setIdCast(rs.getInt(1));
            cast[numberOfCast].setAmount(rs.getInt(2));
            cast[numberOfCast].setQuality(rs.getString(3));
            cast[numberOfCast].setStatus(rs.getString(4));
            cast[numberOfCast].setIdProject(rs.getInt(5));
            cast[numberOfCast].setIdWarehouse(rs.getInt(6));
            numberOfCast++;
        }

        conn.close();
    }

    public void addNewProject(int id, int weight, int size, String desPrj, String desForm, int idmaterial) throws ClassNotFoundException, SQLException {
        if(numberOfProject == 0){
            for(int i = numberOfProject; i < project.length; i++) {
                project[i] = new Project();
            }
        }

        project[numberOfProject].setIdProject(id);

        project[numberOfProject].setWeight(weight);

        project[numberOfProject].setSize(size);


        project[numberOfProject].setProjectDetails(desPrj);

        project[numberOfProject].setFormDetails(desForm);

        project[numberOfProject].setIdMaterial(idmaterial);

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "INSERT INTO project" + " VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, project[numberOfProject].getIdProject());
        stmt.setInt(2, project[numberOfProject].getWeight());
        stmt.setInt(3, project[numberOfProject].getSize());
        stmt.setString(4, project[numberOfProject].getProjectDetails());
        stmt.setString(5, project[numberOfProject].getFormDetails());
        stmt.setInt(6, project[numberOfProject].getIdMaterial());

        stmt.executeUpdate();
        conn.close();
        numberOfProject++;
    }

    protected void deleteProject(int id) throws ClassNotFoundException, SQLException {

        for(int i = 0; i < numberOfProject; i++) {
            if(project[i].getIdProject() == id){
                project[i] = new Project();

            }
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM project where idproject = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);
        stmt.executeUpdate();

        conn.close();
        numberOfCast--;
        repairArrayObjectProject();
    }

    void repairArrayObjectProject(){
        for(int i = 0; i < numberOfProject; i++) {
            if(project[i].getIdProject() == 0){
                if((i+1) < numberOfProject){
                    for(int j = i; j < numberOfProject; j++){
                        project[j].setIdProject(project[j+1].getIdProject());
                        project[j].setWeight(project[j+1].getWeight());
                        project[j].setSize(project[j+1].getSize());
                        project[j].setProjectDetails(project[j+1].getProjectDetails());
                        project[j].setFormDetails(project[j+1].getFormDetails());
                        project[j].setIdMaterial(project[j+1].getIdMaterial());
                    }
                }
            }
        }
    }

    public String showProjectList(){

        String text ="Lista projektów: \n";
        for(int i = 1; i < numberOfProject+1; i++) {
            if(project[i-1].getIdProject() > 0) {
                text += project[i - 1].projectList();
            }
        }
        return text;
    }

    public void loadProject() throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "c##student";
        String password = "student";
        if(numberOfProject == 0){
            for(int i = numberOfProject; i < project.length; i++) {
                project[i] = new Project();
            }
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from project");
        numberOfProject=0;
        while(rs.next()){
            project[numberOfProject].setIdProject(rs.getInt(1));
            project[numberOfProject].setWeight(rs.getInt(2));
            project[numberOfProject].setSize(rs.getInt(3));
            project[numberOfProject].setProjectDetails(rs.getString(4));
            project[numberOfProject].setFormDetails(rs.getString(5));
            project[numberOfProject].setIdMaterial(rs.getInt(6));
            numberOfProject++;
        }

        conn.close();
    }

    public void addNewForm(int id, String type, int multiuse, int idproj ) throws ClassNotFoundException, SQLException {
        if(numberOfForm == 0){
            for(int i = numberOfForm; i < form.length; i++) {
                form[i] = new Form();
            }
        }

        form[numberOfForm].setIdForm(id);

        form[numberOfForm].setType(type);

        form[numberOfForm].setMultiUse(multiuse);

        form[numberOfForm].setIdProject(idproj);

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "INSERT INTO form" + " VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, form[numberOfForm].getIdForm());
        stmt.setString(2, form[numberOfForm].getType());
        stmt.setInt(3, form[numberOfForm].getMultiUse());
        stmt.setInt(4, form[numberOfForm].getIdProject());

        stmt.executeUpdate();
        conn.close();
        numberOfForm++;
    }

    protected void deleteForm(int id) throws ClassNotFoundException, SQLException {

        for(int i = 0; i < numberOfForm; i++) {
            if(form[i].getIdForm() == id){
                form[i] = new Form();

            }
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM form where idform = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);
        stmt.executeUpdate();

        conn.close();
        numberOfForm--;
        repairArrayObjectForm();
    }

    void repairArrayObjectForm(){
        for(int i = 0; i < numberOfForm; i++) {
            if(form[i].getIdForm() == 0){
                if((i+1) < numberOfForm){
                    for(int j = i; j < numberOfForm; j++){
                        form[j].setIdForm(form[j+1].getIdForm());
                        form[j].setType(form[j+1].getType());
                        form[j].setMultiUse(form[j+1].getMultiUse());
                        form[j].setIdProject(form[j+1].getIdProject());
                    }
                }
            }
        }
    }

    public String showFormList(){

        String text =("Lista projektów: \n");
        for(int i = 1; i < numberOfForm+1; i++) {
            if(form[i-1].getIdForm() > 0) {
                text+= form[i - 1].formList();
            }
        }
        return text;
    }

    public void loadForm() throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "c##student";
        String password = "student";
        if(numberOfForm == 0){
            for(int i = numberOfForm; i < form.length; i++) {
                form[i] = new Form();
            }
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from form");
        numberOfForm=0;
        while(rs.next()){
            form[numberOfForm].setIdForm(rs.getInt(1));
            form[numberOfForm].setType(rs.getString(2));
            form[numberOfForm].setMultiUse(rs.getInt(3));
            form[numberOfForm].setIdProject(rs.getInt(4));

            numberOfForm++;
        }

        conn.close();
    }

    public boolean addprojectLock(int int1) {
        for(int i = 0; i < numberOfProject; i++){
            if(int1 == project[i].getIdMaterial()){
                return false;
            }
        }
        return true;
    }

    public boolean subprojectLock(int int1) {
        for(int i = 0; i < numberOfProject; i++){
            if(int1 == project[i].getIdMaterial()){
                return true;
            }
        }
        return false;
    }

    public boolean addformLock(int int1) {
        for(int i = 0; i < numberOfForm; i++){
            if(int1 == form[i].getIdForm()){
                return false;
            }
        }
        return true;
    }

    public boolean subformLock(int int1) {
        for(int i = 0; i < numberOfForm; i++){
            if(int1 == form[i].getIdForm()){
                return true;
            }
        }
        return false;
    }

    public boolean addcastLock(int int1) {
        for(int i = 0; i < numberOfCast; i++){
            if(int1 == cast[i].getIdCast()){
                return false;
            }
        }
        return true;
    }

    public boolean subcastLock(int int1) {
        for(int i = 0; i < numberOfCast; i++){
            if(int1 == cast[i].getIdCast()){
                return true;
            }
        }
        return false;
    }
}

