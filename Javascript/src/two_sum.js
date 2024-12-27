/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  const dictionary = {};
  let i = 0;
  for (const val of nums) {
    if (target - val in dictionary) return [dictionary[target - val], i];
    dictionary[val] = i++;

  }
  return [-1, -1];
};

nums = [2,7,11,15], target = 9
console.log(twoSum(nums,target));