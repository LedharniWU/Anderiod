//: Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground"

let animalname = "cat"

if animalname == "cat" {
    
    print("nyna")
    
} else if animalname == "elephant" {
    
    print("PAoooooooooooN")
}
    
else{
    
    print("bow")
    
}

// Optional binding
let opt: Int? = 30
let intValue = opt ?? 0
// easy but not safe....
opt! + 45

if let unwrapedInt = opt{
    print("\(unwrapedInt + 45)")
} else {
    
}

guard animalname == "dog" else {
    return
}

func parseResponse(responseData: [String:Any]?, error: Error?) -> String {
    
    if let error = error {
        print("error:\(error.localizedDescription)")
        return ""
    }
    guard let data = responseData else {
        print("response data is empty")
        return ""
    }
    
    guard let id = data["id"] as? String else {
        print("user id is not found.")
        return ""
    }
    
    return id
    
}
