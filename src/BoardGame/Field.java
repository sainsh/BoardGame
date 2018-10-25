package BoardGame;

public class Field {

    private int fieldNumber;
    private String name;

    public Field(int number, String name) { //both Lots and SpecialFields are Fields with name and number
        this.fieldNumber = number;
        this.name = name;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
