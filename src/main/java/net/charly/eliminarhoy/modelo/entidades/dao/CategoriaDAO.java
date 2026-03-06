/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.charly.eliminarhoy.modelo.entidades.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.charly.eliminarhoy.config.Conexion;
import net.charly.eliminarhoy.modelo.entidades.Categoria;

/**
 *
 * @author ca921
 */
public class CategoriaDAO extends Conexion {

    private static final String SQL_INSERT = "INSERT INTO categoria (nombreCategoria, descripcionCategoria) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE categoria SET nombreCategoria = ?, "
            + "descripcionCategoria = ? WHERE idCategoria = ?";
    private static final String SQL_DELETE = "DELETE FROM categoria WHERE idCategoria = ?";
    private static final String SQL_SELECT = "SELECT * FROM categoria WHERE idCategoria = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM categoria";

    public boolean insertar(Categoria c) {
        conectar();
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, c.getNombreCategoria());
            ps.setString(2, c.getDescripcion());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Error al insertar categoria! :( " + ex.getLocalizedMessage());

        } finally {
            desconectar();
        }
        return false;
    }

    public boolean actualizar(Categoria c) {
        conectar();
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getNombreCategoria());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getIdCategoria());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Error al actualizar la categoria! :( " + ex.getLocalizedMessage());

        } finally {
            desconectar();
        }
        return false;
    }

    public boolean eliminar(Categoria c) {
        conectar();
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, c.getIdCategoria());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Error al eliminar la categoria! :( " + ex.getLocalizedMessage());

        } finally {
            desconectar();
        }
        return false;
    }

    public Categoria obtenerCategoria(int id) {
        Categoria c = null;
        try {
            conectar();
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                c = new Categoria();
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setNombreCategoria(rs.getString("nombreCategoria"));
                c.setDescripcion(rs.getString("descripcionCategoria"));
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener la categoria! " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
        return c;
    }
    
    public List<Categoria> obtenerCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            conectar();
            ps = conn.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            while(rs.next()){
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("idCategoria"));
                c.setNombreCategoria(rs.getString("nombreCategoria"));
                c.setDescripcion(rs.getString("descripcionCategoria"));
                
                categorias.add(c);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener la categoria! " + ex.getLocalizedMessage());
        } finally {
            desconectar();
        }
        return categorias;
    }

}
