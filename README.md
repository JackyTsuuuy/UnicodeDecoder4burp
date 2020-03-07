# UnicodeDecoder4burp
burpsuite Unicode解码插件


### usage：
##### 情况一
1. 选中要解码的文字
2. 右键-> send to unicode decoder，即可就选中部分解码


##### 情况二
（对于出现中文字符，无法准确选中的情况。或者需要全文解码的时候）
不选中任何字符直接右键-> send to unicode decoder，即可对request/response全文解码

参考：
https://github.com/bit4woo/u2c
弥补了不可二次解码的不足
