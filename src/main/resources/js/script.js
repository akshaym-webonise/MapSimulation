var map;
var polygon;
var markerCount;
var point

document.addEventListener("DOMContentLoaded", initialize, false);

function initialize(){
 	L.mapbox.accessToken = 'pk.eyJ1IjoiYWtzbWtyIiwiYSI6ImNpZmY3bnlncDd6eGtzdWtucjFrY3Z3OGkifQ.2QcYNghIAx0ZsZJVewp8QA';
	map = L.mapbox.map('map', 'mapbox.streets').setView([40, -74.50], 3);
	map.on('click', function(event){
		addToList(event.latlng);
	});
    markerCount=1;
}

function createPolygon(){
    if(polygon)
     	map.removeLayer(polygon);
     polygon_options = {
     		color:'#000'
     };
     polygon = L.polygon(controller.getLatLngList().toArray(), polygon_options).addTo(map);
}

function addToList(latlng){
  	point = createNewPoint(latlng);
 	point.setPointNo(markerCount);
 	controller.addToList(point);
    createMarker(latlng);
    createPolygon();
}

function createNewPoint(latLng){
    point = controller.getNewLatLng();
    point.setLat(latLng.lat);
    point.setLng(latLng.lng);
    return point;
}

function createMarker(latlng){
    var marker = L.marker(latlng, {draggable:true, title:markerCount++});
    marker.on('dragend', function(event){
        point = createNewPoint(marker.getLatLng());
        point.pointNo = parseInt(marker.options.title);
        controller.updateMarker(point);
        createPolygon();
    });

    marker.on('click', function(event){
        point = createNewPoint(marker.getLatLng());
        point.pointNo = parseInt(marker.options.title);
        controller.deleteMarker(point);
        map.removeLayer(marker);
        markerCount--;
        createPolygon();
    });
    marker.addTo(map);
}

function clearPolygon(){
    map.removeLayer(polygon);
    markerCount = 1;
}

function deleteMarkers(){
    var latLngList = controller.getLatLngList();

    for(index = 0 ; index<latLngList.size() ; index++){
        var marker = L.marker(latLngList.get(index));
        map.removeLayer(marker)
    }
}
