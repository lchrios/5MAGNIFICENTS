

import java.util.Random;

public class SchemeGenEval {
	
	private String operationS ="";
	private float resultS;
	private int lowerLimit;
	private int upperLimit;
	
	public SchemeGenEval(int a, int b) {
		if(a<0 || b>10) throw new IllegalArgumentException();
		
		this.lowerLimit = a;
		this.upperLimit = b;

		String[] operators = {"*","+","-","/"};
		
		Random rand = new Random();
	    int randomOpr = rand.nextInt(4); 
	    
	    //System.out.println( operators[randomOpr]);
	    
	    double randomd1 = Math.random() * (this.upperLimit - this.lowerLimit + 1) + this.lowerLimit;
	    double randomd2 = Math.random() * (this.upperLimit - this.lowerLimit + 1) + this.lowerLimit;
	    
	    int randomI1 = (int) randomd1;
	    int randomI2 = (int) randomd2;

	    
	    this.operationS = "("+ operators[randomOpr] + " " + randomI1 + " " + randomI2 + ")";
	    this.resultS = EvalRes(operators[randomOpr], randomI1, randomI2);   
	}
	
	private float EvalRes(String x, int y, int z) {
		
		float finalF = 0;
		
		if(x == "*") {
			finalF = y*z;
		}
		
		if(x == "-") {
			finalF = y-z;
		}
		
		if(x == "+") {
			finalF = y+z;
		}
		if(x == "/") {
			if(z == 0) {
				finalF = Float.MAX_VALUE;
			}
			else {
				finalF = y/(z);
			}
		}
		return finalF;
	}

	
	
	public String getOpr() {
		return this.operationS;
	}
	
	public float getResultS() {
		return this.resultS;
	}

}


