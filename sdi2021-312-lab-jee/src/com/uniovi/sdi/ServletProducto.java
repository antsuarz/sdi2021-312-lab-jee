package com.uniovi.sdi;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/productos")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession	session=request.getSession();
		HashMap<String,Float>	productos = null;//(HashMap<String,Float>)	request.getSession().getAttribute("productos");
		if(productos == null) {
			productos	=	new	HashMap<String,Float>();
			request.getSession().setAttribute("productos",	productos);
		}
		ProductosService ps = new ProductosService(); 
		List<Producto> productosLista = ps.getProductos();
		productos = llenarDiccionario(productosLista, productos);
		request.setAttribute("productos",	productos);
		getServletContext().getRequestDispatcher("/vista-productos.jsp").forward(request,	
		response);
	}


	private HashMap<String, Float> llenarDiccionario(List<Producto> productosLista, HashMap<String, Float> productos) {
		for(Producto p : productosLista) {
			productos.put(p.getNombre(), p.getPrecio());
		}
		return productos;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
