package trails;

public class LightTrial extends Trial {
    private static final int FIRST_MARK_THRESHOLD = 40;
    private static final int SECOND_MARK_THRESHOLD = 40;

    public LightTrial(String account, int mark1, int mark2) {
        super(account, mark1, mark2);
    }

    @Override
    public boolean isPassed() {
        return getMark1() >= FIRST_MARK_THRESHOLD && getMark2() >= SECOND_MARK_THRESHOLD;
    }

    @Override
    public Trial getCopy() {
        return new LightTrial(getAccount(), getMark1(), getMark2());
    }
}

