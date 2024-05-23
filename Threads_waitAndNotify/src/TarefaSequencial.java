public class TarefaSequencial {
    private int etapaAtual = 1;
    private final Tarefa lock = new Tarefa();
    private boolean trabalhoConcluido = false;

    public void executarEtapa1() throws InterruptedException {
        synchronized (lock) {
            while (etapaAtual != 1 && !trabalhoConcluido) {
                lock.wait();
            }
            System.out.println("Etapa 1 executada por " + Thread.currentThread().getName());
            etapaAtual = 2;
            lock.notify();
        }
    }

    public void executarEtapa2() throws InterruptedException {
        synchronized (lock) {
            while (etapaAtual != 2 && !trabalhoConcluido) {
                lock.wait();
            }
            System.out.println("Etapa 2 executada por " + Thread.currentThread().getName());
            etapaAtual = 3;
            lock.notify();
        }
    }

    public void executarEtapa3() throws InterruptedException {
        synchronized (lock) {
            while (etapaAtual != 3 && !trabalhoConcluido) {
                lock.wait();
            }
            System.out.println("Etapa 3 executada por " + Thread.currentThread().getName());
            etapaAtual = 1; // Redefine para ciclos futuros
            trabalhoConcluido = true;
            lock.notify();
        }
    }

    public boolean isTrabalhoConcluido() {
        synchronized (lock) {
            return trabalhoConcluido;
        }
    }
}