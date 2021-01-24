import java.sql.*;


public class Manager extends Worker {

    public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    public static String username = "c##student";
    public static String password = "student";
    int numberOfWorker = 0;
    Worker[] worker = new Worker[100];



    protected void addWorker(int id, int sekcja) throws ClassNotFoundException, SQLException {
        if(numberOfWorker == 0){
            for(int i = numberOfWorker; i < worker.length; i++) {
                worker[i] = new Worker();
            }
        }


        worker[numberOfWorker].setIdWorker(id);

        worker[numberOfWorker].setSection(sekcja);
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

        conn.close();
        numberOfWorker++;
    }

    public String showWorkersList(){
        String text = "Lista pracowników: \n";
        for(int i = 1; i < numberOfWorker+1; i++) {
            if(worker[i-1].getIdWorker() > 0) {
                text += worker[i - 1].workerList();
            }
        }
        return text;
    }

    protected void deleteWorker(int id) throws ClassNotFoundException, SQLException {

        for(int i = 0; i < numberOfWorker; i++) {
            if(worker[i].getIdWorker() == id){
                worker[i] = new Worker();

            }
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM worker where idworker = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);
        stmt.executeUpdate();

        conn.close();
        repairArrayObjectWorker();
    }

    void repairArrayObjectWorker(){
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
        numberOfWorker=0;
        while(rs.next()){
            worker[numberOfWorker].setIdWorker(rs.getInt(1));
            worker[numberOfWorker].setSection(rs.getInt(2));
            numberOfWorker++;
        }

        conn.close();
    }

    public boolean addworkerLock(int int1) {
        for(int i = 0; i < numberOfWorker; i++){
            if(int1 == worker[i].getIdWorker()){
                return false;
            }
        }
        return true;
    }

    public boolean subworkerLock(int int1) {
        for(int i = 0; i < numberOfWorker; i++){
            if(int1 == worker[i].getIdWorker()){
                return true;
            }
        }
        return false;
    }
}
