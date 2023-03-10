package controllers;

public class Validations {
	public boolean isInteger(String strNum) {
		boolean result = false;
		try {
			Integer.parseInt(strNum);
			result = true;
		}
		catch(Exception ex) {
			result = true;
		}
		return (result);
	}
	public boolean isIntegerV2(String strNum) {
		boolean result = false;
		try {
			Integer.parseInt(strNum);
			result = true;
		}
		catch(Exception ex) {
			result = false;
		}
		return (result);
	}
	public boolean isInRange(int num, int start, int stop) {
		boolean result = false;
		try {
			if(num>=start && num<=stop)
				result = true;
		}
		catch(Exception ex) {
			result = false;
		}
		return (result);
	}
}