package st.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public insertServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String town = request.getParameter("town");
		String store = request.getParameter("store");
		String telephone = request.getParameter("telephone");
		String addr = request.getParameter("addr");
		String product = request.getParameter("product");
		StoreBean sb = new StoreBean();
		StoreDAO ins = new StoreDAO();

		try {
			int result = ins.insert(sb);
			if (result != 0) {
				PrintWriter out = response.getWriter();
				out.println("新增成功！");
			}
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

}
