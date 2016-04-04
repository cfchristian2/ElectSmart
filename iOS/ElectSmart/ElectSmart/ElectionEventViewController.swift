//
//  ElectionEventViewController.swift
//  ElectSmart
//
//  Created by Conner Christianson on 3/17/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class ElectionEventViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    


    // MARK: - Navigation

    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if segue.identifier == "showMap" {
            
            let vc = segue.destinationViewController as! PollingPlaceViewController

        }
    }


}
