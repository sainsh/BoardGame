package BoardGame;

public class SpecialField extends Field {


    private int value;
    private String text;
    private String[] exampleText = {"Free parking","Visit Jail", "Go to Jail", "Draw From Special Cards","Draw From Question Cards"};

    public SpecialField(int number, String name, int value, String text) {
        super(number, name);
        this.value = value;
        this.text = exampleText[(int)(Math.random()*exampleText.length)];
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
