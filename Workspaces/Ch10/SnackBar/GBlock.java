import acm.graphics.GRect;

public class GBlock extends GRect{

	
	public int rowInArray;
	public int columnInArray;
	public boolean toRemove;
	
	public GBlock(double x, double y, double width, double height, int row, int column) {
		super(x,y,width,height);
		rowInArray = row;
		columnInArray = column;
		toRemove = false;
			
	}
	public void setLocationInArray(int row, int column){
		rowInArray = row;
		columnInArray = column;
	}

}
