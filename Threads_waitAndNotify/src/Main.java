public class Main {

    public static void main(String[] args) {
        TarefaSequencial tarefa = new TarefaSequencial();

        Thread t1 = new Thread(new ThreadEtapa1(tarefa), "Thread 1");
        Thread t2 = new Thread(new ThreadEtapa2(tarefa), "Thread 2");
        Thread t3 = new Thread(new ThreadEtapa3(tarefa), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

}
