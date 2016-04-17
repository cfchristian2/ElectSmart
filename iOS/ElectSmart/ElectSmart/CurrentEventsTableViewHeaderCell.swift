//
//  CurrentEventsTableViewHeaderCell.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 4/17/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class CurrentEventsTableViewHeaderCell: UITableViewCell {
    
    @IBOutlet weak var queryTextField: UITextField!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
}
