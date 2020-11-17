/**
 * 方法1
 */
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j);
                tmp.add(getDistance(i,j,r0,c0));
                temp.add(tmp);
            }
        }
        Collections.sort(temp, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(2)-o2.get(2);
            }
        });
        int[][] ans = new  int[R*C][2];
        for (int i = 0; i < temp.size(); i++) {
          ans[i][0] = temp.get(i).get(0);
          ans[i][1] = temp.get(i).get(1);
        }
        return ans;
    }
    public int getDistance(int r1,int c1,int r2,int c2)
    {
        return Math.abs(r1-r2)+Math.abs(c1-c2);
    }
}
/**
 * 方法2
 */

class Solution {
    int[] dr = {1, 1, -1, -1};
    int[] dc = {1, -1, -1, 1};

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        int[][] ret = new int[R * C][];
        int row = r0, col = c0;
        int index = 0;
        ret[index++] = new int[]{row, col};
        for (int dist = 1; dist <= maxDist; dist++) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != r0) || (i % 2 != 0 && col != c0)) {
                    if (row >= 0 && row < R && col >= 0 && col < C) {
                        ret[index++] = new int[]{row, col};
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return ret;
    }
}
