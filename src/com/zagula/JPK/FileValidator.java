package com.zagula.JPK;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

public class FileValidator {
	
	final static String DATE_FORMAT = "yyyy-MM-dd";
	final static String COUNTRY_CODE_EU = "AT|BE|BG|CY|CZ|DK|EE|FI|FR|DE|EL|HR|HU|IE|IT|LV|LT|LU|MT|NL|PL|PT|RO|SK|SI|ES|SE|GB|IC|XI|XJ|MC|";
	final static String COUNTRY_CODE_ALL = "AF|AX|AL|DZ|AD|AO|AI|AQ|AG|AN|SA|AR|AM|AW|AU|AT|AZ|BS|BH|BD|BB|BE|BZ|BJ|BM|BT|BY|BO|BA|BW|BR|BN|IO|BG|BF|BI|XC|CL|CN|HR|CY|TD|ME|DK|DM|DO|DJ|EG|EC|ER|EE|ET|FK|FJ|PH|FI|FR|TF|GA|GM|GH|GI|GR|GD|GL|GE|GU|GG|GY|GF|GP|GT|GN|GQ|GW|HT|ES|HN|HK|IN|ID|IQ|IR|IE|IS|IL|JM|JP|YE|JE|JO|KY|KH|CM|CA|QA|KZ|KE|KG|KI|CO|KM|CG|CD|KP|XK|CR|CU|KW|LA|LS|LB|LR|LY|LI|LT|LV|LU|MK|MG|YT|MO|MW|MV|MY|ML|MT|MP|MA|MQ|MR|MU|MX|XL|FM|UM|MD|MC|MN|MS|MZ|MM|NA|NR|NP|NL|DE|NE|NG|NI|NU|NF|NO|NC|NZ|PS|OM|PK|PW|PA|PG|PY|PE|PN|PF|PL|GS|PT|PR|CF|CZ|KR|ZA|RE|RU|RO|RW|EH|BL|KN|LC|MF|VC|SV|WS|AS|SM|SN|RS|SC|SL|SG|SK|SI|SO|LK|PM|US|SZ|SD|SR|SJ|SH|SY|CH|SE|TJ|TH|TW|TZ|TG|TK|TO|TT|TN|TR|TM|UG|UA|UY|UZ|VU|WF|VA|HU|VE|GB|VN|IT|TL|CI|BV|CX|IM|CK|VI|VG|HM|CC|MH|FO|SB|ST|TC|ZM|CV|ZW|AE|";
	final static String CURRENCY_CODE = "AED|AFN|ALL|AMD|ANG|AOA|ARS|AUD|AWG|AZN|BAM|BBD|BDT|BGN|BHD|BIF|BMD|BND|BOB|BOV|BRL|BSD|BTN|BWP|BYR|BZD|CAD|CDF|CHF|CLF|CLP|CNY|COP|COU|CRC|CUC|CUP|CVE|CZK|DJF|DKK|DOP|DZD|EEK|EGP|ERN|ETB|EUR|FJD|FKP|GBP|GEL|GHS|GIP|GMD|GNF|GTQ|GWP|GYD|HKD|HNL|HRK|HTG|HUF|IDR|ILS|INR|IQD|IRR|ISK|JMD|JOD|JPY|KES|KGS|KHR|KMF|KPW|KRW|KWD|KYD|KZT|LAK|LBP|LKR|LRD|LSL|LTL|LVL|LYD|MAD|MDL|MGA|MKD|MMK|MNT|MOP|MRO|MUR|MVR|MWK|MXN|MXV|MYR|MZN|NAD|NGN|NIO|NOK|NPR|NZD|OMR|PAB|PEN|PGK|PHP|PKR|PLN|PYG|QAR|RON|RSD|RUB|RWF|SAR|SBD|SCR|SDG|SEK|SGD|SHP|SLL|SOS|SRD|STD|SVC|SYP|SZL|THB|TJS|TMT|TND|TOP|TRY|TTD|TVD|TWD|TZS|UAH|UGX|USD|UYU|UZS|VEF|VND|VUV|WST|XAF|XCD|XOF|XPD|XPF|YER|ZAR|ZMK|ZWL";
			
	public static void validateMandatory(String pole, String value, int lineNumber) {
		
		if(value==null || value.equals("")) {
			System.out.println("Column " + pole + " at line " + lineNumber + " is null");	
		} 	
	}

	public static void isDateValid(String pole, String value, int lineNumber) 
	{
		if(value != null && !value.equals("")) {
	        try {
	            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	            df.setLenient(false);
	            df.parse(value);
	        } catch (ParseException e) {
	        	System.out.println("Column " + pole + " at line " + lineNumber + " has nonparsable date. Value is " + value);	  
	        }
	        
		}
	}
	
	public static void isValue(String pole, String value, int lineNumber)  {
		
		if(value != null && !value.equals("")) {
			try {
			
			BigDecimal a = new BigDecimal(value);
			} catch (NullPointerException e) {
	        	System.out.println("Column " + pole + " at line " + lineNumber + " has nonparsable value. Value is " + value);	  	
			} catch (NumberFormatException e) {
	        	System.out.println("Column " + pole + " at line " + lineNumber + " has nonparsable value. Value is " + value);	  	
			}
			
		}	
		
	}
	
	public static void validCountryCodeEU(String pole, String value, int lineNumber) {
		String [] code = COUNTRY_CODE_EU.split("\\|");
		
		if(!Arrays.asList(code).contains(value)) {
			System.out.println("Column " + pole + " at line " + lineNumber + " is not on the acceptable country code list. Value is " + value);
        	System.out.println("Check out entire code list splitted by pipe: " + COUNTRY_CODE_EU);
		}
	}
	
	public static void validCurrency(String pole, String value, int lineNumber) {
		String [] code = CURRENCY_CODE.split("\\|");
		
		if(!Arrays.asList(code).contains(value)) {
			System.out.println("Column " + pole + " at line " + lineNumber + " is not on the acceptable currency code list. Value is " + value);
        	System.out.println("Check out entire code list splitted by pipe: " + CURRENCY_CODE);
		}
	}
	
	
	
	
	
	
	
	
	
	

}
