import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread {
	
    Buffer buffer;
    public int id;
    private int wT, lR, uR;
    private boolean run;
    
    Producer(int id, int wT, int lR, int uR, Buffer buffer) {
    	this.id = id;
    	this.wT = wT;
    	this.lR = lR;
    	this.uR = uR;
        this.buffer = buffer;
        this.run = true;
    }

    public void halt() {
    	this.run = false;
    }
    
    private String makeID(int num) {
    	return Thread.currentThread().getName() + Integer.toString(num++);
    }
    
    @Override
    public void run() {
        System.out.println("Running Producer: " + this.id + "\n");
        Random r = new Random(System.currentTimeMillis());
        int num = 1;
        Product product = new Product(Integer.toString(this.id));
        
        while(this.run) {
        	SchemeGenEval geneval = new SchemeGenEval(this.lR,this.uR);
        	product.setProduct(geneval.getOpr());
        	product.setResult(geneval.getResultS());
        	this.buffer.produce(product);
        }
        try {
            Thread.sleep(this.wT);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

