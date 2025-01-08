package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
        static class Edge {
                int src;
                int dest;
                int wt;

                public Edge(int s, int d, int w) {
                        this.src = s;
                        this.dest = d;
                        this.wt = w;
                }
        }

        public static void bfs(ArrayList<Edge> graph[]) {
                int v = graph.length;
                Queue<Integer> q = new LinkedList<>();
                boolean[] visited = new boolean[v];
                q.add(0);
                while (!q.isEmpty()) {
                        int curr = q.remove();
                        if (!visited[curr]) {
                                System.out.print(curr + " ");
                                visited[curr] = true;
                                for (int i = 0; i < graph[curr].size(); i++) {
                                        Edge e = graph[curr].get(i);
                                        q.add(e.dest);
                                }
                        }
                }
        }

        public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {

                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                        Edge e = graph[curr].get(i);
                        if (!visited[e.dest]) {
                                dfs(graph, e.dest, visited);
                        }

                }

        }

        public static boolean hasPath(ArrayList<Edge> graph[], int src, int des, boolean vis[], int curr) {
                if (src == des) {
                        return true;
                }

                for (int i = 0; i < graph[src].size(); i++) {
                        Edge e = graph[src].get(curr);
                        vis[src] = true;
                        if (!vis[e.dest] && hasPath(graph, e.dest, des, vis, curr)) {
                                return true;
                        }
                }

                return false;

        }

        public static boolean isCycle(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                stack[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                        Edge e = graph[curr].get(i);
                        if (stack[e.dest]) {
                                return true;
                        }

                        if (!vis[e.dest] && isCycle(graph, e.dest, vis, stack)) {
                                return true;
                        }
                }
                stack[curr] = false;
                return false;

        }

        public static boolean isCycleExist(ArrayList<Edge> graph[]) {
                boolean visited[] = new boolean[graph.length];
                boolean stack[] = new boolean[graph.length];

                for (int i = 0; i < graph.length; i++) {
                        if (!visited[i]) {
                                if (isCycle(graph, i, visited, stack)) {
                                        return true;
                                }
                        }
                }
                return false;
        }

        public static void createGraph(ArrayList<Edge> graph[]) {
                for (int i = 0; i < graph.length; i++) {
                        graph[i] = new ArrayList<>();
                }
                // 0-s
                graph[0].add(new Edge(0, 1, 0));
                graph[0].add(new Edge(0, 2, 0));
                // 1-s
                graph[1].add(new Edge(1, 3, 0));

                //[2].add(new Edge(2, 3, 0));

        }

        public static boolean detectCycleUndirectedGraphUtil(ArrayList<Edge> graph[], boolean vis[], int curr,
                        int par) {
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                        Edge e = graph[curr].get(i);
                        // Case-1
                        if (!vis[e.dest]) {
                                if (detectCycleUndirectedGraphUtil(graph, vis, e.dest, curr)) {

                                        return true;
                                }
                                // case - 2
                        } else if (vis[e.dest] && e.dest != par) {
                                return true;
                        }

                }
                return false;
        }

        public static boolean detectCycleUndirectedGraph(ArrayList<Edge> graph[]) {
                boolean vis[] = new boolean[graph.length];
                for (int i = 0; i < graph.length; i++) {
                        if (!vis[i]) {
                                if (detectCycleUndirectedGraphUtil(graph, vis, i, -1)) {
                                        return true;
                                }
                        }
                }

                return false;
        }

        public static void main(String[] args) {
                int V = 5;
                ArrayList<Edge>[] graph = new ArrayList[V];
                createGraph(graph);

                System.out.println(detectCycleUndirectedGraph(graph));

                // for (int i = 0; i < V; i++) {
                // graph[i] = new ArrayList<>();
                // }
                // // 0 - vertex
                // graph[0].add(new Edge(0, 1, 5));
                // // 1 - vertex
                // graph[1].add(new Edge(1, 0, 5));
                // graph[1].add(new Edge(1, 2, 1));
                // graph[1].add(new Edge(1, 3, 3));

                // // 2-Vertex
                // graph[2].add(new Edge(2, 3, 1));
                // graph[2].add(new Edge(2, 4, 2));
                // graph[2].add(new Edge(2, 1, 1));

                // // 3-Vertex
                // graph[3].add(new Edge(3, 2, 1));
                // graph[3].add(new Edge(3, 1, 2));

                // // 4-Vertex
                // graph[4].add(new Edge(4, 2, 2));

                // // 2-s Neighbours

                // for (int i = 0; i < graph[2].size(); i++) {
                // Edge e = graph[2].get(i);
                // System.out.print(e.dest + " ");
                // }

        }
}
