package com.uniovi.sdi;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletElimCarrito
 */
@WebServlet("/eliminarCarrito")
public class ServletElimCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletElimCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession	session=request.getSession();
		HashMap<String,Integer>	carrito	=(HashMap<String,Integer>)	request.getSession().getAttribute("carrito");
		if	(carrito	==	null)	{
			return;
		}
		String	producto	=	request.getParameter("producto");
		if	(	producto	!=	null){
			eliminardeCarrito(carrito,	producto);
		}
		//Retornar	la	vista	con	parámetro	"carrito"
		request.setAttribute("paresCarrito",	carrito);
		getServletContext().getRequestDispatcher("/vista-carrito.jsp").forward(request,	
		response);
	}

	private void eliminardeCarrito(HashMap<String, Integer> carrito, String producto) {
		int valor = carrito.get(producto);
		valor = valor - 1;
		if(valor == 0)
			carrito.remove(producto);
		else
			carrito.put(producto, valor);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
