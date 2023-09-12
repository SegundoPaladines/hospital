import javax.swing.JOptionPane;

public class AppHospital {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		
		Hospital hospital=new Hospital();
		int opcion= Integer.parseInt(JOptionPane.showInputDialog("*********** HOSPITAL *********** \n\n"
				+ "SELECCIONE UNA OPCION: \n"+
				"1. AÑADIR PACIENTE \n"+
				"2. EDITAR PACIENTE \n"+
				"3. ELIMINAR PACIENTE \n"+
				"4. EDITAR HABITACION \n"+
				"5. ELIMINAR HABITACION\n"+
				"6. EDITAR REGISTRO DEL PACIENTE \n"+
				"7. MOSTRAR REPORTE DE HABITACIONES Y PACIENTES\n"+
				"8. CAMBIAR AL PASIENTE DE HABITACION\n"+
				"0. SALIR \n\n"));
		
		if(opcion>=0 & opcion<=8) {
			
			while(opcion>0 & opcion<=8){
				
				switch(opcion) {
				
					case 1:
						
						hospital.IngresarPaciente();
						
						break;
					case 2:
						
						hospital.EditarPaciente();
						
						break;
					
					case 3:
						
						hospital.EliminarPaciente();
						
						break;
						
					case 4:
						
						hospital.EditarHabitacion();
						
						break;
						
					case 5:
						
						hospital.EliminarHab();
						
						break;
					case 6:
						
						hospital.CambiarRegistro();
						
						break;
					case 7:
						
						hospital.MostrarRegistros();
						
						break;
					case 8:
						
						hospital.CambiarDeHab();
						
						break;
					
				}
				
				opcion= Integer.parseInt(JOptionPane.showInputDialog("*********** HOSPITAL *********** \n\n"
						+ "SELECCIONE UNA OPCION: \n"+
						"1. AÑADIR PACIENTE \n"+
						"2. EDITAR PACIENTE \n"+
						"3. ELIMINAR PACIENTE \n"+
						"4. EDITAR HABITACION \n"+
						"5. ELIMINAR HABITACION\n"+
						"6. EDITAR REGISTRO DEL PACIENTE \n"+
						"7. MOSTRAR REPORTE DE HABITACIONES Y PACIENTES\n"+
						"8. CAMBIAR AL PASIENTE DE HABITACION\n"+
						"0. SALIR \n\n"));	
			}
			System.out.println("FIN PROGRAMA");
		}else {System.out.println("ENTRADA NO VALIDA");}
	}
}
