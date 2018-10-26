
public class FirstLastSixApp {

	public static void main(String[] args) {
		int[] n1 = {1,2,3,4,5,6,};
		int[] n2 = {6,5,4,3,2,1};
		int[] n3 = {1,2,6};
		int[] n4 = {6,1,2,3};
		int[] n5 = {13,6,1,2,3};

		System.out.println(firstLast6(n1)); // true
		System.out.println(firstLast6(n2)); // true
		System.out.println(firstLast6(n3)); // true
		System.out.println(firstLast6(n4)); // true
		System.out.println(firstLast6(n5)); // true
	}
	
	public static boolean firstLast6(int[] nums) {
		if(nums[0] == 6) {
			return true;
		} else if (nums[nums.length-1] == 6) {
			return true;
		}
		return false;
	}
}
