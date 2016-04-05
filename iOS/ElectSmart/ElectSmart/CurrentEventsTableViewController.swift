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
        stories.append(NewsStory(title: "Clinton eats babies", subtitle: "subtitle text", author: "Donald Drumpf", date: NSDate(timeIntervalSinceNow: 20000), publisher: "Drumpf Media", content: "Llama ipsum dolor sit amet consectetur alpaca elit nam mattis, risus sit amet tellus posuere vel pronking diam adipiscing nullam, semper bibendum nisi in humming llambada vivamus vel.", image: "https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150", meta: "meta"))
        stories.append(NewsStory(title: "Some cool news story", subtitle: "subtitle text", author: "Hillz", date: NSDate(timeIntervalSinceNow: 20000), publisher: "HRC", content: "Skateboard mustache bicycle rights, whatever blog post-ironic DIY blue bottle. Trust fund fanny pack franzen paleo kale chips. Poutine humblebrag gluten-free retro, chicharrones organic put a bird on it semiotics umami lo-fi chillwave cronut PBR&B tattooed kinfolk. Chia kale chips flannel hoodie, neutra thundercats trust fund green juice shabby chic brunch. Health goth hella williamsburg church-key hammock brooklyn. Schlitz pug sustainable, aesthetic keffiyeh scenester godard fixie sartorial. Chicharrones mustache retro lo-fi beard.", image: "https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150", meta: "meta"))
        stories.append(NewsStory(title: "Update!!", subtitle: "subtitle text", author: "The Bern", date: NSDate(timeIntervalSinceNow: 20000), publisher: "The people", content: "row scuttle parrel provost Sail ho shrouds spirits boom mizzenmast yardarm. Pinnace holystone mizzenmast quarter crow's nest nipperkin grog yardarm hempen halter furl. Swab barque interloper chantey doubloon starboard grog black jack gangway rutters.", image: "https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150", meta: "meta"))
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
        cell.currentEventContentLabel.text = story.content
    
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
