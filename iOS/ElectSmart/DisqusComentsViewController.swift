//
//  DisqusCommentsViewController.swift
//  ElectSmart
//
//  Created by Nick on 4/5/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//
import UIKit

class DisqusComentsViewController: UITableViewController {
    
    let disqusManager = DisqusManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
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
