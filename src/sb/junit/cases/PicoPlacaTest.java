package sb.junit.cases;

import static org.junit.Assert.*;

import org.junit.Test;

import sb.exception.DateIsNotValidExc;
import sb.exception.HourIsNotValidExc;
import sb.exception.PlateIsNotValidExc;
import sb.util.PicoPlacaPredictor;

public class PicoPlacaTest {

	@Test
	public void testMondayTrue() throws PlateIsNotValidExc, DateIsNotValidExc, HourIsNotValidExc {		
		boolean resultadoEsperado = true;		
		PicoPlacaPredictor predictor = new PicoPlacaPredictor("ABC-111", "29/05/2017", "08:35");
		boolean resultadoReal =  predictor.testPicoPlaca();
		assertEquals(resultadoEsperado, resultadoReal);		
	}
	
	@Test
	public void testMondayFalse() throws PlateIsNotValidExc, DateIsNotValidExc, HourIsNotValidExc{		
		boolean resultadoEsperado = false;		
		PicoPlacaPredictor predictor = new PicoPlacaPredictor("LBB-220", "30/05/2017", "07:35");
		boolean resultadoReal =  predictor.testPicoPlaca();
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	@Test
	public void testTuesdayTrue() throws PlateIsNotValidExc, DateIsNotValidExc, HourIsNotValidExc{		
		boolean resultadoEsperado = true;		
		PicoPlacaPredictor predictor = new PicoPlacaPredictor("ABC-114", "30/05/2017", "08:31");
		boolean resultadoReal =  predictor.testPicoPlaca();
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	@Test
	public void testWednesdayTrue() throws PlateIsNotValidExc, DateIsNotValidExc, HourIsNotValidExc{		
		boolean resultadoEsperado = true;		
		PicoPlacaPredictor predictor = new PicoPlacaPredictor("ABC-115", "31/05/2017", "7:45");
		boolean resultadoReal =  predictor.testPicoPlaca();
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	@Test
	public void testThursdayTrue() throws PlateIsNotValidExc, DateIsNotValidExc, HourIsNotValidExc{		
		boolean resultadoEsperado = true;		
		PicoPlacaPredictor predictor = new PicoPlacaPredictor("ABC-118", "01/06/2017", "9:00");
		boolean resultadoReal =  predictor.testPicoPlaca();
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	@Test
	public void testFridayTrue() throws PlateIsNotValidExc, DateIsNotValidExc, HourIsNotValidExc{		
		boolean resultadoEsperado = true;		
		PicoPlacaPredictor predictor = new PicoPlacaPredictor("ABC-110", "02/06/2017", "08:10");
		boolean resultadoReal =  predictor.testPicoPlaca();
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
	@Test
	public void testWeekendFalse() throws PlateIsNotValidExc, DateIsNotValidExc, HourIsNotValidExc{		
		boolean resultadoEsperado = false;		
		PicoPlacaPredictor predictor = new PicoPlacaPredictor("ABC-110", "03/06/2017", "09:12");
		boolean resultadoReal =  predictor.testPicoPlaca();
		assertEquals(resultadoEsperado, resultadoReal);
	}
	
}
