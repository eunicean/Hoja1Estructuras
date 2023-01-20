package project;

/**
 *
 * @author Michelle
 */
public interface IRadio {
	/***
	 * Este metodo enciende / Apaga el dispositivo, recibe una variable booleana
	 * que tiene el estado actual del dispositivo
	 * @param el estado
	 * @return mensaje de apagado o encendido
	 */
	public String changeStatusRadio();
	
	/***
	 * Este metodo cambia a la siguiente estacion.
	 * @param indice actual en la lista
	 * @return mensaje del cambio
	 */
	public String nextStation();
	
	/***
	 * Este metodo cambia a la estacion anterior.
	 * @param indice actual en la lista
	 * @return mensaje del cambio
	 */
	public String prevStation();
	
	/***
	 * Este metodo guarda la estaion FM
	 * @param boton (numero del 1 al 6) donde se desea guardar la estacion
	 * @return nombre de la estacion
	 */
	public String saveStationFm(int id);
	
	/***
	 * Este metodo guarda la estaion AM
	 * @param boton (numero del 1 al 6) donde se desea guardar la estacion
	 * @return nombre de la estacion
	 */
	public String saveStationAm(int id);
	
	/***
	 * Este metodo permite subir el volumen hasta 30
	 * @return mensaje del cambio
	 */
	public String upVolume();
	
	/***
	 * Este metodo permite bajar el volumen hasta 0
	 * @return mensaje del cambio
	 */
	public String downVolume();
	
}