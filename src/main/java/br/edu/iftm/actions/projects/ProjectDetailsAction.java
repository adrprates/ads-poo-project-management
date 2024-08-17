package br.edu.iftm.actions.projects;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.database.repositories.projects.FindProjectRepository;
import br.edu.iftm.presentation.menus.ProjectDetailsMenu;
import br.edu.iftm.utils.Scanner;

public class ProjectDetailsAction implements Action {
    private final FindProjectRepository repository = new FindProjectRepository();
    private final Scanner scanner = new Scanner();

    public void execute() {
        try {
            int projectId = this.askProjectId(scanner);

            ProjectModel project = repository.find(projectId);

            this.displayProjectInfo(project);

            ProjectDetailsMenu menu = new ProjectDetailsMenu(project);
            menu.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private int askProjectId(Scanner scanner) {
        System.out.print("ID do projeto: ");
        return scanner.readInt();
    }

    private void displayProjectInfo(ProjectModel project) {
        System.out.println("Nome: " + project.getName());
        System.out.println("Descrição: " + project.getDescription());
        System.out.println("Status: " + project.getStatus());

        if (project.getStartDate() != null) {
            System.out.println("Iniciado em: " + project.getStartDate());
        }

        if (project.getEndDate() != null) {
            System.out.println("Finalizado em: " + project.getEndDate());
        }
    }
}
