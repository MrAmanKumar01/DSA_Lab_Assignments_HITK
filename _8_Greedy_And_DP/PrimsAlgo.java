package _8_Greedy_And_DP;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
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

    //creating graph from scratch --> Undirected and Weighted graph
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

        //        GFG *****
//        graph[0].add(new Edge(0, 1, 4));
//        graph[0].add(new Edge(0, 7, 8));
//
//        graph[1].add(new Edge(1, 2, 8));
//        graph[1].add(new Edge(1, 7, 11));
//        graph[1].add(new Edge(1, 0, 4));
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
//        graph[5].add(new Edge(5, 2, 4));
//        graph[5].add(new Edge(5, 3, 14));
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
//        graph[8].add(new Edge(8, 7, 7));
    }

    static class Pair implements Comparable<Pair> {
        int v; //vertex
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));  //source --> 0
        int finalCost = 0;  //MST cost Or Total Min. weight

        // List to store the selected edges
        ArrayList<Edge> selectedEdges = new ArrayList<>();

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for(int i=0; i<graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                    selectedEdges.add(e); // Store selected edge
                }
            }
        }

        System.out.println("Final(Min.) cost of MST is: " + finalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        prims(graph);
    }
}

/*
OUTPUT:
Final(Min.) cost of MST is: 55
*/