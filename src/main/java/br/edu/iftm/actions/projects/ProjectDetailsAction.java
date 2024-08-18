package br.edu.iftm.actions.projects;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.daos.ProjectDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.utils.Scanner;

public class ProjectDetailsAction implements Action {
    private final ProjectDAO dao = new ProjectDAO();
    private final Scanner scanner = new Scanner();

    public void execute() {
        try {
            int projectId = this.askProjectId();

            Project project = this.dao.find(projectId);

            this.displayProjectInfo(project);
        } catch (Exception e) {
            System.out.println("Projeto não encontrado!");
        }
    }

    private int askProjectId() {
        System.out.print("ID do projeto: ");
        return this.scanner.readInt();
    }

    private void displayProjectInfo(Project project) {
        System.out.println("Nome: " + project.getName());
        System.out.println("Descrição: " + project.getDescription());
        System.out.println("Status: " + project.getStatus());

        if (project.getStartAt() != null) {
            System.out.println("Iniciado em: " + project.getStartAt());
        }

        if (project.getEndAt() != null) {
            System.out.println("Finalizado em: " + project.getEndAt());
        }
    }
}
