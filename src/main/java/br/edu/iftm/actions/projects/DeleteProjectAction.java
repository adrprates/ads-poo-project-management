package br.edu.iftm.actions.projects;

import br.edu.iftm.actions.Action;
import br.edu.iftm.database.models.ProjectModel;
import br.edu.iftm.database.repositories.projects.DeleteProjectRepository;

public class DeleteProjectAction implements Action {
    private final DeleteProjectRepository repository = new DeleteProjectRepository();
    private final ProjectModel project;

    public DeleteProjectAction(ProjectModel project) {
        this.project = project;
    }

    public void execute() {
        try {
            this.repository.delete(project.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
