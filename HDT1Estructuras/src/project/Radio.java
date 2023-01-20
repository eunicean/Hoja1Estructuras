/**
 * Universidad del Valle de Guatemala
 * Hoja de trabajo 1-Radio. Algoritmos y Estructuras de datos 
 * Irving Morales-22781, Ricardo Chuy-221007, Eunice Mata 
 * The objective of this code is to simulate a car radio with its basic functions
 */

package project;
import java.util.*;
import java.text.DecimalFormat;

public class Radio implements IRadio{
	//attributes
	private boolean status;
	private String AmFm;
	private double AMfrequency;
	private double FMfrequency;
	private ArrayList<Double> AMbuttons;
	private ArrayList<Double> FMbuttons;
	private int volumen;
	
	//attribute for format
	private static final DecimalFormat df = new DecimalFormat("0.0");
	
	//constructor
	public Radio() {
		this.status = false;
		AmFm = "FM";
		AMfrequency = 530.0d;
		FMfrequency = 87.9d;
		AMbuttons = new ArrayList<Double>();
		FMbuttons = new ArrayList<Double>();
		this.volumen = 0;
		
		for(int i=0;i<6;i++) {
			AMbuttons.add(0.0d);
			FMbuttons.add(0.0d);
		}
	}

	
	/** 
	 * @return boolean
	 */
	//setters and getters
	public boolean isStatus() {
		return status;
	}

	
	/** 
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	
	/** 
	 * @return String
	 */
	public String getAmFm() {
		return AmFm;
	}

	
	/** 
	 * @param amFm
	 */
	public void setAmFm(String amFm) {
		AmFm = amFm;
	}

	
	/** 
	 * @return double
	 */
	public double getAMfrequency() {
		return AMfrequency;
	}

	
	/** 
	 * @param aMfrequency
	 */
	public void setAMfrequency(double aMfrequency) {
		AMfrequency = aMfrequency;
	}

	
	/** 
	 * @return double
	 */
	public double getFMfrequency() {
		return FMfrequency;
	}

	
	/** 
	 * @param fMfrequency
	 */
	public void setFMfrequency(double fMfrequency) {
		FMfrequency = fMfrequency;
	}

	
	/** 
	 * @return ArrayList<Double>
	 */
	public ArrayList<Double> getAMbuttons() {
		return AMbuttons;
	}

	
	/** 
	 * @param aMbuttons
	 */
	public void setAMbuttons(ArrayList<Double> aMbuttons) {
		AMbuttons = aMbuttons;
	}

	
	/** 
	 * @return ArrayList<Double>
	 */
	public ArrayList<Double> getFMbuttons() {
		return FMbuttons;
	}

	
	/** 
	 * @param fMbuttons
	 */
	public void setFMbuttons(ArrayList<Double> fMbuttons) {
		FMbuttons = fMbuttons;
	}

	
	/** 
	 * @return int
	 */
	public int getVolumen() {
		return volumen;
	}

	
	/** 
	 * @param volumen
	 */
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	
	/** Cambia el estado de a radio
	 * @return String. El estado de la radio (encendido/apagado)
	 */
	//methods from the interface 
	@Override
	public String changeStatusRadio() {
		String r = "";
		if(isStatus() == false) {
			setStatus(true);
			r = "Encendido";
		}
		else {
			setStatus(false);
			r = "Apagado";
		}
		return r;
	}

	
	/** Cambia la frecuencia de la radio
	 * @return String. La frecuencia en la que se encuentra el radio (AM/FM)
	 */
	
