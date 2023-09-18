import java.sql.SQLOutput;

public class app {
    public static void main(String[] args) {
        String encodedText;
        String plainText = "f ()*+,-./";
        System.out.println("String to encode "+ plainText);
        encodedText =function.encode(plainText);
        System.out.println("Encoded String "+ encodedText);
        System.out.println("Decoded String "+ function.decode(encodedText));
    }
}
