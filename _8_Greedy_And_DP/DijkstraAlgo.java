package _8_Greedy_And_DP;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {
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

    //creating graph from scratch
    static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i< graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

//        GFG *****
//        graph[0].add(new Edge(0, 1, 4));
//        graph[0].add(new Edge(0, 7, 8));
//
//        graph[1].add(new Edge(1, 2, 8));
//        graph[1].add(new Edge(1, 7, 11));
//        graph[1].add(new Edge(1, 0, 7));
//
//        graph[2].add(new Edge(2, 1, 8));
//        graph[2].add(new Edge(2, 3, 7));
//        graph[2].add(new Edge(2, 8, 2));
//        graph[2].add(new Edge(2, 5, 4));
//
//        graph[3].add(new Edge(3, 2, 7));
//        graph[3].add(new Edge(3, 4, 9));
//        graph[3].add(new Edge(3, 5, 14));
//
//        graph[4].add(new Edge(4, 3, 9));
//        graph[4].add(new Edge(4, 5, 10));
//
//        graph[5].add(new Edge(5, 4, 10));
//        graph[5].add(new Edge(5, 6, 2));
//
//        graph[6].add(new Edge(6, 5, 2));
//        graph[6].add(new Edge(6, 7, 1));
//        graph[6].add(new Edge(6, 8, 6));
//
//        graph[7].add(new Edge(7, 0, 8));
//        graph[7].add(new Edge(7, 1, 11));
//        graph[7].add(new Edge(7, 6, 1));
//        graph[7].add(new Edge(7, 8, 7));
//
//        graph[8].add(new Edge(8, 2, 2));
//        graph[8].add(new Edge(8, 6, 6));
//        graph[8].add(new Edge(8, 7, 1));
    }

    static class Pair implements Comparable<Pair>{
        int n;  //node
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;  //path based sorting for my pairs
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];  // dist[i] --> distance from src to i
        for(int i=0; i< graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;  // +infinity
            }
        }

        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        //loop for BFS
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.n]) {
                vis[curr.n] = true;
                //neighbours
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u]+wt < dist[v]) {  //update distance of src to v
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        //print all source to vertices shortest distance
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int src = 0; // source defined to 0
        dijkstra(graph, src);
    }
}

/*
OUTPUT:
0 2 3 8 6 9
*/