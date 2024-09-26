public class Task implements Comparable<Task> {
    private final long id;
    private final long creationTime;
    private final int priority;

    // Construtor atualizando para aceitar a prioridade
    public Task(long id, int priority) {
        this.id = id;
        this.creationTime = System.currentTimeMillis();
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public int getPriority() {
        return priority;
    }

    public void execute() {
        try {
            // Simula o tempo de execução entre 1 e 15 segundos
            long execDuration = 1000 + (long) (Math.random() * (15000 - 1000));
            Thread.sleep(execDuration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Implementa a comparação com base na prioridade
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }
}
