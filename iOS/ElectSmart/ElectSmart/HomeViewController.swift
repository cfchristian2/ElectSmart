//
//  HomeViewController.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 3/8/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class HomeViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    var stories: [NewsStory] = [NewsStory]()
    let nextEvent: Election = Election(title: "WI Primary", date: NSDate(timeIntervalSinceNow: 10000), candidates: [], meta: "")
    
    @IBOutlet weak var nextEventTitleButton: UIButton!
    @IBOutlet weak var nextEventDateLabel: UILabel!
    @IBOutlet weak var storiesTableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = "Next Date"
        self.navigationController?.navigationBar.barTintColor = UIColor(red: 0.0/255.0, green: 139.0/255.0, blue: 139.0/255.0, alpha: 1.0)
        self.navigationController?.navigationBar.tintColor = UIColor.whiteColor()
        self.navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName : UIColor.whiteColor()]
        
        getNextEvent()
        getStories()
        
        self.storiesTableView.registerClass(UITableViewCell.self, forCellReuseIdentifier: "homeStoryCell")
        storiesTableView.delegate = self
        storiesTableView.dataSource = self
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    // MARK: Populate next event
    
    private func getNextEvent() {
        nextEventTitleButton.setTitle(nextEvent.title, forState: .Normal)
        nextEventDateLabel.text = nextEvent.date.description
    }
    
    // MARK: Populating stories array
    
    private func getStories() {
        stories.append(NewsStory(title: "Blah", subtitle: "subtitle text", author: "Donald Drumpf", date: NSDate(timeIntervalSinceNow: 20000), publisher: "Drumpf Media", content: "ds sadsads dsads sad sa dsa dsadsddsd sdsd", image: "https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150", meta: "meta"))
        stories.append(NewsStory(title: "Some cool news story", subtitle: "subtitle text", author: "Hillz", date: NSDate(timeIntervalSinceNow: 20000), publisher: "HRC", content: "ds sadsads dsads sad sa dsa dsadsddsd sdsd", image: "https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150", meta: "meta"))
        stories.append(NewsStory(title: "Update!!", subtitle: "subtitle text", author: "The Bern", date: NSDate(timeIntervalSinceNow: 20000), publisher: "The people", content: "ds sadsads dsads sad sa dsa dsadsddsd sdsd", image: "https://placeholdit.imgix.net/~text?txtsize=33&txt=350%C3%97150&w=350&h=150", meta: "meta"))
    }
    
    // MARK: Table view data source
    
    internal func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    internal func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return stories.count
    }
    
    internal func tableView(tableView: UITableView, willDisplayHeaderView view: UIView, forSection section: Int) {
        let headerView = view as! UITableViewHeaderFooterView
        headerView.textLabel!.textColor = UIColor(red: 0.0/255.0, green: 139.0/255.0, blue: 139.0/255.0, alpha: 1.0)
    }
    
    internal func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCellWithIdentifier("homeStoryCell", forIndexPath: indexPath)
        
        // TODO: Change configuration here so that the proper image/title/URL are set for cell
        // TODO: Have UITableViewCell resize to height of downloaded image (currently set to fixed height)
        
        // get story for cell
        let story: NewsStory = self.stories[indexPath.row]
        
        // Configure the cell
        let imageView = UIImageView(frame: cell.frame)
        let labelView = UILabel()
        
        // Add image BG
        if let checkedUrl = NSURL(string: story.image!) {
            imageView.contentMode = .ScaleAspectFit
            downloadImage(checkedUrl, imageView: imageView)
        }
        
        // Add text overlay
        drawTitle(story.title, labelView: labelView, imageViewToReference: imageView)
        
        // Layer subviews
        self.view.addSubview(imageView)
        self.view.addSubview(labelView)
        
        return cell
    }
    
    // MARK: Drawing text overlay
    
    private func drawTitle(title: String, labelView: UILabel, imageViewToReference: UIImageView) {
        labelView.text = "    "+title
        labelView.font = UIFont(name: "System", size: 17)
        labelView.textColor = UIColor.blackColor()
        labelView.backgroundColor = UIColor.whiteColor().colorWithAlphaComponent(0.6)
        labelView.textAlignment = .Left
        labelView.numberOfLines = 1
        labelView.frame = CGRectMake(imageViewToReference.frame.minX, (imageViewToReference.frame.minY+imageViewToReference.frame.height-40), imageViewToReference.frame.width, 40)
    }
    
    // MARK: Loading images into TableView
    
    private func getDataFromUrl(url: NSURL, completion: ((data: NSData?, response: NSURLResponse?, error: NSError?) -> Void)) {
        NSURLSession.sharedSession().dataTaskWithURL(url) {
            (data, response, error) in completion(data: data, response: response, error: error)
            }.resume()
    }
    
    private func downloadImage(url: NSURL, imageView: UIImageView) {
        getDataFromUrl(url) { (data, response, error)  in
            dispatch_async(dispatch_get_main_queue()) { () -> Void in
                guard let data = data where error == nil else { return }
                imageView.image = UIImage(data: data)
                self.storiesTableView.layoutSubviews()
            }
        }
    }
}

