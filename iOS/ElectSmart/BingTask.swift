//
//  BingTask.swift
//  ElectSmart
//
//  Created by Nick on 4/5/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import Foundation
import SwiftyJSON
import Alamofire
import UIKit

extension String
{
    func fromBase64() -> String
    {
        let data = NSData(base64EncodedString: self, options: NSDataBase64DecodingOptions(rawValue: 0))
        return String(data: data!, encoding: NSUTF8StringEncoding)!
    }
    
    func toBase64() -> String
    {
        let data = self.dataUsingEncoding(NSUTF8StringEncoding)
        return data!.base64EncodedStringWithOptions(NSDataBase64EncodingOptions(rawValue: 0))
    }
}

public class BingTask{
    
    let newsurl = "https://api.datamarket.azure.com/Bing/Search/v1/News?Query=%27Hillary%20Clinton%27&$format=JSON"
    let keyString:String = "fDs4/JuSlVn0HIG0tp4QaQwxuLnfe35r8Kq6ej51RL0:fDs4/JuSlVn0HIG0tp4QaQwxuLnfe35r8Kq6ej51RL0"
    

    let keyEncoded:String
    
    init(){
       keyEncoded = keyString.toBase64()
    
        
        
    }
    
    func makeNewsRequest(){
        
        let headers = ["Authorization": "Basic \(keyEncoded)"]
        Alamofire.request(.GET, newsurl, parameters: nil, encoding: .JSON, headers: headers)
            .responseJSON{ response in
                guard response.2.error == nil else {
                    print("error" + response.2.error.debugDescription + " code was " + response.2.debugDescription)
                    return
                }
                
                if let value: AnyObject = response.2.value {
                    //handle the returned JSON
                    let responseValue = JSON(value)
                    //Handle parsing of results
                    //print("Response was" + responseValue.description)
                    
                    //for each News item, populate data models
                    for item in responseValue["d"]["results"].arrayValue {
                        print(item["Title"].stringValue)
                    }
                }
                }
    }
    
    
}

