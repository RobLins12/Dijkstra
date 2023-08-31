package scr;

import java.util.List;
import java.util.ArrayList;

public class Grafo{

    List<Vertice> vertices;
    List<Aresta> arestas;

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public Grafo() {
        vertices = new ArrayList<Vertice>();
        arestas = new ArrayList<Aresta>();
    }

    public Vertice addVertice(String nome) {
        Vertice v = new Vertice(nome);
        vertices.add(v);
        return v;
    }

    public Aresta addAresta(Vertice origem, Vertice destino, Integer peso) {
        Aresta e = new Aresta(origem, destino, peso);
        arestas.add(e);
        origem.lista.add(destino);
        return e;
    }

    public Integer getPeso(Vertice origem, Vertice destino){
        for (Aresta aresta : arestas) {
            if (aresta.origem.equals(origem) && aresta.destino.equals(destino)) {
                return aresta.peso;
            }
        }
        return null;
    }

    public String toString() {
        String r = "";
        for (Vertice u : vertices) {
            r += u.nome;
            for (Vertice s : u.lista) {
                r += " -> ";
                r += s.nome;
            }
            r += "\n";
        }
        return r;
    }

    public static void main(String[] args) {
        Grafo g = new Grafo();

         /*
             * Foz do Iguaçu = 0
             * Cascavel = 1
             * Pato Branco = 2
             * Campo Mourão = 3
             * Guarapuava = 4
             * União da Vitoria = 5
             * Maringá = 6
             * Irati = 7
             * Londrina = 8
             * Ponta Grossa = 9
             * Curitiba = 10
        */

        Vertice v1 = g.addVertice("Foz do Iguaçu");
        Vertice v2 = g.addVertice("Cascavel");
        Vertice v3 = g.addVertice("Pato Branco");
        Vertice v4 = g.addVertice("Campo Mourao");
        Vertice v5 = g.addVertice("Guarapuava");
        Vertice v6 = g.addVertice("União de vitoria");
        Vertice v7 = g.addVertice("Maringá");
        Vertice v8 = g.addVertice("Irati");
        Vertice v9 = g.addVertice("Londrina");
        Vertice v10 = g.addVertice("Ponta Grossa");
        Vertice v11 = g.addVertice("Curitiba");

        //Vertice 1
        Aresta a1 = g.addAresta(v1, v2, 140);
        Aresta a2 = g.addAresta(v1,v3, 337);

        //Vertice 2
        Aresta a3 = g.addAresta(v2,v1, 140);
        Aresta a4 = g.addAresta(v2, v4, 195);
        Aresta a5 = g.addAresta(v2, v5, 332);
        Aresta a6 = g.addAresta(v2, v6, 414);

        //Vertice 3
        Aresta a7 = g.addAresta(v3, v5, 188);
        Aresta a8 = g.addAresta(v3, v1, 337);

        //Vertice 4
        Aresta a9 = g.addAresta(v4, v2, 195);
        Aresta a10 = g.addAresta(v4, v5, 206);
        Aresta a11 = g.addAresta(v4, v7, 91);

        //Vertice 5
        Aresta a12 = g.addAresta(v5, v2, 322);
        Aresta a13 = g.addAresta(v5, v3, 188);
        Aresta a14 = g.addAresta(v5, v4, 206);
        Aresta a15 = g.addAresta(v5, v9, 318);
        Aresta a16 = g.addAresta(v5, v8, 104);
        Aresta a17 = g.addAresta(v5, v10, 163);

        //Vertice 6
        Aresta a18 = g.addAresta(v6, v2, 414);
        Aresta a19 = g.addAresta(v6, v8, 123);
        Aresta a20 = g.addAresta(v6, v11, 241);

        //Vertice 7
        Aresta a21 = g.addAresta(v7, v4, 91);
        Aresta a22 = g.addAresta(v7, v9, 98);

        //Vertice 8
        Aresta a23 = g.addAresta(v8, v5, 104);
        Aresta a24 = g.addAresta(v8, v6, 123);
        Aresta a25 = g.addAresta(v8, v11, 154);

        //Vertice 9
        Aresta a26 = g.addAresta(v9, v5, 318);
        Aresta a27 = g.addAresta(v9, v7, 98);
        Aresta a28 = g.addAresta(v9, v10, 274);

        //Vertice 10
        Aresta a29 = g.addAresta(v10, v5, 163);
        Aresta a30 = g.addAresta(v10, v9, 274);
        Aresta a31 = g.addAresta(v10, v11, 114);

        //Vertice 11
        Aresta a32 = g.addAresta(v11, v6, 241);
        Aresta a33 = g.addAresta(v11, v8, 154);
        Aresta a34 = g.addAresta(v11, v10, 114);

        Dijkstra algoritmo = new Dijkstra(g);
        algoritmo.initDijkstra(v1, v11);

    }
}
