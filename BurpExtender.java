package burp;

//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;

//, IContextMenuFactory

public class BurpExtender implements IBurpExtender, IMessageEditorTabFactory{
        // implements burpExtender
    	public static IBurpExtenderCallbacks callbacks;
    	public static PrintWriter stdout;
    	public static IExtensionHelpers helpers;

		@Override
		public void registerExtenderCallbacks(IBurpExtenderCallbacks _callbacks) {
			
			BurpExtender.callbacks = _callbacks;
			helpers = callbacks.getHelpers();

			stdout = new PrintWriter(callbacks.getStdout(), true);
			callbacks.setExtensionName("Unicode Converter");
			// 注册 menu factory
			callbacks.registerContextMenuFactory(new Menu());
			
			
			
			
		}

		@Override
		public IMessageEditorTab createNewInstance(IMessageEditorController controller, boolean editable) {
			// TODO Auto-generated method stub
			return null;
		}
		

}
