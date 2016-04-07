//
//  DisqusDiscussionRepliesTableViewController.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 4/6/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class DisqusDiscussionRepliesTableViewController: UITableViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // MARK: - Table view data source
    
    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 3
    }
    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        // Header cell is the Discussion Post
        if (indexPath.row == 0) {
            
            let cell = tableView.dequeueReusableCellWithIdentifier("discussionCell", forIndexPath: indexPath)
            
            // Configure cell
            
            return cell
        }
        // Next cells are all responses to discussion
        else {
            
            let cell = tableView.dequeueReusableCellWithIdentifier("replyCell", forIndexPath: indexPath)
            
            // Configure cell
            
            return cell
        }
    }
    
    // MARK: - Navigation
     
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using [segue destinationViewController].
        // Pass the selected object to the new view controller.
    }
    
}