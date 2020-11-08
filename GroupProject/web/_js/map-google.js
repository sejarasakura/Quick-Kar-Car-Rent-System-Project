/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function initMap(id_extension) {
  var map = new google.maps.Map(document.getElementById('map' + id_extension), {
    center: {lat: 3.216764, lng: 101.727759},
    zoom: 17
  });

  var input = document.getElementById('pac-input' + id_extension);
  var option_auto_complete = {compenenttRestrictions:{county:"malaysia"}};
  var autocomplete = new google.maps.places.Autocomplete(input, option_auto_complete);
  autocomplete.bindTo('bounds', map);

  // Specify just the place data fields that you need.
  autocomplete.setFields(['place_id', 'geometry', 'name']);

  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

  var infowindow = new google.maps.InfoWindow();
  var infowindowContent = document.getElementById('infowindow-content' + id_extension);
  infowindow.setContent(infowindowContent);
    var icon = {
        url: 'http://localhost:8080/GroupProject/_resource/icon/pointer_icon.png',
        scaledSize: new google.maps.Size(50, 75), // scaled size
    };
  var marker = new google.maps.Marker({
      map: map,
      icon: icon
  });

  marker.addListener('click', function() {
    infowindow.open(map, marker);
  });

  autocomplete.addListener('place_changed', function() {
      infowindow.close();
      var place = autocomplete.getPlace();
      if (!place.geometry) {
        return;
      }
      if (place.geometry.viewport) {
        map.fitBounds(place.geometry.viewport);
      } else {
        map.setCenter(place.geometry.location);
        map.setZoom(17);
      }
      // Set the position of the marker using the place ID and location.
      marker.setPlace({
        placeId: place.place_id,
        location: place.geometry.location
      });
      marker.setVisible(true);
      infowindowContent.children['place-name' + id_extension].textContent = place.name;
      infowindowContent.children['place-id' + id_extension].textContent = place.place_id;
      infowindowContent.children['place-address' + id_extension].textContent =
          place.formatted_address;
      infowindow.open(map, marker);
  });
}