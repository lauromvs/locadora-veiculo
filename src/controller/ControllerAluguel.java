package controller;

import model.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class ControllerAluguel {
    private List<Aluguel> alugueis;
    private Integer incrementalId;

    public ControllerAluguel() {
        alugueis = new ArrayList<>();
        incrementalId = 1;
    }

    public Aluguel create(Aluguel aluguel){
        aluguel.setId(incrementalId);
        incrementalId++;
        alugueis.add(aluguel);
        return aluguel;
    }

    public List<Aluguel> read(){
        return alugueis;
    }

    public Aluguel read(Integer id){
        for (Aluguel a: alugueis) {
            if(a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public Aluguel update(Aluguel aluguel){
        for (Aluguel a: alugueis) {
            if(a.getId().equals(aluguel.getId())) {
                a = aluguel;
                return a;
            }
        }
        return null;
    }

    public Aluguel delete(Integer id){
        for (Aluguel a: alugueis) {
            if(a.getId().equals(id)) {
                alugueis.remove(a);
                return a;
            }
        }
        return null;
    }
}
