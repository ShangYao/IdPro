 function checkIEV() {
            var X, V, N;
            V = navigator.appVersion;
            N = navigator.appName;
            if (N == "Microsoft Internet Explorer")
                X = parseFloat(V.substring(V.indexOf("MSIE") + 5, V.lastIndexOf("Windows")));
            else
                X = parseFloat(V);
            return X;
        }
        //设置为不打印
        function noPrint() {
            var stylef = document.styleSheets[0];
            var rul = stylef.rules[0]; /*上面@media 那一段*/
            rul.style.display = "none";
        }
        //设置网页打印的页眉页脚和页边距
        function PageSetup_Null() {
            var HKEY_Root, HKEY_Path, HKEY_Key;
            HKEY_Root = "HKEY_CURRENT_USER";
            HKEY_Path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
            try {
                var Wsh = new ActiveXObject("WScript.Shell");
                HKEY_Key = "header";
                //设置页眉（为空）
                //Wsh.RegRead(HKEY_Root+HKEY_Path+HKEY_Key)可获得原页面设置   
                Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "");
                HKEY_Key = "footer";
                //设置页脚（为空）   
                Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "");

                //这里需要浏览器版本，8.0以下的页边距设置与8.0及以上不一样，注意注册表里的单位是英寸，打印设置中是毫米，1英寸=25.4毫米
                if (checkIEV() < 8.0) {
                    HKEY_Key = "margin_left";
                    //设置左页边距
                    Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "0");
                    HKEY_Key = "margin_right";
                    //设置右页边距
                    Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "0");
                    HKEY_Key = "margin_top";
                    //设置上页边距
                    Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "0.20");
                    HKEY_Key = "margin_bottom";
                    //设置下页边距   
                    Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "0.20");
                }
                else {
                    HKEY_Key = "margin_left";
                    //设置左页边距
                    Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "0");
                    HKEY_Key = "margin_right";
                    //设置右页边距
                    Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "0");
                    HKEY_Key = "margin_top";
                    //设置上页边距
                    Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "1");
                    HKEY_Key = "margin_bottom";
                    //设置下页边距   
                    Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "0.405");
                }
            }
            catch (e) {
                //noPrint();
                //alert("ActiveX控件被禁用,请按下面步骤操作：\n1、请打开浏览器'工具'菜单/'选项'/'安全'下的'自定义级别'，\n把'对没有标记为安全的activex控件进行初始化和脚本运行'设置为'启用'。\n2、刷新本页 ");
            }
        }

