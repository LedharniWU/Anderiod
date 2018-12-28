//: Playground - noun: a place where people can play

import UIKit
//Tuple（タプル）
let tuple1 = (1, 2, 3)
let tuple2 = (10000,"東京都")
tuple2.0
let tuple = (2, "String", false, 4)

let (num , str, bool, int) = tuple

print(num)
print(str)

let namedTuple = (first:1, second:"Second!", third:true, fourth:"Fourth")
namedTuple.first

func sayHello(){
    print("Hello!")
}
sayHello()
