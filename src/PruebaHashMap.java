import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class Alumno{
	private String nombre;
	private int edad;
	private String carrera;
	private String fecha;
	
	public Alumno(String nombre, int edad, String carrera, String fecha) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.carrera = carrera;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", carrera=" + carrera + ", fecha=" + fecha + "]";
	}
	
	
	
}

public class PruebaHashMap {
	public static void main(String[] args) {
		int opcion = 0;
		Scanner entrada = new Scanner(System.in);
		HashMap<Integer, Alumno> mapAlumnos = new HashMap<>();
		
		/*
		for (int i = 0; i < 5; i++) {
			 String nombre = "Madeline";
			 int edad = 20;
			 String carrera = "ISC";
			 String fecha = "06/08/2016";
			 mapAlumnos.put(i, new Alumno(nombre, edad, carrera, fecha)); 
		}*/
		
		for (Entry<Integer, Alumno> alumno : mapAlumnos.entrySet()) {
		    System.out.println("Key = " + alumno.getKey() + ", Value = " + alumno.getValue());
		}
		
		do {
			System.out.println("\nElige una de las siguientes opciones");
			System.out.println("1) Llenar lista (llenar el HashMap)");
			System.out.println("2) Vaciar lista");
			System.out.println("3) Mostrar los alumnos por carrera");
			System.out.println("4) Calcular Promedio de edades");
			System.out.println("5) Mostrar los alumnos que se inscribieron después de la fecha indicada (10/08/2016)");
			System.out.println("6) Salir");
			//System.out.println("7) imprimir toda la lista");
			System.out.print("Introduce opcion: ");
			opcion = entrada.nextInt();
			
			switch (opcion) {
			case 1:
				for (int i = 0; i < 5; i++) {
					System.out.println("\nIntroduce datos de alumno " + (mapAlumnos.size()+1) + ": ");
					System.out.println("Nombre: ");
					String nombre = entrada.next();
					System.out.println("Edad: ");
					int edad = entrada.nextInt();
					System.out.println("Carrera: ");
					String carrera = entrada.next().toUpperCase();
					System.out.println("Fecha de inscripcion (formato: dd/mm/aaaa): ");
					String fecha = entrada.next();
					mapAlumnos.put(mapAlumnos.size()+1, new Alumno(nombre, edad, carrera, fecha)); 
				}
				break;
			case 2:
				mapAlumnos.clear();
				System.out.println("\n>> Lista vaciada correctamente");
				break;
			case 3:
				System.out.println(">> Introduce carrera a mostrar: ");
				String carreraRequerida = entrada.next().toUpperCase();
				if (mapAlumnos.isEmpty()) {
					System.out.println("\n>> no existen alumnos registrados");
				}else {
					System.out.println("\nAlumnos de la carrera " + carreraRequerida + ": ");
					for (Entry<Integer, Alumno> alumno : mapAlumnos.entrySet()) {
						String carreraMostrar = ((Alumno)alumno.getValue()).getCarrera();
						if (carreraMostrar.equals(carreraRequerida)) {
							System.out.println(alumno.getValue());
						}
					}
				}
				break;
			case 4:
				int suma = 0;
				if (mapAlumnos.isEmpty()) {
					System.out.println("\n>> no existen alumnos registrados");
				}else {
					
					for (Entry<Integer, Alumno> alumno : mapAlumnos.entrySet()) {
					    suma += (alumno.getValue()).getEdad();
					}
					System.out.println("\nPromedio de edades: " + (suma/mapAlumnos.size()));
				}
				
				break;
			case 5:
				if (mapAlumnos.isEmpty()) {
					System.out.println("\n>> no existen alumnos registrados");
				}else {
					System.out.println("\n>> Alumnos inscritos despues del 10/08/2016: ");
					int dia = 10, mes = 8, año = 2016;
					for (Entry<Integer, Alumno> alumno : mapAlumnos.entrySet()) {
					    String [] fechaStrings = (alumno.getValue()).getFecha().split("/");
					    int diaAlumno = Integer.parseInt(fechaStrings[0]);
					    int mesAlumno = Integer.parseInt(fechaStrings[1]);
					    int añoAlumno = Integer.parseInt(fechaStrings[2]);
					    
					    if (añoAlumno > año) {
					    	System.out.println(alumno.getValue());
					    	continue;
					    } else if (añoAlumno < año){
					    	continue;
					    }
					    
					    
					    if (mesAlumno > mes) {
					    	System.out.println(alumno.getValue());
					    	continue;
					    } else if (mesAlumno < mes) {
					    	continue;
					    }
					    
					    if (diaAlumno > dia) {
					    	System.out.println(alumno.getValue());
					    } else {
					    	
					    }
					}
				}
				break;
			case 6:
				System.out.println("Saliendo . . . ");
				break;
			/*
			case 7:
				for (Entry<Integer, Alumno> alumno : mapAlumnos.entrySet()) {
				    System.out.println("Key = " + alumno.getKey() + ", Value = " + alumno.getValue());
				}
				break;
			*/
			default:
				System.out.println("\n>> Opcion incorrecta");
				break;
			}
		}while(opcion != 6);
	}
}
