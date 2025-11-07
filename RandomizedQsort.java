import java.util.*;
class RandomizedQsort
{
static void chooseRandomPivot(int arr[], int low, int high)
{
Random rand = new Random();
int pivot = rand.nextInt(high - low + 1) + low;
int temp = arr[pivot];
arr[pivot] = arr[high];
arr[high] = temp;
}
static int partition(int arr[], int low, int high)
{
chooseRandomPivot(arr, low, high);
int pivot = arr[high];
int i = low - 1;
for (int j = low; j < high; j++)
{
if (arr[j] < pivot)
{
i++;
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}
}
int temp = arr[i + 1];
arr[i + 1] = arr[high];
arr[high] = temp;
return i + 1;
}
static void sort(int arr[], int low, int high)
{
if (low < high)
{
int pi = partition(arr, low, high);
sort(arr, low, pi - 1);
sort(arr, pi + 1, high);
}
}
static void printArray(int arr[])
{
for (int num : arr)
System.out.print(num + " ");
System.out.println();
}
public static void main(String args[])
{
int arr[] = {10, 7, 8, 9, 1, 5};
sort(arr, 0, arr.length - 1);
System.out.println("Sorted array");
printArray(arr);
}
}
