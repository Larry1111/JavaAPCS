
public abstract class Poem {	
		public abstract int numLines();
		
		public abstract int getSyllables(int k);
		
		public void printRhythm() 
		{
			String str = "";
			for(int i=0;i<numLines();i++)
			{
				for(int j=0;j<getSyllables(i);j++)
				{
					if(j==getSyllables(i)-1)
						str+="ta";
					else
						str+="ta-";
				}
				str+='\n';
			}
			System.out.println(str);
		}
		public static void main(String[]args) {
			Haiku me = new Haiku();
			me.printRhythm();
			Limerick we = new Limerick();
			we.printRhythm();
		}
}

