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
    int firstLine = 2;
     
    
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
    	FileValidator.validateMandatory("pole4_a",linia[3],i);
    	FileValidator.validateMandatory("pole4_b",linia[4],i);
    	//FileValidator.validateMandatory("pole3_a",linia[5],i);
    	//FileValidator.validateMandatory("pole3_b",linia[6],i);    	
    	FileValidator.validCountryCodeEU("pole5_a",linia[7],i);
    	//FileValidator.validateMandatory("pole5_b",linia[8],i);
    	FileValidator.validateMandatory("pole1",linia[9],i);
    	FileValidator.isDateValid("pole1",linia[9],i);
    	//FileValidator.validateMandatory("data_ksiegowania",linia[10],i);
    	//FileValidator.validateMandatory("data_vat",linia[11],i);
    	//FileValidator.validateMandatory("pole6",linia[12],i);
    	//FileValidator.validateMandatory("pole22_a",linia[13],i);
    	FileValidator.validateMandatory("pole15",linia[14],i);
    	FileValidator.isValue("pole15",linia[14],i);
    
    	FileValidator.validateMandatory("pole16",linia[15],i);
    	FileValidator.validateMandatory("pole17",linia[16],i);
    	FileValidator.validateMandatory("pole18",linia[17],i);
    	FileValidator.validateMandatory("pole106_e_2",linia[18],i);
    	FileValidator.validateMandatory("pole106_e_3",linia[19],i);
    	//FileValidator.validateMandatory("pole106_e_3_a",linia[20],i);
    	
    	FileValidator.isValue("pole13_1",linia[21],i);
    	FileValidator.isValue("pole14_1",linia[22],i);
    	FileValidator.isValue("pole13_2",linia[23],i);
    	FileValidator.isValue("pole14_2",linia[24],i);
    	FileValidator.isValue("pole13_3",linia[25],i);
    	FileValidator.isValue("pole14_3",linia[26],i);
    	FileValidator.isValue("pole13_4",linia[27],i);
    	FileValidator.isValue("pole14_4",linia[28],i);
    	FileValidator.isValue("pole13_5",linia[29],i);
    	FileValidator.isValue("pole14_5",linia[30],i);
    	FileValidator.isValue("pole13_6",linia[31],i);
    	FileValidator.isValue("pole13_7",linia[32],i);

    	//FileValidator.validateMandatory("pole19",linia[33],i);
    	//FileValidator.validateMandatory("pole19_a",linia[34],i);
    	//FileValidator.validateMandatory("pole19_b",linia[35],i);
    	//FileValidator.validateMandatory("pole19_c",linia[36],i);
    	//FileValidator.validateMandatory("pole20",linia[37],i);
    	//FileValidator.validateMandatory("pole20_a",linia[38],i);
    	//FileValidator.validateMandatory("pole20_b",linia[39],i);
    	//FileValidator.validateMandatory("pole21",linia[40],i);
    	//FileValidator.validateMandatory("pole21_a",linia[41],i);
    	//FileValidator.validateMandatory("pole21_b",linia[42],i);
    	//FileValidator.validateMandatory("pole21_c",linia[43],i);

    	//FileValidator.validateMandatory("pole22_b",linia[44],i);
    	//FileValidator.validateMandatory("pole22_c",linia[45],i);
    	//FileValidator.validateMandatory("pole23",linia[46],i);
    	//FileValidator.validateMandatory("rodzaj_faktury",linia[47],i);
    	//FileValidator.validateMandatory("przyczyna_korekty",linia[48],i);
    	//FileValidator.validateMandatory("nr_fa_korygowanej",linia[49],i);
    	//FileValidator.validateMandatory("okres_fa_korygowanej",linia[50],i);
    	FileValidator.isValue("zal_zaplata",linia[51],i);
    	FileValidator.isValue("zal_podatek",linia[52],i);
    	//FileValidator.validateMandatory("pole7",linia[53],i);
    	//FileValidator.validateMandatory("pole8_a",linia[54],i);
    	FileValidator.isValue("pole8_b",linia[55],i);
    	FileValidator.isValue("pole9_a",linia[56],i);
    	//FileValidator.validateMandatory("pole9_b",linia[57],i);
    	//FileValidator.validateMandatory("pole10",linia[58],i);
    	FileValidator.isValue("pole11",linia[59],i);
    	//FileValidator.validateMandatory("pole11_a",linia[60],i);
    	//FileValidator.validateMandatory("pole12",linia[61],i);
    	FileValidator.validCurrency("waluta",linia[62],i);
    	//FileValidator.validateMandatory("system",linia[63],i);



    }
    
    
    
}

}
