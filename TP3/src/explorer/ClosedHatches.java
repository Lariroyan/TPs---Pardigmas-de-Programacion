package explorer;

public class ClosedHatches extends HatchState {
    public void openUpper(Explorer explorer) {
        explorer.changeToOpenUpper();
    }

    public void openLower(Explorer explorer) {
        explorer.changeToOpenLower();
    }

    public void close(Explorer explorer) {
        throw new IllegalStateException("There are no open hatches to close");
    }

    public void aspirate(Explorer explorer) {
        throw new IllegalStateException(HatchState.errorMessage_AspirateUpperClosed);
    }

    public void collectSample(Explorer explorer) {
        throw new IllegalStateException(HatchState.errorMessage_CollectSampleLowerClosed);
    }
    public boolean isUpperHatchOpen() {
        return false;
    }
    public boolean isLowerHatchOpen() {
        return false;
    }
}
