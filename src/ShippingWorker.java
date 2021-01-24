import java.sql.*;


public class ShippingWorker extends Worker {
    public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    public static String username = "c##student";
    public static String password = "student";
    int numberOfTransport = 0;
    Transport[] transports = new Transport[100];


    public void orderTransport(int id, int capacity, int weight, int idcast) throws ClassNotFoundException, SQLException {
        Cast castT = new Cast();

        if(numberOfTransport == 0){
            for(int i = numberOfTransport; i < transports.length; i++) {
                transports[i] = new Transport();
            }
        }



        transports[numberOfTransport].setIdTransport(id);

        transports[numberOfTransport].setCapacity(capacity);

        transports[numberOfTransport].setAvailableWeight(weight);

        transports[numberOfTransport].setIdCast(idcast);

        for (int i = 0; i <cast.length; i++){

            if(cast[i].getIdCast()== idcast && cast[i]!=null ){
                castT = cast[i];
                break;
            }

        }

        for(int i = 0; i < warehouse.length; i++){
            if(warehouse[i].getIdWarehouse() == castT.getIdWarehouse()) {
                int castVolume = getCastSize(castT) * castT.getAmount();
                int castWeight = getCastWeight(castT) * castT.getAmount();
                if (castVolume <= transports[numberOfTransport].getCapacity()&& castWeight <= transports[numberOfTransport].getCapacity()){
                    warehouse[i].setCapacity(warehouse[i].getCapacity() + castVolume);
                    warehouse[i].setCastAmount(warehouse[i].getCastAmount() - castT.getAmount());
                    castT.setStatus("Wysłano");
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn = DriverManager.getConnection(url, username, password);

                    String sql = "UPDATE warehouse SET castamount=?, capacity= ?  where idwarehouse = ?";

                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, warehouse[i].getCastAmount());
                    stmt.setInt(2, warehouse[i].getCapacity());
                    stmt.setInt(3, warehouse[i].getIdWarehouse());
                    stmt.executeUpdate();

                    String sql2 = "UPDATE cast SET status=?  where idcast = ?";
                    PreparedStatement stmt2 = conn.prepareStatement(sql2);
                    stmt2.setString(1, castT.getStatus());
                    stmt2.setInt(2, castT.getIdCast());
                    stmt2.executeUpdate();

                    conn.close();
                    for (int j = 0; j < cast.length; j++){
                        if(cast[j].getIdCast()== idcast ){
                            cast[j] = castT;
                        }

                    }
                    transports[numberOfTransport].setStatus(true);
                }
                else {
                    transports[numberOfTransport].setStatus(false);
                }
                    break;
            }

        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "INSERT INTO transport" + " VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, transports[numberOfTransport].getIdTransport());
        stmt.setInt(2, transports[numberOfTransport].getCapacity());
        stmt.setInt(3, transports[numberOfTransport].getAvailableWeight());
        stmt.setInt(4, transports[numberOfTransport].getIdCast());


        stmt.executeUpdate();
        conn.close();

        numberOfTransport++;
        //if(calculateWarehouseCapacityT(castT,)){}
    }

    /*protected void deleteTransport() throws ClassNotFoundException, SQLException {
        System.out.print("Podaj id transportu: ");
        Integer c = scan.nextInt();
        for(int i = 0; i < numberOfTransport; i++) {
            if(transports[i].getIdTransport() == c){
                transports[i] = new Transport();
                System.out.println("Transport o id: " + c + " został usunięty");
            }
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM transport where idtransport = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, c);
        stmt.executeUpdate();

        conn.close();
        numberOfTransport--;
        repairArrayObjectWarehouse();
    }

    void repairArrayObjectWarehouse(){
        for(int i = 0; i < numberOfTransport; i++) {
            if(transports[i].getIdTransport() == 0){
                if((i+1) < numberOfTransport){
                    for(int j = i; j < numberOfTransport; j++){
                        transports[j].setIdTransport(transports[j+1].getIdTransport());
                        transports[j].setCapacity(transports[j+1].getCapacity());
                        transports[j].setAvailableWeight(transports[j+1].getAvailableWeight());
                        transports[j].setIdCast(transports[j+1].getIdCast());
                    }
                }
            }
        }
    }*/

    public String showTransportList(){

        String text ="Transport: \n";
        for(int i = 1; i < numberOfTransport+1; i++) {
            text += transports[i-1].transportList();
        }
        return text;
    }

    public void loadTransport() throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "c##student";
        String password = "student";
        if(numberOfTransport == 0){
            for(int i = numberOfTransport; i < transports.length; i++) {
                transports[i] = new Transport();
            }
        }

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from transport");
        numberOfTransport=0;
        while(rs.next()){
            transports[numberOfTransport].setIdTransport(rs.getInt(1));
            transports[numberOfTransport].setCapacity(rs.getInt(2));
            transports[numberOfTransport].setAvailableWeight(rs.getInt(3));
            transports[numberOfTransport].setIdCast(rs.getInt(4));
            numberOfTransport++;
        }

        conn.close();
    }
/*
    public showRequestTransport(){

    }*/
}

