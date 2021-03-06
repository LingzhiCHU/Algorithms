import java.util.ArrayList;
import java.util.List;
/**
 * @author Lingzhi Chu
 * @version 1.0.0
 * @since 2018-11-02
 *
 * Tags: backtracking
 * Note: very important and basic, no duplicates of element itself
 * level: medium
 * Time cost: O(2^n)
 * Space cost: O(n)
 * Methodology: Like a DFS, for each parent, children is the whole list, if "this path" not work, go back to parent node
 * Further related: 1. how to prove runtime 2. if input has duplicates
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(nums,0,res,new ArrayList<>());
        return res;
    }

    void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> tempList) {
        res.add(new ArrayList<Integer>(tempList));
        for (int i = start; i<nums.length; i++) {
            tempList.add(nums[i]);
            start += 1;
            helper(nums, start, res, tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
