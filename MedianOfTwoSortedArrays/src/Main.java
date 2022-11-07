import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(Arrays.toString(mergeArrays(nums1, nums2)));
        System.out.println(findMedian(mergeArrays(nums1, nums2)));
    }

    public static int[] mergeArrays(int[] nums1, int[] nums2)
    {
        int[] sorted = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                sorted[k] = nums1[i];
                i++;
                k++;
            } else {
                sorted[k] = nums2[j];
                j++;
                k++;
            }
        }
            if (i == nums1.length)
            {
                while (j < nums2.length)
                {
                    sorted[k] = nums2[j];
                    j++;
                    k++;
                }
            }

            if (j == nums2.length)
            {
                while (i < nums1.length)
                {
                    sorted[k] = nums1[i];
                    i++;
                    k++;
                }
            }
        return sorted;
    }

    public static double findMedian(int[] sorted)
    {
        if (sorted.length == 1)
            return sorted[0];
        if (sorted.length % 2 == 0)
        {
            int index = sorted.length / 2;
            return ((double)sorted[index - 1] + sorted[index]) / 2;
        }
        else
        {
            int index = sorted.length / 2;
            return sorted[index];
        }
    }
}