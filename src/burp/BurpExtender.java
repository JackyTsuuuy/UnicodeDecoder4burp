package burp;


import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;


public class BurpExtender implements IBurpExtender{
        // implements burpExtender
    	public static PrintWriter stdout;
    	public static IExtensionHelpers helpers;

		@Override
		public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {
			
			helpers = callbacks.getHelpers();

			stdout = new PrintWriter(callbacks.getStdout(), true);
			callbacks.setExtensionName("Unicode Decoder v1.0 by JackyTsuuuy");
			// 注册 menu factory
			callbacks.registerContextMenuFactory(new Menu());
			
			
		}
		

}
