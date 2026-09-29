class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0]==')'){
            return false;
        }
        if((m+n-1)%2!=0){
            return false;
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, 1});

        boolean[][][] visited =
            new boolean[m][n][m + n];

        visited[0][0][1] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int count = curr[2];

            if (count < 0) {
                continue;
            }

            if (r == m - 1 && c == n - 1) {

                if (count == 0) {
                    return true;
                }

                continue;
            }

            int[] x = {0, 1};
            int[] y = {1, 0};

            for (int k = 0; k < 2; k++) {

                int nr = r + x[k];
                int nc = c + y[k];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n) {

                    int newc = count;

                    if (grid[nr][nc] == '(') {
                        newc++;
                    } else {
                        newc--;
                    }

                    if (newc >= 0 &&
                        !visited[nr][nc][newc]) {

                        visited[nr][nc][newc] = true;

                        q.offer(new int[]{
                            nr, nc, newc
                        });
                    }
                }
            }
        }

        return false;
    }
}