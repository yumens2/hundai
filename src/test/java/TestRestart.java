public class TestRestart extends Restart {
    private boolean shouldRestart = false;

    public void setShouldRestart(boolean shouldRestart1) {
        this.shouldRestart = shouldRestart1;
    }

    @Override
    public boolean askForRestart() {
        return shouldRestart;
    }
}
