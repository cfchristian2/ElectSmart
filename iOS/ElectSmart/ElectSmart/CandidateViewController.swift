//
//  CandidateViewController.swift
//  ElectSmart
//
//  Created by Conner Christianson on 4/4/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class CandidateViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {

    @IBOutlet weak var candidateTable: UITableView!
    
    var candidate: Candidate?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        candidateTable.dataSource = self
        candidateTable.delegate = self
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // MARK: Table View
    
    func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 3
    }
    
    func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        
        if (indexPath.row == 0) {
            
            let cell = tableView.dequeueReusableCellWithIdentifier("candidateHeaderCell", forIndexPath: indexPath) as! CandidateHeaderTableViewCell
            
            cell.candidateNameLabel.text = candidate!.title
            // TODO: Edit candidate photo
            
            return cell
            
        } else if (indexPath.row == 1) {
            
            let cell = tableView.dequeueReusableCellWithIdentifier("bioCell", forIndexPath: indexPath) as! CandidateBioTableViewCell
            
            cell.candidateBioTextView.text = candidate!.bio
            
            return cell
            
        } else {
            
            let cell = tableView.dequeueReusableCellWithIdentifier("historyCell", forIndexPath: indexPath) as! CandidateHistoryTableViewCell
            
            cell.candidateHistoryTextView.text = "Put some voter history about candidate here"
            
            return cell
            
        }
    }
    
    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        if (indexPath.row == 0) {
            return 180
        } else if (indexPath.row == 1){
            return 300
        } else {
            return 300
        }
    }

}
