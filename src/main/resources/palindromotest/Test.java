/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromotest;


/**
 *
 * @author mdo
 */
public class Test {
    
    public boolean consulta(String palabra){
        palabra = palabra.toLowerCase();
        String invertida = "";
        char[] caracteres = palabra.toCharArray();
        
        
        for (int i = caracteres.length-1; i >= 0; i--) {
            invertida += caracteres[i];
        }
        
        return (palabra == null ? invertida == null : palabra.equals(invertida));
    }
    
    public boolean consulta2(String palabra){
        palabra = palabra.toLowerCase();
        
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
   
        int cont = 0;
        
        for (int i = 0; i < palabra.length(); i++) {
            
            char chr = palabra.charAt(i);
            for (int j = 0; j < vocales.length; j++) {
                if(vocales[j] == chr){
                    cont++;
                }
            }
        }
       
        if(palabra.length()%2 == 0){
            if((palabra.length()/2) == cont){
                return true;
            }
        }else{
            return false;
        }
        return false;
    }
}
