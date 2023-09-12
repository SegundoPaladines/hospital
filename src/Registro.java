import javax.swing.JOptionPane;

public class Registro {
	
	private String motivo;
	private String fentrada;
	private String fsalida;
	//Constructor
	public Registro(){
		this.motivo=JOptionPane.showInputDialog("Ingrese el motivo del ingreso del paciente");
		this.fentrada=JOptionPane.showInputDialog("Ingrese fecha de entrada del paciente");
		this.fsalida=JOptionPane.showInputDialog("Ingrese la fecha de salida");
	}
	//Getters
	public String Getmotivo(){
		
		return this.motivo;
		
	}
	public String Getfentrada(){
		
		return this.fentrada;
		
	}
	public String Getfsalida(){
		
		return this.fsalida;
		
	}
	public String MostrarRegistro() {
		String impresion=" Fecha De Entrada: "+this.fentrada+" Fecha De Salida: "+this.fsalida+" Motivo De Ingreso: "+this.motivo;
		return impresion;
	}
	public void ModificarRegistro() {
		this.motivo=JOptionPane.showInputDialog("Ingrese el nuevo motivo del ingreso del paciente");
		this.fentrada=JOptionPane.showInputDialog("Ingrese la nueva fecha de entrada del paciente");
		this.fsalida=JOptionPane.showInputDialog("Ingrese la nueva fecha de salida");
	}
}
