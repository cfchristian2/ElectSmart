//
//  NewsStoryViewController.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 3/13/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class NewsStoryViewController: UIViewController {
    
    var url: NSURL?
    
    @IBOutlet weak var newsStoryWebView: UIWebView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let URLRequest = NSURLRequest(URL: url!)
        self.newsStoryWebView.loadRequest(URLRequest)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}