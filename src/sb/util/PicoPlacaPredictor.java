package sb.util;

import sb.exception.DateIsNotValidExc;
import sb.exception.HourIsNotValidExc;
import sb.exception.PlateIsNotValidExc;
import sb.inputs.CustomDate;
import sb.inputs.Hour;
import sb.inputs.Plate;

public class PicoPlacaPredictor {
	
	private String plateNumber;
	private String datestr;
	private String timestr;
	
	private Plate plate;
	private CustomDate date;
	private Hour hour;	
	
	public PicoPlacaPredictor(String plateNumber, String date, String time) throws PlateIsNotValidExc, DateIsNotValidExc, HourIsNotValidExc{		
		this.plateNumber = plateNumber;
		this.datestr = date;
		this.timestr = time;		
		this.processInputs();
	}
	
	private void processInputs() throws PlateIsNotValidExc, DateIsNotValidExc, HourIsNotValidExc{
		this.plate = new Plate(this.plateNumber);
		this.date = new CustomDate(this.datestr);
		this.hour = new Hour(this.timestr);
	}
	
	/**
	 * Verifica si un automovil, se encuentra en horario de pico y placa
	 * @return
	 */
	public boolean testPicoPlaca(){
		boolean isInPicoPlaca = false;
		//Primero verificamos el dia
		isInPicoPlaca = this.plate.isInPicoPlaca(this.date.getDate());
		if (isInPicoPlaca){
			//Si conicide el dia, verificamos entonces la hora			
			isInPicoPlaca = this.hour.isInPicoPlaca();
		}
		return isInPicoPlaca;
	}
}