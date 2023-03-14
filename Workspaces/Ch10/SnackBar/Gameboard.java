/**
 * This is a program where you play a game in which you must attempt to eliminate all the blocks from the screen by clicking on blocks that have same colored neighbors around them.
 * Ben Gutierrez
 */
import acm.program.GraphicsProgram;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Gameboard extends GraphicsProgram {
	Random rand = new Random();
	
	GBlock[][] Board = new GBlock[10][10];
	
	ArrayList<GBlock> blocksToReview = new ArrayList<>();
	
	
	public void run(){		

		setSize(500,570);
		Label instructions1  = new Label("†Click on blocks that are surrounded by other blocks of the same color to delete them.");
		Label instructions2  = new Label(" Delete all the blocks to win!");
		add(instructions1, NORTH);
		Font myFont = new Font("Serif",Font.BOLD,18);
		instructions2.setFont(myFont);
		add(instructions2,SOUTH);

		
		for(int i=0; i<Board.length; i++) {
			for(int j=0; j<Board[i].length; j++) {			
				Board[i][j] = new GBlock(j*50,i*50,50,50,i,j);
				Board[i][j].setFilled(true);
				Board[i][j].setFillColor(getRandomColor());
				add(Board[i][j]);			
			}
		}
		
		addMouseListeners();
	}
	
	
	public void mouseClicked(MouseEvent e) {
		GBlock selectedBlock = (GBlock) getElementAt(e.getX(), e.getY());
		
		if(selectedBlock != null) {
			
			findSameColoredNeighbors(selectedBlock);
			
			recreateBoard();
		}
	}

	
	public void findSameColoredNeighbors(GBlock selectedBlock) {
		blocksToReview = new ArrayList<>();
		
		reviewMyFourNeighbors(selectedBlock);

		if(!blocksToReview.isEmpty()){
			selectedBlock.toRemove = true;
			for (int i = 0; i<blocksToReview.size(); i++) {
				GBlock currentBlock = blocksToReview.get(i);
				currentBlock.toRemove = true;
				reviewMyFourNeighbors(currentBlock);
			}
		}	
	}
	
	
	public void reviewMyFourNeighbors(GBlock blockToCheck){
		
		int row = blockToCheck.rowInArray;
		int column = blockToCheck.columnInArray;
			
		if (row > 0){
			GBlock topBlock = Board[row-1][column];
			if (topBlock != null){
				if(topBlock.toRemove == false) {
					if(blockToCheck.getFillColor() == topBlock.getFillColor()) {				
						blocksToReview.add(topBlock);
					}				
				}
			}
		}		
		
		if (row < 9) {
			GBlock bottomBlock = Board[row+1][column];
			if(bottomBlock != null){
				if(bottomBlock.toRemove == false) {
					if(blockToCheck.getFillColor() == bottomBlock.getFillColor()) {
						blocksToReview.add(bottomBlock);
					}
				}
			}
		}	
		
		if (column < 9) {
			GBlock rightBlock = Board[row][column+1];
			if(rightBlock != null){
				if(rightBlock.toRemove == false) {
					if(blockToCheck.getFillColor() == rightBlock.getFillColor()) {
						blocksToReview.add(rightBlock);
					}
				}
			}
		}	
		
		if (column > 0) {
			GBlock leftBlock = Board[row][column-1];
			if(leftBlock != null){
				if(leftBlock.toRemove == false) {
					if(blockToCheck.getFillColor() == leftBlock.getFillColor()) {
						blocksToReview.add(leftBlock);
					}
				}
			}
		}
	}
	
	
	public void recreateBoard() {
		GBlock[][] tempBoard = new GBlock[10][10];
		int tempC = 0;
		int tempR = 9;
		
		for(int c=0; c<Board.length; c++) {
			for(int r=Board[c].length-1;r>=0 ; r--){
				if(Board[r][c] != null){
					if(Board[r][c].toRemove == false) {
						tempBoard[tempR][tempC] = Board[r][c];
						tempR--;
					}
				}			
			}
			tempR=9;
			
			if(tempBoard[9][tempC] != null){
				tempC++;
			}
			
		}
		
		removeAll();
		
		for(int i=0; i<Board.length; i++) {
			for(int j=0; j<Board[i].length; j++) {	
				Board[i][j]=tempBoard[i][j];
				if(Board[i][j] != null) {
					Board[i][j].setLocation(j*50, i*50); // set block's new location in canvas
					Board[i][j].setLocationInArray(i, j); // set block's new location in array 
					add(Board[i][j]);	
				}		 
			}
			
		}
		
	}
	
	
	public Color getRandomColor() {
		int bear = rand.nextInt(5);
		switch(bear){
		case 0: return Color.red;
		case 1: return Color.blue;
		case 2: return Color.yellow;
		case 3: return Color.green;
		default: return Color.orange;
		}
		
	}
}
