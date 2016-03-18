//
//  Candidate.swift
//  ElectSmart
//
//  Created by Stephen Gaschignard on 3/17/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import Foundation

public class Candidate {
    
    let title: String
    let meta: String?
    
    init(title: String, meta: String) {
        
        self.title = title
        self.meta = meta
    }
}