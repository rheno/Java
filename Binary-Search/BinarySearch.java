import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch{


	private static boolean bSearchIter(int number, int[] array){
		
		int mid, left, right;
	
		left = 0;
		right = array.length-1;

		
	
		while(left <= right){
			
			mid = (left+right)/2;

			if(array[mid] == number){
				return true;
			}else if(array[mid] < number){
				left = mid + 1;
			}else if(array[mid] > number){
				right = mid - 1;
			}
					
		}
		
		return false;
	}


	private static boolean bSearchRec(int number, int left, int right, int[] array){
		
		int mid = (left+right)/2;
		
		if(left <= right){
			if(array[mid] == number){
				return true;
			}else if(array[mid] < number){
				return bSearchRec(number, mid+1, right, array);	
			}else if(array[mid] > number){
				return bSearchRec(number, left, mid-1, array);	
			}		
		}	
	
		return false;
	}

	public static void main(String[] args){
	
		int[] array = null;	
		int size;
	
		Scanner sc = new Scanner(System.in);	
	
		size = sc.nextInt();
	
		array = new int[size];

		for(int i=0;i<size;i++){
			array[i] = sc.nextInt();
		}
	
		Arrays.sort(array);
	
		/* with iterative */
		if(bSearchIter(6, array)){
                          System.out.println("Found");
                }else{
                          System.out.println("Not Found");
                }	
	
		/* with recursive */
		if(bSearchRec(6, 0, array.length-1, array)){
			System.out.println("Found");
		}else{
			System.out.println("Not Found");
		}

		
	
	}

}
