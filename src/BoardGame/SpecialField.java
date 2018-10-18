package BoardGame;

public class SpecialField extends Field {


    private int value;
    private String text;

    public SpecialField(int number, String name, int value, String text) {
        super(number, name);
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
