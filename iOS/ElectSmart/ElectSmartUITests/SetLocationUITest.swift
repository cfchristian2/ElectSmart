//
//  SetLocationUITest.swift
//  ElectSmart
//
//  Created by Conner Christianson on 4/7/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import XCTest

class SetLocationUITest: XCTestCase {
        
    override func setUp() {
        super.setUp()
        
        // Put setup code here. This method is called before the invocation of each test method in the class.
        
        // In UI tests it is usually best to stop immediately when a failure occurs.
        continueAfterFailure = false
        // UI tests must launch the application that they test. Doing this in setup will make sure it happens for each test method.
        XCUIApplication().launch()

        // In UI tests it’s important to set the initial state - such as interface orientation - required for your tests before they run. The setUp method is a good place to do this.
    }
    
    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        super.tearDown()
    }
    
    func testExample() {
        
        
        let app = XCUIApplication()
        sleep(4)
        app.tabBars.buttons["Settings"].tap()
        app.tables.buttons["Set New Location"].tap()
        app.staticTexts["Address Name"].tap()
        app.staticTexts[" Address Line 1"].tap()
        app.staticTexts["Address Line 2"].tap()
        app.childrenMatchingType(.Window).elementBoundByIndex(0).childrenMatchingType(.Other).elementBoundByIndex(1).childrenMatchingType(.Other).element.childrenMatchingType(.Button).matchingIdentifier("Continue").elementBoundByIndex(1).tap()
        
    }
    
}
