package scr;

public class Aresta {
    Vertice origem;
    Vertice destino;
    Integer peso;

    public Aresta(Vertice origem, Vertice destino, Integer peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
}