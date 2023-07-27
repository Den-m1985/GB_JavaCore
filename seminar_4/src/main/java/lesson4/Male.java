package lesson4;

public enum Male {
    MALE("мальчик"), FEMALE("девочка");

    private final String russianMaleTitle;

    Male(String russianMaleTitle) {
        this.russianMaleTitle = russianMaleTitle;
    }

    public String getRussianMaleTitle() {
        return russianMaleTitle;
    }

    @Override
    public String toString() {
        return name();
    }

//    abstract void test();
}
