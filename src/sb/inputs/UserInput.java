package sb.inputs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class UserInput {
	
	protected boolean isValid;
	
	protected abstract boolean validate(String userInput);	
	
	protected boolean isNotEmptyNull(String str){
		return str!=null && str.trim().length()>0;
	}
	
	protected boolean checkPattern(String thePattern, String userInput){		
        Pattern pattern = Pattern.compile(thePattern);
        Matcher matcher = pattern.matcher(userInput);
        return matcher.matches();
	}
	
	protected Matcher getPatternMatcher(String thePattern, String userInput){		
		Pattern pattern = Pattern.compile(thePattern);
        Matcher matcher = pattern.matcher(userInput);
        return matcher;        
	}	
}