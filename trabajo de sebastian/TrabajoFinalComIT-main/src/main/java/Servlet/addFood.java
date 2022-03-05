package Servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Alimento;

import repositories.commonrepositoryAlimentos; 

@WebServlet("/addFood")
public class addFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public addFood() {
        super();
 
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    
    	doGet(req , resp );
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identificadorParam = request.getParameter("identificador");
		String ingresarParam = request.getParameter("ingresar");
		String peso = request.getParameter("cantidad");
		
		Writer writer = response.getWriter();
		try {
			int identificador = Integer.parseInt(identificadorParam);
			int cantidad=Integer.parseInt(peso);
			
			Alimento alimento = new Alimento(identificador,ingresarParam,cantidad);
			
			
			commonrepositoryAlimentos.AlimentosInterfaceRepository.addNewAlimento(alimento);
			
			
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html;charset=UTF-8");
			writer.append("<div>" + "<b>OK</b>, Alimento agragado correctamente  su stock " +alimento.getAlimentoName() + " cantidad " 
								  +  alimento.getCantidad() + "con ID= " + alimento.getId()
								  + "</div>");
			writer.append("<a href='refrigerador.html'> Volver </a>");
			
			
		}catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
		}
		
	}

}
