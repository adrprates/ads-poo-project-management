package br.edu.iftm.menus;

import br.edu.iftm.utils.Scanner;

public class ProjectsMenu extends Menu {
    private final Scanner scanner = new Scanner();

    public void display() {
        while (true) {
            System.out.println("1. Listar todos os projetos");
            System.out.println("2. Listar os projetos pendentes");
            System.out.println("3. Listar os projetos em andamento");
            System.out.println("4. Listar os projetos finalizados");
            System.out.println("5. Criar um projeto");
            System.out.println("6. Ver os detalhes de um projeto");
            System.out.println("0. Voltar para o menu inicial");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:
                    this.displayProjectDetailsMenu();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida! Selecione novamente");
                    break;
            }
        }
    }

    private void displayProjectDetailsMenu() {
        while (true) {
            System.out.println("1. Atualizar o projeto");
            System.out.println("2. Excluir o projeto");
            System.out.println("0. Voltar para o menu de projetos");

            int selectedOption = this.scanner.readInt();

            this.clearConsole();

            switch (selectedOption) {
                case 1:

                    break;

                case 2:

                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida! Selecione novamente");
                    break;
            }
        }
    }
}
