//
//  HomeStoryTableViewCellController.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 4/5/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class HomeStoryTableViewCellController: UITableViewCell {
    
    @IBOutlet weak var newsStoryTitleLabel: UILabel!
    @IBOutlet weak var newsStoryContentLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        
        // Configure the story title
        newsStoryTitleLabel.backgroundColor = UIColor.grayColor().colorWithAlphaComponent(0.2)
        newsStoryTitleLabel.font = UIFont.boldSystemFontOfSize(17.0)
        newsStoryTitleLabel.textColor = UIColor.blackColor()
        
        // Configure the story content
        newsStoryContentLabel.backgroundColor = UIColor.whiteColor()
    }
    
    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
}
