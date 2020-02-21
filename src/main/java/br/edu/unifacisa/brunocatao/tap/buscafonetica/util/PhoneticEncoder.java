package br.edu.unifacisa.brunocatao.tap.buscafonetica.util;

/**
 * @author Bruno Gama Catão
 */
public class PhoneticEncoder {
    private static final int PADRAO = 0;
    private static final int REGRA  = 1;
    private static final String[][] REGRAS_FONETICAS = {
        {"[ÁÀÃÂÄ]", "A"},
        {"[ÉÈÊË]", "E"},
        {"[ÍÌÎÏ]", "I"},
        {"[ÓÒÕÔÖ]", "O"},
        {"[ÚÙÛÜ]", "U"},
        {"Y", "I"},
        {"BR", "B"},
        {"PH", "F"},
        {"GR|MG|NG|RG", "G"},
        {"GE|GI|RJ|MJ|NJ", "J"},
        {"CE|CI", "S"},
        {"Q|CA|CO|CU|C", "K"},
        {"LH", "L"},
        {"RM|GM|MD|SM|AO$", "M"},
        {"NH", "N"},
        {"PR", "P"},
        {"Ç|X|TS|C|Z|RS", "S"},
        {"LT|TR|CT|RT|ST", "T"},
        {"W", "V"},
        {"S$|Z$|R$|M$|N$|AO$|L$", ""},
        {"[AEIOUH]", ""}
    };
   
    public static String encode(String str) {
        str = str.toUpperCase();
        str = aplicaRegras(str);
        str = eliminarLetrasDuplicadas(str);
        
        return str;
    }
    
    private static String aplicaRegras(String str) {
        for (String[] regra : REGRAS_FONETICAS) {
            str = str.replaceAll(regra[PADRAO], regra[REGRA]);
        }
        
        return str;
    }
    
    private static String eliminarLetrasDuplicadas(String str) {
        if (str.length() == 0) {
            return str;
        }
        
        StringBuilder builder = new StringBuilder(str.substring(0, 1));
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                builder.append(str.charAt(i));
            }
        }
        
        return builder.toString();
    }
}
