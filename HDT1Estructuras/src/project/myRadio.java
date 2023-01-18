package project;
import java.util.Scanner;
public class myRadio {

	public static void main(String[] args) {
		
		Radio MyRadio;
		Scanner scan = new Scanner(System.in);
		String option;
		
		while(true) {
			System.out.println("Bienvenido, la Radio actualmente se encuentra: \n"
								+"Con el tipo de Frecuencia                    : \n"
								+"En la Emisora			             :\n");
			
			System.out.println("Ingrese el numero de la opcion que desea realizar");
		
			System.out.println("\n1.Encender el radio\n"
				         	+ "2.Cambiar tipo de frecuencia\n"
				         	+ "3.Avanzar a la siguiente Emisora\n"
				         	+ "4.Guardar emisora actual en un boton\n"
				         	+ "5.Elegir la emisora de un boton\n"
				         	+ "6.Apagar el radio");
		
			option = "" + scan.nextLine();
			
			if(option.equals("1")) {
				System.out.println("Se cambio el status a: " + changeStatusRadio() );
			}
			
			if(option.equals("2")) {
				
				System.out.println("Se cambia a la frecuencia: " + MyRadio.chageFrequency( MyRadio.getAmFm() ) );
			}

			if(option.equals("3")) {
				System.out.println("Se avanzo a la emisora: " + MyRadio.nextStation() );
			}
			
			if(option.equals("4")) {
				System.out.println("12d");
			}
	
			if(option.equals("5")) {
				System.out.println("12e");
			}
			
		
		}
		

	}

}
