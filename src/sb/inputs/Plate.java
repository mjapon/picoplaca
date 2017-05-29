package sb.inputs;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import sb.exception.PlateIsNotValidExc;
import sb.util.Ctes;

public class Plate extends UserInput {
	
	private String plateNumber;
	private Boolean isValid;
	private int lastdigit;
	
	public Plate(String plateNumber) throws PlateIsNotValidExc{
		String msgError ="El numero de placa no es correcto, debe estar en el formato AAA-999";		
		if (this.isNotEmptyNull(plateNumber)){
			this.isValid = this.validate(plateNumber);
			if (!this.isValid){
				throw new PlateIsNotValidExc(msgError);
			}			
			this.proccessPlate(plateNumber);
		}
		else{
			throw new PlateIsNotValidExc(msgError);
		}		
	}
	
	@Override
	protected boolean validate(String plateNumber){
		String thePattern = "(\\D{3})-(\\d{3})";
		return this.checkPattern(thePattern, plateNumber);        
	}	
	
	private void proccessPlate(String plate){
		String lastdigitstr = plate.substring(plate.length()-1);
        this.lastdigit = Integer.valueOf(lastdigitstr);
	}
	
	public String getPlateNumber(){
		return this.plateNumber;
	}
	
	public Boolean isValid(){
		return this.isValid;
	}	
	
	public boolean isInPicoPlaca(Date date){
		Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        
        boolean isInPicoPlaca = false;

        //Proceso de validacion del utlimo digito
        Integer[] lastDigitPermited =  Ctes.LASTDIGIT_DAY_MAP.get(dayOfWeek);
        if (lastDigitPermited != null){
        	isInPicoPlaca = Arrays.asList(lastDigitPermited).contains(this.lastdigit);
        }
        
        return isInPicoPlaca;
	}
}