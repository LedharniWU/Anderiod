//: Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground"

var dic:[String:String] = ["name":"Led"]
dic["age"] = "24"

//dic["age"] = nil
dic.removeValue(forKey: "age")
print(dic)
