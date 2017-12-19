public class Sort
{
  public void bubbleSort(int numArr[])
  {
   int n = numArr.length;
   
   for(int i = 0; i < n-1; i++)
        for(int j = 0; j < n-i-1; j++)
           if(numArr[j] > numArr[j+1])
           {
            int temp = numArr[j]; 
            numArr[j] = numArr[j+1];
            numArr[j+1] = temp;
           }
  }
  
   public void printArray(int numArr[])
    {
        int n = numArr.length;
        for (int i=0; i<n; ++i)
            System.out.print(numArr[i] + " ");
        System.out.println();
    }
    
   public void selectionSort(int numArr[])
   {
     int n = numArr.length;
     
     for (int i = 0; i < n-1; i++)
     {
     int min = i;
     for(int j = i+1; j < n; j++)
        if(numArr[j] < numArr[min])
         min = j;
     
         
      int temp = numArr[min];
      numArr[min] = numArr[i];
      numArr[i] = temp;
     }
     }

   public void insertionSort(int numArr[])
   {
        int n = numArr.length;
        for (int i = 1; i < n; i++)
        {
            int key = numArr[i];
            int j = i-1;

            while (j >= 0 && numArr[j] > key)
            {
                numArr[j+1] = numArr[j];
                j = j-1;
            }
            numArr[j+1] = key;
        }
   }
   
   public void merge(int numArr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
 
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        for (int i=0; i<n1; ++i)
            L[i] = numArr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = numArr[m + 1+ j];
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                numArr[k] = L[i];
                i++;
            }
            else
            {
                numArr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            numArr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            numArr[k] = R[j];
            j++;
            k++;
        }
    }
 
    public void sort(int numArr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            sort(numArr, l, m);
            sort(numArr , m+1, r);
            merge(numArr, l, m, r);
        }  
   }
 
}
