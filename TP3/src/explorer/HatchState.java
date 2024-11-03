package explorer;

public abstract class HatchState {
    public static String errorMessage_UpperOpen =  "Cannot open upper hatch when lower hatch is open";
    public static String errorMessage_LowerOpen = "Cannot open lower hatch when upper hatch is open";
    public static String errorMessage_AspirateUpperClosed = "Cannot aspirate with upper hatch closed";;
    public static String errorMessage_AspirateLowerOpen = "Cannot aspirate with lower hatch open";
    public static String errorMessage_CollectSampleLowerClosed = "Cannot collect sample with lower hatch closed";
    public static String errorMessage_CollectSampleUpperOpen = "Cannot collect sample with upper hatch open";
    public static String errorMessage_UpperHatchOpen = "Upper hatch is already open";
    public static String errorMessage_LowerHatchOpen = "Lower hatch is already open";

    public abstract void openUpper(Explorer explorer);
    public abstract void openLower(Explorer explorer);
    public abstract void close(Explorer explorer);
    public abstract void aspirate(Explorer explorer);
    public abstract void collectSample(Explorer explorer);
    public abstract boolean isUpperHatchOpen();
    public abstract boolean isLowerHatchOpen();

}


