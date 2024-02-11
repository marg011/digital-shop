package magazin.demo.enums;

public enum LaptopSize {
    THIRTEEN("13"),
    FOURTEEN("14"),
    FIFTEEN("15"),
    SEVENTEEN("17");

    private final String laptopSize;

    LaptopSize(String laptopSize) {
        this.laptopSize = laptopSize;
    }

    public String getValue() {
        return laptopSize;
    }
}
