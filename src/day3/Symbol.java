package day3;

import java.util.Objects;

class Symbol {
    int x;
    int y;
    char value;

    public Symbol() {
    }

    public Symbol(int x, int y,char value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Symbol symbol = (Symbol) object;
        return x == symbol.x && y == symbol.y && value == symbol.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y,value);
    }
}