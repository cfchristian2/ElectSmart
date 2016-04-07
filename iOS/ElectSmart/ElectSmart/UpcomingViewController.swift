//
//  UpcomingViewController.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 3/8/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class UpcomingViewController: UIViewController, UICollectionViewDelegate, UICollectionViewDataSource {
    
    //Collection view containing cells of elections
    @IBOutlet weak var collectionView: UICollectionView!
    
    //TODO: fill in with election data somewhere
    var elections = [Election]()
    var candidates1 = [Candidate]()
    var candidates2 = [Candidate]()
    
    var bernie: Candidate = Candidate(title: "Bernie Sanders", meta: "", party: "Democrat", candidate_url: "", bio: "The man", photo: "https://upload.wikimedia.org/wikipedia/commons/8/83/Bernie_Sanders_1991.jpg")
    var hillary: Candidate = Candidate(title: "Hillary Clinton", meta: "", party: "Democrat", candidate_url: "", bio: "She's definitely running", photo: "https://upload.wikimedia.org/wikipedia/commons/d/d2/Defense.gov_photo_essay_091203-N-0696M-239.jpg")
    var donald: Candidate = Candidate(title: "Donald Drumpf", meta: "", party: "Republican", candidate_url: "", bio: "A terrible human being", photo: "https://pbs.twimg.com/profile_images/704163604703158272/LtrEadTR.jpg")
    var ted: Candidate = Candidate(title: "Ted Cruz", meta: "", party: "Republican", candidate_url: "", bio: "Maybe better than drumpf but probably not", photo: "https://cdn.evbuc.com/eventlogos/4918511/tedcruz.jpg")
    
    var election1: Election?
    var election2: Election?
    var election3: Election?
    
    
    
    
    // TODO: Delete
    let titles = ["Ohio Caucus", "Wisconsin Caucus", "Presidential Election"]
    let dates = ["March 15", "April 5", "November 8"]
    //
    
    

    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = "Upcoming Dates"
        self.navigationController?.navigationBar.barTintColor = UIColor(red: 0.0/255.0, green: 139.0/255.0, blue: 139.0/255.0, alpha: 1.0)
        self.navigationController?.navigationBar.tintColor = UIColor.whiteColor()
        self.navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName : UIColor.whiteColor()]
        
        collectionView.dataSource = self
        
        // TEST
        candidates1.append(bernie)
        candidates1.append(hillary)
        candidates1.append(donald)
        candidates1.append(ted)
        
        candidates2.append(bernie)
        candidates2.append(ted)
        
        election1 = Election(title: "Ohio Caucus", date: NSDate.init(), candidates: candidates1, meta: "")
        election2 = Election(title: "Wisconsin Caucus", date: NSDate.init(), candidates: candidates1, meta: "")
        election3 = Election(title: "Presidential Election" , date: NSDate.init(), candidates: candidates2, meta: "")
        
        elections.append(election1!)
        elections.append(election2!)
        elections.append(election3!)
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    func collectionView(collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return elections.count
    }

    func collectionView(collectionView: UICollectionView, cellForItemAtIndexPath indexPath: NSIndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCellWithReuseIdentifier("cell", forIndexPath: indexPath) as! UpcomingElectionCollectionViewCell
        
        cell.title?.text = self.elections[indexPath.row].title
        cell.date?.text = self.dates[indexPath.row]
        
        return cell
    }
    
    func collectionView(collectionView: UICollectionView, didSelectItemAtIndexPath indexPath: NSIndexPath) {
        self.performSegueWithIdentifier("showElection", sender: self)
    }
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if segue.identifier == "showElection" {
            let indexPaths = self.collectionView!.indexPathsForSelectedItems()!
            let indexPath = indexPaths[0] as NSIndexPath
            let vc = segue.destinationViewController as! ElectionEventViewController
            
            vc.election = elections[indexPath.row]
            
        }
    }

}

