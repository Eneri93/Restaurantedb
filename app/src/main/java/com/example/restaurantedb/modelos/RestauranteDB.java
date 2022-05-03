package com.example.restaurantedb.modelos;
import com.example.restaurantedb.clases.Restaurante;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.ArrayList;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import com.example.restaurantedb.clases.LogoRest;
import com.example.restaurantedb.clases.Restaurante;
import com.example.restaurantedb.utilidades.ImagenesBlobBitmap;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RestauranteDB{
        //-----------------------------------------------------------
        //-----------------------------------------------------------
        public static  ArrayList<Restaurante> obtenerRestaurantes() {


            Connection conexion = BaseDB.conectarConBaseDeDatos();
            if (conexion == null) {
                return null;
            }
            ArrayList<Restaurante> restauranteDevuelto = new ArrayList<Restaurante>();
            try {
                Statement sentencia = conexion.createStatement();
                String ordenSQL = "select * from Restaurante";
                ResultSet resultado = sentencia.executeQuery(ordenSQL);
                while (resultado.next()) {
                    int idrestaurante = resultado.getInt("idRestaurante");
                    String nombre = resultado.getString("nombre");
                    double facturacion = resultado.getDouble("facturacion_anual");
                    int idfranquicia= resultado.getInt("Franquicia_idFranquicia");
                    Restaurante r= new Restaurante(idrestaurante,nombre,facturacion,idfranquicia);


                    restauranteDevuelto.add(r);
                }
                resultado.close();
                sentencia.close();
                conexion.close();
                return restauranteDevuelto;
            } catch (SQLException e) {
                Log.i("sql", "error sql");
                return null;
            }
        }

        //-------------------------------------------------------
        public static boolean insertarRestauranteTabla(Restaurante r) {
            Connection conexion = BaseDB.conectarConBaseDeDatos();
            if (conexion == null) {
                return false;
            }
            //----------------------------
            try {
                String ordensql = "INSERT INTO Restaurante (nombre, facturacion_anual, Franquicia_idFranquicia) VALUES (?, ?, ?);";
                PreparedStatement pst = conexion.prepareStatement(ordensql);
                pst.setString(1, r.getNombre());
                pst.setDouble(2, r.getFacturcion());
                pst.setInt(3, r.getIdFra());
                int filasAfectadas = pst.executeUpdate();
                pst.close();
                conexion.close();
                if (filasAfectadas > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                return false;
            }
        }

        //-----------------------------------------------------------
        public static boolean borrarRestauranteTabla(Restaurante r) {
            Connection conexion = BaseDB.conectarConBaseDeDatos();
            if (conexion == null) {
                return false;
            }
            //----------------------------
            try {
                String ordensql = "DELETE FROM Restaurante WHERE idRestaurante = ?;";
                PreparedStatement pst = conexion.prepareStatement(ordensql);
                pst.setInt(1, r.getIdRest());
                int filasAfectadas = pst.executeUpdate();
                pst.close();
                conexion.close();
                if (filasAfectadas > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                return false;
            }
        }

        //---------------------------------------------------------------
        public static boolean actualizarRestauranteTabla(Restaurante r) {
            Connection conexion = BaseDB.conectarConBaseDeDatos();
            if (conexion == null) {
                return false;
            }
            //----------------------------
            try {
                String ordensql = "UPDATE Restaurante SET nombre = ?, facturacion_anual = ?, Franquicia_idFranquicia = ? WHERE (idRestaurante = ?);";
                PreparedStatement pst = conexion.prepareStatement(ordensql);
                pst.setString(1, r.getNombre());
                pst.setDouble(2, r.getFacturcion());
                pst.setInt(3, r.getIdFra());
                pst.setInt(4, r.getIdRest());
                int filasAfectadas = pst.executeUpdate();
                pst.close();
                conexion.close();
                if (filasAfectadas > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                return false;
            }
        }

        //--------------------------------------------------------------
        public static Restaurante buscarRestauranteTabla(String nombre) {
            Connection conexion = BaseDB.conectarConBaseDeDatos();
            if (conexion == null) {
                return null;
            }
            //---------------------------------
            Restaurante RestEncontrado = null;
            try {
                String ordensql = "select * from Restaurante where nombre like ?";
                PreparedStatement pst = conexion.prepareStatement(ordensql);
                pst.setString(1, nombre);
                ResultSet resultadosql = pst.executeQuery();
                //------------------------------------------------
                while (resultadosql.next()) {
                    int idRestaurante = resultadosql.getInt("idRestaurante");
                    String nombreRest = resultadosql.getString("nombre");
                    Double Facturacion = resultadosql.getDouble("facturacion_anual");
                    int idFranquicia = resultadosql.getInt("Franquicia_idFranquicia");
                    RestEncontrado = new Restaurante(idRestaurante, nombreRest, Facturacion, idFranquicia);
                }
                resultadosql.close();
                pst.close();
                conexion.close();
                return RestEncontrado;
            } catch (SQLException e) {
                return null;

            }}

            public static ArrayList<LogoRest> obtenerLogosRest(int width, int height) {
                Connection conexion = BaseDB.conectarConBaseDeDatos();
                if (conexion == null) {
                    return null;
                }
                ArrayList<LogoRest> LogoRestDevueltos = new ArrayList<LogoRest>();
                try {
                    Statement sentencia = conexion.createStatement();
                    String ordenSQL = "select * from logos";
                    ResultSet resultado = sentencia.executeQuery(ordenSQL);
                    while (resultado.next()) {
                        int idlogo = resultado.getInt("idlogos");
                        Blob logo = resultado.getBlob("logo");
                        Bitmap bm_foto;
                        bm_foto = ImagenesBlobBitmap.blob_to_bitmap(logo, width, height);
                        int idRest = resultado.getInt("idRestaurante");
                        LogoRest Lr = new LogoRest(idlogo, bm_foto, width);
                        LogoRestDevueltos.add(Lr);
                    }
                    resultado.close();
                    sentencia.close();
                    conexion.close();
                    return LogoRestDevueltos;
                } catch (SQLException e) {
                    Log.i("sql", "error sql");
                    return null;
                }
            }
        }

