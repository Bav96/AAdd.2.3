package iestetuan.bav.dao.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.iestetuan.dam2.utilidades.GestorConfiguracion;
import iestetuan.bav.dam.dao.IAlumno;
import iestetuan.bav.dam.utilidades.Gestordeconfiguracion;
import iestetuan.bav.vo.Alumno;

public class implementacionxml implements IAlumno {

	




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
		String rutaxml = Gestordeconfiguracion.getInfoConfiguracion("rutaxml");
		File fichero = new File (rutaxml);
		Document documento = null;
		
		try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  documento = dBuilder.parse(fichero);
			  documento.getDocumentElement().normalize();
			} catch(Exception e) {
			  e.printStackTrace();
		}
		NodeList nListIni = documento.getElementsByTagName("Alumno");
		System.out.println("Nº de alumnos: " + nListIni.getLength());
		boolean existeAlumno=false;
		Element departamentoABorrar=null;
		for(int temp = 0; temp < nListIni.getLength(); temp++) {
			Node nNode = nListIni.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			    Element elemento = (Element) nNode;
		    	String numeroid= elemento.getElementsByTagName("id").item(0).getTextContent();
		    	// Departamento a borrar
				if(Integer.parseInt(numeroid)==id_alumno) {
					existeAlumno= true;
					departamentoABorrar=elemento;
					break;
				}			
			}
		}
		// Se boorra el nodo.
		if(existeAlumno) {
			Element departamentos = documento.getDocumentElement(); // should be <departamentos>
			departamentos.removeChild(departamentoABorrar);
	
			documento.normalize();
			guardarInformacionFicheroXML(documento);						
		}
	}
		
	
	@Override
	public void modificarAlumno(Alumno alumno) {
		String rutaxml = Gestordeconfiguracion.getInfoConfiguracion("rutaxml");
		File fichero = new File (rutaxml);
		Document documento = null;
		try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  documento = dBuilder.parse(fichero);
			  documento.getDocumentElement().normalize();
			} catch(Exception e) {
			  e.printStackTrace();
		}
		
		NodeList nListIni = documento.getElementsByTagName("Alumno");
		System.out.println("Nº de alumnos: " + nListIni.getLength());
		boolean existeAlumno=false;
		for(int temp = 0; temp < nListIni.getLength(); temp++) {
			Node nNode = nListIni.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			    Element elemento = (Element) nNode;
		    	String numeroid= elemento.getElementsByTagName("id").item(0).getTextContent();
		    	// Se modifican los valores en caso
				if(Integer.parseInt(numeroid)==alumno.getNie()) {
					elemento.getElementsByTagName("nombre").item(0).setTextContent(alumno.getNombre());
					elemento.getElementsByTagName("apellido1").item(0).setTextContent(alumno.getApellido1());
					elemento.getElementsByTagName("apellido2").item(0).setTextContent(alumno.getApellido2());
					
					
					existeAlumno= true;
					break;
				}			
			}
		}

		// Solo se guarda la información si existía un departamento. Si no, se deja como estaba( no ha habido modificación).
		if(existeAlumno) {
			guardarInformacionFicheroXML(documento);		
		}
		
	}

		
	
	

	@Override
	public List<Alumno> obtenerlistaalumno() {
		List<Alumno> listaAlumnos= null;
		Alumno alumnos =null;
		String rutaxml = Gestordeconfiguracion.getInfoConfiguracion("rutaxml");
		File fichero = new File (rutaxml);
		
		
		Document documento = null;
		try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  documento = dBuilder.parse(fichero);
			  documento.getDocumentElement().normalize();
			} catch(Exception e) {
			  e.printStackTrace();
		}
		
		NodeList nListIni = documento.getElementsByTagName("Alumno");
		System.out.println("Nº de Alumnos: " + nListIni.getLength());
		if (nListIni.getLength() > 0){
			listaAlumnos= new ArrayList<Alumno>();
		}
		for(int temp = 0; temp < nListIni.getLength(); temp++) {
			Node nNode = nListIni.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			    Element elemento = (Element) nNode;
			    String id= elemento.getElementsByTagName("id").item(0).getTextContent();
			    String nombre= elemento.getElementsByTagName("nombre").item(0).getTextContent();
		    	String apellido1= elemento.getElementsByTagName("apellido1").item(0).getTextContent();
		    	String apellido2=elemento.getElementsByTagName("apellido2").item(0).getTextContent();
		    	alumnos=new Alumno();
		    	alumnos.setNie(Integer.parseInt(id));
		    	alumnos.setNombre(nombre);
		    	alumnos.setApellido1(apellido1);
		    	alumnos.setApellido2(apellido2);
		    	
		    	listaAlumnos.add(alumnos);
			}
		}
		
		return listaAlumnos;
	}





	

	@Override
	public Alumno getAlumno(int nie) {
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
				
				NodeList nListIni = documento.getElementsByTagName("Alumno");
				System.out.println("Numero de alumnos: " + nListIni.getLength());
				for(int temp = 0; temp < nListIni.getLength(); temp++) {
					Node nNode = nListIni.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					    Element elemento = (Element) nNode;
				    	String id= elemento.getElementsByTagName("id").item(0).getTextContent();
				    	int numid=Integer.parseInt(id);
				    	// Se guardan el departamento que contienen el mismo numero de Departamento
				    	if (numid==nie) {
					    	String nombre= elemento.getElementsByTagName("nombre").item(0).getTextContent();
					    	String apellido1= elemento.getElementsByTagName("apellido1").item(0).getTextContent();
					    	String apellido2=elemento.getElementsByTagName("apellido2").item(0).getTextContent();
					    	alumno=new Alumno();
					    	alumno.setNombre(nombre);
					    	alumno.setApellido1(apellido1);
					    	alumno.setApellido2(apellido2);
					    	
				    	}
					}
				}
				
				return alumno;
			}
	
	public   static void guardarInformacionFicheroXML(Document documento) {
		try {
			documento.normalize();
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			String rutaOrigen = "C:\\Users\\Borja\\Downloads\\alumnos-dam2-inicial.xml";
			Result output = new StreamResult(new File(rutaOrigen));
			Source input = new DOMSource(documento);
			transformer.transform(input, output);
		} catch(Exception e) {
			  e.printStackTrace();
		}		
	}
}

