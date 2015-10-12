var map;
var polygon;
var markerCount;

document.addEventListener("DOMContentLoaded", initialize, false);

function initialize(){
 	L.mapbox.accessToken = 'pk.eyJ1IjoiYWtzbWtyIiwiYSI6ImNpZmY3bnlncDd6eGtzdWtucjFrY3Z3OGkifQ.2QcYNghIAx0ZsZJVewp8QA';
	map = L.mapbox.map('map', 'mapbox.streets').setView([40, -74.50], 3);
	map.on('click', function(event){
		addToList(event.latlng);
	});
    markerCount=1;
    LOG.logInfo("Mapbox initialized");
}

function createPolygon(){
    LOG.logDebug("Creating polygon connecting the coordinates");
    if(polygon)
     	map.removeLayer(polygon);
     polygon_options = {
     		color:'#000'
     };
     polygon = L.polygon(controller.getLatLngList().toArray(), polygon_options).addTo(map);
}

function addToList(latlng){
    LOG.logInfo("Creating coordinate : "+markerCount);
    var point = new Point(latlng, markerCount);
    controller.addToList(point);
    createMarker(latlng);
    createPolygon();
}

var Point = function(latLng, pointNo){
    this.point = controller.getNewLatLng();
    this.point.lat = latLng.lat;
    this.point.lng = latLng.lng;
    this.point.pointNo = pointNo;
    return this.point;
}

function createMarker(latlng){
    LOG.logInfo("Creating marker: ");
    var marker = L.marker(latlng, {draggable:true, title:markerCount++});
    marker.on('dragend', function(event){
        var point = new Point(marker.getLatLng(), parseInt(marker.options.title));
        controller.updateMarker(point);
        createPolygon();
    });

    marker.on('click', function(event){
        var point = new Point(marker.getLatLng(), parseInt(marker.options.title));
        controller.deleteMarker(point);
        map.removeLayer(marker);
        createPolygon();
    });
    marker.addTo(map);
}

function clearPolygon(){
    LOG.logInfo("Removing the polygon area selection");
    map.removeLayer(polygon);
    markerCount = 1;
}

function deleteMarkers(){
    LOG.logInfo("Deleting all markers ");
    map.eachLayer(function(layer) {
      if (layer instanceof L.Marker) {
        map.removeLayer(layer);
      }
    });
}
