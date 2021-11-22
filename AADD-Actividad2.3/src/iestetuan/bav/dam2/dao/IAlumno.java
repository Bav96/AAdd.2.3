package iestetuan.bav.dam2.dao;

import java.util.List;

import iestetuan.bav.dam2.vo.Alumno;

public interface IAlumno {
		public Alumno Consultaralumno (int id);
	
		public   List<Alumno> Listadealumnos (Alumno alumno);
	
	
		public List<Alumno> consultarAlumno();
		public void crearAlumno(Alumno alumno);
		public void borrarAlumno(int id);
		public void modificarAlumno(int id);
	
}
