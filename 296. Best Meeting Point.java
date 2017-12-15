/**
 * created by Luna1228
 * two ways: 1) sort -----better for sparse matrix
 *           2) bucket sort
 */
class Solution {
    public int minTotalDistance(int[][] grid) {
       /*way1: sort
       List<Integer> xs = new ArrayList();
        List<Integer> ys = new ArrayList();
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    xs.add(i);
                    ys.add(j);
                }
            }
        }
        
        Collections.sort(xs);
        Collections.sort(ys);
        int res = 0;
        int i = 0;
        int j = xs.size()-1;
        while(i < j) {
            res += xs.get(j) - xs.get(i);
            j--;
            i++;
        }
        i = 0;
        j = ys.size()-1;
        while(i < j) {
            res += ys.get(j) - ys.get(i);
            j--;
            i++;
        }
        return res;*/
        
        //way2: bucket sort
        
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int res = 0;  // remember the result
        
        int[] xs = new int[m];
        int[] ys = new int[n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    xs[i]++;
                    ys[j]++;
                }
            }
        }
        
        int i = 0;
        int j = m-1;
        
        while(i < j && xs[i] == 0) {
            i++;
        }
        while(i < j && xs[j] == 0) {
            j--;
        }    
        while(i < j) {
            res += j-i;
            xs[i]--;
            xs[j]--;
            while(i < j && xs[i] == 0) {
                i++;
            }
            while(i < j && xs[j] == 0) {
                j--;
            }
        }
        
        i = 0;
        j = n-1;
        while(i < j && ys[i] == 0) {
            i++;
        }
        while(i < j && ys[j] == 0) {
            j--;
        }
        while(i < j) {
            res += j-i;
            ys[i]--;
            ys[j]--;
            while(i < j && ys[i] == 0) {
                i++;
            }
            while(i < j && ys[j] == 0) {
                j--;
            }
        }
        return res;
    }
}
