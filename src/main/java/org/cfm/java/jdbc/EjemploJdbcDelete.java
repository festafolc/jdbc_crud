package org.cfm.java.jdbc;


import org.cfm.java.jdbc.models.Producto;
import org.cfm.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.cfm.java.jdbc.repositorio.Repositorio;
import org.cfm.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=========== listar ===========");
            repositorio.listar().forEach(p -> System.out.println(p.getNombre()));
            System.out.println("=========== obtener por id ===========");
            System.out.println(repositorio.porId(2L));
            System.out.println("=========== eliminar producto ===========");
            repositorio.eliminar(3L);
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
