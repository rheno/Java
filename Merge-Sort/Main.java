
class MergeSort{

	public void sort(int[] arr, int left, int right){
		
		if(left < right){
			
			int mid = left + (right - left) / 2;

			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private void merge(int[] arr, int left, int mid, int right){
		
		int[] leftArray = new int[mid - left + 1];
		int[] rightArray = new int[right - mid];

		int length1 = mid - left + 1;
		int length2 = right - mid;

		for(int i=0 ; i < length1; i++){
			leftArray[i] = arr[i + left];
		}

		for(int i=0 ; i < length2; i++){
			rightArray[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0;
		while(i < length1 && j < length2){
			
			if(leftArray[i] <= rightArray[j]){
				arr[left] = leftArray[i];
				i++;
			}else{
				arr[left] = rightArray[j];
				j++;
			}
			left++;
		}	

		while(i < length1){
			arr[left] = leftArray[i];
			i++;
			left++;
		}

		while(j < length2){
			arr[left] = rightArray[j];
			j++;
			left++;
		}
	
	}

}


class BubbleSort{
	
	public void sort(int[] arr){
		
		for(int i=0 ; i < arr.length - 1; i++){
			for(int j= i + 1 ; j < arr.length; j++){
				
				if(arr[i] >= arr[j]){
					arr[i] = arr[i] + arr[j];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];	
				}
			}
		}
	}	
}

public class Main{

  public static void main(String[] args){
	
	int[] array = new int[10000];

	
	for(int i=array.length - 1; i >= 0 ; i--){
		array[array.length - i - 1] = i;
	}
	
	
	MergeSort ms = new MergeSort();
	ms.sort(array, 0, array.length -1);
	
	
	/*	
	BubbleSort bs = new BubbleSort();
	bs.sort(array);			
	*/
	

	for(int i=0 ; i < array.length ; i++){
		System.out.println(array[i]);
	}
			
  }

}
