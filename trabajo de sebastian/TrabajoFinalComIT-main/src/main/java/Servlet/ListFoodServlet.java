package Servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AlimentoCongelado;
import model.Alimento;
import repositories.commonrepositoryAlimentos;

/**
 * Servlet implementation class ListFoodServlet
 */
@WebServlet("/List")
public class ListFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Alimento[] alimentoarray = commonrepositoryAlimentos.AlimentosInterfaceRepository.getAll();
		response.setContentType("text/html;charset=UTF-8");
		Writer writer  = response.getWriter();
		for (int i = 0; i < alimentoarray.length; i++) {
			Alimento alimento = alimentoarray[i];
			
			writer.append("<li><em><b>  id: " +alimento.getId()+ "  , Nombre:  " +alimento.getAlimentoName()+" , cantidad :" + alimento.getCantidad() + "</b></li></em>");
			

			writer.append("<br>");
			writer.append("<br>");
		}
		writer.append("<p>_________________________________________________________________</p>");
		writer.append("<li>ACA VA LO CONGELADO</li>");
		AlimentoCongelado [] AlimentoCongeladoarray = commonrepositoryAlimentos.AlimentosInterfaceRepository.getAllAlimentoCongelado();
		for ( int o = 0 ;o <AlimentoCongeladoarray.length;o++ ) {
			AlimentoCongelado alimentoC=AlimentoCongeladoarray[o];
			writer.append("<li><em><b>  id: " +alimentoC.getIdCong()+ "  , Nombre:  " +alimentoC.getAlimentoCongName()+" , cantidad :" + alimentoC.getCantidadCong() + "</b></li></em>");
		}
	}

}
