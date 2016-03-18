//
//  Election.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 3/17/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import Foundation

public class Election {
    
    let title: String
    let date: NSDate
    let candidates: [Candidate]
    let meta: String?
    
    init(title: String, date: NSDate, candidates: [Candidate], meta: String) {
        
        self.title = title
        self.date = date
        self.candidates = candidates
        self.meta = meta
    }
}