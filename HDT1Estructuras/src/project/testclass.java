package project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testclass {
	@Test
	public void changeAmToFm() {
		Radio myRadio = new Radio();
		assertEquals("AM", myRadio.changeAmFm());
	}
	
	@Test
	public void changeToNextStation() {
		Radio myRadio = new Radio();
		assertEquals("Encendido", myRadio.changeStatusRadio());
	}
	
	@Test
	public void saveStationFM() {
		Radio myRadio = new Radio();
		assertEquals("87.90 FM", myRadio.saveStationFm(1) );
	}
	
	@Test
	public void saveStationAM() {
		Radio myRadio = new Radio();
		assertEquals("530.00 AM", myRadio.saveStationAm(1) );
	}
}
