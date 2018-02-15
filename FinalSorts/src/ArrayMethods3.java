import java.util.Arrays;

public class ArrayMethods3 {
	
	public static void main(String[] args) {
		int[] test1 = {3, 4, 2, 7, 12, 22, 0, 1};
		String[] test3 = {"banana", "cherry", "grape", "mango", "starfruit","apple", "durian", "pineapple", "watermelon"};
		
		long start = System.nanoTime();
		String[] mergeResult = mergeSort(test3);
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Merge sort test took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(mergeResult));
		System.out.println("");
		
		start = System.nanoTime();
		int[] pivotFinalPoint = quickSort(test1,0,test1.length-1);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Quick sort test took: " + time + " nanoseconds");
		System.out.println(pivotFinalPoint);
	}
	
	public static String[] mergeSort(String[] list) {
		if(list.length == 1) {
			return list;
		}
		String[] left = Arrays.copyOfRange(list,0,list.length/2);
		String[] right = Arrays.copyOfRange(list, list.length/2, list.length);
		return(merge(mergeSort(left),mergeSort(right)));
	}
	
	public static String[] merge(String[] list1, String[] list2) {
		String[] newArr = new String[list1.length+list2.length];
		int x = 0, y = 0, i = 0;
		while((x<list1.length)&&(y<list2.length)) {
			if(list1[x].compareTo(list2[y])>0) {
				newArr[i] = list2[y];
				y++;
				i++;
			}else if(list2[y].compareTo(list1[x])>0) {
				newArr[i] = list1[x];
				x++;
				i++;
			}
		}
		while(x<list1.length) {
			newArr[i] = list1[x];
			x++;
			i++;
		}
		while(y<list2.length) {
			newArr[i] = list2[y];
			y++;
			i++;
		}
		return newArr;
	}
	
	public static int partition(int [] list1, int front, int back) {
		int w = 0, z = 0;
		while(front != back) {
			if((list1[front]>list1[back])&&(front<back)) {
				SwapInt(list1,front,back);
				z = front;
				front = back;
				back = z + 1;
			}else if((list1[front]<list1[back])&&(front>back)){
				SwapInt(list1,front,back);
				w = front;
				front = back;
				back = w - 1;
			}else if(front<back){
				back--;
			}else if(front>back){
				back++;
			}
		}
		return front;
	}
	
	public static int[] quickSort(int[] list1, int front, int back) {
		int pivotPos = 0;
		if(back>front) {
			pivotPos = partition(list1,front,back);
		}
		// right
		quickSort(list1,front,pivotPos-1);
		// left
		quickSort(list1,pivotPos+1,back);
		return(quickSort(list1,0,list1.length-1));
	}
	
	public static void SwapInt(int[] arr, int index, int index2) {
		int num = arr[index];
		arr[index] = arr[index2];
		arr[index2] = num;
	}
}
