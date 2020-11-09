public class Main {
    public static void main(String[] args) {
        Buffer<Integer> buffer = new BlockingQueue(5);

        Thread prod = new Thread( new Producer( buffer ) );
        Thread cons = new Thread( new Consumer( buffer ) );
        Thread cons2 = new Thread( new Consumer( buffer ) );

        prod.start();
        cons.start();
        cons2.start();
    }
}
