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
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapsScience<PointLocation> extends MapActivity {
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
        
        GeoPoint point05 = new GeoPoint((int) (33.7916847*1E6), (int) (-84.3722534*1E6));
        OverlayItem overlayitem05 = new OverlayItem(point05, 
        		"Atlanta Botanical Gardens", "1345 Piedmont Ave. NE, Atlanta, GA 30309");
        
        GeoPoint point06 = new GeoPoint((int) (33.7784767*1E6), (int) (-84.3171604*1E6));
        OverlayItem overlayitem06 = new OverlayItem(point06, 
        		"Fernbank Museum of Natural History", "156 Heaton Park Drive, Atlanta, GA 30307");
      
        GeoPoint point10 = new GeoPoint((int) (33.7749203*1E6), (int) (-84.329617*1E6));
        OverlayItem overlayitem10 = new OverlayItem(point10, 
        		"Fernbank Museum of Natural History", "767 Clifton Road, N.E.  Atlanta, GA 30307");
     
        GeoPoint point13 = new GeoPoint((int) (33.762565*1E6), (int) (-84.391488*1E6));
        OverlayItem overlayitem13 = new OverlayItem(point13, 
        		"Imagine It! The Children's Museum of Atlanta", "275 Centennial Olympic Park Drive NW, Atlanta, GA 30313-1827");
        
        GeoPoint point22 = new GeoPoint((int) (33.781031*1E6), (int) (-84.4047187*1E6));
        OverlayItem overlayitem22 = new OverlayItem(point22, 
        		"Institute of Paper and Science Technology", "500 10th St, NW, Atlanta, GA 30318");
       
        GeoPoint point24 = new GeoPoint((int) (33.7986213*1E6), (int) (-84.325819*1E6));
        OverlayItem overlayitem24 = new OverlayItem(point24, 
        		"Centers for Disease Control and Prevention Global Health Odyssey", "1600 Clifton Rd., NE Atlanta, GA 30333");
        
        GeoPoint point26 = new GeoPoint((int) (32.6182444*1E6), (int) (-83.6197287*1E6));
        OverlayItem overlayitem26 = new OverlayItem(point26, 
        		"U.S. Air Force Museum of Aviation", "GA Hwy 247 & Russell Parkway, Warner Robins, GA 31099");
        
        GeoPoint point27 = new GeoPoint((int) (31.466988*1E6), (int) (-83.5324009*1E6));
        OverlayItem overlayitem27 = new OverlayItem(point27, 
        		"Georgia Museum of Agriculture and Historic Village", "1392 Whiddon Mill Road, Tifton, GA 31793");
        
        GeoPoint point28 = new GeoPoint((int) (33.9567067*1E6), (int) (-84.3359178*1E6));
        OverlayItem overlayitem28 = new OverlayItem(point28, 
        		"Dunwoody Nature Center", "5343 Roberts Drive, Dunwoody, GA 30338");
        
       
        itemizedOverlay.addOverlay(overlayitem01);
        itemizedOverlay.addOverlay(overlayitem05);
        itemizedOverlay.addOverlay(overlayitem06);
        itemizedOverlay.addOverlay(overlayitem10);
        itemizedOverlay.addOverlay(overlayitem13);
        itemizedOverlay.addOverlay(overlayitem22);
        itemizedOverlay.addOverlay(overlayitem24);
        itemizedOverlay.addOverlay(overlayitem26);
        itemizedOverlay.addOverlay(overlayitem27);
        itemizedOverlay.addOverlay(overlayitem28);
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
    	  AlertDialog.Builder dialog = new AlertDialog.Builder(MapsScience.this);
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