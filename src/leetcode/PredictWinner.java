package leetcode;


public class PredictWinner {

    //https://leetcode.com/problems/predict-the-winner/description/
    public boolean predictTheWinner(int[] nums) {
        return
                predictTheWinner(nums,0,0, nums.length-1, true) >= 0;
    }

    public int predictTheWinner(int[] nums, int diffP1P2, int begin, int end, boolean isTurnP1) {
        //player 1 wins if they accumulate more than player o
        // canchoose the begining or the end
        // track pointerBegin and end


        //end
        if (begin == end || begin == nums.length || end == -1) {
            return diffP1P2;
        }


        if (isTurnP1) {
            int a = predictTheWinner(nums, diffP1P2 + nums[begin], begin + 1, end, false);
            int b = predictTheWinner(nums, diffP1P2 + nums[end], begin, end - 1, false);
            return Math.max(a,b);
        } else {
            int c =  predictTheWinner(nums, diffP1P2 - nums[begin], begin + 1, end, true);
            int d =predictTheWinner(nums, diffP1P2 - nums[end], begin, end - 1, true);
            return Math.min(c,d);

        }
    }

    public static void main(String[] args) {
        System.out.println(new PredictWinner().predictTheWinner(new int[] {1,3233,5,2}));
    }
}
