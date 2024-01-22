package domain.person.wrapper;

public class NameWrapper {

    private final String name;

    public NameWrapper(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("이름은 공백이거나, NULL 값이 될 수 없습니다.");
        }
    }

    private boolean isBlank(String name) {
        return name == null || name.trim().isEmpty();
    }

    public String getName() {
        return name;
    }
}
