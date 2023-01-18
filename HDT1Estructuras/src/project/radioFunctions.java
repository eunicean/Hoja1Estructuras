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
