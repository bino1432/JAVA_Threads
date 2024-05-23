public class ThreadEtapa3 implements Runnable {
    private final TarefaSequencial tarefa;

    public ThreadEtapa3(TarefaSequencial tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public void run() {
        try {
            while (!tarefa.isTrabalhoConcluido()) {
                tarefa.executarEtapa3();
                Thread.sleep(1000); // Simula algum trabalho
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
