package br.edu.eteczl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

    //https://docs.microsoft.com/pt-br/sql/connect/jdbc/using-the-jdbc-driver
    //private static String connectionDriverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";

    //private static String connectionDriverClass="com.microsoft.jdbc.sqlserver.SQLServerDriver"; //classnotfoundEx      
    //private static String connectionUrl="jdbc:sqlserver://172.17.0.2:1433;databaseName=lojainfo";
    //private static String connectionUrl="jdbc:jtds:172.17.0.2:1433;databaseName=lojainfo;integratedSecurity=true";   

    //private static String connectionUsername="sa";
    //private static String connectionPassword="Aluno#123";


    //private static String connectionDriverClass="org.gjt.mm.mysql.Driver";
    //private static String connectionDriverClass="com.mysql.jdbc.Driver";
    //private static String connectionUrl="jdbc:mysql://192.168.33.151:3306/lojainfo";
    //private static String connectionUsername="root";
    //private static String connectionPassword="admin123";

    private static Connection conn;
    private static String connectionDriverClass = "org.postgresql.Driver";
    private static String connectionString = "jdbc:postgresql://127.0.0.1:5432/lpcg";
    private static String connectionUserName="postgres";
    private static String connectionPassword="sessp*ipgg";
    
    public static Connection getConnection() throws Exception{
        if(JdbcUtil.conn != null) {
            return JdbcUtil.conn;
        }else {
            try{
                Class.forName(connectionDriverClass);
                JdbcUtil.conn = DriverManager.getConnection(
                                                            JdbcUtil.connectionUrl,
                                                            JdbcUtil.connectionUserName,
                                                            JDBCUtil.connectionPassword);
                return JdbcUtil.conn;
            }catch(Execption e){
                System.out.println("Vc colocou o driver nas dependencias do maven?")
                e.printStackTrace();
            }
        }
    }
}
    
