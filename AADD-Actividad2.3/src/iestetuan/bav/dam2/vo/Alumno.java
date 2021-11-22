package iestetuan.bav.dam2.vo;

public class Alumno {
	
	
		private int numeroAlumno;
		private String nombreAlumno;
		private String Apellido1;
		private String apellido2;
		
		

		public Alumno(String nie, String nombre, String apellido, String apellido22, String string) {
			// TODO Auto-generated constructor stub
		}


		public int getNumeroAlumno() {
			return numeroAlumno;
		}


		public void setNumeroAlumno(int numeroAlumno) {
			this.numeroAlumno = numeroAlumno;
		}


		public String getNombreAlumno() {
			return nombreAlumno;
		}


		public void setNombreAlumno(String nombreAlumno) {
			this.nombreAlumno = nombreAlumno;
		}


		public String getApellido1() {
			return Apellido1;
		}


		public void setApellido1(String apellido1) {
			Apellido1 = apellido1;
		}


		public String getApellido2() {
			return apellido2;
		}


		public void setApellido2(String apellido2) {
			this.apellido2 = apellido2;
		}


		
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Número de Alumno: " + numeroAlumno + " Nombre de Alumno: " + nombreAlumno + " Apellido1: " + Apellido1 + "Apellido2"+ apellido2;
		}
	}


