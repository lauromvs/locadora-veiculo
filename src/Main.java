import controller.ControllerAluguel;
import controller.ControllerCategoria;
import controller.ControllerCliente;
import controller.ControllerVeiculo;
import model.Aluguel;
import model.Categoria;
import model.Cliente;
import model.Veiculo;
import view.ViewConsole;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ControllerCategoria controllerCategoria = new ControllerCategoria();
    private static ControllerCliente controllerCliente = new ControllerCliente();
    private static ControllerVeiculo controllerVeiculo = new ControllerVeiculo();
    private static ControllerAluguel controllerAluguel = new ControllerAluguel();

    public static void main(String[] args) {
        ViewConsole view = new ViewConsole();

        while (true) {
            view.printMenuPrincipal();
            Integer option = sc.nextInt();
            switch (option) {
                case 1: {//ESCOLHEU CADASTRAR
                    view.printMenuCadastrar();
                    handleCadastro();
                    break;
                }
                case 2: { // ESCOLHEU PESQUISAR
                    view.printMenuPesquisar();
                    handlePesquisa();
                    break;
                }
                case 3: { // ESCOLHEU APAGAR
                    view.printMenuApagar();
                    handleApagar();
                    break;
                }
            }
        }

    }

    private static void handleCadastro(){
        Integer option = sc.nextInt();
        switch (option) {
            case 1:  //CADASTRO DE CATEGORIA
                cadastrarCategoria();
                break;

            case 2: //CADASTRO DE CLIENTE
                cadastrarCliente();
                break;

            case 3: //CADASTRO DE VEICUO
                cadastrarVeiculo();
                break;

            case 4: //CADASTRO DE ALUGUEL
                cadastrarAluguel();
                break;

        }
    }

    private static void handlePesquisa(){
        Integer option = sc.nextInt();
        switch (option) {
            case 1:  //PESQUISAR CATEGORIA
                pesquisarCategoria();
                break;

            case 2: //PESQUISAR CLIENTE
                pesquisarCliente();
                break;

            case 3: //PESQUISAR VEICUO
                pesquisarVeiculo();
                break;

            case 4: //PESQUISAR ALUGUEL
                pesquisarAluguel();
                break;
        }
    }

    private static void handleApagar(){
        Integer option = sc.nextInt();
        switch (option) {
            case 1:  //APAGAR CATEGORIA
                apagarCategoria();
                break;
            case 2: //APAGAR CLIENTE
                apagarCliente();
                break;
            case 3: //APAGAR VEICUO
                apagarVeiculo();
                break;
            case 4: //APAGAR ALUGUEL
                apagarAluguel();
                break;
        }
    }

    private static void cadastrarCategoria(){
        Categoria categoria = new Categoria();
        System.out.print("DIGITE O NOME DA CATEGORIA: ");
        categoria.setNome(sc.next());

        if (controllerCategoria.create(categoria) != null) {
            System.out.println("Cadastrado: " + categoria.getId() + " | " + categoria.getNome());
        }
    }

    private static void cadastrarCliente(){
        Cliente cliente = new Cliente();
        System.out.print("DIGITE NOME: ");
        cliente.setNome(sc.next());
        System.out.print("DIGITE CPF: ");
        cliente.setCpf(sc.next());
        System.out.print("DIGITE TELEFONE: ");
        cliente.setTelefone(sc.next());
        if (controllerCliente.create(cliente) != null) {
            System.out.println("Cadastrado: " + cliente.getNome());
        }
    }

    private static void cadastrarVeiculo(){
        Veiculo veiculo = new Veiculo();
        System.out.print("DIGITE MARCA: ");
        veiculo.setMarca(sc.next());
        System.out.print("DIGITE MODELO: ");
        veiculo.setModelo(sc.next());
        if (controllerVeiculo.create(veiculo) != null) {
            System.out.println("Cadastrado: " + veiculo.getMarca() + " " + veiculo.getModelo());
        }
    }

    private static void cadastrarAluguel(){
        Aluguel aluguel = new Aluguel();
        System.out.print("DIGITE ID DO CLIENTE: ");
        Cliente c = controllerCliente.read(sc.nextInt());
        aluguel.setCliente(c);
        System.out.print("DIGITE ID DO VEICULO: ");
        Veiculo v = controllerVeiculo.read(sc.nextInt());
        aluguel.setVeiculo(v);
        // PEGA A DATA DE HOJE COMO RETIRADA
        LocalDate retirada = LocalDate.now();
        aluguel.setRetirada(retirada);

        if (controllerAluguel.create(aluguel) != null) {
            System.out.println("Cadastrado: " + aluguel.getId() + " " + aluguel.getRetirada());
        }

    }

    private static void pesquisarCategoria() {
        System.out.println("DIGETE ID DA CATEGORIA OU 0 PARA TODOS: ");
        Integer input = sc.nextInt();
        if (input == 0) {
            for (Categoria c : controllerCategoria.read()) {
                System.out.println(c.getId() + " | " + c.getNome());
            }
        } else {
            Categoria c = controllerCategoria.read(input);
            System.out.println(c.getId() + " | " + c.getNome());
        }
    }

    private static void pesquisarCliente() {
        System.out.println("DIGETE ID DO CLIENTE OU 0 PARA TODOS: ");
        Integer input = sc.nextInt();
        if (input == 0) {
            for (Cliente c : controllerCliente.read()) {
                System.out.println(c.getId() + " | " + c.getNome());
            }
        } else {
            Cliente c = controllerCliente.read(input);
            System.out.println(c.getId() + " | " + c.getNome());
        }
    }

    private static void pesquisarVeiculo() {
        System.out.println("DIGETE ID DO VEICULO OU 0 PARA TODOS: ");
        Integer input = sc.nextInt();
        if (input == 0) {
            for (Veiculo v : controllerVeiculo.read()) {
                System.out.println(v.getId() + " | " + v.getModelo());
            }
        } else {
            Veiculo v = controllerVeiculo.read(input);
            System.out.println(v.getId() + " | " + v.getModelo());
        }
    }

    private static void pesquisarAluguel() {
        System.out.println("DIGETE ID DO ALUGUEL OU 0 PARA TODOS: ");
        Integer input = sc.nextInt();
        if (input == 0) {
            for (Aluguel a : controllerAluguel.read()){
                System.out.println(a.getId() + " | " + a.getRetirada());
                System.out.println(a.getCliente().getNome() + " | " + a.getVeiculo().getModelo());
            }
        } else {
            Aluguel a = controllerAluguel.read(input);
            System.out.println(a.getId() + " | " + a.getRetirada());
            System.out.println(a.getCliente().getNome() + " | " + a.getVeiculo().getModelo());
        }
    }

    private static void apagarCategoria() {
        System.out.println("DIGETE ID DA CATEGORIA PARA APAGAR: ");
        Integer input = sc.nextInt();
        Categoria c = controllerCategoria.delete(input);
        if (c != null) {
            System.out.println("CATEGORIA APAGADA: " + c.getNome());
        } else {
            System.out.println("CATEGORIA INEXISTENTE");
        }
    }

    private static void apagarCliente() {
        System.out.println("DIGETE ID DO CLIENTE PARA APAGAR: ");
        Integer input = sc.nextInt();
        Cliente c = controllerCliente.delete(input);
        if (c != null) {
            System.out.println("CLIENTE APAGADO: " + c.getNome());
        } else {
            System.out.println("CLIENTE INEXISTENTE");
        }
    }

    private static void apagarVeiculo() {
        System.out.println("DIGETE ID DO VEICULO PARA APAGAR: ");
        Integer input = sc.nextInt();
        Veiculo v = controllerVeiculo.delete(input);
        if (v != null) {
            System.out.println("VEICULO APAGADO: " + v.getModelo());
        } else {
            System.out.println("VEICULO INEXISTENTE");
        }
    }

    private static void apagarAluguel() {
        System.out.println("DIGETE ID DO ALUGUEL PARA DAR BAIXA: ");
        Integer input = sc.nextInt();
        Aluguel a = controllerAluguel.read(input);
        if (a != null) {
            a.setDevolucao(LocalDate.now());
            System.out.println("ALUGUEL ENTREGUE: " + a.getId() + " " + a.getDevolucao());
        } else {
            System.out.println("ALUGUEL INEXISTENTE");
        }
    }
}
