package st.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StoreBean sb =new StoreBean();
		StoreDAO ud = new StoreDAO();
		String town = request.getParameter("town");
		String telephone = request.getParameter("telephone");
		String addr = request.getParameter("addr");
		String product = request.getParameter("product");
		String store = request.getParameter("store");
		
		try {
			sb.setTown(town);
			sb.setTelephone(telephone);
			sb.setAddr(addr);
			sb.setProduct(product);
			sb.setStore(store);
			int result = ud.update(sb);
			if (result != 0) {
				PrintWriter out = response.getWriter();
				out.println("修改成功！");
			}
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ;
	}

}
