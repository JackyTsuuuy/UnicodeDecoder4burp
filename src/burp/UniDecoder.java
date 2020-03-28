package burp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniDecoder {
	/**
	 * unicode转字符串
	 * 
	 * @param unicode
	 * @return
	 */
//	public static String unicodeToString(String unicode) {
//		StringBuffer sb = new StringBuffer();
//		String[] hex = unicode.split("\\\\u");
//		for (int i = 1; i < hex.length; i++) {
//			int index = Integer.parseInt(hex[i], 16);
//			sb.append((char) index);
//		}
//		return sb.toString();
//	}
	
	
	public static String unicodeToString(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);

				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed   \\uxxxx   encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}
	
//	public static boolean needtoconvert(String str) {
//	    Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
//	    Matcher matcher = pattern.matcher(str.toLowerCase());
//	    	
//	    if (matcher.find() ){
//	    	String found = matcher.group();
//	    		//��@#��%����&*��������-=������������{}����+
//	    	String chineseCharacter = "\\uff01\\u0040\\u0023\\uffe5\\u0025\\u2026\\u2026\\u0026\\u002a\\uff08\\uff09\\u2014\\u2014\\u002d\\u003d\\uff0c\\u3002\\uff1b\\uff1a\\u201c\\u2018\\u007b\\u007d\\u3010\\u3011\\u002b";
//	    	if (("\\u4e00").compareTo(found)<= 0 && found.compareTo("\\u9fa5")<=0)
//	    		return true;
//	    	else if(chineseCharacter.contains(found)){
//	    		return true;
//	    	}else{
//	    		return false;
//	    	}
//	    }else {
//	    	return false;
//	    }
//	}
	
//	public static String decodeUnicode2(String dataStr) {     
//	        int start = 0;     
//	        int end = 0;     
//	        final StringBuffer buffer = new StringBuffer();     
//	        while (start > -1) {     
//	            end = dataStr.indexOf("\\u", start + 2);     
//	            String charStr = null;     
//	            if (end == -1) {     
//	                charStr = dataStr.substring(start + 2, dataStr.length());     
//	            } else {     
//	                charStr = dataStr.substring(start + 2, end);     
//	            }     
//	            char letter = (char) Integer.parseInt(charStr, 16);   
//	            buffer.append(new Character(letter).toString());     
//	            start = end;     
//	        }     
//	        return buffer.toString();     
//	     } 

    
//	/**
//	 * 字符串转unicode
//	 * 
//	 * @param str
//	 * @return
//	 */
//	public static String stringToUnicode(String str) {
//		StringBuffer sb = new StringBuffer();
//		char[] c = str.toCharArray();
//		for (int i = 0; i < c.length; i++) {
//			sb.append("\\u" + Integer.toHexString(c[i]));
//		}
//		return sb.toString();
//	}

	

}
