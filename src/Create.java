import java.sql.*;
import java.util.ArrayList;

public class Create {
    static ArrayList g1 = new ArrayList();
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
                                g1.add(rs.getString(i + 1));
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


}
