package br.edu.iftm.actions.tasks;

import java.util.List;

import br.edu.iftm.database.daos.TaskDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.database.models.Task;

public class ListProjectTasks {
    private final TaskDAO dao = new TaskDAO();
    private final Project project;

    public ListProjectTasks(Project project) {
        this.project = project;
    }

    public void list() {
        try {
            List<Task> tasks = this.dao.list(this.project.getId());

            if (!tasks.isEmpty()) {
                for (Task task : tasks) {
                    System.out.println(task);
                }
            } else {
                System.out.println("Nenhum projeto cadastrado ainda!");
            }
        } catch (Exception e) {
            System.out.println("Não foi possível listar as tarefas do projeto. Erro: " + e.getMessage());
        }
    }
}
