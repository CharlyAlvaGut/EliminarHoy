/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package net.charly.eliminarhoy;

import java.util.List;
import java.util.Scanner;
import net.charly.eliminarhoy.modelo.entidades.Categoria;
import net.charly.eliminarhoy.modelo.entidades.Producto;
import net.charly.eliminarhoy.modelo.entidades.dao.CategoriaDAO;
import net.charly.eliminarhoy.modelo.entidades.dao.ProductoDAO;

/**
 *
 * @author ca921
 */
public class EliminarHoy {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opc;
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ProductoDAO productoDAO = new ProductoDAO();

        do {
            System.out.println("-----------------------------------");
            System.out.println("\tBienvenido!");
            System.out.println("-----------------------------------");
            System.out.println("Seleccione una opcion: ");
            System.out.println("1) Categorias.");
            System.out.println("2) Productos.");
            System.out.println("3) Salir.");
            System.out.println("-----------------------------------");

            opc = leer.nextInt();
            leer.nextLine();

            if (opc == 1) {

                int opcCat;
                do {
                    System.out.println("----- MENU CATEGORIAS -----");
                    System.out.println("1) Ver categorias");
                    System.out.println("2) Crear categoria");
                    System.out.println("3) Actualizar categoria");
                    System.out.println("4) Eliminar categoria");
                    System.out.println("5) Volver");
                    System.out.println("-----------------------------------");
                    opcCat = leer.nextInt();
                    leer.nextLine();

                    switch (opcCat) {
                        case 1 -> {
                            System.out.println("-------- CATEGORIAS --------");
                            try {
                                List<Categoria> categorias = categoriaDAO.obtenerCategorias();
                                if (categorias.isEmpty()) {
                                    System.out.println();
                                    System.out.println("-----------------------------------");
                                    System.out.println("No existen categorias disponibles!");
                                    System.out.println("-----------------------------------");
                                    System.out.println();

                                } else {
                                    System.out.println("-----------------------------------");
                                    for (Categoria c : categorias) {
                                        System.out.println("ID: " + c.getIdCategoria());
                                        System.out.println("Nombre: " + c.getNombreCategoria());
                                        System.out.println("Descripcion: " + c.getDescripcion());
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    }
                                }

                            } catch (Exception ex) {
                                System.out.println("Error al mostrar las categorias disponibles!");
                            }
                        }
                        case 2 -> {
                            System.out.println("-------- AGREGAR CATEGORIA NUEVA --------");
                            try {
                                String nombreCategoria, descripcionCategoria;
                                System.out.print("Ingrese el nombre de la categoria: ");
                                nombreCategoria = leer.nextLine();
                                System.out.print("Ingrese la descripcion de la categoria: ");
                                descripcionCategoria = leer.nextLine();

                                if (nombreCategoria.isBlank() || descripcionCategoria.isBlank()) {
                                    System.out.println("-----------------------------------");
                                    System.out.println("\tDatos incompletos!");
                                    System.out.println("-----------------------------------");

                                } else {
                                    Categoria c = new Categoria();
                                    c.setNombreCategoria(nombreCategoria);
                                    c.setDescripcion(descripcionCategoria);

                                    if (!categoriaDAO.insertar(c)) {
                                        System.out.println();
                                        System.out.println("-----------------------------------");
                                        System.out.println("Error al agregar la categoria! :(");
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    } else {
                                        System.out.println();
                                        System.out.println("-----------------------------------");
                                        System.out.println("Categoria agregada con exito! :)");
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    }
                                }

                            } catch (Exception ex) {
                                System.out.println("Error al crear una categoria! " + ex.getLocalizedMessage());
                            }
                        }
                        case 3 -> {
                            System.out.println("-------- ACTUALIZAR CATEGORIA --------");
                            try {
                                int cat;
                                System.out.println("Para continuar, por favor, seleccione la categoria a actualizar: ");

                                List<Categoria> categorias = categoriaDAO.obtenerCategorias();
                                if (categorias.isEmpty()) {
                                    System.out.println();
                                    System.out.println("-----------------------------------");
                                    System.out.println("No existen categorias disponibles! No se puede completar la acción :(");
                                    System.out.println("-----------------------------------");
                                    System.out.println();

                                } else {
                                    System.out.println("-----------------------------------");
                                    for (Categoria c : categorias) {
                                        System.out.println("ID: " + c.getIdCategoria());
                                        System.out.println("Nombre: " + c.getNombreCategoria());
                                        System.out.println("Descripcion: " + c.getDescripcion());
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    }
                                }
                                cat = leer.nextInt();
                                leer.nextLine();
                                System.out.println("-----------------------------------");
                                System.out.println();

                                String nombreCategoria, descripcionCategoria;
                                System.out.print("Ingrese el nombre de la categoria: ");
                                nombreCategoria = leer.nextLine();
                                System.out.print("Ingrese la descripcion de la categoria: ");
                                descripcionCategoria = leer.nextLine();

                                if (nombreCategoria.isBlank() || descripcionCategoria.isBlank()) {
                                    System.out.println("-----------------------------------");
                                    System.out.println("\tDatos incompletos!");
                                    System.out.println("-----------------------------------");

                                } else {
                                    Categoria c = categoriaDAO.obtenerCategoria(cat);
                                    c.setNombreCategoria(nombreCategoria);
                                    c.setDescripcion(descripcionCategoria);

                                    if (!categoriaDAO.actualizar(c)) {
                                        System.out.println();
                                        System.out.println("-----------------------------------");
                                        System.out.println("Error al actualizar la categoria! :(");
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    } else {
                                        System.out.println();
                                        System.out.println("-----------------------------------");
                                        System.out.println("Categoria actualizada con exito! :)");
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    }
                                }

                            } catch (Exception ex) {
                                System.out.println("Error al mostrar las categorias disponibles!");
                            }
                        }
                        case 4 -> {
                            System.out.println("-------- ELIMINAR UNA CATEGORIA  --------");
                            try {
                                int cat;
                                System.out.println("Para continuar, por favor, seleccione la categoria a eliminar: ");

                                List<Categoria> categorias = categoriaDAO.obtenerCategorias();
                                if (categorias.isEmpty()) {
                                    System.out.println();
                                    System.out.println("-----------------------------------");
                                    System.out.println("No existen categorias disponibles! No se puede completar la acción :(");
                                    System.out.println("-----------------------------------");
                                    System.out.println();

                                } else {
                                    System.out.println("-----------------------------------");
                                    for (Categoria c : categorias) {
                                        System.out.println("ID: " + c.getIdCategoria());
                                        System.out.println("Nombre: " + c.getNombreCategoria());
                                        System.out.println("Descripcion: " + c.getDescripcion());
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    }
                                }
                                cat = leer.nextInt();
                                leer.nextLine();
                                System.out.println("-----------------------------------");
                                System.out.println();

                                Categoria c = categoriaDAO.obtenerCategoria(cat);
                                int valida;

                                System.out.println("Esta seguro de eliminar la categoria con ID " + c.getIdCategoria() + " y nombre " + c.getNombreCategoria() + "?");
                                System.out.println("1) Si\n2) No");
                                System.out.println("-----------------------------------");
                                valida = leer.nextInt();
                                leer.nextLine();
                                System.out.println("-----------------------------------");
                                if (valida == 1) {
                                    if (!categoriaDAO.eliminar(c)) {
                                        System.out.println();
                                        System.out.println("-----------------------------------");
                                        System.out.println("Error al eliminar la categoria! :(");
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    } else {
                                        System.out.println();
                                        System.out.println("-----------------------------------");
                                        System.out.println("Categoria eliminada con exito! :)");
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    }
                                }

                            } catch (Exception ex) {
                                System.out.println("Error al mostrar la categoria especificada!");
                            }
                        }

                        default -> {
                            System.out.println();
                            System.out.println("-----------------------------------");
                            System.out.println("Opcion invalida! Intente nuevamente");
                            System.out.println("-----------------------------------");
                            System.out.println();
                        }

                    }

                } while (opcCat != 5);

            } else if (opc == 2) {

                int opcProd;
                do {
                    System.out.println("----- MENU PRODUCTOS -----");

                    System.out.println("1) Ver productos");
                    System.out.println("2) Crear producto");
                    System.out.println("3) Actualizar producto");
                    System.out.println("4) Ver un producto especifica");
                    System.out.println("5) Volver");

                    opcProd = leer.nextInt();
                    leer.nextLine();

                    switch (opcProd) {
                        case 1 -> {
                            System.out.println("-------- PRODUCTOS --------");
                            try {

                            } catch (Exception ex) {
                                System.out.println("Error al mostrar los productos disponibles!");
                            }
                        }
                        case 2 -> {
                            System.out.println("-------- AGREGAR PRODUCTO NUEVO --------");
                            try {
                                String nombreProducto, descripcionProducto;
                                double precioProducto;
                                int existenciaProducto, idCategoria;
                                System.out.print("Ingrese el nombre del producto: ");
                                nombreProducto = leer.nextLine();
                                System.out.print("Ingrese la descripcion del producto: ");
                                descripcionProducto = leer.nextLine();
                                System.out.print("Ingrese el precio del producto: ");
                                precioProducto = leer.nextDouble();
                                leer.nextLine();
                                System.out.print("Ingrese las existencias del producto: ");
                                existenciaProducto = leer.nextInt();
                                leer.nextLine();
                                
                                List<Categoria> categorias = categoriaDAO.obtenerCategorias();
                                if (categorias.isEmpty()) {
                                    System.out.println();
                                    System.out.println("-----------------------------------");
                                    System.out.println("No existen categorias disponibles! No se puede completar la acción :(");
                                    System.out.println("-----------------------------------");
                                    System.out.println();

                                } else {
                                    System.out.println("-----------------------------------");
                                    for (Categoria c : categorias) {
                                        System.out.println("ID: " + c.getIdCategoria());
                                        System.out.println("Nombre: " + c.getNombreCategoria());
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    }
                                    System.out.print("Seleccione la categoria del producto: ");
                                }

                                idCategoria = leer.nextInt();
                                leer.nextLine();
                                System.out.println("-----------------------------------");
                                System.out.println();

                                if (nombreProducto.isBlank() || descripcionProducto.isBlank() || precioProducto <= 0 || existenciaProducto <= 0 || idCategoria <= 0) {
                                    System.out.println("-----------------------------------");
                                    System.out.println("\tDatos incompletos o incorrectos! Favor de verificar nuevamente ...");
                                    System.out.println("-----------------------------------");

                                } else {
                                    Producto p = new Producto();
                                    p.setNombreProducto(nombreProducto);
                                    p.setDescripcionProducto(descripcionProducto);
                                    p.setPrecioProducto(precioProducto);
                                    p.setExistencia(existenciaProducto);
                                    p.setIdCategoria(idCategoria);

                                    if (!productoDAO.insertar(p)) {
                                        System.out.println();
                                        System.out.println("-----------------------------------");
                                        System.out.println("Error al agregar el producto! :(");
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    } else {
                                        System.out.println();
                                        System.out.println("-----------------------------------");
                                        System.out.println("Producto agregado con exito! :)");
                                        System.out.println("-----------------------------------");
                                        System.out.println();
                                    }
                                }

                            } catch (Exception ex) {
                                System.out.println("Error al crear un producto! " + ex.getLocalizedMessage());
                            }
                        }
                        case 3 -> {
                            System.out.println("-------- ACTUALIZAR PRODUCTO --------");
                            try {

                            } catch (Exception ex) {
                                System.out.println("Error al mostrar los productos disponibles!");
                            }
                        }
                        case 4 -> {
                            System.out.println("-------- CONSULTAR UN PRODUCTO  --------");
                            try {

                            } catch (Exception ex) {
                                System.out.println("Error al mostrar el producto especificado!");
                            }
                        }

                        default -> {
                            System.out.println();
                            System.out.println("-----------------------------------");
                            System.out.println("Opcion invalida! Intente nuevamente");
                            System.out.println("-----------------------------------");
                            System.out.println();
                        }

                    }

                } while (opcProd != 5);
            }

        } while (opc != 3);
    }
}
