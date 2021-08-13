package controllers.reports;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class ReportsLikeServlet
 */
@WebServlet("/reports/like")
public class ReportsLikeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsLikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub

    EntityManager em = DBUtil.createEntityManager();

    Report r = em.find(Report.class, Integer.parseInt(request.getParameter("id")));



    int like_coun = r.getLike_count() + 1 ;
    r.setLike_count(like_coun);


//    r.setLike_count(request.getParameter("like_count"));

    em.getTransaction().begin();
    em.getTransaction().commit();
    em.close();
    request.getSession().setAttribute("flush", "いいね しました。");

    request.getSession().removeAttribute("report_id");

    response.sendRedirect(request.getContextPath() + "/reports/index");

    // response.getWriter().append("Served at: ").append(request.getContextPath());
  }



}
