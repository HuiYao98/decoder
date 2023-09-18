import java.sql.SQLOutput;

public class app {
    public static void main(String[] args) {
        String output;
        String text = "f ()*+,-./";
        System.out.println("String to encode "+ text);
        output =function.encode(text);
        System.out.println("Encoded String "+ output);
        System.out.println("Decoded String "+ function.decode(output));
    }
}
