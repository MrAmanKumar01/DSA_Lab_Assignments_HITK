package _8_Greedy_And_DP;

//import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSandDFS {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    //Creating Graph from scratch using Adjacency List
    static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i< graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        //O vertex
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        //1 vertex
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        //2 vertex
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        //3 vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        //4 vertex
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        //5 vertex
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        //6 vertex
        graph[6].add(new Edge(6,5,1));

        //7 vertex
        graph[7].add(new Edge(7,8,1));

        //8 vertex
        graph[8].add(new Edge(8,7,1));

        //9 vertex
        graph[9].add(new Edge(9,9,1));

    }

    //method to implement BFS (also handles connected components)***
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        //traversing all the vertices
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                bfsUtil(graph, i, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, int src, boolean[] vis) {  // O(V+E) --> O(n)
        Queue<Integer> q = new LinkedList<>();
//        q.add(0); // source = 0
        q.add(src); // source = src

        while(!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {  //visit curr
                System.out.print(curr + " ");
                vis[curr] = true;
                // for finding neighbours of current vertex
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);  //add to queue
                }
            }
        }

    }

    //method to implement DFS (also handles connected components)***
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for(int i=0; i< graph.length; i++) {
            if(!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis) {  //O(V+E) --> O(n)
        //visit
        System.out.print(curr + " ");
        vis[curr] = true;

        //neighbours of curr
        for(int i=0; i< graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        /*
              1 ---- 3              7
             /       | \            |
            0        |  5 --- 6     |      9
            \        | /            8
             2 ----- 4
         */
        int V = 10;
        ArrayList<Edge>[] graph = new ArrayList[V];  // null --> empty arraylist
        createGraph(graph);
        System.out.print("BFS traversal: ");
        bfs(graph);
        System.out.println();
        System.out.print("DFS traversal: ");
        dfs(graph);

    }
}

/*
OUTPUT:
BFS traversal: 0 1 2 3 4 5 6 7 8 9
DFS traversal: 0 1 3 4 2 5 6 7 8 9
*/