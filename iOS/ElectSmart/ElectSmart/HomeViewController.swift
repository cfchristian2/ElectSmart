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
    
    //let title: String
    //let ID: Int
    //let url: String
    //let date: NSDate
    //let source: String
    //let description: String
    
    
    /*
    private func getStories() {
        
        
        let testAPI:BingTask = BingTask()
        
        
        
        testAPI.makeRequest() { responseObject, error in
            //print(responseObject)
            for story in responseObject! {
                self.stories.append(story)
            }
            
            print(self.stories)
            
            
        }
        
        
        //stories.append(NewsStory(title: "Blah", ID: "1", url: "www.apple.com", date: NSDate(timeIntervalSinceNow: 20000), source: "Drumpf Media", description: "ds sadsads dsads sad sa dsa dsadsddsd sdsd"))
        //stories.append(NewsStory(title: "Blah", ID: "2", url: "www.apple.com", date: NSDate(timeIntervalSinceNow: 20000), source: "Drumpf Media", description: "ds sadsads dsads sad sa dsa dsadsddsd sdsd"))
        //stories.append(NewsStory(title: "Blah", ID: "3", url: "www.apple.com", date: NSDate(timeIntervalSinceNow: 20000), source: "Drumpf Media", description: "ds sadsads dsads sad sa dsa dsadsddsd sdsd"))
    }
*/
    
    // MARK: Navigation
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        
        if (segue.identifier == "goToElectionEventView") {
            let vc = segue.destinationViewController as! ElectionEventViewController
            
            vc.electionDate = nextEventDateLabel.text
            vc.electionTitle = nextEventTitleButton.titleLabel?.text
            vc.election = nextEvent
        
        } else {
            let vc = segue.destinationViewController as! HomeStoryTableViewController
            
            let testAPI:BingTask = BingTask()
            
            
            
            testAPI.makeRequest() { responseObject, error in
                //print(responseObject)
                if (responseObject?.count > 0){
                for story in responseObject! {
                    self.stories.append(story)
                }
                
                    //debug stories
                //print(self.stories)
                vc.stories = self.stories
                vc.tableView.reloadData()
                } else {
                    print("We didn't get the right data returned")
                }
                
                
            }
            
            vc.stories = stories
            vc.tableView.reloadData()
        }
    }
}