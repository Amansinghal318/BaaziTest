package Baazi;

public class SumLeftRightEqual {
//    select id,name from student where score in (select max(score) from student order by id desc limit 3);
    public int leftRightEqualSum(int[] arr){
        int sum=0;
        for(int var:arr)
            sum+=var;
        int tempSum=0;
        for(int i=0;i<arr.length;i++){
            if(sum-2*tempSum-arr[i]==0){
                return i;
            }
            tempSum+=arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        SumLeftRightEqual sumLeftRightEqual=new SumLeftRightEqual();
        int[] arr={1,2,3,4,6};
        System.out.println(sumLeftRightEqual.leftRightEqualSum(arr));
    }
}
