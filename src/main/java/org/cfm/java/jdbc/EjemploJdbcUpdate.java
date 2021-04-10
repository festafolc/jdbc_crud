package org.cfm.java.jdbc;


import org.cfm.java.jdbc.models.Categoria;
import org.cfm.java.jdbc.models.Producto;
import org.cfm.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.cfm.java.jdbc.repositorio.Repositorio;
import org.cfm.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=========== listar ===========");
            repositorio.listar().forEach(p -> System.out.println(p.getNombre()));
            System.out.println("=========== obtener por id ===========");
            System.out.println(repositorio.porId(2L));
            System.out.println("=========== producto actualizado ===========");
            Producto producto = new Producto();
            producto.setId(4L);
            producto.setNombre("Teclado Corsair k95 mecánico");
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);
            producto.setPrecio(700);
            repositorio.guardar(producto);
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
