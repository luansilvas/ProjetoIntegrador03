package br.senac.sp.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luans
 */
public class ConexaoDB {

    public static String STATUS = "Não conectado";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static String SERVER = "localhost";
    public static String DATABASE = "tades";

    public static String LOGIN = "root";
    public static String SENHA = "";

    public static String URL = "";

    public static Connection CONEXAO;

    /**
     * @return CONEXAO do tipo tipo Connection, isto é, permite que seja aberta
     * a conexão para fazer o CRUD no banco
     * @throws ClassNotFoundException trata os erros de conexão com o banco,
     * caso não exista a base de dados ou ele não esteja ativo, por exemplo
     * @throws SQLException no trata de erros no banco
     */
    public static Connection abrirConexao() throws ClassNotFoundException, SQLException {

        URL = "jdbc:mysql://" + SERVER + ":3306/" + DATABASE + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

        if (CONEXAO == null) {
            try {

                Class.forName(DRIVER);
                CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);

                if (CONEXAO != null) {
                    STATUS = "Conexão realizada com sucesso!";
                } else {
                    STATUS = "Não foi possivel realizar a conexão";
                }

            } catch (ClassNotFoundException e) {

                throw new ClassNotFoundException("O driver expecificado nao foi encontrado.");

            } catch (SQLException e) {

                throw new SQLException("Erro ao estabelecer a conexão! Verifique as informações e tente novamentes.");
            }

        } else {
            try {

                if (CONEXAO.isClosed()) {
                    CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);
                }
            } catch (SQLException ex) {
                throw new SQLException("Falha ao fechar a conexão.");
            }
        }
        return CONEXAO;
    }

    /**
     * @return String descrevendo coomo está a situação do banco
     */
    public static String getStatusConexao() {
        return STATUS;
    }

    /**
     * @return boolean true: A conexão foi fechada e ele não realizará mais
     * atividaes até que reaberto; false: houve algum erro que impede o banco de
     * fechar a conexão
     * @throws SQLException caso acontece algum erro ao fechar a conexão
     */
    public static boolean fecharConexao() throws SQLException {

        boolean retorno = false;

        try {
            if (CONEXAO != null) {
                if (!CONEXAO.isClosed()) {
                    CONEXAO.close();
                }
            }

            STATUS = "Não conectado";
            retorno = true;

        } catch (SQLException e) {
            retorno = false;
        }

        return retorno;
    }

}

/*
        // Bloco executado uma única vez quando o servidor é inicializado
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDB.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

    public static Connection getConexao()
            throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/tades?useTimezone=true&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }*/
