package BoardGame;

public class SpecialField extends Field {


    private int value;
    private String text;
    private String[] exampleText = {"Free parking","Visit Jail", "Go to Jail", "Draw From Special Cards","Draw From Question Cards"}; // current list of different SpecialField texts

    public SpecialField(int number, String name, int value, String text) {
        super(number, name);
        this.value = value;
        this.text = exampleText[(int)(Math.random()*exampleText.length)];   //sets what text the SpecialField has
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
