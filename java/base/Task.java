import java.util.Random;

public class Task {
    private final long id;
    private final long creationTime;

    public Task(long id) {
        this.id = id;
        this.creationTime = System.currentTimeMillis();
    }

    public long getId(){
        return this.id;
    }

    public long getCreationTime() {
        return this.creationTime;
    }

    public void execute() {
        try {
            long execDuration = 1000 + (long) (new Random().nextFloat() * (15000 - 1000));
            Thread.sleep(execDuration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
