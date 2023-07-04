package trails;

public class StrongTrial extends Trial {
    private static final int FIRST_MARK_COEFFICIENT = 2;

    public StrongTrial(String account, int firstMark, int secondMark) {
        super(account, firstMark, secondMark);
    }

    @Override
    public int calculateResult() {
        return getMark1() / FIRST_MARK_COEFFICIENT + getMark2();
    }

    @Override
    public Trial getCopy() {
        return new StrongTrial(getAccount(), getMark1(), getMark2());
    }
}
