package com.example.restaurantedb.modelos;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexioncondb {

    public static final String HOSTDB = "10.0.2.2";
    public static final String NOMBREDB = "RestaurantesDB";
    public static final String USUARIODB = "root";
    public static final String CLAVEDB = "dam1";
    public static final int ANCHO_IMAGENES_BITMAP = 100;
    public static final int ALTO_IMAGENES_BITMAP = 100;
    public static final int NUMERO_DE_COLUMNAS = 3;
    private static final String OPCIONESHORA = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String PUERTOMYSQL = "3306";
    public static final String URLMYSQL = "jdbc:mysql://"+ HOSTDB +":"+PUERTOMYSQL + "/" + NOMBREDB + OPCIONESHORA;

    //----------------------------------------------------------....
    public static Connection conectarConBaseDeDatos() {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection conexion = DriverManager.getConnection(URLMYSQL, USUARIODB, CLAVEDB);
            return conexion;
        } catch (SQLException e) {
            System.out.println("No se pudo establecer la conexion con la base de datos");
            return null;
        }
    }

}
