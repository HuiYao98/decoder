import javax.swing.*;
import java.util.Arrays;

public class function {

    public static String encode(String plainText){
        Text parsedText = parseString(plainText);
        return encodeString(parsedText);
    }

    public static String decode(String encodedText) {
        Text text = parseString(encodedText);
        return decodeString(text);
    }

    private static Text parseString(String plainText){
        String newText="";
        //plainText= plainText.toUpperCase();
        char offsetChar = plainText.charAt(0);
        plainText = plainText.substring(1,plainText.length());
        Text text= new Text(plainText,offsetChar);
        return text;
    }
    private static String encodeString(Text text){

        String stringToEncode = text.getText();
        char offsetChar = text.getOffsetChar();
        String encodedText="";
        encodedText += offsetChar;

        //Loop through the string and check the cases
        for(int i =0; i<stringToEncode.length();i++){
            char charToAdd=' ';
            char target = Character.toUpperCase(stringToEncode.charAt(i));
            int index = table.refTable.indexOf(target);
            //Check for spaces
            if (target==' '){
                charToAdd =' ';
            }
            else if(text.offsetChar =='B' || text.offsetChar == 'b'){

                index-=1;
                if(index<0){
                    charToAdd='/';
                }else {
                    charToAdd= table.refTable.get(index);
                }

            }
            else if (text.offsetChar =='F' || text.offsetChar =='f'){
                index-=5;
                if (index<0){
                    index +=44;
                }
                charToAdd = table.refTable.get(index);

            }
            //If it is neither a space, Offset Char not B or F, return the original string
            else {
                return stringToEncode;
            }
            encodedText += charToAdd;
        }
        return encodedText;
    }

    private static String decodeString(Text text){
        String stringToDecode = text.getText();
        char offsetChar = text.getOffsetChar();
        String plainText="";
        plainText += offsetChar;
        //Loop through the string and check the cases
        for(int i =0; i<stringToDecode.length();i++){
            char charToAdd=' ';
            char target = Character.toUpperCase(stringToDecode.charAt(i));
            int index = table.refTable.indexOf(target);
            //Check for spaces
            if (target==' '){
                charToAdd =' ';
            }
            else if(text.offsetChar =='B' || text.offsetChar =='b'){
                index+=1;
                if(index>43){
                    charToAdd='A';
                }else {
                    charToAdd= table.refTable.get(index);
                }
            }
            else if (text.offsetChar =='F' || text.offsetChar == 'f'){
                index+=5;
                if (index>43){
                    index -=44;
                }
                charToAdd = table.refTable.get(index);

            }
            //If it is neither a space, Offset Char not B or F, return the original string
            else {
                return stringToDecode;
            }
            plainText += charToAdd;
        }
        return plainText;

    }
}
