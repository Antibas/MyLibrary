package mylib.games.minesweeper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Slot {
    private SlotSign sign;
    private int minesAround;

    public Slot(int minesAround) {
        this.sign = SlotSign.EMPTY;
        this.minesAround = minesAround;
    }

    public Slot(SlotSign sign) {
        this.sign = SlotSign.EMPTY;
        this.minesAround = 0;
    }
}
