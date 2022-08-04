package magicBox;

import interfaces.Nameble;

public class MagicBoxWithName extends MagicBox implements Nameble {
    private String name;

    public MagicBoxWithName(int maximumAmount) {
        super(maximumAmount);
    }

    public MagicBoxWithName(int maximumAmount, String name) {
        this(maximumAmount);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
