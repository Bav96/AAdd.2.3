package iestetuan.bav.dao.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import iestetuan.bav.dam.dao.IAlumno;
import iestetuan.bav.vo.Alumno;

public class implementacionjdbc implements IAlumno {

	@Override
	public Alumno getAlumno(int nie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno consultarAlumno(int id_alumno) {
		// TODO Auto-generated method stub
		String esteeseliddelalumno="";
		String esteeselnombredelalumno="";
		String esteeselprimerapellidodelalumno="";
		String esteeselsegundoapellidodelalumno="";
		
		
		try {
			File ArchivoXml = new File("C:\\xampp\\htdocs\\aadd\\recursos\\alumnos-dam2-nuevos.xml");  
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(ArchivoXml);
			
			doc.getDocumentElement().normalize();
			
			NodeList ListaNodo = doc.getElementsByTagName("alumno");
		//	System.out.println("Es el alumno " + ListaNodo.getLength());
			
			for(int temp = 0; temp < ListaNodo.getLength(); temp++) {
				  Node nNode = ListaNodo.item(temp);

				  if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				    Element eElement = (Element) nNode;
				    
				  	if (eElement.getAttribute("id").equals(id_alumno)) {
				    esteeseliddelalumno=eElement.getAttribute("id");	
				  	esteeselnombredelalumno=eElement.getElementsByTagName("nombre").item(0).getTextContent();
				  	esteeselprimerapellidodelalumno=eElement.getElementsByTagName("apellido1").item(0).getTextContent();
				  	esteeselsegundoapellidodelalumno=eElement.getElementsByTagName("apellido2").item(0).getTextContent();
				  	
				  	}	
				  	
				  }
			}
			
			
			} catch(Exception e) {
			  e.printStackTrace();
			}
			Alumno esteeselalumnoquevamosadevolver = new Alumno(esteeselsegundoapellidodelalumno, esteeselsegundoapellidodelalumno, esteeselsegundoapellidodelalumno, esteeselsegundoapellidodelalumno, esteeselsegundoapellidodelalumno);
			esteeselalumnoquevamosadevolver.setNie(esteeseliddelalumno);
			esteeselalumnoquevamosadevolver.setNombre(esteeselnombredelalumno);
			esteeselalumnoquevamosadevolver.setApellido1(esteeselprimerapellidodelalumno);
			esteeselalumnoquevamosadevolver.setApellido2(esteeselsegundoapellidodelalumno);
		
		
		
		return esteeselalumnoquevamosadevolver;
	}

	@Override
	public void borrarAlumno(int id_alumno) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
	       Alumno alumno = null;
		
		try {
     
      // abrir la conexion 
			Connection conexion =getConexion();
			try (Statement stmt = conexion.createStatement()) {
          // enviar el comando delete
          stmt.executeUpdate("delete from alumnos where nie = " + id + ";");
      }
			System.out.print("Datos borrados");
  } catch (SQLException e) {
      throw new RuntimeException(e);
  } finally {
      if (conn != null) {
          try {
              conn.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
  }
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Alumno> obtenerlistaalumno() {
		// TODO Auto-generated method stub
		return null;
	}

}
