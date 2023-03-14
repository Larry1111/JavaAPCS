
public class Rotate {
	public static void rotateLeft(int[] a) {
        int first = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = first;
    }

    public static void rotateRight(int[] a) {
        int last = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = last;
    }
    public static void rotate(int[] a, int d) {
        while (d < 0) {
            rotateLeft(a);
            d++;
        }
        while (d > 0) {
            rotateRight(a);
            d--;
        }
    
    }
   
    public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		rotate(arr, -12);
		Examples.printIntArray(arr);
    }

	}    
