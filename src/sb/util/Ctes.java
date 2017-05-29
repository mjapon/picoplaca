package sb.util;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Ctes {
	
	//Estos valores pueden variar, indican el horario en el que se aplica el pico y placa en Quito Mañan: 7-9:30, Tarda 16- 19:30
	public static double MORNING_SHEDULE_MIN = 7;
	public static double MORNING_SHEDULE_MAX = 9.5;
	public static double AFTERNOON_SHEDULE_MIN = 16;
	public static double AFTERNOON_SHEDULE_MAX = 19.5;	
	
	public static Map<Integer,Integer[]>  LASTDIGIT_DAY_MAP = new HashMap<>();
	
	//Indica los digitos permitidos segun el dia de la semana (Estos valores pueden variar segun las normativas vigentes)
	static{
		LASTDIGIT_DAY_MAP.put(Calendar.MONDAY, new Integer[]{1,2});
		LASTDIGIT_DAY_MAP.put(Calendar.TUESDAY, new Integer[]{3,4});
		LASTDIGIT_DAY_MAP.put(Calendar.WEDNESDAY, new Integer[]{5,6});
		LASTDIGIT_DAY_MAP.put(Calendar.THURSDAY, new Integer[]{7,8});
		LASTDIGIT_DAY_MAP.put(Calendar.FRIDAY, new Integer[]{9,0});
	}
	
}
