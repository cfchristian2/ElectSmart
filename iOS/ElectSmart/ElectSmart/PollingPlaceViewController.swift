//
//  PollingPlace.swift
//  ElectSmart
//
//  Created by Conner Christianson on 4/4/16.
//  Copyright © 2016 Stephen Gaschignard. All rights reserved.
//

import UIKit
import MapKit

class PollingPlaceViewController: UIViewController, MKMapViewDelegate, CLLocationManagerDelegate {

    @IBOutlet weak var mapView: MKMapView!
    
    let locationManager = CLLocationManager()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        self.locationManager.delegate = self
        self.locationManager.desiredAccuracy = kCLLocationAccuracyBest
        self.locationManager.requestWhenInUseAuthorization()
        self.locationManager.startUpdatingLocation()
        self.mapView.showsUserLocation = true
        self.mapView.delegate = self
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // MARK: Get polling pin location
    
    func getPollingPin(address: String) -> MKPointAnnotation {
        let annotation = MKPointAnnotation()
        
        let localSearchRequest = MKLocalSearchRequest()
        localSearchRequest.naturalLanguageQuery = address
        let localSearch = MKLocalSearch(request: localSearchRequest)
        localSearch.startWithCompletionHandler { (localSearchResponse, error) -> Void in
            
            if localSearchResponse == nil{
                let alertController = UIAlertController(title: nil, message: "Place Not Found", preferredStyle: UIAlertControllerStyle.Alert)
                alertController.addAction(UIAlertAction(title: "Dismiss", style: UIAlertActionStyle.Default, handler: nil))
                self.presentViewController(alertController, animated: true, completion: nil)
                return
            }
            
            annotation.title = "Polling Place"
            annotation.coordinate = CLLocationCoordinate2D(latitude: localSearchResponse!.boundingRegion.center.latitude, longitude: localSearchResponse!.boundingRegion.center.longitude)
            
        }
        
        return annotation
    }
    

    // MARK: Location Delegate Methods
    
    func locationManager(manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        
        // Zoom in on location
        let location = locations.last
        let center = CLLocationCoordinate2D(latitude: location!.coordinate.latitude, longitude: location!.coordinate.longitude)
        let region = MKCoordinateRegion(center: center, span: MKCoordinateSpan(latitudeDelta: 0.6, longitudeDelta: 0.6))
        self.mapView.setRegion(region, animated: true)
        
        self.locationManager.stopUpdatingLocation()
        
        //
        // Mark pin for polling location
        //
        
        // TODO: Get polling place address
        let annotation = getPollingPin("5 Embarcadero Center, San Francisco, CA 94111")
        mapView.addAnnotation(annotation)
    }
    
    func locationManager(manager: CLLocationManager, didFailWithError error: NSError) {
        print("Polling place error: " + error.localizedDescription)
    }
    
}
