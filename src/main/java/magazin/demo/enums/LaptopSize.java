package magazin.demo.enums;

public enum LaptopSize {
    THIRTEEN(13),
    FOURTEEN(14),
    FIFTEEN(15),
    SEVENTEEN(17);

    private final int laptopSize;

    LaptopSize(int laptopSize) {
        this.laptopSize = laptopSize;
    }

    public int getValue() {
        return laptopSize;
    }
}
