package servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.StringUtils;

import model.ShopCart;

/**
 * Servlet implementation class CardServlet
 */
@WebServlet("/CardServlet")
public class CardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ShopCart cart = (ShopCart) request.getSession().getAttribute("shoppingcart");
        
        if(cart == null) {
        	cart = new ShopCart();
        	request.getSession().setAttribute("shoppingcart", cart);
        }
		request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        ShopCart cart = (ShopCart) request.getSession().getAttribute("shoppingcart");
        
        // if cart is null, this means its new session and we have to create new cart
        if(cart == null) {
        	cart = new ShopCart();
        	request.getSession().setAttribute("shoppingcart", cart);
        }
        
        String id =  request.getParameter("productid");
        if (id != null) {
        	if(cart != null) {
        		cart.addToCart(id);
        	}
        } else {
        	// get all product ids
        	Enumeration<String> enu = request.getParameterNames();
        	while(enu.hasMoreElements()) {
        		String productid = enu.nextElement();
        		
        		// set new value for products
        		try {
        			int newVal = Integer.parseInt(request.getParameter(productid));
        			cart.setNewValue(productid, newVal);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("Illegal NumberFormat");
				}
        	}
        	
        }

        request.getSession().setAttribute("shoppingcart", cart);
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);
	}

}
