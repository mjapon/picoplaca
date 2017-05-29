package sb.inputs;

import java.util.regex.Matcher;

import sb.exception.HourIsNotValidExc;
import sb.util.Ctes;

/**
 * Created by manueljapon on 24/5/17.
 */
public class Hour extends UserInput {

    private int hora;
    private int minuto;
    private String thePattern = "(\\d{1,2})\\:(\\d{2})";
    
    public Hour(String hour) throws HourIsNotValidExc{    	
    	String msgError = "La hora ingresada es incorrecta, debe estar en el formato hh:mm";
    	
    	if (this.isNotEmptyNull(hour)){
			this.isValid = this.validate(hour);
			if (!this.isValid){
				throw new HourIsNotValidExc(msgError);
			}
			this.proccessUserInput(hour);						
		}
		else{
			throw new HourIsNotValidExc(msgError);
		}    	
    }
    
    public Hour(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }
    
    @Override
	protected boolean validate(String userInput) {    	
		return this.checkPattern(thePattern, userInput);
	}
    
    private void proccessUserInput(String hour) throws HourIsNotValidExc{
    	String msgError = "La hora ingresada es incorrecta";
    	Matcher matcher = this.getPatternMatcher(thePattern, hour);
    	if (matcher.find()){
    		this.hora = Integer.valueOf( matcher.group(1) );
    		this.minuto = Integer.valueOf( matcher.group(2) );    		
    		if ((this.hora<0) || (this.hora>24) ){
    			throw new HourIsNotValidExc(msgError);
    		}
    		else if((this.minuto<0)||(this.minuto>60)){
    			throw new HourIsNotValidExc(msgError);
    		}
    	}
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public double getEquivalence(){
        return (this.hora)+ (this.minuto/60.00);
    }
    
    /**
     * Pico y placa en Quito se aplica segun normativa vigente 
     * @return
     */
    public boolean isInPicoPlaca(){
        double equivalence = this.getEquivalence();
        if ( (equivalence>=Ctes.MORNING_SHEDULE_MIN) && (equivalence<=Ctes.MORNING_SHEDULE_MAX) ) {
            return true;
        }
        else if ( ( equivalence>=Ctes.AFTERNOON_SHEDULE_MIN ) && (equivalence<=Ctes.AFTERNOON_SHEDULE_MAX) ){
            return true;
        }
        return false;
    }	
}