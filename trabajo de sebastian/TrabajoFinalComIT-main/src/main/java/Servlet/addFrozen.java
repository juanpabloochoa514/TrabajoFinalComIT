package Servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.AlimentoCongelado;

import repositories.commonrepositoryAlimentos;


@WebServlet("/addFrozen")
public class addFrozen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public addFrozen() {
        super();
       
    }
    
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
    	String IdParameter = request.getParameter("Idcongelado");
    	String ingresarC = request.getParameter("IngresoCongelado");
		String cantidadC = request.getParameter("CantidadCongelado");

		Writer writer = response.getWriter();
		
		try {
			int IdCong = Integer.parseInt(IdParameter);
			int cantidadCong =Integer.parseInt(cantidadC);
			
			AlimentoCongelado alimentoC =new AlimentoCongelado (IdCong,ingresarC,cantidadCong);
			
		
			
			commonrepositoryAlimentos.AlimentosInterfaceRepository.addFrozenAlimento(alimentoC);
			
			
			
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("text/html;charset=UTF-8");
			writer.append("<div>" + "<b>OK</b>, Alimento agragado correctamente a  su stock del congelador" +alimentoC.getAlimentoCongName()+ " cantidad " 
								  +  alimentoC.getCantidadCong() + "con ID= " + alimentoC.getIdCong()
								  + "</div>");
			writer.append("<a href='congelador.html'> Volver </a>");
			
		}catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}

    }


    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);

	}
    
}
