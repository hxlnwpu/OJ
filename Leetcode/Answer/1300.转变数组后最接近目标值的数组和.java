class Solution {
    public int findBestValue(int[] arr, int target) {
                        Arrays.sort(arr);
        int ret = arr[0];
        int max= arr[arr.length-1];
        List<Integer> sum = new ArrayList<>();
        int tempSum = arr.length*ret;
        sum.add(tempSum);
        if(tempSum<target){
            while(tempSum<target&&ret<max)
            {
                tempSum = 0;
                ret ++;
                for(int i :arr)
                {
                    tempSum += i>ret?ret:i;
                }
                sum.add(tempSum);
            }

            int answer1 = sum.get(sum.size()-1);
            int answer2 = sum.get(sum.size()-2);
            int cha1 = Math.abs(answer1- target);
            int cha2 = Math.abs(target-  answer2);
            return cha1<cha2?(ret):(ret-1);
        }
        else
        {
            ret = 0;
            tempSum = 0;
            while(tempSum<target)
            {
                tempSum = 0;
                for(int i :arr)
                {
                    tempSum += i>ret?ret:i;
                }
                sum.add(tempSum);
                ret ++;
            }

            int answer1 = sum.get(sum.size()-1);
            int answer2 = sum.get(sum.size()-2);
            int cha1 = Math.abs(answer1- target);
            int cha2 = Math.abs(target-  answer2);
            return cha1<cha2?(ret-1):(ret-2);
        }
    }
}