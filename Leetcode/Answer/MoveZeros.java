public class MoveZeros{
    public static void main(String[] args)
    {
        int[] nums = {0,1,0,3,12};
        int j = 0;
        for(int elem:nums){
            if (elem == 0){
                continue;
            }
            else{
                nums[j] = elem;
                j += 1;
            }
        }
        if(j<nums.length){
            for(int k = j;k<nums.length;k++)
            {
                nums[k] = 0;
            }
        }
        for(int elem:nums){
            System.out.println(elem); 
        }
    }
}
