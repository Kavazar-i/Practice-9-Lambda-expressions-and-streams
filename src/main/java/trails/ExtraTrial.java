package trails;

public class ExtraTrial extends Trial {
    private static final int PASS_SCORE = 20;
    private static final String TO_STRING_FORMAT = "%s;%d";
    private int mark3;

    public ExtraTrial(String account, int mark1, int mark2, int mark3) {
        super(account, mark1, mark2);
        this.mark3 = mark3;
    }

    public int getMark3() {
        return mark3;
    }

    @Override
    public boolean isPassed() {
        return super.isPassed() && mark3 >= PASS_SCORE;
    }
    
    @Override
    protected String formatClassFieldsToString() {
        return String.format(TO_STRING_FORMAT, super.formatClassFieldsToString(), mark3);
    }
    
    @Override
    public void clearMarks() {
        super.clearMarks();
        this.mark3 = 0;
    }

    @Override
    public Trial getCopy() {
        return new ExtraTrial(getAccount(), getMark1(), getMark2(), getMark3());
    }

}
