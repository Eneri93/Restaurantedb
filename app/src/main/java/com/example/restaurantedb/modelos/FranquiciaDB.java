package com.example.restaurantedb.modelos;

import android.util.Log;

import com.example.restaurantedb.clases.Franquicia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FranquiciaDB {
    //----------------------------------------------------------....
    public static boolean insertarFranquiciaTabla(Franquicia f1)
    {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "INSERT INTO Franquicia (nombreFranquicia) VALUES (?);";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, f1.getNombre());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
    //-----------------------------------------------------------
    public static Franquicia buscarFranquiciaTabla(String nombre)
    {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        //---------------------------------
        Franquicia franquiciaEncontrada = null;
        try {
            ResultSet resultadosql = BaseDB.buscarFilasEnTabla(conexion, "Franquicia", "nombreFranquicia", nombre);
            //------------------------------------------------
            if(resultadosql == null)
            {
                return null;
            }
            while(resultadosql.next())
            {
                int idFranquicia = resultadosql.getInt("idFranquicia");
                String nombreFranquicia = resultadosql.getString("nombreFranquicia");
                franquiciaEncontrada = new Franquicia(idFranquicia,nombreFranquicia);
            }
            resultadosql.close();
            conexion.close();
            return franquiciaEncontrada;
        } catch (SQLException e) {
            return null;
        }
    }

    public static ArrayList<Franquicia> obtenerFranquicias() {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return null;
        }
        ArrayList<Franquicia> franquiciasDevueltas = new ArrayList<Franquicia>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select * from Franquicia";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while(resultado.next())
            {
                int idfranquicia = resultado.getInt("idFranquicia");
                String nombre = resultado.getString("nombreFranquicia");
                Franquicia fr = new Franquicia(idfranquicia, nombre);
                franquiciasDevueltas.add(fr);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return franquiciasDevueltas;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return franquiciasDevueltas;
        }
    }

    public static boolean borrarFranquiciaTabla(Franquicia p) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "DELETE FROM Franquicia WHERE nombreFranquicia LIKE ?;";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, p.getNombre());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean actualizarFranquiciaTabla(Franquicia f) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "UPDATE Franquicia SET nombreFranquicia = ? WHERE idFranquicia = ?";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, f.getNombre());
            pst.setInt(2, f.getIdFranquicia());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
