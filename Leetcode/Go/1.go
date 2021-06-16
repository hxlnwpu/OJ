package main

import (
	"fmt"
)

func main() {
	fmt.Println("hello")
}
func twoSum(nums []int, target int) []int {
	var ret []int
	for index, elem := range nums {
		for j := index + 1; j < len(nums); j++ {
			if elem+nums[j] == target {
				ret[0] = index
				ret[1] = j
				return ret
			}
		}
	}
	return ret
}
