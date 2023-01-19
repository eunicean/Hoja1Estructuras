package project;
import java.util.Scanner;
public class myRadio {

	public static void main(String[] args) {
		
		Radio MyRadio = new Radio();
		Scanner scan = new Scanner(System.in);
		String option;
		int selectedButton;
		
		System.out.println("Bienvenido al simulador de Radio ");
		while(true) {
			String radStatus = " Radio: ";
			if(MyRadio.getAmFm()=="AM") {
				radStatus = radStatus + String.format("%.0f", MyRadio.getAMfrequency()) + " AM";
			}
			else if(MyRadio.getAmFm()=="FM"){
				radStatus = radStatus + String.format("%.2f", MyRadio.getFMfrequency()) + " FM";
			}
			
			System.out.println();
			System.out.println("-----------------------------");
			System.out.println(radStatus);
			System.out.println("-----------------------------");
			System.out.println();
			System.out.println("Ingrese el numero de la opcion que desea realizar");
			System.out.println("\n1.Encender el radio\n"
				         	+ "2.Cambiar tipo de frecuencia\n"
				         	+ "3.Avanzar a la siguiente Emisora\n"
				         	+ "4.Guardar emisora actual en un boton\n"
				         	+ "5.Elegir la emisora de un boton\n"
				         	+ "6.Apagar el radio\n");
		
			option = "" + scan.nextLine();
			System.out.println();
			if(option.equals("1")) {
				System.out.println("Se cambio el status a: " + MyRadio.changeStatusRadio() + "\n");
			}
			
			if(MyRadio.isStatus() == false) {
				System.out.println("+-----------------------------+");
				System.out.println("| Radio aun no está encendida |");
				System.out.println("+-----------------------------+");
			}
			else {
				if(option.equals("2")) {
					
					System.out.println("Se cambia a la frecuencia: " + MyRadio.changeAmFm(  ) + "\n");
				}

				if(option.equals("3")) {
					System.out.println("Se avanzo a la emisora: " + MyRadio.nextStation() + "\n");
				}
				
				if(option.equals("4")) {
					System.out.println(MyRadio.printListButtons());
					System.out.println("Escribe el numero de boton en el que se guardara la emisora (1-6)");
					selectedButton = scan.nextInt();
					System.out.println("Se guardo la emisora:" + MyRadio.saveFrequency(selectedButton) + "\n");
				}
		
				if(option.equals("5")) {
					System.out.println(MyRadio.printListButtons());
					System.out.println("\"Escribe el numero de boton del cual deseas cargar la emisora (1-6)");
					selectedButton = scan.nextInt();
					System.out.println(MyRadio.selectFrequency(selectedButton) + "\n");
				}
			
				if(option.equals("6")) {
					System.out.println("Se cambio el status a: " + MyRadio.changeStatusRadio() + "\n");
				}
			}
			
			
		}
		

	}

}
