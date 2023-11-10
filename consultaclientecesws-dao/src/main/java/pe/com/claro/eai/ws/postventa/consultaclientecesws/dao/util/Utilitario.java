package pe.com.claro.eai.ws.postventa.consultaclientecesws.dao.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public final class Utilitario {

    private static final Logger log = Logger.getLogger(Utilitario.class);

    private Utilitario() {
    }


    public static void close(String msgId, Connection c) throws SQLException {
        if (c != null) {
            c.close();
            log.info(msgId+" Connection Cerrado");
        }
    }

    public static void close(String msgId, CallableStatement cs) throws SQLException {
        if (cs != null) {
            cs.close();
            log.info(msgId+" CallableStatement Cerrado");
        }
    }

    public static void close(String msgId, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
            log.info(msgId+" ResultSet Cerrado");
        }
    }
}