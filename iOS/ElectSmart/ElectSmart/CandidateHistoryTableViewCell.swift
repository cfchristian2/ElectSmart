//
//  CandidateHistoryTableViewCell.swift
//  ElectSmart
//
//  Created by Conner Christianson on 4/5/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit

class CandidateHistoryTableViewCell: UITableViewCell {

    @IBOutlet weak var candidateHistoryTextView: UITextView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
