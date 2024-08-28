public class PrimMST {
    static int INF = 9999999;
    static int V = 5;

    static int[][] G = {
            {0, 9, 75, 0, 0},
            {9, 0, 95, 19, 42},
            {75, 95, 0, 51, 66},
            {0, 19, 51, 0, 31},
            {0, 42, 66, 31, 0}
    };

    static int[] selected = new int[V];

    static int no_edge = 0;

    static void primMST() {
        selected[0] = 1;

        System.out.println("Edge : Weight\n");

        while (no_edge < V - 1) {
            int minimum = INF;
            int x = 0;
            int y = 0;

            for (int i = 0; i < V; i++) {
                if (selected[i] == 1) {
                    for (int j = 0; j < V; j++) {
                        if (selected[j] == 0 && G[i][j] != 0) {
                            if (minimum > G[i][j]) {
                                minimum = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            System.out.println(x + "-" + y + ":" + G[x][y]);
            selected[y] = 1;
            no_edge++;
        }
    }

    public static void main(String[] args) {
        primMST();
    }
}
