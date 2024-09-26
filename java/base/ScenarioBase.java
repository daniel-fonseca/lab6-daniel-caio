import java.util.concurrent.*;

public class ScenarioBase {

    public static void main(String[] args) {

        BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>();
        ExecutorService nodePool = Executors.newFixedThreadPool(3);
        ExecutorService producerPool = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 3; i++){
            nodePool.execute(new Node(taskQueue));
        }

        for(int i = 0; i < 5; i++){
            producerPool.execute(new TaskProducer(taskQueue, i));
        }



    }
}
