package dev.solar.baekjoon;

public class MergeSort {
    private int[] arr;
    private int[] sortedArr;

    public static void main(String[] args) {
        int[] arr = {15, 25, 22, 357, 16, 23, -53, 12, 46, 3};
        MergeSort ms = new MergeSort();
        int[] result = ms.sort(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] sort(int[] arr) {
        this.arr = arr;
        this.sortedArr = new int[arr.length];
        mergeSort(0, arr.length);
        return arr;
    }

    // arr[st:en]을 정렬하고 싶다.
    public void mergeSort(int st, int en) {
        if (st + 1 == en) // 리스트의 길이가 1인 경우
            return ;
        int mid = (st + en) / 2;
        mergeSort(st, mid); // arr[st:mid]을 정렬한다.
        mergeSort(mid, en); // arr[mid:en]을 정렬한다.
        merge(st, en); // arr[st:mid]와 arr[mid:en]을 합친다.
    }

    // mid = (st+en)/2라고 할 때 arr[st:mid], arr[mid:en]은 이미 정렬이 되어있는 상태일 때 arr[st:mid]와 arr[mid:en]을 합친다.
    public void merge(int st, int en) {
        int mid = (st + en) / 2;
        int lidx = st;
        int ridx = mid;

        for (int i = st; i < en; i++) {
            if (lidx == mid)
                sortedArr[i] = arr[ridx++];
            else if (ridx == en)
                sortedArr[i] = arr[lidx++];
            else if (arr[lidx] <= arr[ridx])
                sortedArr[i] = arr[lidx++];
            else
                sortedArr[i] = arr[ridx++];
        }

        //sortedArr을 그대로 사용하면 안되고, 부분 정렬시킨 arr을 가지고 다시 재 정렬 해야하므로 다시 값을 넣어줘야 함!!
        System.arraycopy(sortedArr, st, arr, st, en - st);
//        for (int i = st; i < en; i++) {
//            arr[i] = sortedArr[i];
//        }
    }
}
