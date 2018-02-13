import java.util.Arrays;

public class ArrayMethods3 {
	public static String[] mergeSort(String[] list) {
		if(list.length == 1) {
			return list;
		}
		String[] left = Arrays.copyOfRange(list,0,list.length/2);
		String[] right = Arrays.copyOfRange(list, list.length/2, list.length);
		return(merge(mergeSort(left),mergeSort(right)));
	}
	
	public static int partition(int [] list1, int front, int back) {
		if(front == back) {
			return front;
		}
		
	}
	
	public static void quickSort(int[] list1, int front, int back) {
		
	}
}
