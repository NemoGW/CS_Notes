public class QuickSort{

    //Driver main class
    public static void main(String[] args){
        int array[] = {10, 80, 30, 90, 40, 50, 70};
        int n = array.length;

        quickSort(array, 0, n-1);

        for(int a : array){
            System.out.print(a + " ");
        }
    }

    //the sorting
    public static void quickSort(int[] array, int beg, int end){
        if(beg < end){
            int p = partition(array, beg, end);

            quickSort(array, beg, p-1);
            quickSort(array, p+1, end);
        }
        
    }

    //re-order array
    public static int partition(int[] array, int beg, int end){
        int pivot = array[end];
        int j = beg-1;

        for(int i=beg; i<end; i++){
            if(array[i] < pivot){
                j++;

                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
            int temp = array[j+1];
            array[j+1] = array[end];
            array[end] = temp;

        return j+1;
        
    }
}