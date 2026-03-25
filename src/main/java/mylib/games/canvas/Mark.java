package mylib.games.canvas;

import lombok.Getter;

@Getter
public enum Mark {
    TRIANGLE, SQUARE, GEAR, RAINBOW,
    PER_TRIANGLE(TRIANGLE), PER_SQUARE(SQUARE), PER_GEAR(GEAR), PER_RAINBOW(RAINBOW);

    private final Mark includedMark;
    Mark(Mark includedMark) {
        this.includedMark = includedMark;
    }
    Mark() {
        this(null);
    }

    public boolean isIncluded() {
        return includedMark != null;
    }
}
