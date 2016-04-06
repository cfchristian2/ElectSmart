//
//  CandidateViewController.swift
//  ElectSmart
//
//  Created by Conner Christianson on 4/4/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class CandidateViewController: UIViewController {
    
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var partyLabel: UILabel!
    @IBOutlet weak var urlLabel: UILabel!
    @IBOutlet weak var bioLabel: UILabel!
    
    var candidate: Candidate?
    
    override func viewDidLoad() {
        super.viewDidLoad()

        titleLabel.text = candidate?.title
        partyLabel.text = candidate?.party
        urlLabel.text = candidate?.candidate_url
        bioLabel.text = candidate?.bio
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
