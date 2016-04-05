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
    
    let newsurl = "https://api.datamarket.azure.com/Bing/Search/v1/News?Query=%27Hilary%20Clinton%27&$format=JSON"
    let keyString:String = "fDs4/JuSlVn0HIG0tp4QaQwxuLnfe35r8Kq6ej51RL0"
    let keyEncoded:String
    
    init(){
       keyEncoded = keyString.toBase64()
    
        
        
    }
    
    func makeNewsRequest(){
        Alamofire.request(.GET, newsurl)
            .responseJSON{ response in
                guard response.2.error == nil else {
                    print("error")
                    return
                }
                
                if let value: AnyObject = response.2.value {
                    //handle the returned JSON
                    let responseValue = JSON(value)
                    //Handle parsing of results
                    print("Response was" + responseValue.description)
                    
                    //handle accessing fields
                    //if let bio = post["bio"].string {
                    //print("Bio was " + bio)
                    // } else {
                    // print ("error")
                    // }
                }
                }
    }
    
    
}

