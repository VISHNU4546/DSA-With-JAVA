public class DivideAndConquer {
    static void print(int arr[]){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    static void merge(int arr[],int s,int e,int m){
    int temp [] = new int [e-s+1];
    // int length1 = m-s+1;
    // int length2 = e-m;

    int i = s,j =m+1;
    int index = 0;
            while(i<=m && j<=e){
                if(arr[i]<arr[j]){
                    temp[index++] = arr[i++];
                }
                else{
                    temp[index++] = arr[j++];
                }
            }
             while(i<=m){
                temp[index++] = arr[i++];
             }
             while(j<=e){
                  temp[index++] = arr[j++];
             }

int k;
             for( k = 0,i=s;k<temp.length;k++,i++){
                arr[i] =temp[k];
             }

    }
  static void mergeSort(int arr[],int start,int end){
    if(start>=end){
        return;
    }
    int mid = start + (end-start)/2;
   mergeSort(arr,start,mid);
   mergeSort(arr,mid+1,end);
merge(arr,start,end,mid);

  }

  public static void quickSort(int arr[],int s,int e){
    if(s>=e){
        return;
    }

    int pIdx = partion(arr,s,e);
    quickSort(arr, s, pIdx-1);
    quickSort(arr, pIdx+1, e);

  }

  public static int partion(int arr[],int s,int e){

    int pivot = arr[e];
    int i = s-1;
    for(int j = s;j<e;j++){
        if(arr[j]<=pivot){
            i++;
            int temp = arr[j];
            arr[j] = arr[i]; 
            arr[i] =temp;
            
        }

    }
    i++;
    int temp = pivot;
    arr[e] = arr[i];
    arr[i] = temp;
    return i;  
  }

    public static void main(String args[]){

        int arr[] = {6,3,2,9,5};
        // mergeSort(arr,0,4);
        quickSort(arr,0,4);
         print(arr);
        //  System.out.print("hello");
    }
}
