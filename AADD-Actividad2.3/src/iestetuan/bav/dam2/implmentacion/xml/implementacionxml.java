package iestetuan.bav.dam2.implmentacion.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
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
import org.w3c.dom.Text;

import es.iestetuan.dam2.dao.xml.Departamento;
import iestetuan.bav.dam2.dao.IAlumno;
import iestetuan.bav.dam2.utilidades.GestorConfiguracion;
import iestetuan.bav.dam2.vo.Alumno;



public class implementacionxml implements IAlumno{

	@Override
	public Alumno Consultaralumno(int id) {
		Alumno alumnos = null;
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
		// Se obtiene la lista de nodos relacionado con 'alumno'
		NodeList nListIni = documento.getElementsByTagName("alumno");
		System.out.println("id de alumno: " + nListIni.getLength());
		for(int temp = 0; temp < nListIni.getLength(); temp++) {
			Node nNode = nListIni.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			    Element elemento = (Element) nNode;
		    	String numeroid= elemento.getElementsByTagName("id").item(0).getTextContent();
		    	int numid=Integer.parseInt(numeroid);
		    	
		    	if (numid==id) {
			    	String nombreAlumno= elemento.getElementsByTagName("nombre").item(0).getTextContent();
			    	String apellido1= elemento.getElementsByTagName("apellido1").item(0).getTextContent();
			    	String apellido2= elemento.getElementsByTagName("apellido1").item(0).getTextContent();
			    	alumnos =new Alumno();
			    	alumnos.setNombreAlumno(nombreAlumno);
			    	alumnos.setApellido1(apellido1);
			    	alumnos.setApellido2(apellido2);
		    	}
			}
		}
		
