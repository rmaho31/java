
public class RotateLeftApp {

	public static void main(String[] args) {
		int[] n1 = {1,2,3};
		int[] n2 = {5,11,9};
		int[] n3 = {7,0,0};
		int[] n4 = {1,3,5,3,2,1,5,3,3};
		
		for(int n : rotateLeft(n1)) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		for(int n : rotateLeft(n2)) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		for(int n : rotateLeft(n3)) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		for(int n : rotateLeft(n4)) {
			System.out.print(n + " ");
		}
		System.out.println();


	}
	
	public static int[] rotateLeft(int[] n) {
		int[] newArr = new int[n.length];
		for(int i = 0, j = 1; i < n.length; i++, j++) {
			if(j < n.length) {
				newArr[i] = n[j];
			} else {
				newArr[i] = n[j-n.length];
			}
		}
		return newArr;
	}

}
