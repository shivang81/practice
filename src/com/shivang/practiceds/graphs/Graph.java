package com.shivang.practiceds.graphs;

import java.util.LinkedList;

/**
 * Graph Traversals
 * Created by shivanggupta on 05/01/17.
 */
class Graph
{
    private int V;
    private LinkedList<Integer>[] adj;

    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    void BFS(int s)
    {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s+" ");

            for (Integer n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFSUtil(int v,boolean visited[])
    {
        visited[v] = true;
        System.out.print(v+" ");

        for (Integer n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v)
    {
        boolean visited[] = new boolean[V];

        DFSUtil(v, visited);
    }

    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);

        System.out.println("\nFollowing is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}
