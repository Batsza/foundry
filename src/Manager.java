import java.sql.*;
import java.util.Scanner;

public class Manager extends Worker {

    public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    public static String username = "c##student";
    public static String password = "student";
    int numberOfWorker = 0;
    Worker[] worker = new Worker[100];

    Scanner scan = new Scanner(System.in);

    protected void addWorker() throws ClassNotFoundException, SQLException {
        if(numberOfWorker == 0){
            for(int i = numberOfWorker; i < worker.length; i++) {
                worker[i] = new Worker();
            }
        }

        System.out.print("Podaj id pracownika: ");
        Integer a = scan.nextInt();
        worker[numberOfWorker].setIdWorker(a);
        System.out.print("Podaj sekcje pracownika: ");
        Integer b = scan.nextInt();
        worker[numberOfWorker].setSection(b);
        if(numberOfWorker == 0){
            for(int i = numberOfWorker; i < worker.length; i++) {
                worker[i] = new Worker();
            }
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "INSERT INTO worker (idworker, section) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);


        stmt.setInt(1, worker[numberOfWorker].getIdWorker());
        stmt.setInt(2, worker[numberOfWorker].getSection());
        stmt.executeUpdate();
        //System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4));

        conn.close();
        loadWorker();
        numberOfWorker++;
    }

    public void showWorkersList(){
        System.out.println("Lista pracowników: ");
        for(int i = 1; i < numberOfWorker+1; i++) {
            if(worker[i-1].getIdWorker() != 0) {
                worker[i - 1].workerList();
            }
        }
    }

    protected void deleteWorker() throws ClassNotFoundException, SQLException {
        System.out.print("Podaj id pracownika: ");
        Integer c = scan.nextInt();
        for(int i = 0; i < numberOfWorker; i++) {
            if(worker[i].getIdWorker() == c){
                worker[i] = new Worker();
                System.out.println("Pracownik o id: " + c + " został usunięty");
            }
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM worker where idworker = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, c);
        stmt.executeUpdate();
        //System.out.println(rs.getInt(1)+"  "+rs.getInt(2));

        conn.close();
        loadWorker();
        repairArrayObject();
        showWorkersList();
    }

    void repairArrayObject(){
        for(int i = 0; i < numberOfWorker; i++) {
            if(worker[i].getIdWorker() == 0){
                if((i+1) < numberOfWorker){
                    for(int j = i; j < numberOfWorker; j++){
                        worker[j].setIdWorker(worker[j+1].getIdWorker());
                        worker[j].setSection(worker[j+1].getSection());
                    }
                }
            }
        }
    }

    public void loadWorker() throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "c##student";
        String password = "student";
        if(numberOfWorker == 0){
            for(int i = numberOfWorker; i < worker.length; i++) {
                worker[i] = new Worker();
            }
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from worker");

        while(rs.next()){
            worker[numberOfWorker].setIdWorker(rs.getInt(1));
            worker[numberOfWorker].setSection(rs.getInt(2));
            numberOfWorker++;
        }

        //System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4));
        conn.close();
    }
}