		return alumnos;
	}


	@Override
	public List<Alumno> Listadealumnos(Alumno alumno) {
		List<Alumno> listaDeAlumnos= null;
		Alumno alumnos =null;
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
		
		NodeList nListIni = documento.getElementsByTagName("alumno");
		System.out.println("Nº de alumnos: " + nListIni.getLength());
		if (nListIni.getLength() > 0){
			listaDeAlumnos= new ArrayList<Alumno>();
		}
		for(int temp = 0; temp < nListIni.getLength(); temp++) {
			Node nNode = nListIni.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			    Element elemento = (Element) nNode;
		    	String nombre= elemento.getElementsByTagName("nombre").item(0).getTextContent();
		    	
		    	if (nombre.contains((CharSequence) alumno)) {
			    	String numeroid= elemento.getElementsByTagName("id").item(0).getTextContent();
			    	String apellido1= elemento.getElementsByTagName("apellido1").item(0).getTextContent();
			    	String apellido2= elemento.getElementsByTagName(apellido2).item(0).getTextContent();
			    	alumnos =new Alumno();
			    	alumnos.setNumeroAlumno(Integer.parseInt(numeroid));
			    	alumnos.setNombreAlumno(nombre);
			    	alumnos.setApellido1(apellido1);
			    	alumnos.setApellido2(apellido2);
			    	listaDeAlumnos.add(alumnos);
		    	}
			}
		}
		
		return listaDeAlumnos;
	}

	

	@Override
	public List<Alumno> consultarAlumno() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		File rutaDondesecreaelxml= new File ("C:\\Users\\Borja\\Downloads\\alumnos-dam2-inicial.xml");
		Document documento = null;
		try {
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newDefaultInstance();
			DocumentBuilder dBuilder = dbfactory.newDocumentBuilder();
			
			//documento = dBuilder.parse(rutaDondesecreaelxml);
			documento = dBuilder.newDocument();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Element raiz = documento.createElement("Alumnos");
		documento.appendChild(raiz);
		Element nodoAlumno = null;
		Element nodoDatos=null;
		Text texto= null;
		for ( Alumno resultadoalumnos :  alumno ) {
			
			nodoAlumno = documento.createElement("Alumno");
			raiz.appendChild(nodoAlumno);
			
			nodoDatos = documento.createElement("id");
			nodoAlumno.appendChild(nodoDatos);
			
			String numeroId = String.valueOf(resultadoalumnos.getNumeroAlumno());
			texto = documento.createTextNode(numeroId);
			nodoDatos.appendChild(texto);
			
			nodoDatos = documento.createElement("nombre");
			nodoAlumno.appendChild(nodoDatos);
			
			String nombre = String.valueOf(resultadoalumnos.getNombreAlumno());
			texto = documento.createTextNode(nombre);
			nodoDatos.appendChild(texto);

			nodoDatos = documento.createElement("apellido1");
			nodoAlumno.appendChild(nodoDatos);
			
			String apellido1 = String.valueOf(resultadoalumnos.getApellido1());
			texto = documento.createTextNode(apellido1);
			nodoDatos.appendChild(texto);
			
			nodoDatos = documento.createElement("apellido2");
			nodoAlumno.appendChild(nodoDatos);
			
			String apellido2 = String.valueOf(resultadoalumnos.getApellido2());
			texto = documento.createTextNode(apellido2);
			nodoDatos.appendChild(texto);

		
		}
		
		documento.normalize();
		
		guardarInformacionFicheroXML(documento);
		
		
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

		
	
public static   List <Alumno> getAlumnos() {
	List <Alumno> todoslosalumnos =new ArrayList<Alumno>();
	File fichero= new File ("C:\\Users\\Borja\\Downloads\\alumnos-dam2-inicial (3).txt");
	FileReader fr;
	BufferedReader br= null;
	String sLinea=null;
	
	boolean primeraVez=true;
	
	try {
	fr = new FileReader (fichero,Charset.forName ("UTF-8"));
	br= new BufferedReader(fr);
	while((sLinea=br.readLine())!=null){
		if (primeraVez) {
			primeraVez=false;
		}else {
			
		//Esta linea recoge toda la informacion leiada entre comas de cada elemneto de nuestro fichero
		String [] partesLinea=sLinea.split(",");
		
		
		//Guardar toda la informacion de cada alumno
		String nie = partesLinea [0];
		String nombre = partesLinea [1];
		String apellido = partesLinea [2];
		String apellido2= "";
		
		if (partesLinea.length==4) {
			apellido2=partesLinea[3];
				
		}
		
		//En este constructor se mete la informacion consegida anteriorme de cada alumno 
		Alumno objetoAlumno =new Alumno(nie, nombre, apellido, apellido2, "");
		
		todoslosalumnos.add(objetoAlumno);
		
		
			
		}
		
		
		
	}
		
		
		
	
	
	
	
	
	
	
	}catch(Exception e) {
		e.printStackTrace();
	}

	return todoslosalumnos;
}
}


	@Override
	public void borrarAlumno(int id) {
		// TODO Auto-generated method stub
		File fichero= new File ("C:\\Users\\Borja\\Downloads\\alumnos-dam2-inicial (3).txt");
		Document documento = null;
		try {
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  documento = dBuilder.parse(fichero);
			  documento.getDocumentElement().normalize();
			} catch(Exception e) {
			  e.printStackTrace();
		}
		
		NodeList nListIni = documento.getElementsByTagName("alumno");
		System.out.println("Nº alumnos: " + nListIni.getLength());
		boolean existeDepartamento=false;
		Element departamentoABorrar=null;
		for(int temp = 0; temp < nListIni.getLength(); temp++) {
			Node nNode = nListIni.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			    Element elemento = (Element) nNode;
		    	String numeroid= elemento.getElementsByTagName("alumno").item(0).getTextContent();
		    	// Departamento a borrar
				if(Integer.parseInt(numeroid)==id) {
					existeDepartamento= true;
					departamentoABorrar=elemento;
					break;
				}			
			}
		}
		// Se boorra el nodo.
		if(existeDepartamento) {
			Element departamentos = documento.getDocumentElement(); // should be <departamentos>
			departamentos.removeChild(departamentoABorrar);
	
			documento.normalize();
			guardarInformacionFicheroXML(documento);						
		}
	}
	}

	@Override
	public void modificarAlumno(int id) {
		// TODO Auto-generated method stub
		
	}
}

	
