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
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: Table view data source
    
    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return stories.count
    }
    
    override func tableView(tableView: UITableView, willDisplayHeaderView view: UIView, forSection section: Int) {
        let headerView = view as! UITableViewHeaderFooterView
        headerView.textLabel!.textColor = UIColor(red: 0.0/255.0, green: 139.0/255.0, blue: 139.0/255.0, alpha: 1.0)
    }
    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCellWithIdentifier("homeStoryCell", forIndexPath: indexPath) as! HomeStoryTableViewCell
        
        // get story for cell
        let story: NewsStory = self.stories[indexPath.row]
        
        cell.newsStoryTitleLabel.text = "  "+story.title
        cell.newsStoryContentLabel.text = story.content
        
        return cell
    }
    
    // MARK: - Navigation
        
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        let detScene = segue.destinationViewController as! NewsStoryViewController
        
        // TODO: Pass real URL and title to next view taken from NewsStory item
        detScene.url = NSURL(string: "https://www.apple.com")
        detScene.storyTitle = "Apple FTW"
        
    }
}
