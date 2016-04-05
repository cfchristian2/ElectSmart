//
//  HomeStoryTableViewCellController.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 4/5/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class CurrentEventsTableViewCell: UITableViewCell {
    
    @IBOutlet weak var currentEventTitleLabel: UILabel!
    @IBOutlet weak var currentEventContentLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        
        // Configure the story title
        currentEventTitleLabel.backgroundColor = UIColor.grayColor().colorWithAlphaComponent(0.2)
        currentEventTitleLabel.font = UIFont.boldSystemFontOfSize(17.0)
        currentEventTitleLabel.textColor = UIColor.blackColor()
        
        // Configure the story content
        currentEventContentLabel.backgroundColor = UIColor.whiteColor()
    }
    
    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
}
