package calculator;

import java.util.Objects;

public class Separator {

    private final String separator;

    public Separator(String... separator) {
        StringBuilder sb = new StringBuilder();
        for (String s : separator) {
            sb.append(s);
        }
        this.separator = sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Separator separator1 = (Separator) o;
        return Objects.equals(separator, separator1.separator);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(separator);
    }
}
