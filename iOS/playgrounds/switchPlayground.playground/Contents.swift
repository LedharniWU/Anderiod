//: Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground"


let num:Int = 20

switch num {
case 10...20:
    print("hoge")

case 18:
    print("fuge")
default:
    break
}

if num == 20 {
    
} else if num == 18 {
    
}else{
    
}

let array = [1, 2, 3, 4, 5, 6]
array.count

for number in 1...10 {
    print("number: \(number)")
}

var array2:[Int] = [1, 2, 3, 4, 5, 6,]
let stringArray:[String] = ["Sunday","Monday"]
stringArray[0]
stringArray[1]

for dayOfWeek in stringArray {
    print("today is: \(dayOfWeek)")
}

Array(repeating: "sunday", count: 5)

let emptyArray:[Int] = []

if array2.count == 10 {
    
}else{
    array2.append(7)
    print("array is:\(array2)")
}

let array3:[Int] = [7, 8, 9, 10]
let array4:[Int] = array3 + [11, 12]

var array5:[Int] = [1,2,4,5,6]
array5.insert(3, at: 2)






