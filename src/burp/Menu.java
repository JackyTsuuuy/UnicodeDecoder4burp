package burp;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JMenuItem;

public class Menu implements IContextMenuFactory {
	//重写createMenuItems方法

	public PrintWriter stdout;

	@Override
	public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {
		//ctx获取当前所选的位置
		byte ctx = invocation.getInvocationContext();
		//创建一个JMenuItem类型的list
		List<JMenuItem> listMenuItems = new ArrayList<JMenuItem>();
		
		//创建一个menu的选项实例，"send to Unicode Decoder"
		JMenuItem jMenuItem = new JMenuItem("send to Unicode Decoder");
		//在JMenuItem类型的list中添加新的实例
		listMenuItems.add(jMenuItem);
		
		jMenuItem.addActionListener(new ActionListener() {
			Dialog dlg = new Dialog();
			UniDecoder uniDecoder = new UniDecoder();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub				
				//if:如果是request，elif如果是response
				if (ctx == IContextMenuInvocation.CONTEXT_MESSAGE_EDITOR_REQUEST ||
						ctx == IContextMenuInvocation.CONTEXT_MESSAGE_VIEWER_REQUEST
						) {
					IHttpRequestResponse[] requestResponses = invocation.getSelectedMessages();
					int start = invocation.getSelectionBounds()[0];
					int end = invocation.getSelectionBounds()[1];
					if (start == end) {
					    
					    //接收
					    String testString = null;
					    try {
						testString = new String(requestResponses[0].getRequest(), "UTF-8");
					    } catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					    }
					    
					    //弹框
					    dlg.setString(uniDecoder.unicodeToString(testString));
					    dlg.show();
					    
					    BurpExtender.stdout.println(testString);
					    
					} else {
					    
					    
					    String testString = null;
					    try {
						testString = new String(requestResponses[0].getRequest(), "UTF-8").substring(start, end);
					    } catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					    }
					    //弹框
					    dlg.setString(uniDecoder.unicodeToString(testString));
					    dlg.show();
					    
					    BurpExtender.stdout.println(testString);

					}
				}else if (ctx == invocation.CONTEXT_MESSAGE_EDITOR_RESPONSE || 
					ctx == invocation.CONTEXT_MESSAGE_VIEWER_RESPONSE
					) {

					IHttpRequestResponse[] requestResponses = invocation.getSelectedMessages();
					int start = invocation.getSelectionBounds()[0];
					int end = invocation.getSelectionBounds()[1];
					if (start == end) {
					    
					    //接收
					    String testString = null;
					    try {
						testString = new String(requestResponses[0].getResponse(), "UTF-8");
					    } catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					    }
					  //弹框
					    dlg.setString(uniDecoder.unicodeToString(testString));
					    dlg.show();
					    
					    BurpExtender.stdout.println(testString);
					    
					} else {
					    
					    
					    String testString = null;
					    try {
						testString = new String(requestResponses[0].getResponse(), "UTF-8").substring(start, end);
					    } catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					    }
					    
					  //弹框
					    dlg.setString(uniDecoder.unicodeToString(testString));
					    dlg.show();
					    
					    BurpExtender.stdout.println(testString);

					}
				
				}else {
				    BurpExtender.stdout.println("error??");
				}
				

			}
		});
		
		
		return listMenuItems;
	}
	
	

}
