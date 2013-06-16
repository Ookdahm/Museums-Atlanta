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

public class MapsHistory<PointLocation> extends MapActivity {
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
        
        GeoPoint point06 = new GeoPoint((int) (33.7784767*1E6), (int) (-84.3171604*1E6));
        OverlayItem overlayitem06 = new OverlayItem(point06, 
        		"Fernbank Museum of Natural History", "156 Heaton Park Drive, Atlanta, GA 30307");
        
        GeoPoint point07 = new GeoPoint((int) (33.8418226*1E6), (int) (-84.3862688*1E6));
        OverlayItem overlayitem07 = new OverlayItem(point07, 
        		"Atlanta History Center", "130 West Paces Ferry Road NW, Atlanta, GA 30305");
        
        GeoPoint point08 = new GeoPoint((int) (33.755064*1E6), (int) (-84.373007*1E6));
        OverlayItem overlayitem08 = new OverlayItem(point08, 
        		"The King Center", "449 Auburn Avenue, NE, Atlanta, GA 30312");
        
        GeoPoint point09 = new GeoPoint((int) (33.7899824*1E6), (int) (-84.3247796*1E6));
        OverlayItem overlayitem09 = new OverlayItem(point09, 
        		"Michael C. Carlos Museum", "571 South Kilgo Circle, Atlanta, GA 30322");
        
        GeoPoint point10 = new GeoPoint((int) (33.7749203*1E6), (int) (-84.329617*1E6));
        OverlayItem overlayitem10 = new OverlayItem(point10, 
        		"Fernbank Museum of Natural History", "767 Clifton Road, N.E.  Atlanta, GA 30307");
        
        GeoPoint point11 = new GeoPoint((int) (33.75527*1E6), (int) (-84.383087*1E6));
        OverlayItem overlayitem11 = new OverlayItem(point11, 
        		"The Apex Museum", "135 Auburn Avenue, Atlanta, GA  30303");
        
        GeoPoint point12 = new GeoPoint((int) (33.7375619*1E6), (int) (-84.422393*1E6));
        OverlayItem overlayitem12 = new OverlayItem(point12, 
        		"The Wren's Nest", "1050 Ralph David Abernathy Blvd, SW, Atlanta, GA 30310");
        
        GeoPoint point13 = new GeoPoint((int) (33.762565*1E6), (int) (-84.391488*1E6));
        OverlayItem overlayitem13 = new OverlayItem(point13, 
        		"Imagine It! The Children's Museum of Atlanta", "275 Centennial Olympic Park Drive NW, Atlanta, GA 30313-1827");
        
        GeoPoint point14 = new GeoPoint((int) (33.7666558*1E6), (int) (-84.3550018*1E6));
        OverlayItem overlayitem14 = new OverlayItem(point14, 
        		"The Jimmy Carter Library and Museum", "441 Freedom Parkway, Atlanta, Georgia 30307");
        
        GeoPoint point15 = new GeoPoint((int) (33.793593*1E6), (int) (-84.389527*1E6));
        OverlayItem overlayitem15 = new OverlayItem(point15, 
        		"The Breman Jewish Heritage & Holocaust Museum", "1440 Spring St. NW, Atlanta, Georgia 30309");
        
        GeoPoint point16 = new GeoPoint((int) (33.739676*1E6), (int) (-84.371717*1E6));
        OverlayItem overlayitem16 = new OverlayItem(point16, 
        		"Atlanta Cyclorama & Civil War Museum", "800 Cherokee Ave. S.E.,  Atlanta, GA 30315");
        
        GeoPoint point17 = new GeoPoint((int) (33.781219*1E6), (int) (-84.384464*1E6));
        OverlayItem overlayitem17 = new OverlayItem(point17, 
        		"Margaret Mitchell House and Museum", "990 Peachtree Street, NE, Atlanta, GA 30309");
        
        GeoPoint point26 = new GeoPoint((int) (32.6182444*1E6), (int) (-83.6197287*1E6));
        OverlayItem overlayitem26 = new OverlayItem(point26, 
        		"U.S. Air Force Museum of Aviation", "GA Hwy 247 & Russell Parkway, Warner Robins, GA 31099");
        
        GeoPoint point27 = new GeoPoint((int) (31.466988*1E6), (int) (-83.5324009*1E6));
        OverlayItem overlayitem27 = new OverlayItem(point27, 
        		"Georgia Museum of Agriculture and Historic Village", "1392 Whiddon Mill Road, Tifton, GA 31793");
        
        GeoPoint point29 = new GeoPoint((int) (34.28979*1E6), (int) (-85.180618*1E6));
        OverlayItem overlayitem29 = new OverlayItem(point29, 
        		"Oak Hill & The Martha Berry Museum", "2277 Martha Berry Hwy NW,  Mount Berry, GA 30149");
        
        GeoPoint point30 = new GeoPoint((int) (33.9875203*1E6), (int) (-84.1535828*1E6));
        OverlayItem overlayitem30 = new OverlayItem(point30, 
        		"Southeastern Railway Museum", "3595 Buford Hwy., Duluth, GA 30096");
        
        GeoPoint point31 = new GeoPoint((int) (33.7555533*1E6), (int) (-84.3841929*1E6));
        OverlayItem overlayitem31 = new OverlayItem(point31, 
        		"Auburn Avenue Research Library", "101 Auburn Avenue NE, Atlanta GA 30303-2503");

        GeoPoint point33 = new GeoPoint((int) (33.755959*1E6), (int) (-84.406762*1E6));
        OverlayItem overlayitem33 = new OverlayItem(point33, 
        		"Herndon Home Museum", "587 University Place, NW, Atlanta, GA 30314");
        
        
        itemizedOverlay.addOverlay(overlayitem01);
        itemizedOverlay.addOverlay(overlayitem02);
        itemizedOverlay.addOverlay(overlayitem06);
        itemizedOverlay.addOverlay(overlayitem07);
        itemizedOverlay.addOverlay(overlayitem08);
        itemizedOverlay.addOverlay(overlayitem09);
        itemizedOverlay.addOverlay(overlayitem10);
        itemizedOverlay.addOverlay(overlayitem11);
        itemizedOverlay.addOverlay(overlayitem12);
        itemizedOverlay.addOverlay(overlayitem13);
        itemizedOverlay.addOverlay(overlayitem14);
        itemizedOverlay.addOverlay(overlayitem15);
        itemizedOverlay.addOverlay(overlayitem16);
        itemizedOverlay.addOverlay(overlayitem17);
        itemizedOverlay.addOverlay(overlayitem26);
        itemizedOverlay.addOverlay(overlayitem27);
        itemizedOverlay.addOverlay(overlayitem29);
        itemizedOverlay.addOverlay(overlayitem30);
        itemizedOverlay.addOverlay(overlayitem31);
        itemizedOverlay.addOverlay(overlayitem33);
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
    	  AlertDialog.Builder dialog = new AlertDialog.Builder(MapsHistory.this);
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