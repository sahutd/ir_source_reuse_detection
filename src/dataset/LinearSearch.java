class LinearSearch
{
    // This function returns index of element x in arr[]
    static int search(int arr[],  int x)
    {
        for (int i = 0; i < 100; i++)
        {
            // Return the index of the element if the element
            // is found
            if (arr[i] == x)
                return i;
        }
  
        // return -1 if the element is not found
        return -1;
    }
} 
