/***************************************************************************
 * Author: Isai Damier
 * Title: Heapsort
 * Project: geekviewpoint
 * Package: algorithms
 *
 * Statement:
 *   Given a disordered list of integers (or any other items),
 *   rearrange the integers in natural order.
 *
 * Sample Input: {8,5,3,1,9,6,0,7,4,2,5}
 * Sample Output: {0,1,2,3,4,5,5,6,7,8,9}
 *
 * Time Complexity of Solution:
 *   Best O(n*log(n)); Average O(n*log(n)); Worst O(n*log(n)).
 *
 * Approach:
 *   Heap sort happens in two phases. In the first phase, the array
 *   is transformed into a heap. A heap is a binary tree where
 *       1) each node is greater than each of its children
 *       2) the tree is perfectly balanced
 *       3) all leaves are in the leftmost position available.
 *    In phase two the heap is continuously reduced to a sorted array:
 *       1) while the heap is not empty
 *          - remove the top of the head into an array
 *          - fix the heap.
 *    Heap sort was invented by John Williams not by B. R. Heap.
 *
 * MoveDown:
 *   The movedown method checks and verifies that the structure is a heap.
 *
 * Technical Details:
 *   A heap is based on an array just as a hashmap is based on an
 *   array. For a heap, the children of an element n are at index
 *   2*n+1 for the left child and 2*n+2 for the right child.
 *
 *   The movedown function checks that an element is greater than its
 *   children. If not the values of element and child are swapped. The
 *   function continues to check and swap until the element is at a position
 *   where it is greater than its children.
 ***************************************************************************/
 public void heapsort(int[] input) {
  // convert input to heap
  int leastParent = (input.length - 1) / 2;
  for (int i = leastParent; i >= 0; i--) {
    moveDown(input, i, input.length - 1);
  }
  // flatten heap into sorted array
  for (int i = input.length - 1; i > 0; i--) {
    if (input[0] > input[i]) {
      swap(input, 0, i);
      moveDown(input, 0, i - 1);
    }
  }
}
 
private void moveDown(int[] input, int first, int last) {
  int largest = 2 * first + 1;
  while (largest <= last) {
    // right child exists and is larger than left child
    if (largest < last && input[largest] < input[largest + 1]) {
      largest++;
    }
    // right child is larger than parent
    if (input[largest] > input[first]) {
      swap(input, largest, first);
      // move down to largest child
      first = largest;
      largest = 2 * first + 1;
    } else {
      return;// force exit
    }
  }
}
 
private void swap(int[] input, int a, int b) {
  int tmp = input[a];
  input[a] = input[b];
  input[b] = tmp;
