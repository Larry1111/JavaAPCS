// Implements the game of Craps logic

public class CrapsGame
{
	private enum State{NEW_ROLL,KEEP_ROLLING};
	private State state = State.NEW_ROLL;
	private int point = 0;

  /**
   *  Calculates the result of the next dice roll in the Craps game.
   *  The parameter total is the sum of dots on two dice.
   *  point is set to the saved total, if the game continues,
   *  or 0, if the game has ended.
   *  Returns 1 if player won, -1 if player lost,
   *  0 if player continues rolling.
   */  
	
	  public int processRoll(int total) {
		  int result = 0;
	        switch(state) { // le first roll
	        case NEW_ROLL:
	        	switch(total) {
	                case 7:
	                case 11:
	                    result = 1;
	                    return result;
	                
	                case 2:
	                case 3:
	                case 12:
	                    result = -1;
	                    return result;
	                
	                    
	                default:
	                	result = 0;
	                    point = total;
	                    state = State.KEEP_ROLLING;
	                    return result;
	            }
	        
	        case KEEP_ROLLING:
	        	
	            if (total == point) {
	                result = 1;
	                point = 0;
	                state = State.NEW_ROLL;
	            } 
	            else if (total == 7) {
	                result = -1;
	                point = 0;
	                state = State.NEW_ROLL;
	            } 
	            else {
	            	state = State.KEEP_ROLLING;
	            	result = 0;
	            }
	            
	        }
	        return result;
	  }
	    
	            
	            
	            
	        
	        	

	    /**
	     * Returns the saved point
	     */
	    public int getPoint() {
	        return point;
	    }
  }

