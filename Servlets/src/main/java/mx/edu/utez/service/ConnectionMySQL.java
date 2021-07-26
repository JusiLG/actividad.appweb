package mx.edu.utez.service;

import java.sql.*;

public class ConnectionMySQL {
    public static ConnectionMySQL getConnection() throws SQLException {
        String host = "127.0.0.1";
        String port = "3306";
        String database = "mitiendita";
        String useSSL = "false";
        String timezone = "UTC";
        String user = "root";
        String password = "";
        String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=%s&serverTimezone=%s", host, port, database, useSSL, timezone);
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeConnection(Connection con, CallableStatement cstm, ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
            if(cstm != null) {
                cstm.close();
            }
            if(con != null) {
                con.close();
            }
        }
    }

    public static void closeConnection(Connection con, CallableStatement cstm) {
        try {
            if (cstm != null) {
                cstm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
