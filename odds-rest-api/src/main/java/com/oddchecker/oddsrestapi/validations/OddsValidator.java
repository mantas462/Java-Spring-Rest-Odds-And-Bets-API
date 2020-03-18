package com.oddchecker.oddsrestapi.validations;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OddsValidator implements ConstraintValidator<Odds, String> {

   
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

    	value = value.trim();
		String[] lines = value.split("\r\n|\r|\n");

		int ilgis = lines.length;

		boolean matchedOddFormat = false;
		boolean matchedSPFormat = false;
		boolean matchedBoth = false;

		for (int i = 0; i < ilgis; i++) {

			if (ilgis - 1 != i) {
				if (lines[i].split("/").length < 3) {
					
					String[] rows = lines[i].split("/");

					if (isInteger(rows[0].trim()) && isInteger(rows[1].trim())) {
						matchedOddFormat = true;
					} else {
						matchedOddFormat = false;
						break;
					}

				} else {
					matchedOddFormat = false;
					break;
				}
			} else {
				if (lines[i].equals("SP")) {
					matchedSPFormat = true;
				} else {
					matchedSPFormat = false;
				}
			}

		}
		
		if(matchedSPFormat && matchedOddFormat) {
			matchedBoth=true;
		}
		return matchedBoth;

    }
    
    
    public boolean isInteger(String str) {
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(str);
		boolean b = m.matches();
		return b;
	}
}