	public String changeAmFm() {
		String r = "";
		if(getAmFm() == "AM") {
			setAmFm("FM");
			r = "FM";
		}
		else if(getAmFm() == "FM"){
			setAmFm("AM");
			r = "AM";
		}
		return r;
	}

	
	/** 
	 * @return String
	 */
	@Override
	public String prevStation() {
		// method no needed
		return null;
	}

	
	/** Avanza a la siguiente estación de la radio 
	 * @return String. La nueva estacion en la que se encuentra la radio y su frecuencia
	 */
	@Override
	public String nextStation() {
		String r = "";
		if(getAmFm() == "AM") {
			if(getAMfrequency() < 1610.0) {
				setAMfrequency(getAMfrequency() + 10.0);
			}
			else {
				setAMfrequency(510.0);
			}
			r = String.format("%.0f", getAMfrequency()) + " AM";
		}
		else if(getAmFm() == "FM"){
			if(getFMfrequency() < 107.9) {
				setFMfrequency(getFMfrequency() + 0.2);
			}
			else {
				setFMfrequency(87.9);
			}
			r = String.format("%.2f", getFMfrequency()) + " FM";
		}
		return r;
	}

	
	/** Sube el volumen de la radio 
	 * @return String. No retorna nada
	 */
	@Override
	public String upVolume() {
		// Method not needed
		return null;
	}

	
	/** Baja el volumen de la radio
	 * @return String
	 */
	@Override
	public String downVolume() {
		// Method not needed
		return null;
	}
	
	
	/** Regresa a la estacion guardada que el usuario seleccione
	 * @param num. El numero de boton en la que esa guardad la estación que el usuario dese cargar
	 * @return String. La nueva estacion en la que se encuentra la radio y su frecuencia
	 */
	
	public String selectFrequency(int num) {
		String r = "Se cargo la emisora: ";
		if(getAmFm() == "AM"){
			if(AMbuttons.get(num-1) == 0.00) {
				r = "Boton no tiene frecuencia guardada";
			}
			else {
				setAMfrequency(AMbuttons.get(num-1));
				r = r + String.format("%.0f", AMbuttons.get(num-1)) + " AM";
			}
		}
		else if(getAmFm() == "FM"){
			if(FMbuttons.get(num-1) == 0.00) {
				r = "Boton no tiene frecuencia guardada";
			}
			else {
				setFMfrequency(FMbuttons.get(num-1));
				r = r + String.format("%.2f", FMbuttons.get(num-1)) + " FM";
			}
		}
		return r;
	}

	
	/** Guarda la estacion actual en el boton que el usuario seleccione
	 * @param num. 
	 * @return String. Espacio en blanco
	 */
	
	public String saveFrequency(int num) {
		String r = "";
		if(getAmFm() == "AM"){
			r = saveStationAm((num-1));
		}
		else if(getAmFm() == "FM"){
			r = saveStationFm((num-1));
		}
		return r;
	}

	
	/** Guarda la estacion (de FM) actual en el boton que el usuario seleccione
	 * @param id El numero de boton en el que el usuario desea guardar la estacion
	 * @return String
	 */
	@Override
	public String saveStationFm(int id) {
		FMbuttons.set(id, getFMfrequency());
		String r = String.format("%.2f", getFMfrequency()) + " FM";
		return r;
	}

	
	/** Guarda la estacion actual (de AM) en el boton que el usuario seleccione
	 * @param id. El numero de boton en el que el usuario desea guardar la estacion
	 * @return String
	 */
	@Override
	public String saveStationAm(int id) {
		AMbuttons.set(id, getAMfrequency());
		String r = String.format("%.0f", getAMfrequency()) + " AM";
		return r;
	}

	//method from the object
	/**
	 * Muestra la lista de botones para que el usuario guarde una estacion
	 * @return. La lista de botones 
	 */
	public String printListButtons() {
		String r = "";
		
		if(getAmFm() == "AM"){
			r = r + "Botones AM\n";
			for(int i = 0;i<6;i++) {
				r = r + " " + (i+1) + ". " + String.format("%.0f", AMbuttons.get(i)) + "\n";
			}
		}
		else if(getAmFm() == "FM"){
			r = r + "Botones FM\n";
			for(int i = 0;i<6;i++) {
				r = r + " " + (i+1) + ". " + String.format("%.2f", FMbuttons.get(i)) + "\n";
			}
		}
		return r;
	}
	
	
}
