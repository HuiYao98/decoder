import java.util.Arrays;

public class Text {

    String text;
    char offsetChar;

    public Text(String text, char offsetChar) {
        this.text = text;
        this.offsetChar = offsetChar;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char getOffsetChar() {
        return offsetChar;
    }

    public void setOffsetChar(char offsetChar) {
        this.offsetChar = offsetChar;
    }
}
