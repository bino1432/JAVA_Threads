public class ThreadEtapa2 implements Runnable {
    private final TarefaSequencial tarefa;

    public ThreadEtapa2(TarefaSequencial tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public void run() {
        try {
            while (!tarefa.isTrabalhoConcluido()) {
                tarefa.executarEtapa2();
                Thread.sleep(1000); // Simula algum trabalho
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
