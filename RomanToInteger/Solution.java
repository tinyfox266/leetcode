public int romanToInt(String s) {
    int result = 0;
    int index = 0;
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };  
    String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };  
    for (int i = 0; i < values.length; i++) {  
       if(numerals[i].length() == 1){
           while(index < s.length() && 
                   s.substring(index, index+1).equals(numerals[i])){
               result += values[i];
               index ++;
           }
       }else{
           if(index < s.length()-1 && 
                   s.substring(index, index+2).equals(numerals[i])){
               result += values[i];
               index += 2;
           }
       }
       if(index >= s.length()) break;
    }  
    return result;
}
