package com.sticksports.nativeExtensions.mopub.functions.banner;

import android.widget.FrameLayout;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREObject;
import com.sticksports.nativeExtensions.mopub.MoPubBannerContext;
import com.sticksports.nativeExtensions.mopub.MoPubExtension;
import com.sticksports.nativeExtensions.utils.UIThreadSafeFREFunction;

public class MoPubBannerSetWidth extends UIThreadSafeFREFunction {

	public FREObject safeCall( FREContext ctx, FREObject[] args )
	{
		try
		{
			MoPubBannerContext context = (MoPubBannerContext) ctx;
			int width = args[0].getAsInt();
			context.getBanner().setPlannedWidth( width );
			
		    FrameLayout.LayoutParams params = ( FrameLayout.LayoutParams ) context.getBanner().getLayoutParams();
		    if( params != null )
		    {
		    	params.width = width;
			   	context.getBanner().setLayoutParams(params);
		    }
		    
		    MoPubExtension.log("Banner width set to " + width);
		}
		catch ( Exception exception )
		{
			MoPubExtension.logW(exception.toString());
			exception.printStackTrace();
		}
		return null;
	}

}
