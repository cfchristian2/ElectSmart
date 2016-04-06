//
//  ElectSmartUITests.swift
//  ElectSmartUITests
//
//  Created by Nick on 4/5/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import XCTest

class ElectSmartUITests: XCTestCase {
        
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
        // Use recording to get started writing UI tests.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
        
        let app = XCUIApplication()
        let tabBarsQuery = app.tabBars
        tabBarsQuery.buttons["Upcoming"].tap()
        tabBarsQuery.buttons["Current Events"].tap()
        tabBarsQuery.buttons["Settings"].tap()
        
        let tablesQuery = app.tables
        tablesQuery.buttons["Set New Location"].tap()
        app.childrenMatchingType(.Window).elementBoundByIndex(0).childrenMatchingType(.Other).elementBoundByIndex(1).childrenMatchingType(.Other).element.childrenMatchingType(.Button).matchingIdentifier("Continue").elementBoundByIndex(1).tap()
        tabBarsQuery.buttons["Home"].tap()
        tablesQuery.staticTexts["  Bernie Sanders\U2019 Supporters Overwhelmingly Refuse To Support Hillary Clinton If She Wins Democratic Nomination"].pressForDuration(0.6);
        
        //XCTAssertTrue(table.exists)
        //XCTAssertEqual(table.cells.count, 10)
        
        
    }
    
}