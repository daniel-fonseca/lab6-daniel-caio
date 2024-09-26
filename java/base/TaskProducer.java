import java.util.concurrent.BlockingQueue;

public class TaskProducer implements Runnable {

    private final BlockingQueue<Task> taskQueue;
    private int idProdutor;
    private long idTask = 0;

    public TaskProducer(BlockingQueue<Task> taskQueue, int idProdutor) {
        taskQueue = this.taskQueue;
        idProdutor = this.idProdutor;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}