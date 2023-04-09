package com.hl.attendance;
public class AutoPhone {
    //1、获取当前应用的包名 adb shell dumpsys window | findstr mCurrentFocus   钉钉com.alibaba.android.rimet
    //2、找到入口Activity adb shell dumpsys package com.alibaba.android.rimet   | findstr \/ |findstr filter
    //3、启动app adb shell am start com.xxx.xxx/com.xxx.xxx.starActivity

    /**
     * KEYCODE_CALL: 拨号键
     * KEYCODE_ENDCALL: 挂机键
     * KEYCODE_HOME: 按键Home
     * KEYCODE_MENU: 菜单键
     * KEYCODE_BACK: 返回键
     * KEYCODE_SEARCH: 搜索键
     * KEYCODE_CAMERA: 拍照键
     * KEYCODE_FOCUS: 拍照对焦键
     * KEYCODE_POWER: 电源键
     * KEYCODE_NOTIFICATION: 通知键
     * KEYCODE_MUTE: 话筒静音键
     * KEYCODE_VOLUME_MUTE: 扬声器静音键
     * KEYCODE_VOLUME_UP: 音量增加键
     * KEYCODE_VOLUME_DOWN: 音量减小键
     * KEYCODE_ENTER: 回车键
     * KEYCODE_ESCAPE: ESC键
     * KEYCODE_DPAD_CENTER: 导航键 确定键
     * KEYCODE_DPAD_UP: 导航键 向上
     * KEYCODE_DPAD_DOWN: 导航键 向下
     * KEYCODE_DPAD_LEFT: 导航键 向左
     * KEYCODE_DPAD_RIGHT: 导航键 向右
     * KEYCODE_MOVE_HOME: 光标移动到开始键
     * KEYCODE_MOVE_END: 光标移动到末尾键
     * KEYCODE_PAGE_UP: 向上翻页键
     * KEYCODE_PAGE_DOWN: 向下翻页键
     * KEYCODE_DEL: 退格键
     * KEYCODE_FORWARD_DEL: 删除键
     * KEYCODE_INSERT: 插入键
     * KEYCODE_TAB: Tab键
     * KEYCODE_NUM_LOCK: 小键盘锁
     * KEYCODE_CAPS_LOCK: 大写锁定键
     * KEYCODE_BREAK: Break/Pause键
     * KEYCODE_SCROLL_LOCK: 滚动锁定键
     * KEYCODE_ZOOM_IN: 放大键
     * KEYCODE_ZOOM_OUT: 缩小键
     * <p>
     * 0 --> "KEYCODE_UNKNOWN"
     * 1 --> "KEYCODE_MENU"
     * 2 --> "KEYCODE_SOFT_RIGHT"
     * 3 --> "KEYCODE_HOME"
     * 4 --> "KEYCODE_BACK"
     * 5 --> "KEYCODE_CALL"
     * 6 --> "KEYCODE_ENDCALL"
     * 7 --> "KEYCODE_0"
     * 8 --> "KEYCODE_1"
     * 9 --> "KEYCODE_2"
     * 10 --> "KEYCODE_3"
     * 11 --> "KEYCODE_4"
     * 12 --> "KEYCODE_5"
     * 13 --> "KEYCODE_6"
     * 14 --> "KEYCODE_7"
     * 15 --> "KEYCODE_8"
     * 16 --> "KEYCODE_9"
     * 17 --> "KEYCODE_STAR"
     * 18 --> "KEYCODE_POUND"
     * 19 --> "KEYCODE_DPAD_UP"
     * 20 --> "KEYCODE_DPAD_DOWN"
     * 21 --> "KEYCODE_DPAD_LEFT"
     * 22 --> "KEYCODE_DPAD_RIGHT"
     * 23 --> "KEYCODE_DPAD_CENTER"
     * 24 --> "KEYCODE_VOLUME_UP"
     * 25 --> "KEYCODE_VOLUME_DOWN"
     * 26 --> "KEYCODE_POWER"
     * 27 --> "KEYCODE_CAMERA"
     * 28 --> "KEYCODE_CLEAR"
     * 29 --> "KEYCODE_A"
     * 30 --> "KEYCODE_B"
     * 31 --> "KEYCODE_C"
     * 32 --> "KEYCODE_D"
     * 33 --> "KEYCODE_E"
     * 34 --> "KEYCODE_F"
     * 35 --> "KEYCODE_G"
     * 36 --> "KEYCODE_H"
     * 37 --> "KEYCODE_I"
     * 38 --> "KEYCODE_J"
     * 39 --> "KEYCODE_K"
     * 40 --> "KEYCODE_L"
     * 41 --> "KEYCODE_M"
     * 42 --> "KEYCODE_N"
     * 43 --> "KEYCODE_O"
     * 44 --> "KEYCODE_P"
     * 45 --> "KEYCODE_Q"
     * 46 --> "KEYCODE_R"
     * 47 --> "KEYCODE_S"
     * 48 --> "KEYCODE_T"
     * 49 --> "KEYCODE_U"
     * 50 --> "KEYCODE_V"
     * 51 --> "KEYCODE_W"
     * 52 --> "KEYCODE_X"
     * 53 --> "KEYCODE_Y"
     * 54 --> "KEYCODE_Z"
     * 55 --> "KEYCODE_COMMA"
     * 56 --> "KEYCODE_PERIOD"
     * 57 --> "KEYCODE_ALT_LEFT"
     * 58 --> "KEYCODE_ALT_RIGHT"
     * 59 --> "KEYCODE_SHIFT_LEFT"
     * 60 --> "KEYCODE_SHIFT_RIGHT"
     * 61 --> "KEYCODE_TAB"
     * 62 --> "KEYCODE_SPACE"
     * 63 --> "KEYCODE_SYM"
     * 64 --> "KEYCODE_EXPLORER"
     * 65 --> "KEYCODE_ENVELOPE"
     * 66 --> "KEYCODE_ENTER"
     * 67 --> "KEYCODE_DEL"
     * 68 --> "KEYCODE_GRAVE"
     * 69 --> "KEYCODE_MINUS"
     * 70 --> "KEYCODE_EQUALS"
     * 71 --> "KEYCODE_LEFT_BRACKET"
     * 72 --> "KEYCODE_RIGHT_BRACKET"
     * 73 --> "KEYCODE_BACKSLASH"
     * 74 --> "KEYCODE_SEMICOLON"
     * 75 --> "KEYCODE_APOSTROPHE"
     * 76 --> "KEYCODE_SLASH"
     * 77 --> "KEYCODE_AT"
     * 78 --> "KEYCODE_NUM"
     * 79 --> "KEYCODE_HEADSETHOOK"
     * 80 --> "KEYCODE_FOCUS"
     * 81 --> "KEYCODE_PLUS"
     * 82 --> "KEYCODE_MENU"
     * 83 --> "KEYCODE_NOTIFICATION"
     * 84 --> "KEYCODE_SEARCH"
     * 85 --> "TAG_LAST_KEYCODE"
     */
    //private static final String MAIN_UI = "com.alibaba.android.rimet.biz.LaunchHomeActivity";
    private static final String LOGIN_UI = "com.alibaba.android.user.login.SignUpWithPwdActivity";
    public static void testTap(int x, int y) {//点击屏幕100 800坐标启动钉钉
        try {
            Runtime.getRuntime()
                    .exec("adb shell input tap " + x + " " + y);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 1、keyPower模拟按下电源键，点亮屏幕
     * 2、keySwipe模拟滑动，解锁。首先要取消锁屏密码
     * 3、keyHome模拟回到手机主界面，按键两次
     * 4、keyTap模拟点击放在主界面的钉钉，设置好位置。（我的100 800）
     * 5、执行 adb shell dumpsys window w |findstr \/ |findstr name= >c:\a.txt 判断当前钉钉界面
     * com.alibaba.android.rimet.biz.LaunchHomeActivity 钉钉主界面
     * com.alibaba.android.user.login.SignUpWithPwdActivity 钉钉登录界面
     * 6、keyHome
     * 7、keyPower关闭屏幕
     */
    public void mockAttendance() {
        String filename="D:\\autoAttendance\\application.properties";
        String[] dingTalkLocationList = GetXmlSetting.getPropertiesAsList(filename,"dingTalkLocation").split("=");
        String dingTalkLocation=dingTalkLocationList[1];
        try {
            Runtime.getRuntime().exec("adb shell input keyevent KEYCODE_POWER");
            Thread.sleep(4000);
            Runtime.getRuntime().exec("adb shell input swipe 500 500 500 800");
            Thread.sleep(3000);
            Runtime.getRuntime().exec("adb shell input keyevent KEYCODE_HOME");
            Thread.sleep(1000);
            Runtime.getRuntime().exec("adb shell input keyevent KEYCODE_HOME");
            Thread.sleep(1000);
            Runtime.getRuntime().exec("adb shell input tap " + dingTalkLocation);
            Thread.sleep(15000);
            getActivity();
            if ((GetXmlSetting.getTxt("D:\\autoAttendance\\isLogin.txt")).contains(LOGIN_UI)) {
                String[] pwdLocationList=GetXmlSetting.getPropertiesAsList(filename,"pwdLocation").split("=");
                String[] pwdList = GetXmlSetting.getPropertiesAsList(filename,"dingTalkPassword").split("=");
                String[] loginLocationList=GetXmlSetting.getPropertiesAsList(filename,"loginLocation").split("=");
                String pwdLocation=pwdLocationList[1];
                String pwd=pwdList[1];
                String loginLocation=loginLocationList[1];
                Runtime.getRuntime().exec("adb shell input tap " + pwdLocation);
                Thread.sleep(1000);
                Runtime.getRuntime().exec("adb shell input text " + pwd);
                Thread.sleep(2000);
                Runtime.getRuntime().exec("adb shell input tap " + loginLocation);
                Thread.sleep(15000);
            }
            Runtime.getRuntime().exec("adb shell input keyevent KEYCODE_HOME");
            Thread.sleep(1000);
            Runtime.getRuntime().exec("adb shell input keyevent KEYCODE_POWER");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /*@Test
    @Bean
    public void text2(AppProperties properties){
        System.out.println(properties.getHoliday());
    }*/
    /**
     * 获取当前Activity的信息重定向输出到c:\a.txt,用于判断是登陆界面还是主界面
     */
    public static void getActivity() {
        try {
            String[] cmd = {"cmd.exe", "/c", "adb shell dumpsys window w |findstr \\/ |findstr name= >D:\\autoAttendance\\isLogin.txt"};
            Runtime.getRuntime().exec(cmd);
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
