package controller;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ControllerCliente {
    private List<Cliente> clientes;
    private Integer incrementalId;

    public ControllerCliente() {
        clientes = new ArrayList<>();
        incrementalId = 1;
    }

    public Cliente create(Cliente cliente) {
        cliente.setId(incrementalId);
        incrementalId ++;
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> read() {
        return clientes;
    }

    public Cliente read(Integer id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Cliente update(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getId().equals(cliente.getId())) {
                c = cliente;
                return c;
            }
        }
        return  null;
    }

    public Cliente delete(Integer id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                clientes.remove(c);
                return c;
            }
        }
        return null;
    }

}
