package ti2cc;

import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {

        CelularDAO celularDAO = new CelularDAO();

        Celular celular = new Celular(128, "apple", "phonezin", 3000.47);
        Scanner sc = new Scanner(System.in);

        Menu();
        int op = sc.nextInt();

        while (op >= 1 && op <= 4) {
            if (op == 1) {
                System.out.println("\n\n==== Inserir Celular === ");
                if (celularDAO.insert(celular) == true) {
                    System.out.println("Inserção com sucesso -> " + celular.toString());

                    System.out.println("\n\n==== Testando autenticação ===");
                    System.out.println(
                            "Celular (" + celular.getModelo() + "): " + celularDAO.autenticar("phonezin", "apple"));
                }
            } else if (op == 2) {
                int opp = 0;
                listage();
                opp = sc.nextInt();
                if (opp == 1) {
                    System.out.println("\n\n==== Mostrar celulares por preco === ");
                    List<Celular> celulares = celularDAO.getOrderByPreco();
                    for (Celular u : celulares) {
                        System.out.println(u.toString());
                    }
                } else if (opp == 2) {
                    System.out.println("\n\n==== Mostrar celulares por marca === ");
                    List<Celular> celulares = celularDAO.getOrderByMarca();
                    for (Celular u : celulares) {
                        System.out.println(u.toString());
                    }
                } else if (opp == 3) {
                    System.out.println("\n\n==== Mostrar celulares por memoria === ");
                    List<Celular> celulares = celularDAO.getOrderByMemoria();
                    for (Celular u : celulares) {
                        System.out.println(u.toString());
                    }
                }
            } else if (op == 3) {

                System.out.println("\n\n==== Atualizar marca (marca (" + celular.getMarca() + ") === ");
                celular.setMarca("xiaomi");
                celularDAO.update(celular);
                System.out.println("\n\n==== Testando Autenticação ===");
                System.out.println("Pizza (" + celular.getMarca() + "): " + celularDAO.autenticar("phonezin", "xiaomi"));
                System.out.println("\n\n==== Invadir usando SQL Injection ===");
                System.out.println(
                        "Pizza (" + celular.getMarca() + "): " + celularDAO.autenticar("xiaomi", "x' OR 'x' LIKE 'x"));
            } else {
                System.out.println("\n\n==== Excluir celular (marca " + celular.getMarca() + ") === ");
                celularDAO.delete(celular.getMarca());
            }

            Menu();
            op = sc.nextInt();

            System.out.println("\n\n==== FIM DO PROGRAMA ====");
            //sc.close();
        }

    }

    public static void Menu() {
        System.out.println("\nMENU DE OPÇÕES:");
        System.out.println("1) Inserir");
        System.out.println("2) Listar");
        System.out.println("3) Atualizar");
        System.out.println("4) Excluir");
        System.out.println("5) Sair");
    }

    public static void listage() {
        System.out.println("Quer que a listagem venha de que maneira?");
        System.out.println("1) Por preco");
        System.out.println("2) Por marca");
        System.out.println("3) Por memória"); 
    }
}

