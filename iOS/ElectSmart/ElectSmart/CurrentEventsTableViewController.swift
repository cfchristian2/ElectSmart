//
//  CurrentEventsTableViewController.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 3/13/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class CurrentEventsTableViewController: UITableViewController {
    
    var stories: [NewsStory] = [NewsStory]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = "Current Events"
        self.navigationController?.navigationBar.barTintColor = UIColor(red: 0.0/255.0, green: 139.0/255.0, blue: 139.0/255.0, alpha: 1.0)
        self.navigationController?.navigationBar.tintColor = UIColor.whiteColor()
        self.navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName : UIColor.whiteColor()]
        
        getStories()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: Populating stories array
    
    private func getStories() {
        stories.append(NewsStory(title: "Blah", ID: "1", url: "www.apple.com", date: NSDate(timeIntervalSinceNow: 20000), source: "Drumpf Media", description: "ds sadsads dsads sad sa dsa dsadsddsd sdsd"))
        stories.append(NewsStory(title: "Blah", ID: "2", url: "www.apple.com", date: NSDate(timeIntervalSinceNow: 20000), source: "Drumpf Media", description: "ds sadsads dsads sad sa dsa dsadsddsd sdsd"))
        stories.append(NewsStory(title: "Blah", ID: "3", url: "www.apple.com", date: NSDate(timeIntervalSinceNow: 20000), source: "Drumpf Media", description: "ds sadsads dsads sad sa dsa dsadsddsd sdsd"))
    }
    
    // MARK: - Table view data source
    
    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // TODO: Define number of rows as the number of elements in stories
        return stories.count
    }
    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCellWithIdentifier("currentEventCell", forIndexPath: indexPath) as! CurrentEventsTableViewCell
        
        // get story for cell
        let story: NewsStory = self.stories[indexPath.row]
        
        cell.currentEventTitleLabel.text = "  "+story.title
        cell.currentEventContentLabel.text = story.description
    
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
