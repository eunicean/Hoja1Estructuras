/**
 * Universidad del Valle de Guatemala
 * Hoja de trabajo 1-Radio. Algoritmos y Estructuras de datos 
 * Irving Morales-22781, Ricardo Chuy-221007, Eunice Mata 
 * The objective of this code is to simulate a car radio with its basic functions
 */

package project;

public interface radioFunctions {
    
    public String changeStatusRadio();
    
    public String changeAmFm();
    
    public String prevStation();
    
    public String nextStation();
    
    public String upVolume();
    
    public String downVolume();
    
    public String selectFrequency(int num);
    
    public String saveFrequency(int num);
    
    public String saveStationFm(int id);
    
    public String saveStationAm(int id);

}
