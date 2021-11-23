package iestetuan.bav.dao.txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import iestetuan.bav.dam.dao.IAlumno;
import iestetuan.bav.vo.Alumno;

public class implementaciontxt implements IAlumno{

	@Override
	public Alumno getAlumno(String nie) {
		// TODO Auto-generated method stub
		Alumno alumnoRespuesta=null;
		File fichero= new File("C:\\xampp\\htdocs\\aadd\\recursos\\alumnos-dam2-inicial.txt");
		FileReader fr;
		BufferedReader br= null;
		String sLinea=null;
		boolean primerVez=true;
		try {
			fr = new FileReader(fichero, Charset.forName("UTF-8"));
			br= new BufferedReader(fr);
			while((sLinea=br.readLine())!=null) {
				if(primerVez) {
					primerVez=false;
				}else{
					// Información de una línea
					String[] partesLinea=sLinea.split(",");
					String idRespuesta = partesLinea[0];
					//int idRespuesta = Integer.parseInt(sId);
					if(idRespuesta.equals(nie)){
						String nickname= partesLinea[1];
						String email= partesLinea[2];
						// Se carga la información de un usuario
						alumnoRespuesta=new Alumno();
						alumnoRespuesta.setNie(partesLinea[0]);
						alumnoRespuesta.setNombre(partesLinea[1]);
						alumnoRespuesta.setApellido1(partesLinea[2]);
						alumnoRespuesta.setApellido2(partesLinea[3]);
						
						
						break;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnoRespuesta;
	}
	

	@Override
	public void crearAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno consultarAlumno(int id_alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarAlumno(int id_alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Alumno> obtenerlistaalumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Alumno getAlumno(int nie) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Alumno alumno=null;
				File rutaDondeesta= new File ("C:\\Users\\Borja\\Downloads\\alumnos-dam2-inicial.xml");
				Document documento = null;
				
				try {
					  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					  documento = dBuilder.parse(rutaDondeesta);
					  documento.getDocumentElement().normalize();
					} catch(Exception e) {
					  e.printStackTrace();
				}
				// Se obtiene la lista de nodos relacionado con 'departamento'
				NodeList nListIni = documento.getElementsByTagName("alumno");
				System.out.println("Numero de alumnos: " + nListIni.getLength());
				for(int temp = 0; temp < nListIni.getLength(); temp++) {
					Node nNode = nListIni.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					    Element elemento = (Element) nNode;
				    	String id= elemento.getElementsByTagName("ID").item(0).getTextContent();
				    	int numid=Integer.parseInt(id);
				    	// Se guardan el departamento que contienen el mismo numero de Departamento
				    	if (numid==nie) {
					    	String nombre= elemento.getElementsByTagName("nombre").item(0).getTextContent();
					    	String apellido1= elemento.getElementsByTagName("APELLIDO1").item(0).getTextContent();
					    	String apellido2=elemento.getElementsByTagName("APELLIDO2").item(0).getTextContent();
					    	alumno=new Alumno();
					    	alumno.setNie(nie);
					    	alumno.setNombre(nombre);
					    	alumno.setApellido1(apellido1);
					    	alumno.setApellido2(apellido2);
					    	
				    	}
					}
				}
				
				return departamento;
			}
	}

}
}
