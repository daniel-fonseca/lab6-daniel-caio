import java.util.concurrent.BlockingQueue;
import java.util.List;

public class Node implements Runnable {
    private final BlockingQueue<Task> taskQueue;
    private final List<Task> processedTasks;
    private final int nodeId;

    public Node(int nodeId, BlockingQueue<Task> taskQueue, List<Task> processedTasks) {
        this.nodeId = nodeId;
        this.taskQueue = taskQueue;
        this.processedTasks = processedTasks;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Task task = taskQueue.take();
                System.out.println("Node " + nodeId + " processando tarefa " + task.getId() + " com prioridade " + task.getPriority());
                task.execute();
                System.out.println("Node " + nodeId + " completou a tarefa " + task.getId());

                synchronized (processedTasks) {
                    processedTasks.add(task);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Node " + nodeId + " interrompido.");
        }
    }
}
