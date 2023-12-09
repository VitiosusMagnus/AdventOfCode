package day3;

import java.util.Objects;

class Number {
    int value;
    int yStart;
    int yEnd;
    int x;

    public Number() {
    }

    public Number(int value,int x, int yStart, int yEnd) {
        this.value = value;
        this.x = x;
        this.yStart = yStart;
        this.yEnd = yEnd;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Number number = (Number) object;
        return value == number.value && yStart == number.yStart && yEnd == number.yEnd && x == number.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, yStart, yEnd, x);
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                ", yStart=" + yStart +
                ", yEnd=" + yEnd +
                ", x=" + x +
                '}';
    }
}

