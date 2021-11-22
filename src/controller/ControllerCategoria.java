package controller;

import model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class ControllerCategoria {
    private List<Categoria> categorias;
    private Integer incrementalId;

    public ControllerCategoria() {
        categorias = new ArrayList<>();
        incrementalId = 1;
    }

    public Categoria create(Categoria categoria) {
        categoria.setId(incrementalId);
        incrementalId++;
        categorias.add(categoria);
        return categoria;
    }

    public Categoria read(Integer id) {
        for (Categoria c : categorias) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public List<Categoria> read () {
        return categorias;
    }

    public Categoria update(Categoria categoria) {
        for (Categoria c : categorias) {
            if (c.getId().equals(categoria.getId())) {
                c = categoria;
                return c;
            }
        }
        return null;
    }

    public Categoria delete(Integer id) {
        for (Categoria c : categorias) {
            if (c.getId().equals(id)) {
                categorias.remove(c);
                return c;
            }
        }
        return null;
    }
}
