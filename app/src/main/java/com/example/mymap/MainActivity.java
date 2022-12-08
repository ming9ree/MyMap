package com.example.mymap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.Manifest;
import android.graphics.PointF;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.overlay.PathOverlay;
import com.naver.maps.map.util.FusedLocationSource;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements OnMapReadyCallback {

    private NaverMap naverMap;
    private FusedLocationSource locationSource;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private static final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    List<LatLng> lstLatLng = new ArrayList<>();

    //마커 변수 선언 및 초기화
    private Marker pmarker_lib1 = new Marker();
    private Marker pmarker_lib2 = new Marker();
    private Marker pmarker_lib3 = new Marker();
    private Marker pmarker_art1 = new Marker();
    private Marker pmarker_art2 = new Marker();
    private Marker pmarker_ch = new Marker();
    private Marker pmarker_sci = new Marker();
    private Marker pmarker_nuri = new Marker();
    private Marker pmarker_barom1 = new Marker();
    private Marker pmarker_barom2 = new Marker();
    private Marker pmarker_admin1 = new Marker();
    private Marker pmarker_admin2 = new Marker();
    private Marker pmarker_admin3 = new Marker();
    private Marker pmarker_admin4 = new Marker();
    private Marker pmarker_admin5 = new Marker();
    private Marker emarker_50th = new Marker();
    private Marker emarker_ch = new Marker();
    private Marker emarker_inmun1 = new Marker();
    private Marker emarker_inmun2 = new Marker();
    private Marker emarker_art1 = new Marker();
    private Marker emarker_art2 = new Marker();
    private Marker emarker_lib = new Marker();
    private Marker emarker_nuri1 = new Marker();
    private Marker emarker_nuri2 = new Marker();
    private Marker emarker_1stsci = new Marker();
    private Marker emarker_2ndsci = new Marker();
    private Marker emarker_shalom = new Marker();
    private Marker emarker_gukje = new Marker();
    private Marker emarker_barom1 = new Marker();
    private Marker emarker_barom2 = new Marker();
    private Marker emarker_admin = new Marker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE
        );

        ToggleButton btn_parking = (ToggleButton) findViewById(R.id.btn_parking);
        ToggleButton btn_entrance = (ToggleButton) findViewById(R.id.btn_entrance);


        btn_parking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked) {
                    setMarker(pmarker_lib1, 37.628386, 127.091545, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_lib2, 37.628405, 127.091548, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_lib3, 37.628272, 127.091645, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_art1, 37.628912, 127.091603, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_art2, 37.628720, 127.091708, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_ch, 37.626863, 127.092806, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_sci, 37.629221, 127.090207, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_nuri, 37.628993, 127.090213, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_barom1, 37.627160, 127.088355, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_barom2, 37.627150, 127.088379, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_admin1, 37.626926, 127.089124, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_admin2, 37.626906, 127.089110, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_admin3, 37.626891, 127.089095, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_admin4, 37.626875, 127.089080, R.drawable.ic_parking, 10, naverMap);
                    setMarker(pmarker_admin5, 37.626998, 127.089309, R.drawable.ic_parking, 10, naverMap);
                }
                else{
                    setMarker(pmarker_lib1, 0,0,0,0, null);
                    setMarker(pmarker_lib2, 0,0,0,0, null);
                    setMarker(pmarker_lib3, 0,0,0,0, null);
                    setMarker(pmarker_art1, 0,0,0,0, null);
                    setMarker(pmarker_art2, 0,0,0,0, null);
                    setMarker(pmarker_ch, 0,0,0,0, null);
                    setMarker(pmarker_sci, 0,0,0,0, null);
                    setMarker(pmarker_nuri, 0,0,0,0, null);
                    setMarker(pmarker_barom1, 0,0,0,0, null);
                    setMarker(pmarker_barom2, 0,0,0,0, null);
                    setMarker(pmarker_admin1, 0,0,0,0, null);
                    setMarker(pmarker_admin2, 0,0,0,0, null);
                    setMarker(pmarker_admin3, 0,0,0,0, null);
                    setMarker(pmarker_admin4, 0,0,0,0, null);
                    setMarker(pmarker_admin5, 0,0,0,0, null);
                }
            }


        });
        btn_entrance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            public void onCheckedChanged (CompoundButton buttonView,boolean isChecked)
            {
                if (isChecked) {
                    setMarker(emarker_50th, 37.626000, 127.093285, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_ch, 37.626829, 127.092730, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_inmun1, 37.628068, 127.092110, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_inmun2, 37.627760, 127.092244, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_art1, 37.628957, 127.091695, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_art2, 37.629132, 127.091242, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_lib, 37.628358, 127.090920, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_nuri1, 37.628457, 127.090680, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_nuri2, 37.628730, 127.090180, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_1stsci, 37.629210, 127.090030, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_2ndsci, 37.629251, 127.090180, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_shalom, 37.628776, 127.089058, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_gukje, 37.628042, 127.088675, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_barom1, 37.627607, 127.088646, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_barom2, 37.627265, 127.088515, R.drawable.ic_entrance, 10, naverMap);
                    setMarker(emarker_admin, 37.626949, 127.089175, R.drawable.ic_entrance, 10, naverMap);

                }
                else {
                    setMarker(emarker_50th, 0, 0, 0, 0, null);
                    setMarker(emarker_ch, 0, 0, 0, 0, null);
                    setMarker(emarker_inmun1, 0, 0, 0, 0, null);
                    setMarker(emarker_inmun2, 0, 0, 0, 0, null);
                    setMarker(emarker_art1, 0, 0, 0, 0, null);
                    setMarker(emarker_art2, 0, 0, 0, 0, null);
                    setMarker(emarker_lib, 0, 0, 0, 0, null);
                    setMarker(emarker_nuri1, 0, 0, 0, 0, null);
                    setMarker(emarker_nuri2, 0, 0, 0, 0, null);
                    setMarker(emarker_1stsci, 0, 0, 0, 0, null);
                    setMarker(emarker_2ndsci, 0, 0, 0, 0, null);
                    setMarker(emarker_shalom, 0, 0, 0, 0, null);
                    setMarker(emarker_gukje, 0, 0, 0, 0, null);
                    setMarker(emarker_barom1, 0, 0, 0, 0, null);
                    setMarker(emarker_barom2, 0, 0, 0, 0, null);
                    setMarker(emarker_admin, 0, 0, 0, 0, null);
                }
            }
        });
    }

    //현재위치 표시
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;
        naverMap.setLocationSource(locationSource);  //현재위치 표시
        ActivityCompat.requestPermissions(this, PERMISSIONS,
                LOCATION_PERMISSION_REQUEST_CODE);
    }

    //위치접근 함수
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
            if(!locationSource.isActivated()) {
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
                return;
            } else {
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    //마커 생성 함수
    void setMarker(Marker marker,  double lat, double lng, int resourceID, int zIndex, NaverMap naverMap)
    {
        //원근감 표시
        //marker.setIconPerspectiveEnabled(true);
        //아이콘 지정
        marker.setIcon(OverlayImage.fromResource(resourceID));
        //마커의 투명도
        marker.setAlpha(0.8f);
        //마커 위치
        marker.setPosition(new LatLng(lat, lng));
        //마커 우선순위
        marker.setZIndex(zIndex);
        //마커 표시
        marker.setMap(naverMap);
        //마커 최소 최대 줌 레벨
        marker.setMinZoom(15);
        marker.setMaxZoom(21);
    }


}