package edu.nju.autodroid;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.ShellCommandUnresponsiveException;
import com.android.ddmlib.TimeoutException;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.graphics.Rect;
import edu.nju.autodroid.activity.ActivityNode;
import edu.nju.autodroid.activity.ActivityTree;
import edu.nju.autodroid.uiautomator.UiAutomatorHelper;
import edu.nju.autodroid.utils.AdbConnection;
import edu.nju.autodroid.utils.AdbHelper;
import edu.nju.autodroid.utils.CmdExecutor;
import edu.nju.autodroid.utils.Configuration;

public class Server {
	public static final String TAG = "server";  
    public static int PC_LOCAL_PORT = 22222;  
    public static int PHONE_PORT = 22222;  

	public static void main(String[] args) throws TimeoutException, AdbCommandRejectedException, IOException, InterruptedException, ShellCommandUnresponsiveException {

		//System.out.println(Configration.getProperty("android_jar_version"));
		//CmdExecutor.execCmd("sh -c ant")i;
		//UiAutomatorHelper helper = new UiAutomatorHelper();
		//helper.BeginTest("demo", "edu.nju.autodroid.main.Main", "testDemo", 3);
		//AdbHelper.initializeBridge();
		//System.out.println(UiAutomatorHelper.getWorkSpase());
		AdbHelper.initializeBridge();
		/*mDevice = AdbHelper.getDevice();
		mDevice.createForward(PC_LOCAL_PORT, PHONE_PORT);
		initializeConnection();*/
		AdbConnection.initializeConnection(PC_LOCAL_PORT, PHONE_PORT);
		String layout = AdbConnection.getLayout();
		System.out.println(layout);
		ActivityTree at = new ActivityTree(layout);
		at.print();
		at.forAll(new Consumer<ActivityNode>() {
			
			@Override
			public void accept(ActivityNode t) {
				if(t.focusable && t.className.contains("EditText")){
					System.out.println("consumer: " + t.className);
					AdbConnection.doSetText(t, "only english accepted");
				}
				
				
			}
		});
		System.out.println(AdbHelper.getFocusedActivity());
		Thread.sleep(2000);
		
		AdbHelper.terminateBridge();
	}
}
