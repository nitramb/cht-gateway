package medic.gateway;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.provider.Telephony;

public class Capabilities {
	@TargetApi(19)
	public boolean isDefaultSmsProvider(Context ctx) {
		if(!canBeDefaultSmsProvider()) throw new IllegalStateException();
		return Utils.class.getPackage().getName().equals(Telephony.Sms.getDefaultSmsPackage(ctx));
	}

	/**
	 * Check if medic-gateway can be the default messaging app on this
	 * device.  This feature is only available on Android 4.4 (kitkat®) or
	 * later.
	 */
	public boolean canBeDefaultSmsProvider() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
	}

	public static Capabilities getCapabilities() {
		return new Capabilities();
	}
}
