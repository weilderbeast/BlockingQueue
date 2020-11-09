import java.util.Random;


public class Producer
        implements Runnable
{
    private static final int MAX_PROD_TIME = 5000; // 5 seconds


    private static final Random random = new Random();

    private Buffer<Integer> buffer;


    public Producer( Buffer<Integer> buffer )
    {
        this.buffer = buffer;
    }


    @Override
    public void run()
    {
        while( true ) {
            try {
                Thread.sleep( random.nextInt( MAX_PROD_TIME ) );
            } catch( InterruptedException ex ) {
            }

            int value = random.nextInt();
            System.out.println( "put(" + value + ") trying" );
            buffer.put( value );
            System.out.println( "put(" + value + ") done" );
        }
    }
}