public class TestRestart extends Restart {
    private boolean shouldRestart = false;

    public void setShouldRestart(boolean shouldRestart) {
        this.shouldRestart = shouldRestart;
    }

    @Override
    public boolean askForRestart() {
        return shouldRestart;
    }
}
