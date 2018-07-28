package com.zagula.JPK;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JPKLoad {

	
    public static void main(String[] args) {	

    String csvFile = "C:/JPK/FA/";
    String fileName = "JPK_FA_5252517917_20170801105124";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = "\\|\\#\\|";
    String extension = ".txt";
    //int firstLine = 2;
     
    
    List<String[]> linie =new ArrayList<String[]>();
    try {

        br = new BufferedReader(new FileReader(csvFile + fileName + extension));
        int i=0;
        //System.out.println(new FileReader(csvFile + fileName + extension));
        while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] country = line.split(cvsSplitBy);
            if(i>0) {
            	linie.add(country);
            }
            
        	i=i+1;            
            //System.out.println("Country [code= " + country[4] + " , name=" + country[15] + "]");         
            
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    //System.out.println(linie);
    //for(String[] linia : linie) {
    //	for(String pole : linia) {
    //		System.out.print(pole);
    //		System.out.print(", ");
    //	}
    //	System.out.println("");
    //}
  
    
    int i=0;
    for (String[] linia : linie) {
    	i=i+1;
    	FileValidator.validateMandatory("pole2_a",linia[0],i);
    	FileValidator.validateMandatory("pole3_c",linia[1],i);
    	FileValidator.validateMandatory("pole3_d",linia[2],i);
    	//FileValidator.validateMandatory("pole4_a",linia[3],i);
    	//FileValidator.validateMandatory("pole4_b",linia[4],i);
    	//FileValidator.validateMandatory("pole3_a",linia[5],i);
    	//FileValidator.validateMandatory("pole3_b",linia[6],i);    	
    	FileValidator.validCountryCodeEU("pole5_a",linia[7],i);
    	FileValidator.validateNIP("pole5_b",linia[8],i);
    	FileValidator.validateMandatory("pole1",linia[9],i);
    	FileValidator.isDateValid("pole1",linia[9],i);
    	FileValidator.isDateValid("data_ksiegowania",linia[10],i);
    	FileValidator.isDateValid("data_vat",linia[11],i);
    	FileValidator.isDateValid("pole6",linia[12],i);
    	FileValidator.isDateValid("pole22_a",linia[13],i);
    	FileValidator.validateMandatory("pole15",linia[14],i);
    	FileValidator.isValue("pole15",linia[14],i);
    
    	FileValidator.validateMandatory("pole16",linia[15],i);
    	FileValidator.validateMandatory("pole17",linia[16],i);
    	FileValidator.validateMandatory("pole18",linia[17],i);
    	FileValidator.validateMandatory("pole106_e_2",linia[18],i);
    	FileValidator.isBoolean("pole106_e_2",linia[18],i);
    	FileValidator.validateMandatory("pole106_e_3",linia[19],i);
    	FileValidator.isBoolean("pole106_e_3",linia[19],i);
    	FileValidator.validateRelatedColumnIsTrue("pole106_e_3",0,linia[19],"pole106_e_3_a",new String[] {linia[20]},i);
    	
    	FileValidator.isValue("pole13_1",linia[21],i);
    	FileValidator.validateDoubleRelation("pole13_1",linia[21],"pole14_1",linia[22],i);
    	FileValidator.isValue("pole14_1",linia[22],i);
    	FileValidator.validateDoubleRelation("pole14_1",linia[22],"pole13_1",linia[21],i);

    	FileValidator.isValue("pole13_2",linia[23],i);
    	FileValidator.validateDoubleRelation("pole13_2",linia[23],"pole14_2",linia[24],i);

    	FileValidator.isValue("pole14_2",linia[24],i);
    	FileValidator.validateDoubleRelation("pole14_2",linia[24],"pole13_2",linia[23],i);

    	FileValidator.isValue("pole13_3",linia[25],i);
    	FileValidator.validateDoubleRelation("pole13_3",linia[25],"pole14_3",linia[26],i);

    	FileValidator.isValue("pole14_3",linia[26],i);
    	FileValidator.validateDoubleRelation("pole14_3",linia[26],"pole13_3",linia[25],i);

    	FileValidator.isValue("pole13_4",linia[27],i);
    	FileValidator.validateDoubleRelation("pole13_4",linia[27],"pole14_4",linia[28],i);

    	FileValidator.isValue("pole14_4",linia[28],i);
    	FileValidator.validateDoubleRelation("pole14_4",linia[28],"pole13_4",linia[27],i);

    	FileValidator.isValue("pole13_5",linia[29],i);
    	FileValidator.validateDoubleRelation("pole13_5",linia[29],"pole14_5",linia[30],i);

    	FileValidator.isValue("pole14_5",linia[30],i);
    	FileValidator.validateDoubleRelation("pole14_5",linia[30],"pole13_5",linia[29],i);

    	FileValidator.isValue("pole13_6",linia[31],i);
    	FileValidator.isValue("pole13_7",linia[32],i);

    	FileValidator.isBoolean("pole19",linia[33],i);
    	FileValidator.validateRelatedColumnIsTrue("pole19",1,linia[33],"pole19_a, pole19_b, pole19_c",new String[] {linia[34],linia[35],linia[36]},i);

    	FileValidator.isBoolean("pole20",linia[37],i);
    	FileValidator.validateRelatedColumnIsTrue("pole20",0,linia[37],"pole20_a, pole20_b",new String[] {linia[38],linia[39]},i);

    	FileValidator.isBoolean("pole21",linia[40],i);
    	FileValidator.validateRelatedColumnIsTrue("pole21",0,linia[40],"pole21_a, pole21_b, pole21_c",new String[] {linia[41],linia[42],linia[43]},i);

    	FileValidator.isBoolean("pole23",linia[46],i);
    	FileValidator.validInvoiceType("rodzaj_faktury",linia[47],i);
    	FileValidator.validateRelatedColumnIsKorekta("rodzaj_faktury",0,linia[47],"przyczyna_korekty, nr_fa_korygowanej, okres_fa_korygowanej",new String[] {linia[48],linia[49],linia[50]},i);
    	FileValidator.validateRelatedColumnIsZaliczka("rodzaj_faktury",0,linia[47],"zal_zaplata, zal_podatek",new String[] {linia[51],linia[52]},i);

    	FileValidator.isValue("zal_zaplata",linia[51],i);
    	FileValidator.isValue("zal_podatek",linia[52],i);
    	
    	FileValidator.validateRelatedColumnIsVAT("rodzaj_faktury",0,linia[47],"pole7",new String[] {linia[53]},i);
    	FileValidator.validateRelatedColumnIsZaliczka("rodzaj_faktury",0,linia[47],"pole7",new String[] {linia[53]},i);

    	//FileValidator.isValue("pole8_a",linia[54],i);
    	FileValidator.isValue("pole8_b",linia[55],i);
    	FileValidator.isValue("pole9_a",linia[56],i);
    	FileValidator.isValue("pole9_b",linia[57],i);
    	FileValidator.isValue("pole10",linia[58],i);
    	FileValidator.isValue("pole11",linia[59],i);
    	FileValidator.isValue("pole11_a",linia[60],i);
    	FileValidator.validTaxValue("pole12",linia[61],i);
    	FileValidator.validCurrency("waluta",linia[62],i);
    	//FileValidator.validateMandatory("system",linia[63],i);
    }
    
    
}

}
