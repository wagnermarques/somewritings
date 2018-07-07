package br.com.fzlbpms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String strUrl = "jdbc:sqlserver://172.17.0.2:1433;databaseName=teste;user=sa;password=Aluno#123";
        System.out.println(DriverManager.getConnection(strUrl,"SA", "Aluno#123"));
        
    }
}
