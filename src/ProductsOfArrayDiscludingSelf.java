import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsOfArrayDiscludingSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,4,6};


        int [] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] productExceptSelf(int[] nums) {
        List <Integer> result = new ArrayList<Integer>();
        int prod = 1;
        int zeroCount = 0;
        for(Integer num:nums){
            if(num != 0)
                prod =  prod * num;
            else {
                zeroCount++;
            }
        }
        if(zeroCount >1){
            return new int [nums.length];
        }

        for( int i = 0 ; i<nums.length ; i++){

            if (zeroCount > 0) {
                result.add((nums[i] == 0) ? prod : 0);
            }else{

                result.add(prod/nums[i]);
            }

        }
        int [] o =  result.stream().mapToInt(i -> i).toArray();
        return  o;
    }
}
