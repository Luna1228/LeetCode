/**
 * created by Luna1228
 * use bfs
 * 505. The Maze II
 * question description: https://leetcode.com/problems/the-maze-ii/description/
 */
 class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        //bfs
        int m = maze.length;
        int n = maze[0].length;
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(visited[i], -1);
        }
        if(start[0] == destination[0] && start[1] == destination[1]) return 0;
        Queue<int[]> queue = new LinkedList();
        queue.offer(start);
        visited[start[0]][start[1]] = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int len = visited[cur[0]][cur[1]];
            //to left
            int y = cur[1];
            for(; y >= 0; y--) {
                if(maze[cur[0]][y] == 1) {
                    break;
                }
            }
            y++;
            int newlen = len+cur[1]-y;
            if(visited[cur[0]][y] == -1 || visited[cur[0]][y] > newlen) {
                visited[cur[0]][y] = newlen;
                queue.offer(new int[]{cur[0], y});
            }
            //to right
            y = cur[1];
            for(; y < n; y++) {
               if(maze[cur[0]][y] == 1) {
                    break;
                } 
            }
            y--;
            newlen = len+y-cur[1];
            if(visited[cur[0]][y] == -1 || visited[cur[0]][y] > newlen) {
                visited[cur[0]][y] = newlen;
                queue.offer(new int[]{cur[0], y});
            }
            //to up
            int x = cur[0];
            for(; x >= 0; x--) {
                if(maze[x][cur[1]] == 1) {
                    break;
                }
            }
            x++;
            newlen = len+cur[0]-x;
            if(visited[x][cur[1]] == -1 || visited[x][cur[1]] > newlen) {
                visited[x][cur[1]] = newlen;
                queue.offer(new int[]{x, cur[1]});
            }
            //to down
            x = cur[0];
            for(; x < m; x++) {
                if(maze[x][cur[1]] == 1) {
                    break;
                }
            }
            x--;
            newlen = len+x-cur[0];
            if(visited[x][cur[1]] == -1 || visited[x][cur[1]] > newlen) {
                visited[x][cur[1]] = newlen;
                queue.offer(new int[]{x, cur[1]});
            }
        }
        return visited[destination[0]][destination[1]];
    }
}
