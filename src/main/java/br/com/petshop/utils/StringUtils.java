package br.com.petshop.utils;

import java.text.Normalizer;

public class StringUtils {  
    public static String lpad(String valueToPad, String filler, int size) {  
        while (valueToPad.length() < size) {  
            valueToPad = filler + valueToPad;  
        }  
        return valueToPad;  
    }  
      
    public static String rpad(String valueToPad, String filler, int size) {  
        while (valueToPad.length() < size) {  
            valueToPad = valueToPad+filler;  
        }  
        return valueToPad;  
    }
    
    public static boolean isNumeric(String str)  
    {  
      try  
      {  
        int d = Integer.parseInt(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }
    
    public static String removerAcentos(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
    
    public static boolean contemEmVetor(String pesquisa, String[] vetor){
    	for (int i = 0; i < vetor.length; i++) {
			if(vetor[i].equals(pesquisa)){
				return true;
			}
		}
    	return false;
    }
    
    public static String somenteNumeros(String string){
    	return string.replaceAll("[^0-9]", "");
    }
}