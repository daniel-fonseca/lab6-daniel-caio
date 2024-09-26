import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class TaskProducer implements Runnable {
    private final BlockingQueue<Task> taskQueue;
    private final int producerId;
    private final int taskPriority;
    private final long sleepTime;
    private static final AtomicLong idTaskGenerator = new AtomicLong(0); // Gerador de IDs únicos

    public TaskProducer(BlockingQueue<Task> taskQueue, int producerId, int taskPriority, long sleepTime) {
        this.taskQueue = taskQueue;
        this.producerId = producerId;
        this.taskPriority = taskPriority;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                long taskId = idTaskGenerator.getAndIncrement();
                Task task = new Task(taskId, taskPriority);
                taskQueue.put(task);
                System.out.println("Produtor " + producerId + " produziu a tarefa " + task.getId() + " com prioridade " + task.getPriority());
                Thread.sleep(sleepTime); // O intervalo de produção depende do produtor
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Produtor " + producerId + " foi interrompido.");
        }
    }
}
