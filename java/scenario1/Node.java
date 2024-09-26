import java.util.concurrent.*;
import java.util.List;

public class Node implements Runnable {

  private final BlockingQueue<Task> taskQueue;
  private final List<Task> processedTasks;
  public Node(int nodeId,BlockingQueue<Task> taskQueue, List<Task> processedTasks){
    this.taskQueue = taskQueue;
    this.processedTasks = processedTasks;
  }

    @Override
    public void run() {
      try{
        while(true){
          Task task = taskQueue.take();
          System.out.println("Node " + Thread.currentThread().getName() + "processando tarefa " + task.getId());
          task.execute();
          System.out.println("Node " + Thread.currentThread().getName() + "completou a tarefa " + task.getId());

          synchronized (processedTasks){
            processedTasks.add(task);
          }


        }
      }catch(InterruptedException e){
        Thread.currentThread().interrupt();
        System.out.println("Node interrompido");
    }
  }
}
