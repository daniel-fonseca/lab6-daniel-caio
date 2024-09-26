import java.util.concurrent.BlockingQueue;

public class TaskProducer implements Runnable {

    private final BlockingQueue<Task> taskQueue;
    private final int idProdutor;
    private long idTask = 0;

    public TaskProducer(BlockingQueue<Task> taskQueue, int idProdutor) {
        this.taskQueue = taskQueue;
        this.idProdutor = idProdutor;
    }

    @Override
    public void run() {
        while (true) {
            Task task = new Task(idTask++);
            try {
                taskQueue.put(task);
                System.out.println("Produtor " + idProdutor + " produziu a task de id " + task.getId());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Produtor " + idProdutor + "foi interrompido");
            }
        }
    }
}