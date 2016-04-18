//
//  HomeStoryTableViewController.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 3/17/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class HomeStoryTableViewController: UITableViewController {
    
    var stories: [NewsStory] = [NewsStory]()
    var queryTextField: UITextField?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        tableView.rowHeight = UITableViewAutomaticDimension
        tableView.estimatedRowHeight = 166
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    @IBAction func searchWithQuery(sender: AnyObject) {
        
        let query = self.queryTextField!.text!
        
        if (query.characters.count > 0) {
            stories.removeAll()
            
            NSOperationQueue.mainQueue().addOperationWithBlock {
                let queryTask: BingTask = BingTask(query: query)
                queryTask.makeRequest() { responseObject, error in
                    if (responseObject?.count > 0){
                        for story in responseObject! {
                            self.stories.append(story)
                        }
                        self.tableView.reloadData()
                    } else {
                        print("We didn't get the right data returned")
                    }
                }
                dispatch_async(dispatch_get_main_queue(), { () -> Void in
                    self.tableView.reloadData()
                })
            }
        }
    }
    
    
    // MARK: Table view data source
    
    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return stories.count + 1
    }
    
    override func tableView(tableView: UITableView, willDisplayHeaderView view: UIView, forSection section: Int) {
        let headerView = view as! UITableViewHeaderFooterView
        headerView.textLabel!.textColor = UIColor(red: 0.0/255.0, green: 139.0/255.0, blue: 139.0/255.0, alpha: 1.0)
    }
    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        if (indexPath.row == 0) {
            
            let cell = tableView.dequeueReusableCellWithIdentifier("homeQueryCell", forIndexPath: indexPath) as! HomeQueryTableViewCell
            
            queryTextField = cell.searchText
            
            return cell
            
        } else {
            
            let cell = tableView.dequeueReusableCellWithIdentifier("homeStoryCell", forIndexPath: indexPath) as! HomeStoryTableViewCell
        
            let story = stories[indexPath.row]
        
            cell.newsStoryTitleLabel.text = "  "+story.title
            cell.newsStoryContentLabel.text = story.description
        
            return cell
        }
    }
    
    // MARK: - Navigation
        
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        
        if let indexPath = self.tableView.indexPathForSelectedRow {
            if (indexPath.row > 0) {
                let detScene = segue.destinationViewController as! NewsStoryViewController
                
                let selectedStory = self.stories[indexPath.row - 1]
                detScene.url = NSURL(string: selectedStory.url)
                detScene.storyTitle = selectedStory.title
            }
        }
    }
}
