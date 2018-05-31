package kr.ac.afa.atnote;

import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity2 extends Fragment implements OnMapReadyCallback {

    private MapView mapView = null;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private Location location;
    GoogleMap mgoogleMap;

    public MainActivity2() {
        // required
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.activity_ttmaps, container, false);

        mapView = (MapView) layout.findViewById(R.id.map);
        mapView.getMapAsync(this);

        if (mapView != null) {
            mapView.onCreate(savedInstanceState);
            // MAPVIEW 생성
            // Next. 데이터 베이스 불러오기
            mDatabase = FirebaseDatabase.getInstance();

            mReference = mDatabase.getReference();
            mReference.child("users").addChildEventListener(new com.google.firebase.database.ChildEventListener() {  // message는 child의 이벤트를 수신합니다.

                @Override
                public void onChildAdded(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {
                    location = dataSnapshot.getValue(Location.class);  // chatData를 가져오고
                    //Next. 마커 추가
                    LatLng latLng = new LatLng(Double.parseDouble(location.getPlace_lati()),Double.parseDouble(location.getPlace_long()));
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.title(location.getPlace_name());
                    markerOptions.snippet(location.getPlace_address());
                    mgoogleMap.addMarker(markerOptions);

                }

                @Override
                public void onChildChanged(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {
                    //Next. 마커 추가
                    LatLng latLng = new LatLng(Double.parseDouble(location.getPlace_lati()),Double.parseDouble(location.getPlace_long()));
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.title(location.getPlace_name());
                    markerOptions.snippet(location.getPlace_address());
                    mgoogleMap.addMarker(markerOptions);

                }

                @Override
                public void onChildRemoved(com.google.firebase.database.DataSnapshot dataSnapshot) {
                    //Next. 마커 추가
                    LatLng latLng = new LatLng(Double.parseDouble(location.getPlace_lati()),Double.parseDouble(location.getPlace_long()));
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.title(location.getPlace_name());
                    markerOptions.snippet(location.getPlace_address());
                    mgoogleMap.addMarker(markerOptions);
                }

                @Override
                public void onChildMoved(com.google.firebase.database.DataSnapshot dataSnapshot, String s) {
                    //Next. 마커 추가
                    LatLng latLng = new LatLng(Double.parseDouble(location.getPlace_lati()),Double.parseDouble(location.getPlace_long()));
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.title(location.getPlace_name());
                    markerOptions.snippet(location.getPlace_address());
                    mgoogleMap.addMarker(markerOptions);
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    //Next. 마커 추가
                    LatLng latLng = new LatLng(Double.parseDouble(location.getPlace_lati()),Double.parseDouble(location.getPlace_long()));
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.title(location.getPlace_name());
                    markerOptions.snippet(location.getPlace_address());
                    mgoogleMap.addMarker(markerOptions);
                }
            });
        }
        return layout;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mgoogleMap = googleMap;
        LatLng SEOUL = new LatLng(37.56, 126.97);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("수도");
        mgoogleMap.addMarker(markerOptions);
        mgoogleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        mgoogleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
        //서울 기준점
        if ( ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            googleMap.setMyLocationEnabled(true);
        }else {googleMap.setMyLocationEnabled(true); }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}