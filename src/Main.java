import java.sql.*;

class Main {

    public static void main(String args[]) throws SQLException{
        Connection dbConnection =null;
        try {
           dbConnection = DBConnection.getInstance().getConnection();
            PreparedStatement statement = dbConnection.prepareStatement("select * from employee");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if(dbConnection!=null)
                dbConnection.close();
        }



    }
}