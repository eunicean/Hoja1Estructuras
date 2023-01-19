package project;
import java.util.*;
import java.text.DecimalFormat;

public class Radio implements radioFunctions{
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

	//setters and getters
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAmFm() {
		return AmFm;
	}

	public void setAmFm(String amFm) {
		AmFm = amFm;
	}

	public double getAMfrequency() {
		return AMfrequency;
	}

	public void setAMfrequency(double aMfrequency) {
		AMfrequency = aMfrequency;
	}

	public double getFMfrequency() {
		return FMfrequency;
	}

	public void setFMfrequency(double fMfrequency) {
		FMfrequency = fMfrequency;
	}

	public ArrayList<Double> getAMbuttons() {
		return AMbuttons;
	}

	public void setAMbuttons(ArrayList<Double> aMbuttons) {
		AMbuttons = aMbuttons;
	}

	public ArrayList<Double> getFMbuttons() {
		return FMbuttons;
	}

	public void setFMbuttons(ArrayList<Double> fMbuttons) {
		FMbuttons = fMbuttons;
	}

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

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

	@Override
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

	@Override
	public String prevStation() {
		// method no needed
		return null;
	}

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

	@Override
	public String upVolume() {
		// Method not needed
		return null;
	}

	@Override
	public String downVolume() {
		// Method not needed
		return null;
	}
	
	@Override
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

	@Override
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

	@Override
	public String saveStationFm(int id) {
		FMbuttons.set(id, getFMfrequency());
		String r = String.format("%.2f", getFMfrequency()) + " FM";
		return r;
	}

	@Override
	public String saveStationAm(int id) {
		AMbuttons.set(id, getAMfrequency());
		String r = String.format("%.0f", getAMfrequency()) + " AM";
		return r;
	}

	//method from the object
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
