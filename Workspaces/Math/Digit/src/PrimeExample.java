public class PrimeExample{    
private static int zero,one,two,three,four,five,six,seven,eight,nine;

public static void checkPrime(int n) {
  int i,m=0,flag=0;      
  //it is the number to be checked    
  m=n/2;      
  if(n==0||n==1){  
//   System.out.println(n+" is not prime number");      
  }else{  
   for(i=2;i<=m;i++){      
    if(n%i==0){      
//     System.out.println(n+" is not prime number");      
     flag=1;      
     break;      
    }      
   }      
   if(flag==0)  { 
	   System.out.println(n+" is prime number");
	   String s = ((Integer)n).toString();
   }
////	   for(i=0;i<s.length();i++)
////	   {
////		   switch(s.substring(i,i+1))
////			{
////			case "0":
////				zero++;
////				break;
////			case "1": 
////				one++;
////				break;
////			case "2": 
////				two++;
////				break;
////			case "3": 
////				three++;
////				break;
////			case "4": 
////				four++;
////				break;
////			case "5": 
////				five++;
////				break;
////			case "6": 
////				six++;
////				break;
////			case "7": 
////				seven++;
////				break;
////			case "8": 
////				eight++;
////				break;
////			case "9": 
////				nine++;
////				break;
////			default:
////				break;
////			}
////	   }
////   }  
//  }//end of else  
}
}
public static void main(String args[])
{
	for(int i=2; i<1000000; i++)//test the upperbound of the 
	{
		checkPrime(i);
	}
//	System.out.println("0: "+ zero);
//	System.out.println("1: "+ one);
//	System.out.println("2: "+ two);
//	System.out.println("3: "+ three);
//	System.out.println("4: "+ four);
//	System.out.println("5: "+ five);
//	System.out.println("6: "+ six);
//	System.out.println("7: "+ seven);
//	System.out.println("8: "+ eight);
//	System.out.println("9: "+ nine);
//	System.out.println("number of the digits: "+ zero+one+two+three+four+five+six+seven+eight+nine);
//	System.out.println("zero: "+ ((double)zero)/(zero+one+two+three+four+five+six+seven+eight+nine));
//	System.out.println("one "+ ((double)one)/(zero+one+two+three+four+five+six+seven+eight+nine));
//	System.out.println("two "+ ((double)two)/(zero+one+two+three+four+five+six+seven+eight+nine));
//	System.out.println("three "+ ((double)three)/(zero+one+two+three+four+five+six+seven+eight+nine));
//	System.out.println("four "+ ((double)four)/(zero+one+two+three+four+five+six+seven+eight+nine));
//	System.out.println("five "+ ((double)five)/(zero+one+two+three+four+five+six+seven+eight+nine));
//	System.out.println("six "+ ((double)six)/(zero+one+two+three+four+five+six+seven+eight+nine));
//	System.out.println("seven "+ ((double)seven)/(zero+one+two+three+four+five+six+seven+eight+nine));
//	System.out.println("eight "+ ((double)eight)/(zero+one+two+three+four+five+six+seven+eight+nine));
//	System.out.println("nine "+ ((double)nine)/(zero+one+two+three+four+five+six+seven+eight+nine));
}
}   