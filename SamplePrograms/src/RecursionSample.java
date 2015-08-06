import java.util.Arrays;


public class RecursionSample {

	public static String exR1(int n)
	{
		if (n <= 0) return "";
		return exR1(n-3) + n + exR1(n-2) + n;
	}
	
	public static int mystery(int a, int b)
	{
		System.out.printf("a=%d, b = %d\n", a, b);
		if (b == 0) return 1;
		if (b % 2 == 0) return mystery(a*a, b/2);
		return mystery(a*a, b/2) * a;
	}

	/**
	 * Find magic index i where arr[i] = i, arr is sorted but has duplicates
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public static int findMagicIndex(int[] arr, int start, int end)
	{
		System.out.printf("start: %d, end: %d\n", start, end);
		if (start < 0 || end > arr.length || start > end)
		{
			return -1;
		}
		
		int mid = (start + end)/2;
		int midVal = arr[mid];
		System.out.println("Mid is " + mid);
		
		if (mid == midVal)
		{
			return mid;
		}
		
		int left = findMagicIndex(arr, start, Math.min(midVal, mid-1));
		
		if (left >= 0)
		{
			return left;
		}
		
		int right = findMagicIndex(arr, Math.max(midVal, mid+1), end);
		
		return right;
	}
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(exR1(6));
		System.out.println(mystery(2,25));
		System.out.println(mystery(3,11));
		
		int[] arr = {-2, 2, 3, 4, 5, 6, 7, 7, 9, 10, 11};
				
		System.out.printf("Magic index in arr %s: %d\n", Arrays.toString(arr), findMagicIndex(arr, 0, arr.length-1));
	}

}
