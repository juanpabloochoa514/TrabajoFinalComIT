package repositories;

import java.sql.SQLException;

public class commonrepositoryAlimentos {
	public static AlimentosInterfaceRepository AlimentosInterfaceRepository;
	static {
		 try {
			System.out.println("Iniciando base de datos");
			AlimentosInterfaceRepository = new DataBaseALimentos();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
