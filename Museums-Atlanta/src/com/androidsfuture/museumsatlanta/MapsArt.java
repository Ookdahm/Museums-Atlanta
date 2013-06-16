 package com.androidsfuture.museumsatlanta;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapsArt<PointLocation> extends MapActivity {
    /** Called when the activity is first created. */
	List<Overlay> mapOverlays;
	Drawable drawable;
	MuseumItemizedOverlay itemizedOverlay;
	Context mContext;
	MapView mapView;
	MyLocationOverlay me=null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);

        mapView = (MapView) findViewById(R.id.mapview);
        mapView.setBuiltInZoomControls(true);
        
        mapOverlays = mapView.getOverlays();
        drawable = this.getResources().getDrawable(R.drawable.museum_48);
        itemizedOverlay = new MuseumItemizedOverlay(drawable);
        
        me=new MyLocationOverlay(this, mapView);
        
        me.runOnFirstFix(new Runnable() { public void run() {
            mapView.getController().animateTo(me.getMyLocation());
        }});
        
    	mapView.getOverlays().add(me);
        
    	GeoPoint point01 = new GeoPoint((int) (33.781031*1E6), (int) (-84.4047187*1E6));
        OverlayItem overlayitem01 = new OverlayItem(point01, 
        		"American Museum of Papermaking", "500 10th Street NW, Atlanta, GA 30332");
        
        GeoPoint point02 = new GeoPoint((int) (33.781999*1E6), (int) (-84.345691*1E6));
        OverlayItem overlayitem02 = new OverlayItem(point02, 
        		"Callanwolde Fine Arts Center", "980 Briarcliff Road, N.E., Atlanta, Georgia 30306");
        
        GeoPoint point03 = new GeoPoint((int) (33.790098*1E6), (int) (-84.385493*1E6));
        OverlayItem overlayitem03 = new OverlayItem(point03, 
        		"High Museum of Art", "1280 Peachtree Street, N.E., Atlanta, Georgia 30309");
        
        GeoPoint point04 = new GeoPoint((int) (33.8749844*1E6), (int) (-84.3336721*1E6));
        OverlayItem overlayitem04 = new OverlayItem(point04, 
        		"Oglethorpe University Museum", "4484 Peachtree Road, N.E., Atlanta, GA 30319");
        
        GeoPoint point09 = new GeoPoint((int) (33.7899824*1E6), (int) (-84.3247796*1E6));
        OverlayItem overlayitem09 = new OverlayItem(point09, 
        		"Michael C. Carlos Museum", "571 South Kilgo Circle, Atlanta, GA 30322");
        
        GeoPoint point18 = new GeoPoint((int) (33.790098*1E6), (int) (-84.385493*1E6));
        OverlayItem overlayitem18 = new OverlayItem(point18, 
        		"The Woodruff Arts Center", "1280 Peachtree Street NE, Atlanta, GA 30309");
        
        GeoPoint point19 = new GeoPoint((int) (33.792772*1E6), (int) (-84.389119*1E6));
        OverlayItem overlayitem19 = new OverlayItem(point19, 
        		"Center for Puppetry Arts", "1404 Spring St. NW at 18th, Atlanta, GA 30309");
        
        GeoPoint point20 = new GeoPoint((int) (33.741241*1E6), (int) (-84.420882*1E6));
        OverlayItem overlayitem20 = new OverlayItem(point20, 
        		"Hammonds House Museum", "503 Peeples Street, SW, Atlanta, GA 30310");
        
        GeoPoint point21 = new GeoPoint((int) (33.7728392*1E6), (int) (-84.4052857*1E6));
        OverlayItem overlayitem21 = new OverlayItem(point21, 
        		"Atlanta Contemporary Art Center", "535 Means Street, NW, Atlanta, GA 30318");
          
        GeoPoint point23 = new GeoPoint((int) (33.761985*1E6), (int) (-84.385582*1E6));
        OverlayItem overlayitem23 = new OverlayItem(point23, 
        		"Museum of Design Atlanta", "285 Peachtree Center Ave, NE, Atlanta, GA 30303");
 
        GeoPoint point25 = new GeoPoint((int) (33.479383*1E6), (int) (-81.9689099*1E6));
        OverlayItem overlayitem25 = new OverlayItem(point25, 
        		"Morris Museum of Art", "1 Tenth Street, Augusta, Georgia 30901");
        
        GeoPoint point32 = new GeoPoint((int) (33.745176*1E6), (int) (-84.411187*1E6));
        OverlayItem overlayitem32 = new OverlayItem(point32, 
        		"Spelman College Museum of Fine Arts", "350 Spelman Lane SW, Atlanta, GA 30314");
        
        
        itemizedOverlay.addOverlay(overlayitem01);
        itemizedOverlay.addOverlay(overlayitem02);
        itemizedOverlay.addOverlay(overlayitem03);
        itemizedOverlay.addOverlay(overlayitem04);
        itemizedOverlay.addOverlay(overlayitem09);
        itemizedOverlay.addOverlay(overlayitem18);
        itemizedOverlay.addOverlay(overlayitem19);
        itemizedOverlay.addOverlay(overlayitem20);
        itemizedOverlay.addOverlay(overlayitem21);
        itemizedOverlay.addOverlay(overlayitem23);
        itemizedOverlay.addOverlay(overlayitem25);
        itemizedOverlay.addOverlay(overlayitem32);
        mapOverlays.add(itemizedOverlay);
        
		MapController mapControl = mapView.getController();
        mapControl.setCenter(itemizedOverlay.getCenter());
        mapControl.zoomToSpan(itemizedOverlay.getLatSpanE6(), itemizedOverlay.getLonSpanE6());
        mapControl.setZoom(21);
    }
    
    @Override
	public void onResume() {
		super.onResume();
		me.enableMyLocation();
		me.enableCompass();
	}		

	@Override
	public void onPause() {
		super.onPause();
		me.disableMyLocation();
		me.disableCompass();
	}
    

    protected boolean isRouteDisplayed() {
        return false;
    }
	    
	 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_menu, menu);
        return true;
    }
	  
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        
        case R.id.Sat_View:
        	mapView.setSatellite(true);
            mapView.setStreetView(true);
            return true;
            
        case R.id.Map_View:
        	mapView.setSatellite(false);
            mapView.setStreetView(false);
            return true;
        
        case R.id.Map_Menu_All:
        	
    		startActivity(new Intent(this, Maps.class));
    		Toast.makeText(this, R.string.toast_all, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Free:
    		
    		startActivity(new Intent(this, MapsFree.class));
    		Toast.makeText(this, R.string.toast_free, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Art:
    		
    		startActivity(new Intent(this, MapsArt.class));
    		Toast.makeText(this, R.string.toast_art, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Mansion:
    		
    		startActivity(new Intent(this, MapsMansion.class));
    		Toast.makeText(this, R.string.toast_mansion, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_History:
    	
    		startActivity(new Intent(this, MapsHistory.class));
    		Toast.makeText(this, R.string.toast_history, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
    	case R.id.Map_Menu_Science:
    	
    		startActivity(new Intent(this, MapsScience.class));
    		Toast.makeText(this, R.string.toast_science, Toast.LENGTH_LONG).show();
    		this.finish();
    		return true;
    		
        default:
            return super.onOptionsItemSelected(item);
        }
    }   
	    
	    
    public class MuseumItemizedOverlay extends ItemizedOverlay {

    	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
    	
    	public MuseumItemizedOverlay(Drawable defaultMarker) {
    		super(boundCenterBottom(defaultMarker));
    		
    		// TODO Auto-generated constructor stub
    	}
    	
    	public void addOverlay(OverlayItem overlay) {
    	    mOverlays.add(overlay);
    	    populate();
    	}

    	@Override
    	protected OverlayItem createItem(int i) {
    		// TODO Auto-generated method stub
    		return mOverlays.get(i);
    	}

    	@Override
    	public int size() {
    		// TODO Auto-generated method stub
    		return mOverlays.size();
    	}
    	
    	@Override
    	protected boolean onTap(int index) {
    	
    	
    	  final OverlayItem item = mOverlays.get(index);
    	  AlertDialog.Builder dialog = new AlertDialog.Builder(MapsArt.this);
    	  dialog.setTitle(item.getTitle());
    	  dialog.setMessage(item.getSnippet());
    	  
    	  dialog.setNegativeButton("Navigate", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int id) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://maps.google.com/maps?daddr=" + item.getSnippet())));
				
			}
		});
    	  
    	  dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
				
			}
		});
    	  dialog.show();
    	 
    	  return true;
    	}

    }

}