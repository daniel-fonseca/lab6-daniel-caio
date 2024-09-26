import java.util.concurrent.*;
import java.util.*;

public class Scenario2 {

    public static void main(String[] args) {
        BlockingQueue<Task> taskQueue = new PriorityBlockingQueue<>();

        List<Task> processedTasks = Collections.synchronizedList(new ArrayList<>());

        ExecutorService nodePool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            nodePool.execute(new Node(i, taskQueue, processedTasks));
        }

        ExecutorService producerPool = Executors.newFixedThreadPool(3);
        producerPool.execute(new TaskProducer(taskQueue, 0, 0, 13000));
        producerPool.execute(new TaskProducer(taskQueue, 1, 1, 7000));
        producerPool.execute(new TaskProducer(taskQueue, 2, 2, 3000));
    }
}
