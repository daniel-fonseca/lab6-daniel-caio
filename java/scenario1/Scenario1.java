import java.util.concurrent.*;
import java.util.*;

public class Scenario1 {

    public static void main(String[] args) {

        BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>();
        List<Task> processedTasks = Collections.synchronizedList(new ArrayList<>());
        ExecutorService nodePool = Executors.newFixedThreadPool(3);
        ExecutorService producerPool = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 3; i++){
            nodePool.execute(new Node(i, taskQueue, processedTasks));
        }

        for(int i = 0; i < 5; i++){
            producerPool.execute(new TaskProducer(taskQueue, i));
        }

        ScheduledExecutorService reportScheduler = (ScheduledExecutorService) Executors.newSingleThreadExecutor();
        reportScheduler.scheduleAtFixedRate(() -> {
            synchronized (processedTasks){
                if(processedTasks.isEmpty()){
                    System.out.println("Nenhuma tarefa foi processada ate o momento");
                    return;
                }
                

                for(Task task : processedTasks){
                    long timeActive = System.currentTimeMillis() - task.getCreationTime();
                    System.out.println("Tarefa " + task.getId() + "ficou ativa por " + timeActive + "ms.");
                }
            }
        }, 0, 5, TimeUnit.SECONDS);
    }   
}