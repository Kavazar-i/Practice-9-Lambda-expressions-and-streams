package trails;

public class Trial {
    private final String account;
    private int mark1;
    private int mark2;
    private final static int PASS_THRESHOLD = 80;
    private final static String DELIMITER = ";";
    private static final String CLASS_FIELDS_TO_STRING_FORMAT = "%s" + DELIMITER + "%s" + DELIMITER + "%d" + DELIMITER + "%d";
    private static final String TO_STRING_FORMAT = "%s" + DELIMITER + "%b";

    public Trial(String account, int mark1, int mark2) {
        this.account = account;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public String getAccount() {
        return account;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public int getPassThreshold() {
        return PASS_THRESHOLD;
    }

    public int calculateResult() {
        return mark1 + mark2;
    }

    public boolean isPassed() {
        return calculateResult() >= PASS_THRESHOLD;
    }

    protected String formatClassFieldsToString() {
        return String.format(CLASS_FIELDS_TO_STRING_FORMAT, getClass().getSimpleName(), account, mark1, mark2);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, formatClassFieldsToString(), isPassed());
    }

    public void clearMarks() {
        this.mark1 = 0;
        this.mark2 = 0;
    }

    public Trial getCopy() {
        return new Trial(getAccount(), getMark1(), getMark2());
    }
}
