package com.hl.attendance;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * info: 调用API接口判断日期是否是工作日 周末还是节假日
 *
 * @Author caoHaiYang
 * {@Location 配置文件位于: /resources/holiday.txt}
 */
public class HolidayUtils {
    /**
     * 法定节假日
     */
    static List<String> holiday = new ArrayList<>();
    /**
     * 调休上班日
     */
    static List<String> extraWorkDay = new ArrayList<>();
    /**
     * 法定节假日标识字符串
     */
    private static final String HOLIDAY_FLAG_STRING = "#######法定节假日日期#######";
    /**
     * 调休加班标识字符串
     */
    private static final String EXTRAWORKDAY_FLAG_STRING = "#######调休加班日期#######";

    /**
     * 初始化节假日和调休
     */
    public static void initHolidayAndExtraWorkDay() throws IOException {
        //方式二 利用FileUtils将ClassPathResource.getInputStream 得到的输入流复制到临时文件中
        Resource resource = new ClassPathResource("holiday.txt");
        InputStream inputStream = resource.getInputStream();
        File tempFile = File.createTempFile("temp", ".txt");
        FileUtils.copyInputStreamToFile(inputStream, tempFile);
        String s = FileUtils.readFileToString(tempFile, StandardCharsets.UTF_8);

        String[] split = s.split("\r\n");
        //方式一, 手动编写文件读取方法
        //List<String> list = readTxtFile("holiday.txt");
        List<String> list = Arrays.asList(split);
        //定义起始下标
        int startIndex = 0;
        //定义结束下标
        int endIndex = 0;
        startIndex = list.indexOf(HOLIDAY_FLAG_STRING);
        endIndex = list.indexOf(EXTRAWORKDAY_FLAG_STRING);
        List<String> holidayList = list.subList(startIndex + 1, endIndex);
        List<String> initExtraWorkDay = list.subList(endIndex + 1, list.size());
        //初始化节假日
        holiday.addAll(holidayList);
        //初始化额外加班日
        extraWorkDay.addAll(initExtraWorkDay);
    }

    /**
     * 判断是否是工作日
     */
    public static Boolean isWorkingDay(long time) throws IOException {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneOffset.of("+8"));
        String formatTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        /*String workWeekend=GetXmlSetting.getProperties("workWeekend");
        String holiday=GetXmlSetting.getProperties("holiday");*/
        String filename="D:\\autoAttendance\\application.properties";
        String workWeekend=GetXmlSetting.getPropertiesAsList(filename,"workWeekend");
        String holiday=GetXmlSetting.getPropertiesAsList(filename,"holiday");
        initHolidayAndExtraWorkDay();
        //是否加班日
        if (workWeekend.contains(formatTime)) {
            return true;
        }
        //是否节假日
        if (holiday.contains(formatTime)) {
            return false;
        }
        //如果是1-5表示周一到周五  是工作日
        DayOfWeek week = dateTime.getDayOfWeek();
        if (week == DayOfWeek.SATURDAY || week == DayOfWeek.SUNDAY) {
            return false;
        }
        return true;
    }
    /**
     * 判断是否是法定休息日
     * 法定休息日:非法定工作日
     *
     * @param time 当前时间(毫秒数)
     * @return true: 休息日, false: 工作日
     * @throws IOException
     */
    public static Boolean isOffDay(long time) throws IOException {
        return !isWorkingDay(time);
    }

    /**
     * 判断是否是法定节假日
     *
     * @param time 当前时间(毫秒数)
     * @return true: 节假日, false: 非节假日
     * @throws IOException
     */
    public static Boolean isHoliday(long time) throws IOException {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneOffset.of("+8"));
        String formatTime = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        initHolidayAndExtraWorkDay();
        //是否节假日
        if (holiday.contains(formatTime)) {
            return false;
        }
        return true;
    }

    /**
     * Java读取txt文件的内容
     *
     * @param表示resources目录下文件名称
     * @return 转为String
     */

    public static List<String> readTxtFile(String fileName) {
        List<String> listContent = new ArrayList<>();
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String encoding = "utf-8";
        try {
            Resource resource = new ClassPathResource(fileName);
            is = resource.getInputStream();
            isr = new InputStreamReader(is, encoding);
            br = new BufferedReader(isr);
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                listContent.add(lineTxt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listContent;
    }

    //获取ADB返回信息
    /*public void getADBMsg(){
        Process process;
        String[] cmd = { "cmd.exe","/c", "adb shell dumpsys window w |findstr \\/ |findstr name= >c:/a.txt" };
        try {
            Runtime.getRuntime().exec(cmd);
            //process = Runtime.getRuntime().exec("adb shell dumpsys window w |findstr \\/ |findstr name=");
            //process = Runtime.getRuntime().exec("adb devices");
            //process=Runtime.getRuntime().exec("adb shell keyevent KEYCODE_POWER");
            //Thread.sleep(3000);
            //process=Runtime.getRuntime().exec("adb shell swipe 500 500 500 800");
            //Thread.sleep(2000);
            //process.waitFor();
        } catch (IOException  e) {
            throw new RuntimeException(e);
        }
        *//*InputStreamReader isr=new InputStreamReader(process.getInputStream());
        Scanner sc=new Scanner(isr);
        while(sc.hasNext()){
            System.out.println(sc.next());
        }*//*
        System.out.println(GetXmlSetting.getTxt("c:/a.txt"));
    }*/

    //测试工具类方法
    /*public static void main(String[] args) throws IOException, ParseException {
        //当前时间
        long currentTimeStamp = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        Boolean workingDay = isWorkingDay(currentTimeStamp);

        if (workingDay) {
            System.out.println("工作日，加油，打工人");
        } else {
            System.out.println("休息日, 放假了, 兄弟萌");
        }

    }*/
}	