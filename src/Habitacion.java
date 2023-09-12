public class Habitacion {
	
	public int id;
	public Paciente paciente;
	public int estado;
	public String reporte;
	//contrusctor
	public Habitacion(int id) {
		
		this.id=id;
		this.estado=1; // 1 disponible, 0 ocupada
		this.reporte="  Historial De Pacientes: \n\n";
		
	}
	public String DatosHab() {
		if(estado==1) {return "Id: "+this.id+" Estado: Disponible ";}
		else if(estado==-1){return "Id: "+this.id+" Estado: Habitacion Eliminada ";}
		else{return "Id: "+this.id+" Estado: No Disponible ";}
		
	}
}
