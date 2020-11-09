import java.util.Random;


public class Consumer
        implements Runnable
{
    private static final int MAX_CONS_TIME = 5000; // 5 seconds


    private static final Random random = new Random();

    private Buffer<Integer> buffer;


    public Consumer( Buffer<Integer> buffer )
    {
        this.buffer = buffer;
    }


    @Override
    public void run()
    {
        while( true ) {
            System.out.println( "take() trying" );
            int value = buffer.take();
            System.out.println( "take() got " + value );

            try {
                Thread.sleep( random.nextInt( MAX_CONS_TIME ) );
            } catch( InterruptedException ex ) {
            }
        }
    }
}
