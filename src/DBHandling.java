import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DBHandling {
    Produckt produckt;
    HashMap<Integer,Produckt> listOfProdukt = new HashMap<>();
    private Connection connection;
    private Statement statement;
    public DBHandling() {
    }

      public boolean open() {
        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver").getDeclaredConstructor().newInstance();

          //  connection = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.18.200:1433;databaseName=Paint_Ua", "sa", "xthyfz_htxrf");
            connection = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.18.200:1433;databaseName=Paint_Ua", "buh", "buh");

            try {
                statement = connection.createStatement();
               // String query = "SELECT NAME_ARTIC FROM SCL_ARTC" ;
                String query = "SELECT SCL_ARTC.NGROUP_TVR, SCL_ARTC.NAME_ARTIC, SCL_ARTC.ID_SCLAD " +
                                "FROM SCL_ARTC " +
                                "WHERE SCL_ARTC.ID_SCLAD=1 AND SCL_ARTC.NGROUP_TVR='Без названия' ";
                ResultSet rs = statement.executeQuery(query);


                while (rs.next()) {

                    System.out.println(rs.getString(1)+"  "+rs.getString("NAME_ARTIC")+"  "+Integer.parseInt(rs.getString(3)));

                }

                String query2 = "SELECT SCL_ARTC.COD_ARTIC, SCL_ARTC.NGROUP_TVR, SCL_ARTC.NAME_ARTIC, SCL_ARTC.ID_SCLAD, SCL_PRIC.NAME_PRICE, SCL_PRIC.RUB_PRICE " +
                                "FROM SCL_ARTC " +
                                "LEFT JOIN SCL_PRIC ON SCL_ARTC.ID_SCLAD = SCL_PRIC.ID_SCLAD AND SCL_ARTC.COD_ARTIC = SCL_PRIC.COD_ARTIC "+
                                 "WHERE SCL_ARTC.ID_SCLAD=1 AND SCL_ARTC.NGROUP_TVR='Без названия' ";
                rs = statement.executeQuery(query2);

                while (rs.next()) {

                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString("NAME_ARTIC")+"  "+Integer.parseInt(rs.getString(4))+"  "+rs.getString(5)+"  "+rs.getString(6));

                }
                rs.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;

        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
