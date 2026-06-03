package mylib.games.minesweeper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slot {
    private SlotSign sign;
    private int minesAround;
    private boolean opened;

    private Slot(SlotSign sign, int minesAround) {
        this.sign = sign;
        this.minesAround = minesAround;
        this.opened = false;
    }
    public Slot(int minesAround) {
        this(SlotSign.EMPTY, minesAround);
    }

    public Slot(SlotSign sign) {
        this(sign, 0);
    }

    public Slot() {
        this(SlotSign.EMPTY, 0);
    }
}
