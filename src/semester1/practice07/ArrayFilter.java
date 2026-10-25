package semester1.practice07;

public class ArrayFilter {
    public int[] filter(int[] arr, int threshold) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > threshold) {
                count++;
            }

        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > threshold) {
                result[index] = arr[i];
                index++;
            }
        }
        return result;
    }

    public int[] filter(int[] arr, int min, int max) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && arr[i] <= max) {
                count++;
            }

        }
        int[] result = new int[count];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= min && arr[i] <= max) {
                result[index] = arr[i];
                index++;
            }
        }

        return result;
    }

    public int[] filter(int[] arr, boolean keepEvens) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (keepEvens && arr[i] % 2 == 0) {
                count++;
            } else if (!keepEvens && arr[i] % 2 != 0) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (keepEvens && arr[i] % 2 == 0) {
                result[index] = arr[i];
                index++;
            } else if (!keepEvens && arr[i] % 2 != 0) {
                result[index] = arr[i];
                index++;
            }
        }

        return result;
    }
}