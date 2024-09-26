import java.util.concurrent.*;

public class Node implements Runnable {

  private final BlockingQueue<Task> taskQueue;


  public Node(BlockingQueue<Task> taskQueue){
    this.taskQueue = taskQueue;
  }

    @Override
    public void run() {
      try{
        while(true){
          Task task = taskQueue.take();
          System.out.println("Node " + Thread.currentThread().getName() + "processando tarefa " + task.getId());
          task.execute();
          System.out.println("Node " + Thread.currentThread().getName() + "completou a tarefa " + task.getId());
        }
      }catch(InterruptedException e){
        Thread.currentThread().interrupt();
        System.out.println("Node interrompido");
    }
  }
}
