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
        throw new IllegalStateException("Cannot aspirate with upper hatch closed");
    }

    public void collectSample(Explorer explorer) {
        throw new IllegalStateException("Cannot collect sample with lower hatch closed");
    }
    public boolean isUpperHatchOpen() {
        return false;
    }
    public boolean isLowerHatchOpen() {
        return false;
    }
}
