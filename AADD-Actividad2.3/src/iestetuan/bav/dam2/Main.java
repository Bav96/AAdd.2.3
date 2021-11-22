/**
 * 
 */
package iestetuan.bav.dam2;

import java.util.List;

import iestetuan.bav.dam2.dao.IAlumno;
import iestetuan.bav.dam2.implmentacion.xml.implementacionxml;
import iestetuan.bav.dam2.vo.Alumno;





/**
 * @author Borja
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		IAlumno operacionAlumno = new implementacionxml();
		
		// Consulta 
    	Alumno alumno = operacionAlumno.Consultaralumno(021);
    	System.out.print(operacionAlumno);
    	
    		
	
	
	
	
	}

}
