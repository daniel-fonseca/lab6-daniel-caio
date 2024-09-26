import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class TaskProducer implements Runnable {
    private final BlockingQueue<Task> taskQueue;
    private final int idProdutor;
    private static final AtomicLong idTaskGenerator = new AtomicLong(0); // Gerador de IDs únicos

    public TaskProducer(BlockingQueue<Task> taskQueue, int idProdutor) {
        this.taskQueue = taskQueue;
        this.idProdutor = idProdutor;
    }

    @Override
    public void run() {
        try {
            while (true) {
                long idTask = idTaskGenerator.getAndIncrement(); 
                Task task = new Task(idTask);
                taskQueue.put(task);
                System.out.println("Produtor " + idProdutor + " produziu a tarefa de id " + task.getId());
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Produtor " + idProdutor + " foi interrompido.");
        }
    }
}
