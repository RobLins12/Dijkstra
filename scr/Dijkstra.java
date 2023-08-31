package scr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra {

    Grafo graph;
    Integer [] dist;
    Vertice [] previous;

    public Dijkstra(Grafo graph){
        this.graph = graph;
        dist = new Integer[graph.getVertices().size()];  
        previous = new Vertice[graph.getVertices().size()];
    }

    public void initDijkstra(Vertice source, Vertice destination){
        ArrayList<Vertice> vertices = (ArrayList<Vertice>) graph.getVertices();
        Queue<Vertice> q = new LinkedList<>();
        dist[vertices.indexOf(source)] = 0;
        for (Vertice vertice : vertices) {
            if (!(vertice.nome.equals(source.nome))) {
                dist[vertices.indexOf(vertice)] = 100000;
                previous[vertices.indexOf(vertice)] = null;
            }
            q.add(vertice);
        }
        
        while(!q.isEmpty()){
            Vertice u = minSize(q, vertices);
            q.remove();

            for (Vertice v : u.lista) {
                Integer alt = dist[vertices.indexOf(u)] + graph.getPeso(u, v);
                if (alt < dist[vertices.indexOf(v)]) {
                    dist[vertices.indexOf(v)] = alt;
                    previous[vertices.indexOf(v)] = u;
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println("");

        ArrayList<Vertice> s = new ArrayList<>();
        while(previous[vertices.indexOf(destination)] != null){
            s.add(destination);
            destination = previous[vertices.indexOf(destination)];
        }

        for (Vertice vertice : s) {
            System.out.print(vertice.nome + " -> ");
        }

        System.out.print(source.nome);
        
    }

    private Vertice minSize(Queue<Vertice> queue, ArrayList<Vertice> vertices){
        Vertice min = queue.element();
        for (Vertice vertice : queue) {
            if(dist[vertices.indexOf(min)] > dist[vertices.indexOf(vertice)]){
                min = vertice;
            }  
        }
        return min;
    }  
}
