package com.ecodeup.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeup.dao.ProductoDAO;

import comm.ecodeup.model.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/ProductoController")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws                              ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String opcion =request.getParameter("opcion");
		if(opcion.equals("insert")) {
			
			RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/insertar.jsp");
			requestDispacher.forward(request, response);
		}
		else if(opcion.equals("mostrar"))
		{
			ProductoDAO productoDao= new ProductoDAO();
			List<Producto> lista = new ArrayList<>();
			try {
				lista=productoDao.obtenerTodosProductos();
				for (Producto producto : lista) {
					System.out.println(producto);					
				}
				
				//enviar los datos a la tabla
				request.setAttribute("lista", lista);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
			
		}
		else if(opcion.equals("mostraractualizar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("Editar id:"+id);
			ProductoDAO productoDao= new ProductoDAO();
			Producto p = new Producto();
			try {
				p=productoDao.obtenerunProducto(id);
				System.out.println(p);
				request.setAttribute("producto", p);
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/views/actualizar.jsp");
				requestDispacher.forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
			else if(opcion.equals("eliminar")) {
				ProductoDAO productoDao = new ProductoDAO();
				int id = Integer.parseInt(request.getParameter("id"));
			try {
				productoDao.eliminar(id);
				System.out.println("Registro Eliminado");
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
			
		
		
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String opcion=request.getParameter("opcion");		
		Date fechaActual = new Date();
		
		if (opcion.equals("guardar")) 
		{
			ProductoDAO productoDAO=new ProductoDAO();
			Producto producto= new Producto();
			
			//nos traemos los nombre del html de cada txt o label
			producto.setNombre(request.getParameter("txtnombre"));
			producto.setCantidad(Double.parseDouble(request.getParameter("txtcantidad")));
			producto.setPrecio(Double.parseDouble(request.getParameter("txtprecio")));
			producto.setFechaCrear(new java.sql.Date(fechaActual.getTime()));
			
			try {
				
				productoDAO.insertar(producto);
				System.out.println("Producto Almaccenado correctamente");
				RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
				requestDispacher.forward(request, response);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
			
			else if(opcion.equals("actualizar")) {
				
				Producto producto= new Producto();
				ProductoDAO productoDao = new ProductoDAO();
				
				//nos traemos los nombre del html de cada txt o label
				producto.setId(Integer.parseInt(request.getParameter("id")));
				producto.setNombre(request.getParameter("txtnombre"));
				producto.setCantidad(Double.parseDouble(request.getParameter("txtcantidad")));
				producto.setPrecio(Double.parseDouble(request.getParameter("txtprecio")));
				producto.setFechaActualizar(new java.sql.Date(fechaActual.getTime()));
				
				try {
					productoDao.editar(producto);
					System.out.println("Producto actualizado correctamente");
					RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
					requestDispacher.forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
		
		
		
		
	}

}
