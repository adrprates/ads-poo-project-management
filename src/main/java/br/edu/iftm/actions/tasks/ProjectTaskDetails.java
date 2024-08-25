package br.edu.iftm.actions.tasks;

import br.edu.iftm.database.daos.TaskDAO;
import br.edu.iftm.database.models.Project;
import br.edu.iftm.database.models.Task;
import br.edu.iftm.utils.Scanner;

public class ProjectTaskDetails {
    private final TaskDAO dao = new TaskDAO();
    private final Scanner scanner = new Scanner();
    private final Project project;

    public ProjectTaskDetails(Project project) {
        this.project = project;
    }

    public void show() {
        try {
            int projectId = this.project.getId();
            int taskId = this.askTaskId();

            Task task = this.dao.find(projectId, taskId);

            this.displayProjectTaskInfo(task);
        } catch (Exception e) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    private int askTaskId() {
        System.out.print("ID da tarefa: ");
        return this.scanner.readInt();
    }

    private void displayProjectTaskInfo(Task task) {
        System.out.println(task.getDescription());
        System.out.println("STATUS: " + task.getStatus());
        System.out.println("Data de entrega: " + task.getCompletionDate());
    }
}
