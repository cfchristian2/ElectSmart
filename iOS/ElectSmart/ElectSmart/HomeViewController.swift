//
//  HomeViewController.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 3/8/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit
import Foundation

class HomeViewController: UIViewController {
    let dateFormat : NSDateFormatter = {
        let df = NSDateFormatter()
        df.dateStyle = NSDateFormatterStyle.LongStyle
        df.timeStyle = .NoStyle
        return df
    }()
    
    
    
    var stories: [NewsStory] = [NewsStory]()
    let nextEvent: Election = Election(title: "WI Primary", date: NSDate(timeIntervalSinceNow: 10000), candidates: [], meta: "")
    
    @IBOutlet weak var nextEventTitleButton: UIButton!
    @IBOutlet weak var nextEventDateLabel: UILabel!
    @IBOutlet weak var storiesTableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = "Home"
        self.navigationController?.navigationBar.barTintColor = UIColor(red: 0.0/255.0, green: 139.0/255.0, blue: 139.0/255.0, alpha: 1.0)
        self.navigationController?.navigationBar.tintColor = UIColor.whiteColor()
        self.navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName : UIColor.whiteColor()]
        
        getNextEvent()
        
        //Testing for JSON stuff
        //let testAPI:BingTask = BingTask()
        //testAPI.makeNewsRequest()
        
        //
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    @IBAction func nextElectionButtonPress(sender: AnyObject) {
        self.performSegueWithIdentifier("goToElectionEventView", sender: self)
    }
    
    
    // MARK: Populate next event
    
    private func getNextEvent() {
        nextEventTitleButton.setTitle(nextEvent.title, forState: .Normal)
        nextEventDateLabel.text = dateFormat.stringFromDate(nextEvent.date)
    }
    
    // MARK: Populating stories array
    
    private func getStories() {
        stories.append(NewsStory(title: "Blah", subtitle: "subtitle text", author: "Donald Drumpf", date: NSDate(timeIntervalSinceNow: 20000), publisher: "Drumpf Media", content: "ds sadsads dsads sad sa dsa dsadsddsd sdsd", image: "https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150", meta: "meta"))
        stories.append(NewsStory(title: "Some cool news story", subtitle: "subtitle text", author: "Hillz", date: NSDate(timeIntervalSinceNow: 20000), publisher: "HRC", content: "ds sadsads dsads sad sa dsa dsadsddsd sdsd", image: "https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150", meta: "meta"))
        stories.append(NewsStory(title: "Update!!", subtitle: "subtitle text", author: "The Bern", date: NSDate(timeIntervalSinceNow: 20000), publisher: "The people", content: "ds sadsads dsads sad sa dsa dsadsddsd sdsd", image: "https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150", meta: "meta"))
    }
    
    // MARK: Navigation
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        
        if (segue.identifier == "goToElectionEventView") {
            let vc = segue.destinationViewController as! ElectionEventViewController
            
            vc.electionDate = nextEventDateLabel.text
            vc.electionTitle = nextEventTitleButton.titleLabel?.text
        
        } else {
            let vc = segue.destinationViewController as! HomeStoryTableViewController
            
            getStories()
            
            vc.stories = stories
            vc.tableView.reloadData()
        }
    }
}