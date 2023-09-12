import javax.swing.JOptionPane;

public class Hospital {
	
	private int id;
	public Habitacion habitaciones[];
	//Constructor
	public Hospital () {
		this.id=1;
		int tamano=Integer.parseInt(JOptionPane.showInputDialog("Ingrese La Cantidad De Habitaciones"));
		this.habitaciones= new Habitacion[tamano];
		for(int i=0; i<tamano; i++) {
			this.habitaciones[i]=new Habitacion(i);
		}
		System.out.println("El Hospital "+id+" Ha Sido Creado, Cuenta Con "+tamano+" Habitaciones");
	}
	//metodos
	public void IngresarPaciente() {	
		//Lista las habitaciones que estan disponbibles
		String habs="";
		for(int i=0; i<this.habitaciones.length; i++) {
			habs=habs+this.habitaciones[i].DatosHab()+"\n";
		}
		int idhab=Integer.parseInt(JOptionPane.showInputDialog("Ingrese id de la habitacion donde va a ingresar al pasiente \n\n"+habs));
		int idpos=this.PosHab(idhab);
		if(idpos!=-1) {
			if(this.habitaciones[idpos].estado==1) {
				this.habitaciones[idpos].paciente=new Paciente();
				this.habitaciones[idpos].estado=0;
				this.habitaciones[idpos].reporte=habitaciones[idpos].reporte+habitaciones[idpos].paciente.DatosPaciente()+habitaciones[idpos].paciente.registro.MostrarRegistro()+"\n\n";
				System.out.println("Paciente Ingresado Con Exito");
			}else {System.out.println("La Habitacion No Disponible");}
		}else {System.out.println("La Habitacion No Existe");}
		
	}
	public void EditarPaciente() {
		String pacientes="Lista de pacientes: \n\n";
		for(int i=0; i<this.habitaciones.length; i++) {
			if(this.habitaciones[i].estado==0) {
				pacientes=pacientes+this.habitaciones[i].paciente.DatosPaciente()+"\n";
			}
		}
		String cedula=JOptionPane.showInputDialog("Ingrese la cedula del pasiente a editar \n\n"+pacientes);
		int pospac=this.PosPaciente(cedula);
		if(pospac!=-1) {
			this.habitaciones[pospac].paciente.EditarPaciente();
			this.habitaciones[pospac].reporte=habitaciones[pospac].reporte+habitaciones[pospac].paciente.DatosPaciente()+habitaciones[pospac].paciente.registro.MostrarRegistro()+"\n\n";
			
			System.out.println("Paciente Editado Con Exito");
		}else {System.out.println("El Paciente No Existe");}
	}
	public void EliminarPaciente() {
		
		String pacientes="Lista de pacientes: \n\n";
		for(int i=0; i<habitaciones.length; i++) {
			if(habitaciones[i].estado==0) {
				pacientes=pacientes+habitaciones[i].paciente.DatosPaciente()+"\n";
			}
		}
		String cedula=JOptionPane.showInputDialog("Ingrese la cedula del pasiente a eliminar\n\n"+pacientes);
		int pospac=PosPaciente(cedula);
		if(pospac!=-1) {
			habitaciones[pospac].paciente=null;
			habitaciones[pospac].estado=1;
			System.out.println("Paciente Eliminado Con Exito");
		}else {System.out.println("El Paciente No Existe");}
	}
	public void EditarHabitacion() {
		
		String habs="";
		for(int i=0; i<this.habitaciones.length; i++) {
			habs=habs+this.habitaciones[i].DatosHab()+"\n";
		}
		int idhab=Integer.parseInt(JOptionPane.showInputDialog("Ingrese id de la habitacion a editar\n"+habs));
		int poshab=this.PosHab(idhab);
		if(poshab!=-1) {
			if(this.habitaciones[poshab].estado!=-1) {
				int opciones=Integer.parseInt(JOptionPane.showInputDialog(" ******** EDITAR HABITACION ******** \n"
						+ "SELECCIONE UNA OPCION: \n\n"
						+ "1. CAMBIAR EL PACIENTE \n"
						+ "2. ELIMINAR EL PACIENTE \n"
						+ "3. LIMPIAR REPORTE"));
				if(opciones==1) {
					
					if(this.habitaciones[poshab].estado==0) {
						this.habitaciones[poshab].paciente.EditarPaciente();
						this.habitaciones[poshab].reporte=habitaciones[poshab].reporte+habitaciones[poshab].paciente.DatosPaciente()+habitaciones[poshab].paciente.registro.MostrarRegistro()+"\n\n";
					}
					else if(this.habitaciones[poshab].estado==1){
						System.out.println("La Habitacion Esta Vacia, Ingrese Un Nuevo Paciente");
						this.habitaciones[poshab].paciente=new Paciente();
						this.habitaciones[poshab].estado=0;
						this.habitaciones[poshab].reporte=habitaciones[poshab].reporte+habitaciones[poshab].paciente.DatosPaciente()+habitaciones[poshab].paciente.registro.MostrarRegistro()+"\n\n";
					}
				}
				if(opciones==2) {
					
					if(this.habitaciones[poshab].estado==0) {
						this.habitaciones[poshab].paciente=null;
						this.habitaciones[poshab].estado=1;
					}else {
						System.out.println("La Habitacion Esta Vacia");
					}
					
				}
				if(opciones==3) {
					
					this.habitaciones[poshab].reporte="Historial De Pacientes: \n\n";
					System.out.println("Habitacion Editada Con Exito");
				}
			}else {System.out.println("La Habitacion No Existe");}
			
		}else {System.out.println("La Habitacion No Existe");}
		
	}
	public void EliminarHab() {
		String habs="";
		for(int i=0; i<this.habitaciones.length; i++) {
			habs=habs+this.habitaciones[i].DatosHab()+"\n";
		}
		int idhab=Integer.parseInt(JOptionPane.showInputDialog("Ingrese id de la habitacion a eliminar\n\n"+habs));
		int poshab=PosHab(idhab);
		if(poshab!=-1) {
			
			this.habitaciones[poshab].estado=-1;
			
		}else{System.out.println("La Habitacion No Existe");}
	}
	public void CambiarRegistro() {
		String pacientes="Lista de pacientes: \n\n";
		for(int i=0; i<this.habitaciones.length; i++) {
			if(this.habitaciones[i].estado==0) {
				pacientes=pacientes+this.habitaciones[i].paciente.DatosPaciente()+"Registro: "+this.habitaciones[i].paciente.registro.MostrarRegistro()+"\n";
			}
		}
		String cedula=JOptionPane.showInputDialog("Ingrese la cedula del pasiente a editar registro \n\n"+pacientes);
		int pospac=this.PosPaciente(cedula);
		if(pospac!=-1) {
			this.habitaciones[pospac].paciente.registro.ModificarRegistro();
			System.out.println("Registro Editado Con Exito");
		}else {System.out.println("El Paciente No Existe");}
	}
	public void MostrarRegistros() {
		String impresion="";
		for(int i=0; i<this.habitaciones.length; i++) {
			
			impresion=impresion+"Reporte De La Habitacion "+i+habitaciones[i].reporte+"\n";
		}
		JOptionPane.showMessageDialog(null, impresion);
	}
	public void CambiarDeHab() 
	{
		String pacientes="Lista de pacientes: \n\n";
		for(int i=0; i<this.habitaciones.length; i++) {
			if(this.habitaciones[i].estado==0) {
				pacientes=pacientes+this.habitaciones[i].paciente.DatosPaciente()+"\n";
			}
		}
		String cedula=JOptionPane.showInputDialog("ingrese la cedula del paciente\n"+pacientes);
		int poshab=this.PosPaciente(cedula);
		if(poshab!=-1) {
			String habs="";
			for(int i=0; i<this.habitaciones.length; i++) {
				habs=habs+this.habitaciones[i].DatosHab()+"\n";
			}
			int nhab=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la nueva habitacion\n"+habs));
			if(this.habitaciones[nhab].estado==1) {
				this.habitaciones[nhab].paciente=this.habitaciones[poshab].paciente;
				this.habitaciones[nhab].estado=0;
				this.habitaciones[nhab].reporte=habitaciones[nhab].reporte+habitaciones[nhab].paciente.DatosPaciente()+habitaciones[nhab].paciente.registro.MostrarRegistro()+"\n\n";
				this.habitaciones[poshab].paciente=null;
				this.habitaciones[poshab].estado=1;
				System.out.println("Pasiente cambiado de la habitacion "+poshab+" a la habitacion "+nhab);
			}
		}else {System.out.println("La cedula del paciente no existe");}
	}
	public int PosHab(int id) {
		int bandera=-1;
		for(int i=0; i<this.habitaciones.length; i++) {
			if(id==this.habitaciones[i].id) {
				bandera=i;
			}
		}
		return bandera;
	}
	public int PosPaciente(String cedula) {
		int bandera=-1;
		for(int i=0; i<this.habitaciones.length; i++) {
			if(this.habitaciones[i].estado==0) {
				if(cedula.equals(this.habitaciones[i].paciente.Getcedula())) {
					bandera=i;
				}
			}
		}
		return bandera;
	}
}
