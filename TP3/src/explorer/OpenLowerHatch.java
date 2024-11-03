package explorer;

public class OpenLowerHatch extends HatchState {
    public void openUpper(Explorer explorer) {
        throw new IllegalStateException(HatchState.errorMessage_UpperOpen );
    }

    public void openLower(Explorer explorer) {
        throw new IllegalStateException(HatchState.errorMessage_LowerHatchOpen);
    }

    public void close(Explorer explorer) {
        explorer.changeToClosed();
    }

    public void aspirate(Explorer explorer) {
        throw new UnsupportedOperationException(HatchState.errorMessage_AspirateLowerOpen);
    }

    public void collectSample(Explorer explorer) {
    }

    public boolean isUpperHatchOpen() {
        return false;
    }

    public boolean isLowerHatchOpen() {
        return true;

    }
}
