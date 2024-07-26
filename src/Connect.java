import java.sql.*;
import java.util.Scanner;

public class Connect {
    /**
     * Connect to a sample database 
     */
    public static void Insert() {
        Connection conn = null;
        Scanner sc = new Scanner(System.in);
        try {

            String s1 = "bacon";
            String s2 = "CD";
            int s3 = 0;
            String s4 = "bacon" + 0 + 1;



            String url = "jdbc:sqlite:C:/sqlite/db/Demo.db";

            System.out.println("What is your email? ( this will be used to create emails in the future )");
            s1 = sc.nextLine();




//            String check = "INSERT INTO CD (Names, ID) VALUES (\"bacon\" , 10)";
//            System.out.println(check);
            String query = "INSERT INTO CD (Names, TableID) VALUES (" + "\"" + s1 + "\"" + "," + "\"" + s2 + "\"" + ")";

//            String check2 = "SELECT Number FROM CD ORDER BY Number DESC";
//            String query2 = "\"INSERT INTO CD (ID) VALUES";

            System.out.println(query);
            try {

                conn = DriverManager.getConnection(url);
                Statement st = conn.createStatement();
                st.executeQuery(query);

                //seems putting it under it did the trick. I don't know if it will do anything though... let me see
//                Statement st2 = conn.createStatement();
//                st2.executeQuery(check);

            } catch (SQLException e) {
                // there is an exception, but since it doesn't hurt anything right now I am leaving it
            }


            System.out.println("Connection is good");
        }
//         catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//end of Insert Method

    public static void Delete() {
        Connection conn = null;
        Scanner sc = new Scanner(System.in);
        try {

            String d1 = "bacon";
            String d2 = "CD";
            int d3 = 0;
            String s4 = "bacon" + 0 + 1;


            String url = "jdbc:sqlite:C:/sqlite/db/Demo.db";

            System.out.println("What would you like to delete? ( this will be used to delete users in the future )");
            d1 = sc.nextLine();




//            String check = "INSERT INTO CD (Names, ID) VALUES (\"bacon\" , 10)";
//            System.out.println(check);
            String query = "DELETE FROM CD WHERE Names = " +"\"" + d1 + "\"";

//            String check2 = "SELECT Number FROM CD ORDER BY Number DESC";
//            String query2 = "\"INSERT INTO CD (ID) VALUES";

            System.out.println(query);
            try {

                conn = DriverManager.getConnection(url);
                Statement st = conn.createStatement();
                st.executeQuery(query);

                //seems putting it under it did the trick. I don't know if it will do anything though... let me see
//                Statement st2 = conn.createStatement();
//                st2.executeQuery(check);

            } catch (SQLException e) {
                // there is an exception, but since it doesn't hurt anything right now I am leaving it
            }


            System.out.println("Connection is good");
        }
//         catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }// end Delete

    public static void Access() {
        Connection conn = null;
        Scanner sc = new Scanner(System.in);
        try {

            String a1 = "bacon";
            String a2 = "CD";
            int a3 = 0;
            String s4 = "bacon" + 0 + 1;



            String url = "jdbc:sqlite:C:/sqlite/db/Demo.db";

            System.out.println("Please type in your name to get your information ( this and a password set by the user will be used to get data in final version )");
            a1 = sc.nextLine();




            String query = "SELECT * FROM CD Where Names = " + "\"" +a1 + "\"";

            try (Connection con = DriverManager.getConnection(url);
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(query)) {
                int colNum = getColumnNames(rs);
                if(colNum>0){
                    while(rs.next()) {
                        for(int i =0; i<colNum; i++) {
                            if(i+1 == colNum){
                                System.out.println(rs.getString(i+1));}
                            else
                                System.out.print(rs.getString(i+1)+ ", ");
                            //endif
                        }//endfor
                    }//endwhile
                }//end if
            } catch (SQLException e) {
                System.out.println(e);
            }//end try catch
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//end Access

    public static int getColumnNames(ResultSet rs) throws SQLException {
        int numberOfColumns = 0;
        if (rs != null) {
            //create an object based on the Metadata of the result set
            ResultSetMetaData rsMetaData = rs.getMetaData();
            //Use the getColumn method to get the number of columns returned
            numberOfColumns = rsMetaData.getColumnCount();
            //get and print the column names, column indexes start from 1
            for (int i = 1; i < numberOfColumns + 1; i++) {
                String columnName = rsMetaData.getColumnName(i);
                System.out.print(columnName + ", ");
            }//endfor
        }//endif
        //place the cursor on a new line in the console
        System.out.println();
        return numberOfColumns;
    }//end method getColumnNames

    public static void Names() {

        String url = "jdbc:sqlite:C:/sqlite/db/Demo.db";

        try {

            String query = "SELECT * FROM CD";
            try (Connection con = DriverManager.getConnection(url);
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(query)) {
                int colNum = getColumnNames(rs);
                if(colNum>0){
                    while(rs.next()) {
                        for(int i =0; i<colNum; i++) {
                            if(i+1 == colNum){
                                Create.g1.add(rs.getString(i + 1));
                                System.out.println(rs.getString(i+1));}
                            else
                                System.out.print(rs.getString(i+1)+ ", ");
                            //endif
                        }//endfor
                    }//endwhile
                }//end if
            } catch (SQLException e) {
                System.out.println(e);
            }//end try catch
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//end Names

    public static void setIdInt(){

        Connection conn = null;
        Scanner sc = new Scanner(System.in);
        try {

            String s1 = "bacon";
            String s2 = "CD";
            int s3 = 0;
            String s4 = "bacon" + 0 + 1;



            String url = "jdbc:sqlite:C:/sqlite/db/Demo.db";

            System.out.println("Say email to pull int");
            s1 = sc.nextLine();


            String query = "SELECT * FROM CD WHERE Names = " + "\"" + s1 + "\"";
            // make sure to keep it as all, can get individual values later


            try {
                conn = DriverManager.getConnection(url);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                int getId = rs.getInt("Number"); //yes!!! I DID IT!!! It needs to be the same value as the column I am pulling it from
                String getName = rs.getString("Names");
                String getTableId = rs.getString("TableID");
                System.out.println("Name is " + getName);
                System.out.println("Id is " + getId);
                System.out.println("Table ID is " + getTableId );


            } catch (SQLException e) {
                System.out.println("Sql Exception ( Usually, because nothing is there )");
            }


            System.out.println("Connection is good");
        }

        finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }



    }


}
