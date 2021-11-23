package iestetuan.bav.dam.dao;

import java.util.List;

import iestetuan.bav.vo.*;

public interface IAlumno {
	
	Alumno getAlumno(int nie);
	public void  crearAlumno( Alumno alumno);
	public Alumno consultarAlumno(int id_alumno );
	public void borrarAlumno(int id_alumno );
	public void modificarAlumno(Alumno alumno);
	public List<Alumno> obtenerlistaalumno();
}
