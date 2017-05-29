package sb.junit.cases;

import static org.junit.Assert.*;

import org.junit.Test;

import sb.exception.DateIsNotValidExc;
import sb.exception.HourIsNotValidExc;
import sb.exception.PlateIsNotValidExc;
import sb.util.PicoPlacaPredictor;

public class ValidInputsTest {
	
	@Test
	public void testValidPlate(){
		try {
			PicoPlacaPredictor predictor = new PicoPlacaPredictor("LBB-2203", "30/05/2017", "07:35");
			fail("Se esperaba PlateIsNotValidExc");
		} catch (PlateIsNotValidExc e){ 
			e.printStackTrace();
		} catch (DateIsNotValidExc e) {
			e.printStackTrace();
		} catch (HourIsNotValidExc e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testValidDate(){		
		try {
			PicoPlacaPredictor predictor = new PicoPlacaPredictor("LBB-223", "30/15/2017", "07:35");
			fail("Se esperaba DateIsNotValidExc");
		} catch (PlateIsNotValidExc e){ 
			e.printStackTrace();
		} catch (DateIsNotValidExc e) {
			e.printStackTrace();
		} catch (HourIsNotValidExc e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testValidHour(){
		try {
			PicoPlacaPredictor predictor = new PicoPlacaPredictor("LBB-223", "30/01/2017", "07:85");
			fail("Se esperaba HourIsNotValidExc");
		} catch (PlateIsNotValidExc e){ 
			e.printStackTrace();
		} catch (DateIsNotValidExc e) {
			e.printStackTrace();
		} catch (HourIsNotValidExc e) {
			e.printStackTrace();
		}
	}	
}
