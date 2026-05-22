package mylib.games.minesweeper;

import mylib.math.matrix.template.Matrix;

public class Grid {
    private final Matrix<Slot> grid;

    public Grid(int size, int mines) {
        this.grid = new Matrix<>(size, size);
        int i, j;
        for(int m = 0; m < mines; m++) {
            do {
                i = (int) (Math.random() * size);
                j = (int) (Math.random() * size);
            } while (grid.elementAt(i, j).getSign().equals(SlotSign.MINE));
            grid.set(i, j, new Slot(SlotSign.MINE));
        }

        Matrix<Slot> adj;
        int bombs = 0;

        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (grid.elementAt(i, j).getSign().equals(SlotSign.MINE)) {
                    continue;
                }
                adj = this.grid.adjacent(i, j,3);
                for (int k = i; k < adj.rows()+i; k++) {
                    for (int l = j; l < adj.columns()+j; l++) {
                        if(adj.elementAt(k, l).getSign().equals(SlotSign.MINE))
                            bombs++;
                    }
                }

                grid.elementAt(i, j).setMinesAround(bombs);
                bombs = 0;
            }
        }
    }
}
