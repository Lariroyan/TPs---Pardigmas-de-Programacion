package explorer;

public class OpenUpperHatch extends HatchState{
    public void openUpper(Explorer explorer) {
        throw new IllegalStateException(HatchState. errorMessage_UpperHatchOpen);
    }

    public void openLower(Explorer explorer) {
        throw new IllegalStateException(HatchState.errorMessage_LowerOpen);
    }

    public void close(Explorer explorer) {
        explorer.changeToClosed();
    }

    public void aspirate(Explorer explorer) {
    }

    public void collectSample(Explorer explorer) {
        throw new UnsupportedOperationException(HatchState.errorMessage_CollectSampleUpperOpen);
    }
    public boolean isUpperHatchOpen() {
        return true;
    }
    public boolean isLowerHatchOpen() {
        return false;
    }

}
