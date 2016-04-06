//
//  ElectionEventViewController.swift
//  ElectSmart
//
//  Created by Conner Christianson on 3/17/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class ElectionEventViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {

    @IBOutlet weak var electionTable: UITableView!
    
    var election: Election?
    var electionDate: String?
    var electionTitle: String?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        electionTable.dataSource = self
        electionTable.delegate = self

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    // MARK: Table View
    
    
    // The amount of candidates + 1 for the header cell
    //
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return election!.candidates.count + 1
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        // Header cell, there should only be one
        //
        if (indexPath.row == 0) {
            
            let cell = tableView.dequeueReusableCellWithIdentifier("headerCell", forIndexPath: indexPath) as! ElectionHeaderTableViewCell
            
            // TODO: Change date
            
            cell.electionTitle.text = election!.title
            cell.electionDate.text = "April 5"
            
            return cell
            
            // List of candidates
            //
        } else {
            
            let cell = tableView.dequeueReusableCellWithIdentifier("candidateCell", forIndexPath: indexPath) as! ElectionCandidateTableViewCell
            
            // TODO: Populate with candidate data
            let url = NSURL(string: "https://upload.wikimedia.org/wikipedia/commons/8/83/Bernie_Sanders_1991.jpg")
            let data = NSData(contentsOfURL:url!)
            
            if (data != nil) {
                cell.candidateImage.image = UIImage(data:data!)
            }
            
            cell.candidateName.text = election!.candidates[indexPath.row - 1].title
            cell.candidateDescription.text = election!.candidates[indexPath.row - 1].bio
            cell.candidateDescription.editable = false
            cell.candidateDescription.selectable = false
            
            return cell
            
        }


    }
    
    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        if (indexPath.row == 0) {
            return 180
        } else {
            return 100
        }
    }
    
    // MARK: Navigation

    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if segue.identifier == "showMap" {
            
            segue.destinationViewController as! PollingPlaceViewController

            // TODO: Pass in polling place
            
        } else if segue.identifier == "showCandidate" {
            
            segue.destinationViewController as! CandidateViewController
            
            // TODO: Pass in candidate info
        }
    }
    
}
