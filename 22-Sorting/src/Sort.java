import java.util.Arrays;

public class Sort {
  public static void main(String[] args) {
    int[] array = {1, 17, 7, 2, 4};
    quickSort(array);
    for (int i : array) {
      System.out.print(i + " ");
    }
  }

  public static void selectionSort(int[] array) {
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
      // Findet das kleinste Element im unsortierten Teil des Arrays
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      // Tauscht das gefundene kleinste Element mit dem
      // ersten Element des unsortierten Teils
      swapElements(array, i, minIndex);
    }
  }

  public static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int key = array[i];
      int j = i - 1;
      // Verschiebe Elemente des Arrays, die größer als der Schlüssel sind,
      // eine Position nach rechts
      while (j >= 0 && array[j] > key) {
        array[j + 1] = array[j];
        j = j - 1;
      }
      array[j + 1] = key;
    }
  }

  public static void bubbleSort(int[] arr) {
    int min;

    for (int i = arr.length - 1; i >= 1; i--) {
      for (int j = 0; j < i; j++) {
        // Elemente [i..arr.length-1] sind sortiert
        if (arr[j] > arr[j + 1])
          swapElements(arr, j, j + 1);
      }
    }
  }

  private static void swapElements(int[] array, int pos, int minIndex) {
    int tmp = array[minIndex];
    array[minIndex] = array[pos];
    array[pos] = tmp;
  }


  public static void mergeSort(int[] arr) {
    mergeSort(arr, 0, arr.length - 1);
  }

  static void mergeSort(int[] arr, int start, int end) {
    if (start >= end) return;

    int middle = (start + end) / 2;

    mergeSort(arr, start, middle);
    mergeSort(arr, middle + 1, end);
    merge(arr, start, middle, end);
  }

  static void merge(int[] arr, int start, int middle, int end) {
    int[] left = Arrays.copyOfRange(arr, start, middle + 1);
    int[] right = Arrays.copyOfRange(arr, middle + 1, end + 1);

    int i = 0, j = 0, k = start;

    // jeweils das kleinere Element anhängen
    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        arr[k++] = left[i++];
      } else {
        arr[k++] = right[j++];
      }
    }

    // Reste von links
    while (i < left.length) {
      arr[k++] = left[i++];
    }

    // Reste von rechts
    while (j < right.length) {
      arr[k++] = right[j++];
    }
  }

  static void merge2(int[] arr, int start, int middle, int end) {
    if (end - start >= 1) {
      int a = 0;
      int b = 0;
      final int na = middle - start + 1;
      final int nb = end - middle;
      int[] buf = new int[na + nb];

      // jeweils das kleinere Element anhängen
      while (a < na && b < nb) {
        if (arr[start + a] <= arr[middle + 1 + b]) {
          buf[a + b] = arr[start + a];
          a++;
        } else {
          buf[a + b] = arr[middle + 1 + b];
          b++;
        }
      }
      // evtl. Reste von a anhaengen
      while (a < na) {
        buf[a + b] = arr[start + a];
        a++;
      }
      // evtl. Reste von b anhaengen
      while (b < nb) {
        buf[a + b] = arr[middle + 1 + b];
        b++;
      }
      // Zurückkopieren ins ursprüngliche Array
      for (int i = 0; i < na + nb; ++i) {
        arr[start + i] = buf[i];
      }
    }
  }

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}

	static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int divider = partition(arr, start, end);
			quickSort(arr, start, divider - 1);
			quickSort(arr, divider + 1, end);
		}
	}

  // Aufteilung a la Robert Sedgewick
	static int partition(int[] arr, int start, int end) {
		final int pivot = arr[end];
		int left  = start - 1;
		int right = end;

		while (left < right) {
			do { left++; } while (arr[left] < pivot);
			do { right--; } while (arr[right] > pivot && left < right);

			if (left < right)
				swapElements(arr, left, right);
		}
		swapElements(arr, left, end);
		return left;
	}
}
