package org.cfm.java.jdbc;


import org.cfm.java.jdbc.models.Categoria;
import org.cfm.java.jdbc.models.Producto;
import org.cfm.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.cfm.java.jdbc.repositorio.Repositorio;
import org.cfm.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getInstance()) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=========== listar ===========");
            repositorio.listar().forEach(p -> System.out.println(p.getNombre()));
            System.out.println("=========== obtener por id ===========");
            System.out.println(repositorio.porId(1L));
            System.out.println("=========== insertar nuevo producto ===========");
            Producto producto = new Producto();
            producto.setNombre("Teclado Red Dragon mecánico");
            producto.setPrecio(450);
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            producto.setFecha_registro(new Date());
            repositorio.guardar(producto);
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
