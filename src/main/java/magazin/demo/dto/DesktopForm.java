package magazin.demo.dto;

public enum DesktopForm {
    DESKTOP("desktop"),
    NETTOP("nettop"),
    MONOBLOCK("monoblock");

    private final String desktopForm;

    DesktopForm(String desktopForm) {
        this.desktopForm = desktopForm;
    }

    public String getValue() {
        return desktopForm;
    }
}
