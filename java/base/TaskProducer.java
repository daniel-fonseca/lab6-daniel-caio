import java.util.concurrent.BlockingQueue;

public class TaskProducer implements Runnable {

    private final BlockingQueue<Task> taskQueue;
    private int idProdutor;
    private final long idTask = 0;

    public TaskProducer(BlockingQueue<Task> taskQueue, int idProdutor) {
        this.taskQueue = taskQueue;
        this.idProdutor = idProdutor;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}