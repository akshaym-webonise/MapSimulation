var map;
var latlngs;
var polygon;
var markers;
var markerCount;

document.addEventListener("DOMContentLoaded", initialize, false);

 function initialize()
 {
	console.log("Initializing map");
 	L.mapbox.accessToken = 'pk.eyJ1IjoiYWtzbWtyIiwiYSI6ImNpZmY3bnlncDd6eGtzdWtucjFrY3Z3OGkifQ.2QcYNghIAx0ZsZJVewp8QA';
	map = L.mapbox.map('map', 'mapbox.streets').setView([40, -74.50], 3);

    markerCount=1;
	latlngs = new Array();
	map.on('click', function(event){
		//addToTable(event.latlng);
		showPolygon(event.latlng);
	});
 }

 function showPolygon(latlng)
 {
 	if(polygon != undefined)
 	map.removeLayer(polygon);
 	polygon_options = {
 		color:'#000'
 	};
 	latlngs.push(latlng);
    createMarkers(latlng);
 	polygon = L.polygon(latlngs, polygon_options).addTo(map);
 }

 function createMarkers(latlng){
    var marker = L.marker(latlng, {draggable:true});
    marker.on('dragend', function(event){
        console.log("Clicked "+marker.getLatLng());
        showPolygon(marker.getLatLng());
    });

    marker.on('dblClick', function(event){
        map.removeLayer(marker);
    });
    marker.bindPopup(markerCount).openPopup();
    marker.addTo(map);
 }

 function addToTable(latlng){
    console.log(latlng.lat+" "+latlng.lng);
    coordinates.setLatitude(latlng.lat);
    coordinates.setLongitude(latlng.lng);
    coordinates.setDataFromJs(true);
}

function clearPolygon(){
    map.removeLayer(polygon);
    polygon = null;
    latlngs = new Array();
    console.log("Map cleared");
}