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
    let party: String
    let candidate_url: String
    let bio: String
    let photo: String
    //email and address needed? Trying to follow Voting Info Project guidelines
    let meta: String?
    
    
    init(title: String, meta: String,  party: String, candidate_url: String, bio: String, photo: String) {
        
        self.title = title
        self.meta = meta
        self.party = party
        self.candidate_url = candidate_url
        self.bio = bio
        self.photo = photo
    }
}