import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class DBHandling {
    private Connection connection;
    private Statement statement;

    static ArrayList<String> departments = new ArrayList<>();
    static ArrayList<String> specialities = new ArrayList<>();
    static ArrayList<String> disciplines = new ArrayList<>();

    static ArrayList<Discipline> BDDisciplines = new ArrayList<>();
    static ArrayList<Speciality> BDSpecialities = new ArrayList<>();
    static ArrayList<Department> BDDepartments = new ArrayList<>();


    public DBHandling() {
//        selectSpeciality();
//        selectDepartment();
//        selectDiscipline();
    }

    public ArrayList<String> getDepartments() {
        return departments;
    }

    public ArrayList<String> getSpecialities() {
        return specialities;
    }

    public ArrayList<String> getDisciplines() {
        return disciplines;
    }

    public void selectMinMaxDis() {
        if (open()) {
            try {
                statement = connection.createStatement();
                String query = "SELECT NAME_ARTIC FROM SCL_ARTC WHERE ID_SLAD=1" ;
                ResultSet rs = statement.executeQuery(query);
//                ArrayList<Integer> arr = new ArrayList<>();
//
                while (rs.next()) {
//                       arr.add(rs.getInt("lexHours") + rs.getInt("labHours") + rs.getInt("pracHours"));

                    System.out.println(rs.getInt("side_number"));
                }
//                Collections.sort(arr);
//                String strMin  = " " + arr.get(0);
//                String strMax  = " " + arr.get(arr.size()-1);
//
//                Main.area.setText("Минимальное кол-во: " + strMin +"\n"
//                + "Максимальное кол-во: " + strMax);
                rs.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectDepartmentDis() {
        if (open()) {
            try {
                statement = connection.createStatement();
                String query = "SELECT speciality FROM department";
                ResultSet rs = statement.executeQuery(query);
                ArrayList<String> arr = new ArrayList<>();

                while (rs.next()) {

                    arr.add(rs.getString("speciality"));
                }
                String str = " ";
                for (int i = 0; i < arr.size(); i++) {
                    query = "SELECT disciplines FROM speciality where title ='" + arr.get(i) + "'";
                    rs = statement.executeQuery(query);
                    while (rs.next()) {

                        str += " " + rs.getString("disciplines");
                    }
                }

                Main.area.setText(str);
                rs.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void selectDepHours() {
        if (open()) {
            try {
                statement = connection.createStatement();
                String query = "SELECT labHours, lexHours, pracHours FROM discipline where specialities = '" + MyActionListener.selectedSpeciality + "'";
                ResultSet rs = statement.executeQuery(query);
                disciplines.clear();
                int count = 0;
                while (rs.next()) {
                    count += rs.getInt("labHours");
                    count += rs.getInt("lexHours");
                    count += rs.getInt("pracHours");

                }
                String str = "" + count;
                Main.area.setText(str);
                rs.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectВDisciplines(){
        if (open()) {
            try {
                statement = connection.createStatement();
                String query = "SELECT disciplines FROM speciality where title = '" + MyActionListener.selectedSpeciality + "'";
                ResultSet rs = statement.executeQuery(query);
                disciplines.clear();
                while (rs.next()) {
                  Main.area.setText(rs.getString("disciplines"));
                }
                rs.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public void selectLabHours(){

        if (open()) {
            try {
                statement = connection.createStatement();
                String query = "SELECT labHours FROM discipline where specialities = '" + MyActionListener.selectedSpeciality + "'";
                ResultSet rs = statement.executeQuery(query);
                disciplines.clear();
                int count = 0;
                while (rs.next()) {
                    count += rs.getInt("labHours");

                }
                String str = "" + count;
                Main.area.setText(str);
                rs.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void selectSpeciality() {
        if (open()) {
            try {
                statement = connection.createStatement();
                String query = "SELECT code, title, qualification, form, disciplines FROM speciality ";
                ResultSet rs = statement.executeQuery(query);
                specialities.clear();
                while (rs.next()) {
                    specialities.add(rs.getString("title"));
                    BDSpecialities.add(new Speciality(rs.getString("code"), rs.getString("title"), rs.getString("qualification"),
                            rs.getString("form"), rs.getString("disciplines") ));

                }
                rs.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void selectDiscipline(){
        if (open()) {
            try {
                statement = connection.createStatement();
                String query = "SELECT title, semester, specialities, lexHours, labHours, pracHours, examType FROM discipline";
                ResultSet rs = statement.executeQuery(query);
                disciplines.clear();
                while (rs.next()) {
                    disciplines.add(rs.getString("title"));
                }
                rs.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void selectDepartment(){
        if (open()) {
            try {
                statement = connection.createStatement();
                String query = "SELECT  title,  telephoneNumber, faculty, speciality FROM department";
                ResultSet rs = statement.executeQuery(query);
                departments.clear();
                while (rs.next()) {
                    departments.add(rs.getString("title"));
                }
                rs.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void insertSpeciality() {
        String query = "INSERT INTO speciality(code, title, qualification, form, disciplines)" +
                "VALUES(" + "'"+ AddWindow.strCode +"','" + AddWindow.strSpecName + "','"+  AddWindow.strQualification + "','"+
                AddWindow.strForm + "','" +  AddWindow.strDisciplines + "')";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDiscipline() {
        String query = "INSERT INTO discipline(title, semester, specialities, lexHours, labHours, pracHours, examType)" +
                "VALUES(" + "'"+  AddWindow.strDisciplineName +"','" +  AddWindow.strSemester + "','"+  AddWindow.strSpeciality + "','"+
                AddWindow.strLexHours + "','" +  AddWindow.strLabHours + "','" +  AddWindow.strPracHours + "','" +  AddWindow.strExamType +"')";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

   public void insertDepartment() {

        String query = "INSERT INTO department(title, telephoneNumber, faculty, speciality)" +
                "VALUES(" + "'"+  AddWindow.strDepartmentName +"','" +  AddWindow.strPhoneNuber + "','" +  AddWindow.strFaculty + "','"
                +  AddWindow.strSpecName+ "')";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean open() {
        try {
            System.out.println("Pre__Pre__Gut!!!!");
            Class.forName("net.sourceforge.jtds.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Pre__Gut!!!!");
         //   Class.forName("com.mysql.cj.jdbc.Driver");
         //   connection = DriverManager.getConnection("jdbc:sqlite:C:\\Sqlite\\instituteManagment.db");
         //   Connection
            connection = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.18.200:1433;databaseName=Paint_Ua", "sa", "xthyfz_htxrf");
            System.out.println("Gut!!!!");
            try {
                statement = connection.createStatement();
               // String query = "SELECT NAME_ARTIC FROM SCL_ARTC" ;
                String query = "SELECT SCL_ARTC.NGROUP_TVR, SCL_ARTC.NAME_ARTIC, SCL_ARTC.ID_SCLAD " +
                                "FROM SCL_ARTC " +
                                "WHERE SCL_ARTC.ID_SCLAD=1 AND SCL_ARTC.NGROUP_TVR='Без названия' ";
                ResultSet rs = statement.executeQuery(query);

//                ArrayList<Integer> arr = new ArrayList<>();
//
                while (rs.next()) {
//                       arr.add(rs.getInt("lexHours") + rs.getInt("labHours") + rs.getInt("pracHours"));

            //        System.out.println(rs.getString("SCL_ARTC"));
                    System.out.println(rs.getString(1)+"  "+rs.getString("NAME_ARTIC")+"  "+Integer.parseInt(rs.getString(3)));
            //        System.out.println(rs);
                }

                String query2 = "SELECT SCL_ARTC.COD_ARTIC, SCL_ARTC.NGROUP_TVR, SCL_ARTC.NAME_ARTIC, SCL_ARTC.ID_SCLAD, SCL_PRIC.NAME_PRICE, SCL_PRIC.RUB_PRICE " +
                                "FROM SCL_ARTC " +
                                "LEFT JOIN SCL_PRIC ON SCL_ARTC.ID_SCLAD = SCL_PRIC.ID_SCLAD AND SCL_ARTC.COD_ARTIC = SCL_PRIC.COD_ARTIC "+
                                 "WHERE SCL_ARTC.ID_SCLAD=1 AND SCL_ARTC.NGROUP_TVR='Без названия' ";
                rs = statement.executeQuery(query2);

//                ArrayList<Integer> arr = new ArrayList<>();
//
                while (rs.next()) {
//                       arr.add(rs.getInt("lexHours") + rs.getInt("labHours") + rs.getInt("pracHours"));

                    //        System.out.println(rs.getString("SCL_ARTC"));
                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString("NAME_ARTIC")+"  "+Integer.parseInt(rs.getString(4))+"  "+rs.getString(5)+"  "+rs.getString(6));
                    //        System.out.println(rs);
                }
//                Collections.sort(arr);
//                String strMin  = " " + arr.get(0);
//                String strMax  = " " + arr.get(arr.size()-1);
//
//                Main.area.setText("Минимальное кол-во: " + strMin +"\n"
//                + "Максимальное кол-во: " + strMax);
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

    public void controlQuantity() {
        if (open()) {
            try {
                statement = connection.createStatement();
                String query = "SELECT  speciality FROM department";
                ResultSet rs = statement.executeQuery(query);
                ArrayList<String> specialities = new ArrayList<>();
                while (rs.next()) {
                   specialities.add(rs.getString("speciality"));
                }

                String str = "";
                for(int i = 0; i < specialities.size(); i++) {
                    query = "SELECT  disciplines FROM speciality where title = '" + specialities.get(i) + "'";
                    rs = statement.executeQuery(query);
                    str += " " + rs.getString("disciplines") + "\n";
                }

                Main.area.setText(str);

                rs.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
