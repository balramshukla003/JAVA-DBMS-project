import java.sql.*;
class LINK {
    void Connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/balramshukla";
            String username = "root"; // MySQL credentials
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");

            java.sql.Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            System.out.println("Connection Established successfully");

            ResultSet rs=st.executeQuery("select * from data");

            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));
            con.close();
            System.out.println("Connection Closed");
        }catch (Exception e){
            System.out.println("Error "+e);
        }
    }
}
