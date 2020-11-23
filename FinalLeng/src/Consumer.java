import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread {
    Buffer buffer;
    int id;
    Integer wT;
    
    Consumer(int id, Integer wT , Buffer buffer) {
        this.buffer = buffer;
        this.id = id;
        this.wT = wT;
    }
   
    private boolean halt;
    
    public void halt() {
        this.halt = true;
    }
   
    
    @Override
    public void run() {
        System.out.println("Running Consumer...");
        Product product;
        try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        while(!this.halt) {
            product = this.buffer.consume(Integer.toString(this.id));
            //System.out.println("Consumer consumed: " + product);
            Buffer.print("Consumer consumed: " + product);
            
            try {
                Thread.sleep(this.wT);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                
            }catch (ArrayIndexOutOfBoundsException e){
            	Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
