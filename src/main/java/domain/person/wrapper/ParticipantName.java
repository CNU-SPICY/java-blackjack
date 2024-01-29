package domain.person.wrapper;

public class ParticipantName {

    private final String name;

    private ParticipantName(final String name) {
        this.name = name;
    }

    public static ParticipantName create(final String name) {
        validate(name);
        return new ParticipantName(name);
    }


    private static void validate(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException("이름은 공백이거나, NULL 값이 될 수 없습니다.");
        }
    }

    private static boolean isBlank(String name) {
        return name == null || name.trim().isEmpty();
    }

    public String getName() {
        return name;
    }
}
