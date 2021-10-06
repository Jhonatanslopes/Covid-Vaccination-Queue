package vacinarMe;


import java.sql.Connection;
import java.sql.DriverManager;


public class ConexaoBD {
    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "db_vacina";
    private static String usuario = "root";
    private static String senha = "SENHA";
    
    public static Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://"+host+":"+porta+"/"+db+
                           "?user="+usuario+"&password="+senha+"&useTimezone=true&serverTimezone=America/Sao_Paulo");
            return c;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
