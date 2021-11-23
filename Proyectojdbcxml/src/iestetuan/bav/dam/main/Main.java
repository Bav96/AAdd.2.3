package iestetuan.bav.dam.main;

import java.util.List;

import iestetuan.bav.dam.dao.IAlumno;
import iestetuan.bav.dao.txt.implementaciontxt;
import iestetuan.bav.dao.xml.implementacionxml;
import iestetuan.bav.vo.Alumno;

public class Main {
	
public static void main(String[] args) {
		
	
		//Alumno ejemplo = new implementaciontxt().getAlumno("032");
	
		
		//System.out.println(" el nombre del alumno es  : " +ejemplo.getNombre()+ 
		//"\n el apellido del alumnos es : "+ ejemplo.getApellido1()+"\n el segundo apellido del alumno es :"+ejemplo.getApellido2() );
		
		//Alumno ejemplos[] = new implementaciontxt().getAlumnos();
		
		//System.out.println("es el alumno : " +ejemplos[2].getNombre() );
		
		
		//Alumno ejemplo = new implementacionxml().getAlumno(513);
		
		//System.out.println(" el nombre del alumno es  : " +ejemplo.getNombre()+ 
			//"\n el apellido del alumnos es : "+ ejemplo.getApellido1()+"\n el segundo apellido del alumno es :"+ejemplo.getApellido2() );
	
	
		IAlumno operacionesAlumnos = new implementacionxml();
		
		//toda lista de alumnos 
		List<Alumno>listaAlumnos = operacionesAlumnos.obtenerlistaalumno();
		for (Alumno alumnos : listaAlumnos) {
			System.out.print(alumnos.getNombre());
		}
		//Modifica las lista alumnos 
		//Alumno alumno1= new Alumno();
		//alumno1.setNie(156);
		//alumno1.setNombre("Antonio");
		//alumno1.setApellido1("Pinzon");
		//alumno1.setApellido2("");
	
		
		
		//operacionesAlumnos.borrarAlumno(32);
	

	
}
}
