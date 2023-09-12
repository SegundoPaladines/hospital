import javax.swing.JOptionPane;

public class Paciente {
	private String cedula;
	private String nombre;
	private String descripcion;
	public Registro registro;
	public int cantingresos;
	//Constructor
	public Paciente() {
		this.cedula=JOptionPane.showInputDialog("Ingrese la cedula del paciente");
		this.nombre=JOptionPane.showInputDialog("Ingrese el nombre del paciente");
		this.descripcion=JOptionPane.showInputDialog("Ingrese la descripcion del paciente");
		this.registro=new Registro();
	}
	//Getters
	public String Getcedula(){
		
		return this.cedula;
		
	}
	public String Getnombre(){
		
		return this.nombre;
		
	}
	public String Getdescripcion() {
		return this.descripcion;
	}
	//metodos
	public String DatosPaciente() {
		return "Cedula: "+cedula+" Nombre "+nombre+" Descripcion: "+descripcion;
	}
	public void EditarPaciente() {
		
		this.cedula=JOptionPane.showInputDialog("Ingrese la nueva cedula");
		this.nombre=JOptionPane.showInputDialog("Ingrese el nuevo nombre");
		this.descripcion=JOptionPane.showInputDialog("Ingrese la nueva descripcion del paciente");
	}
	
}
