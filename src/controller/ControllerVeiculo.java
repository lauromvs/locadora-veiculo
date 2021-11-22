package controller;

import model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class ControllerVeiculo {
    private List<Veiculo> veiculos;
    private Integer incrementalId;

    public ControllerVeiculo() {
        veiculos = new ArrayList<>();
        incrementalId = 1;
    }

    public Veiculo create(Veiculo veiculo) {
        veiculo.setId(incrementalId);
        incrementalId++;
        veiculos.add(veiculo);
        return veiculo;
    }

    public List<Veiculo> read() {
        return veiculos;
    }

    public Veiculo read(Integer id) {
        for (Veiculo v : veiculos) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public Veiculo update(Veiculo veiculo) {
        for (Veiculo v : veiculos) {
            if (v.getId().equals(veiculo.getId())) {
                v = veiculo;
                return v;
            }
        }
        return null;
    }

    public Veiculo delete(Integer id) {
        for (Veiculo v : veiculos) {
            if (v.getId().equals(id)) {
                veiculos.remove(v);
                return v;
            }
        }
        return null;
    }
}
