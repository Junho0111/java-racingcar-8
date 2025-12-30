package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        checkName(name);
        this.name = name;
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }

    //.isEmpty() 자바6 = 문자열의 길이가 0인 경우에, true를 리턴
    //.isBlank() 자바11 = 문자열이 비어 있거나, 빈 공백으로만 이루어져 있으면, true를 리턴
    private void checkName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + name);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isAtPosition(int maxPosition) {
        return this.position == maxPosition;
    }
}