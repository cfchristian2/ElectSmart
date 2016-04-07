//
//  DisqusDiscussionsTableViewController.swift
//  ElectSmart
//
//  Created by Nick on 4/5/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class DisqusDiscussionsTableViewController: UITableViewController {
    
    let disqusManager = DisqusManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = "Discussions"
        self.navigationController?.navigationBar.barTintColor = UIColor(red: 0.0/255.0, green: 139.0/255.0, blue: 139.0/255.0, alpha: 1.0)
        self.navigationController?.navigationBar.tintColor = UIColor.whiteColor()
        self.navigationController?.navigationBar.titleTextAttributes = [NSForegroundColorAttributeName : UIColor.whiteColor()]
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // MARK: - Table view data source
    
    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 2
    }
    
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCellWithIdentifier("discussionPostCell", forIndexPath: indexPath)
        
        // configure cell
        
        return cell
    }
    
    // MARK: - Disqus functions
    
    func showNewPostForm(onSuccess: () -> ()) {
        if disqusManager.isUserAuthenticated() {
            // Succeed
            onSuccess()
        } else {
            // Authenticate user
            let vc = DisqusAuthenticateViewController()
            vc.onSuccess = onSuccess
            let navigationController = UINavigationController(rootViewController: vc)
            navigationController.modalPresentationStyle = UIModalPresentationStyle.FormSheet
            self.presentViewController(navigationController, animated: true, completion: nil)
        }
    }
    
    /*
    // MARK: - Navigation
    
    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
    }
    */
    
}

protocol DisqusComments {
    func presentNewPostForm()
}
