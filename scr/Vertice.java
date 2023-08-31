package scr;

import java.util.ArrayList;
import java.util.List;

public class Vertice {

    protected List<Vertice> lista;
    protected String nome;

    public Vertice(String nome) {
        this.nome = nome;
        this.lista = new ArrayList<Vertice>();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertice other = (Vertice) obj;
        if (lista == null) {
            if (other.lista != null)
                return false;
        } else if (!lista.equals(other.lista))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

}