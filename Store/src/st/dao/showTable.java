package st.dao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showTable")
public class showTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	public showTable01() {
//		super();
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//測試尋找一商店結果
		StoreDAO dao = new StoreDAO();
		StoreBean bean = dao.findByStore("老順香");
		System.out.println(bean.getProduct());
		try {
			request.setAttribute("AllStores", dao.getAll());
			RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ;
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
