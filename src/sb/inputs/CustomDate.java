package sb.inputs;

import java.text.ParseException;
import java.util.Date;

import sb.exception.DateIsNotValidExc;
import sb.util.CustomDateUtil;

public class CustomDate extends UserInput {
	
	private Date date;
	
	public CustomDate(String fecha) throws DateIsNotValidExc{
		String msgError = "La fecha ingresada es incorrecta, debe estar en el formato dd/mm/yyyy";
    	
    	if (this.isNotEmptyNull(fecha)){
			this.isValid = this.validate(fecha);
			if (!this.isValid){
				throw new DateIsNotValidExc(msgError);
			}
			this.proccessUserInput(fecha);
		}
		else{
			throw new DateIsNotValidExc(msgError);
		}		
	}

	@Override
	protected boolean validate(String userInput) {
		try {
			CustomDateUtil.parseDate(userInput);
			return true;
		} catch (ParseException e) {
			return false;			
		}
	}
	
	private void proccessUserInput(String date){
		try {
			this.date = CustomDateUtil.parseDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}	
	
	public Date getDate(){
		return this.date;
	}
}
