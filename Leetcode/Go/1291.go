// package main

// import "sort"

// func main() {
// 	sequentialDigits(1, 100)
// }
// func sequentialDigits(low int, high int) []int {
// 	var ret []int
// 	for i := 1;i<10;i++{
// 		num := i
// 		for j := i+1;j<10;j++{
// 			num = num *10 +j
// 			if low <= num && num <= high{
// 				ret = append(ret, num)
// 			}
// 		}
// 	}
//    sort.Ints(ret)
//    return ret

// }
