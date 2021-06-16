// package main

// func main() {

// }

// func removeDuplicates(nums []int) int {
// 	if len(nums) == 0 {
// 		return 0
// 	}
// 	var fast, slow = 1, 1
// 	for ; fast < len(nums); fast++ {
// 		if nums[fast] != nums[fast-1] {
// 			nums[slow] = nums[fast]
// 			slow++
// 		}
// 	}
// 	return slow

// }
