package com.jotime.common.utils.joTime;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.font.FontDesignMetrics;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.time.temporal.ChronoUnit.*;

/**
 * 利用ffmpeg进行音频视频操作，需先下载安装ffmpeg
 */
public class FfmpegUtils {
    /**
     * 下载的ffmpeg解压后的bin目录路径，可配置到环境变量通过配置文件读取
     */
    private static String ffplay = "D:\\wc\\ffmpeg\\bin\\ffplay.exe";
    private static String ffmpeg = "D:\\wc\\ffmpeg\\bin\\ffmpeg.exe";
    private static String ffprobe = "D:\\wc\\ffmpeg\\bin\\ffprobe.exe";
    /**
     * 提取的音频、合成的视频存放路径，不存在会自动创建
     */
    private static String saveMediaPath = "E:\\ffmpegMedia\\merge\\";

    /**
     * 无声视频+音频合成后存放路径，不存在会自动创建
     * 视频/音频剪切保存路径
     */
    private static String dubbingPath = "E:\\ffmpegMedia\\dubbing\\";

    /**
     * 保存音频、视频的临时文件夹，不存在会自动创建
     */
    private static String tempMediaPath = "E:\\ffmpegMedia\\temp\\";
    /**
     * 保存图片截图的文件夹，不存在会自动创建
     */
    private static String picturMediaPath = "E:\\ffmpegMedia\\pictur\\";


    static {
        //如果没有文件夹，则创建
        File saveMediaFile = new File(saveMediaPath);
        if (!saveMediaFile.exists() && !saveMediaFile.isDirectory()) {
            saveMediaFile.mkdirs();
        }
        File dubbingFile = new File(dubbingPath);
        if (!dubbingFile.exists() && !dubbingFile.isDirectory()) {
            dubbingFile.mkdirs();
        }
        File tempMediaFile = new File(tempMediaPath);
        if (!tempMediaFile.exists() && !tempMediaFile.isDirectory()) {
            tempMediaFile.mkdirs();
        }
        File picturMediaFile = new File(picturMediaPath);
        if (!picturMediaFile.exists() && !picturMediaFile.isDirectory()) {
            picturMediaFile.mkdirs();
        }
    }

    /**
     * 播放音频和视频
     *
     * @param resourcesPath 文件的路径
     */
    public static void playVideoAudio(String resourcesPath) {
        List<String> command = new ArrayList<>();
        command.add(ffplay);
        command.add("-window_title");
        String fileName = resourcesPath.substring(resourcesPath.lastIndexOf("\\") + 1);
        command.add(fileName);
        command.add(resourcesPath);
        //播放完后自动退出
        //command.add("-autoexit");
        commandStart(command);
    }

    /**
     * 播放音频和视频并指定循环次数
     *
     * @param resourcesPath 文件的路径
     * @param loop          循环播放次数
     */
    public static void playVideoAudio(String resourcesPath, int loop) {
        List<String> command = new ArrayList<>();
        command.add(ffplay);
        command.add("-window_title");
        String fileName = resourcesPath.substring(resourcesPath.lastIndexOf("\\") + 1);
        command.add(fileName);
        command.add(resourcesPath);
        command.add("-loop");
        command.add(String.valueOf(loop));
        //播放完后自动退出
        //command.add("-autoexit");
        commandStart(command);
    }

    /**
     * 播放音频和视频并指定宽、高、循环次数
     *
     * @param resourcesPath 文件的路径
     * @param weight        宽度
     * @param height        高度
     * @param loop          循环播放次数
     */
    public static void playVideoAudio(String resourcesPath, int weight, int height, int loop) {
        List<String> command = new ArrayList<>();
        command.add(ffplay);
        command.add("-window_title");
        String fileName = resourcesPath.substring(resourcesPath.lastIndexOf("\\") + 1);
        command.add(fileName);
        command.add(resourcesPath);
        command.add("-x");
        command.add(String.valueOf(weight));
        command.add("-y");
        command.add(String.valueOf(height));
        command.add("-loop");
        command.add(String.valueOf(loop));
        //播放完后自动退出
        //command.add("-autoexit");
        commandStart(command);
    }

    /**
     * 调用命令行执行
     *
     * @param command 命令行参数
     */
    public static boolean commandStart(List<String> command) {
        command.forEach(v -> System.out.print(v + " "));
        System.out.println();
        System.out.println();
        ProcessBuilder builder = new ProcessBuilder();
        //正常信息和错误信息合并输出
        builder.redirectErrorStream(true);
        builder.command(command);
        //开始执行命令
        Process process = null;
        try {
            process = builder.start();
            //如果你想获取到执行完后的信息，那么下面的代码也是需要的
            String line = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 调用命令行执行，并返回信息
     *
     * @param command 命令行参数
     */
    public static String getInfoStr(List<String> command) {
        command.forEach(v -> System.out.print(v + " "));
        System.out.println();
        System.out.println();
        ProcessBuilder builder = new ProcessBuilder();
        //正常信息和错误信息合并输出
        builder.redirectErrorStream(true);
        builder.command(command);
        //开始执行命令
        Process process = null;
        StringBuffer sb = new StringBuffer();
        try {
            process = builder.start();
            //如果你想获取到执行完后的信息，那么下面的代码也是需要的
            String line = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(sb);
    }


    /**
     * 从视频中提取音频为mp3
     *
     * @param videoResourcesPath 视频文件的路径
     */
    public static void getAudioFromVideo(String videoResourcesPath) {
        String fileName = videoResourcesPath.substring(videoResourcesPath.lastIndexOf("\\") + 1, videoResourcesPath.lastIndexOf("."));
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(videoResourcesPath);
        command.add(saveMediaPath + fileName + ".mp3");
        commandStart(command);
    }

    /**
     * 从视频中去除去音频并保存视频
     *
     * @param videoResourcesPath 视频文件的路径
     * @param savePath 去声后保存路径
     * @return true/false
     */
    public static boolean getVideoFromAudio(String videoResourcesPath,String savePath) {
        //如果没有文件夹，则创建
        File saveMediaFile = new File(savePath.substring(0,savePath.lastIndexOf("\\")));
        if (!saveMediaFile.exists() && !saveMediaFile.isDirectory()) {
            saveMediaFile.mkdirs();
        }

        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(videoResourcesPath);
        command.add("-vcodec");
        command.add("copy");
        command.add("-an");
        command.add(savePath);

        return commandStart(command);
    }

    /**
     * 从视频中去除去音频并保存视频
     *
     * @param videoResourcesPath 视频文件的路径
     */
    public static void getVideoFromAudio(String videoResourcesPath) {
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(videoResourcesPath);
        command.add("-vcodec");
        command.add("copy");
        command.add("-an");
        command.add(saveMediaPath + videoResourcesPath.substring(videoResourcesPath.lastIndexOf("\\") + 1));
        commandStart(command);
    }

    /**
     * 无声视频+音频合并为一个视频
     * 若音频比视频长，画面停留在最后一帧，继续播放声音。
     *
     * @param videoResourcesPath 视频文件的路径
     * @param audioResourcesPath 音频文件的路径
     */
    public static void mergeSilentVideoAudio(String videoResourcesPath, String audioResourcesPath) {
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(videoResourcesPath);
        command.add("-i");
        command.add(audioResourcesPath);
        command.add("-vcodec");
        command.add("copy");
        command.add("-acodec");
        command.add("copy");
        command.add(dubbingPath + videoResourcesPath.substring(videoResourcesPath.lastIndexOf("\\") + 1));
        commandStart(command);
    }

    /**
     * 无声视频+音频合并为一个视频
     * 若音频比视频长，画面停留在最后一帧，继续播放声音。
     * 若要以视频和音频两者时长短的为主，放开注解启用-shortest。
     *
     * 比较视频和音频结束时间
     * 用结束时间短的，截切合成后的视频
     *
     * @param videoResourcesPath 视频文件的路径
     * @param audioResourcesPath 音频文件的路径
     */
    public static String mergeSilentVideoAudioCut(String videoResourcesPath, String audioResourcesPath) {
        //获取视频结束时长
        List<String> list = videoAudioInfo(videoResourcesPath);
        String resolution = list.stream().filter(v -> v.contains("结束时间")).findFirst().get().substring(5);
        System.out.println("视频结束时间="+resolution);
        //获取音频结束时长
        List<String> list2 = videoAudioInfo(audioResourcesPath);
        String resolution2 = list2.stream().filter(v -> v.contains("结束时间")).findFirst().get().substring(5);
        System.out.println("音频结束时间="+resolution2);
        //2个时间比大小
        int num = resolution.compareTo(resolution2);
        //时长最短的为
        String resolution3;
        if(num > 0){ //resolution 大
            resolution3 = resolution2;
        }else if(num < 0){ //resolution2 大
            resolution3 = resolution;
        }else{//相等
            resolution3 = resolution;
        }

        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(videoResourcesPath);
        command.add("-i");
        command.add(audioResourcesPath);
        command.add("-vcodec");
        command.add("copy");
        command.add("-acodec");
        command.add("copy");
        //-shortest会取视频或音频两者短的一个为准
        command.add("-shortest");
        String dubbingUrl = dubbingPath + videoResourcesPath.substring(videoResourcesPath.lastIndexOf("\\") + 1);
        command.add(dubbingUrl);
        boolean ret = commandStart(command);
        if(ret){
            //用结束时间短的那个 截切视频
            String cutUrl = cutVideoAudio(dubbingUrl,"00:00:00",resolution3);
            if(cutUrl.length() > 0){
                //删除没剪切之前的本地资源（视频+配音）
                File file = new File(dubbingUrl);
                if(file.exists()){
                    file.delete();
                }
                return cutUrl;
            }else{
                //如果截切失败，返回没剪切之前的地址
                return dubbingUrl;
            }
        }else {
            System.out.println("视频+音频合成失败！！！");
            return "0";
        }
    }


    /**
     * 有声视频+音频合并为一个视频。
     * 若音频比视频长，画面停留在最后一帧，继续播放声音,
     * 若要以视频和音频两者时长短的为主，放开注解启用-shortest。
     *
     * @param videoResourcesPath 视频文件的路径
     * @param audioResourcesPath 音频文件的路径
     */
    public static void mergeVideoAudio(String videoResourcesPath, String audioResourcesPath) {
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(videoResourcesPath);
        command.add("-i");
        command.add(audioResourcesPath);
        command.add("-filter_complex");
        command.add("amix");
        command.add("-map");
        command.add("0:v");
        command.add("-map");
        command.add("0:a");
        command.add("-map");
        command.add("1:a");
        //-shortest会取视频或音频两者短的一个为准，多余部分则去除不合并
        //command.add("-shortest");
        command.add(saveMediaPath + videoResourcesPath.substring(videoResourcesPath.lastIndexOf("\\") + 1));
        commandStart(command);
    }


    /**
     * 多视频拼接合并
     *
     * @param videoResourcesPathList 视频文件路径的List
     */
    public static String mergeVideos(List<String> videoResourcesPathList) {
        //时间作为合并后的视频名
        String getdatatime = nowTime();
        //所有要合并的视频转换为ts格式存到videoList里
        List<String> videoList = new ArrayList<>();
        String strFileName = "";
        for (String video : videoResourcesPathList) {
            List<String> command = new ArrayList<>();
            String videoTempName = video.substring(video.lastIndexOf("\\") + 1, video.lastIndexOf(".")) + ".ts";
            File file = new File(tempMediaPath + videoTempName);
            if(file.exists()){
                file.delete();
            }
            command.add(ffmpeg);
            command.add("-i");
            command.add(video);
            command.add("-c");
            command.add("copy");
            command.add("-bsf:v");
            command.add("h264_mp4toannexb");
            command.add("-f");
            command.add("mpegts");
            command.add(tempMediaPath + videoTempName);
            commandStart(command);
            videoList.add(tempMediaPath + videoTempName);

            strFileName = strFileName + video.substring(video.lastIndexOf("\\") + 1, video.lastIndexOf("_")) + "-";
        }

        List<String> command1 = new ArrayList<>();
        command1.add(ffmpeg);
        command1.add("-i");
        StringBuffer buffer = new StringBuffer("\"concat:");
        for (int i = 0; i < videoList.size(); i++) {
            buffer.append(videoList.get(i));
            if (i != videoList.size() - 1) {
                buffer.append("|");
            } else {
                buffer.append("\"");
            }
        }
        command1.add(String.valueOf(buffer));
        command1.add("-c");
        command1.add("copy");

        String mergePath = saveMediaPath + strFileName + getdatatime + ".mp4";

        command1.add(mergePath);
        boolean ret = commandStart(command1);
        if(ret){
            return mergePath;
        }else{
            return null;
        }
    }

    /**
     * 多视频拼接合并。（mergeVideos1比上面的mergeVideos兼容性更好）
     *
     * @param videoResourcesPathList 视频文件路径的List
     */
    public static void mergeVideos1(List<String> videoResourcesPathList) {
        String videosPath= tempMediaPath+"videos.txt";
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(videosPath, false)))) {
            for (String video:videoResourcesPathList) {
                writer.println("file '"+video+"'");
            }
        }catch (IOException e) {
            System.err.println(e);
        }
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-f");
        command.add("concat");
        command.add("-safe");
        command.add("0");
        command.add("-i");
        command.add(videosPath);
        command.add("-c");
        command.add("copy");
        //时间作为合并后的视频名
        String getdatatime = nowTime();
        command.add(saveMediaPath + "视频合并" + getdatatime + ".mp4");
        commandStart(command);
    }

    /**
     * 多音频拼接合并为一个音频（在每个音频结尾追加另一个音频，即同一时间只播放一个音频）
     *
     * @param audioResourcesPathList 音频文件路径的List
     */
    public static void mergeAudios(List<String> audioResourcesPathList) {
        //时间作为合并后的音频名
        String getdatatime = nowTime();
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        StringBuffer buffer = new StringBuffer("\"concat:");
        for (int i = 0; i < audioResourcesPathList.size(); i++) {
            buffer.append(audioResourcesPathList.get(i));
            if (i != audioResourcesPathList.size() - 1) {
                buffer.append("|");
            } else {
                buffer.append("\"");
            }
        }
        command.add(String.valueOf(buffer));
        command.add("-acodec");
        command.add("copy");
        command.add(saveMediaPath + "音频合并" + getdatatime + ".mp3");
        commandStart(command);
    }

    /**
     * 两个音频混缩合并为一个音频（即同一时间播放两首音频）。
     *
     * @param audioResourcesPath1 音频1文件路径
     * @param audioResourcesPath1 音频2文件路径的
     */
    public static void mergeAudios(String audioResourcesPath1, String audioResourcesPath2) {
        //时间作为混缩后的音频名
        String getdatatime = nowTime();
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(audioResourcesPath1);
        command.add("-i");
        command.add(audioResourcesPath2);
        command.add("-filter_complex");
        command.add("amix=inputs=2:duration=longest");
        command.add(saveMediaPath + "音频混缩" + getdatatime + ".mp3");
        commandStart(command);
    }

    /**
     * 两个音频混缩合并为一个音频（即同一时间播放两首音频）。
     *
     * @param audioResourcesPath1 音频1文件路径
     * @param  number1           音频1的音量，如取 0.4 表示音量是原来的40%  ，取1.5表示音量是原来的150%
     * @param audioResourcesPath1 音频2文件路径的
     * @param  number2          音频2的音量，如取 0.4 表示音量是原来的40%  ，取1.5表示音量是原来的150%
     */
    public static void mergeAudios(String audioResourcesPath1,String number1, String audioResourcesPath2,String number2) {
        //时间作为混缩后的音频名
        String getdatatime = nowTime();
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(audioResourcesPath1);
        command.add("-i");
        command.add(audioResourcesPath2);
        command.add("-filter_complex");
        command.add("[0:a]volume=1"+number1+"[a1];[1:a]volume="+number2+"[a2];[a1][a2]amix=inputs=2:duration=longest");
        command.add(saveMediaPath + "音频混缩" + getdatatime + ".mp3");
        commandStart(command);
    }

    /**
     * 视频/音频格式转换
     *
     * @param videoResourcesPath 视频/音频文件的路径
     * @param format             要转换为的格式
     */
    public static void videoFormatConversion(String videoResourcesPath, String format) {
        String fileName = videoResourcesPath.substring(videoResourcesPath.lastIndexOf("\\") + 1, videoResourcesPath.lastIndexOf("."));
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(videoResourcesPath);
        command.add(saveMediaPath + fileName + "." + format);
        commandStart(command);
    }

    /**
     * 获取音频或视频信息
     *
     * @param videoAudioResourcesPath 音频或视频文件的路径
     */
    public static List<String> videoAudioInfo(String videoAudioResourcesPath) {
        List<String> command = new ArrayList<>();
        command.add(ffprobe);
        command.add("-i");
        command.add(videoAudioResourcesPath);
        //调用命令行获取视频信息
        String infoStr = getInfoStr(command);
        System.out.println(" ");

        String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
        String regexVideo = "Video: (.*?) tbr";
        String regexAudio = "Audio: (.*?), (.*?) Hz, (.*?) kb\\/s";
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexDuration);
        Matcher matcher = pattern.matcher(infoStr);
        if (matcher.find()) {
            list.add("视频/音频整体信息: ");
            list.add("视频/音频名称：" + videoAudioResourcesPath);
            list.add("开始时间：" + matcher.group(2));
            list.add("结束时间：" + matcher.group(1));
            list.add("比特率: " + matcher.group(3) + " kb/s");
            list.add("------------------------------------ ");
        }

        Pattern patternVideo = Pattern.compile(regexVideo);
        Matcher matcherVideo = patternVideo.matcher(infoStr);
        if (matcherVideo.find()) {
            String videoInfo = matcherVideo.group(1);
            String[] sp = videoInfo.split(",");
            list.add("视频流信息: ");
            list.add("视频编码格式: " + sp[0]);
            int ResolutionPosition = 2;
            if (sp[1].contains("(") && sp[2].contains(")")) {
                list.add("YUV: " + sp[1] + "," + sp[2]);
                ResolutionPosition = 3;
            } else if (sp[1].contains("(") && !sp[2].contains(")") && sp[3].contains(")")) {
                list.add("YUV: " + sp[1] + "," + sp[2] + "," + sp[3]);
                ResolutionPosition = 4;
            } else {
                list.add("YUV: " + sp[1]);
            }
            list.add("分辨率: " + sp[ResolutionPosition]);
            list.add("视频比特率: " + sp[ResolutionPosition + 1]);
            list.add("帧率: " + sp[ResolutionPosition + 2]);
            list.add("------------------------------------ ");
        }
        Pattern patternAudio = Pattern.compile(regexAudio);
        Matcher matcherAudio = patternAudio.matcher(infoStr);
        if (matcherAudio.find()) {
            list.add("音频流信息: ");
            list.add("音频编码格式: " + matcherAudio.group(1));
            list.add("采样率: " + matcherAudio.group(2) + " HZ");
            list.add("声道: " + matcherAudio.group(3).split(",")[0]);
            list.add("音频比特率: " + matcherAudio.group(3).split(",")[2] + " kb/s");
        }
        return list;
    }

    /**
     * 视频或音频剪切
     *
     * @param videoAudioResourcesPath 视频或音频文件的路径
     * @param startTime               开始时间 如：00:01:09
     * @param endTime                 结束时间 如：00:08:27
     *
     */
    public static String cutVideoAudio(String videoAudioResourcesPath, String startTime, String endTime) {
        //旧视频/音频名称
        //String fileName = videoAudioResourcesPath.substring(videoAudioResourcesPath.lastIndexOf("\\") + 1);
        //时间作为剪切后的视频名
        String getdatatime = nowTime();
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-ss");
        command.add(startTime);
        command.add("-t");
        command.add(calculationEndTime(startTime, endTime));
        command.add("-i");
        command.add(videoAudioResourcesPath);
        command.add("-c:v");
        command.add("libx264");
        command.add("-c:a");
        command.add("aac");
        command.add("-strict");
        command.add("experimental");
        command.add("-b:a");
        command.add("98k");
        String cutUrl = dubbingPath + "cut" + getdatatime + ".mp4";
        command.add(cutUrl);
        boolean ret = commandStart(command);
        if(ret){
            return cutUrl;
        }else{
            System.out.println("视频或音频剪切");
            return "0";
        }
    }


    /**
     * 视频裁剪大小尺寸（根据leftDistance和topDistance确定裁剪的起始点，再根据finallywidth和finallyHeight确定裁剪的宽和长）
     *
     * @param videoAudioResourcesPath 视频文件的路径
     * @param finallyWidth            裁剪后最终视频的宽度
     * @param finallyHeight           裁剪后最终视频的高度
     * @param leftDistance            开始裁剪的视频左边到y轴的距离（视频左下角为原点）
     * @param topDistance             开始裁剪的视频上边到x轴的距离（视频左下角为原点）
     *
     */
    public static void cropVideoSize(String videoAudioResourcesPath, String finallyWidth, String finallyHeight, String leftDistance, String topDistance) {
        String fileName = videoAudioResourcesPath.substring(videoAudioResourcesPath.lastIndexOf("\\") + 1);
        //时间作为剪切后的视频名
        String getdatatime = nowTime();
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(videoAudioResourcesPath);
        command.add("-vf");
        //获取视频信息得到原始视频长、宽
        List<String> list = FfmpegUtils.videoAudioInfo(videoAudioResourcesPath);
        String resolution = list.stream().filter(v -> v.contains("分辨率")).findFirst().get();
        String sp[] = resolution.split("x");
        String originalWidth = sp[0].substring(sp[0].indexOf(":") + 1).trim();
        String originalHeight = sp[1].substring(0, 4).trim();
        Integer cropStartWidth = Integer.parseInt(originalWidth) - Integer.parseInt(leftDistance);
        Integer cropStartHeight = Integer.parseInt(originalHeight) - Integer.parseInt(topDistance);
        command.add("crop=" + finallyWidth + ":" + finallyHeight + ":" + cropStartWidth + ":" + cropStartHeight);
        command.add(saveMediaPath + "裁剪视频" + getdatatime + fileName);
        commandStart(command);
    }


    /**
     * 计算两个时间的时间差
     *
     * @param startime 开始时间，如：00:01:09
     * @param endtime  结束时间，如：00:08:27
     * @return 返回xx:xx:xx形式，如：00:07:18
     */
    public static String calculationEndTime(String startime, String endtime) {
        LocalTime timeStart = LocalTime.parse(startime);
        LocalTime timeEnd = LocalTime.parse(endtime);
        long hour = HOURS.between(timeStart, timeEnd);
        long minutes = MINUTES.between(timeStart, timeEnd);
        long seconds = SECONDS.between(timeStart, timeEnd);
        minutes = minutes > 59 ? minutes % 60 : minutes;
        String hourStr = hour < 10 ? "0" + hour : String.valueOf(hour);
        String minutesStr = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        long getSeconds = seconds - (hour * 60 + minutes) * 60;
        String secondsStr = getSeconds < 10 ? "0" + getSeconds : String.valueOf(getSeconds);
        return hourStr + ":" + minutesStr + ":" + secondsStr;
    }


    /**
     * 视频截图
     *
     * @param videoResourcesPath 视频文件的路径
     * @param screenshotTime     截图的时间，如：00:01:06
     */
    public static void videoScreenshot(String videoResourcesPath, String screenshotTime) {
        //时间作为截图后的视频名
        String getdatatime = nowTime();
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-ss");
        command.add(screenshotTime);
        command.add("-i");
        command.add(videoResourcesPath);
        command.add("-f");
        command.add("image2");
        String fileName = videoResourcesPath.substring(videoResourcesPath.lastIndexOf("\\") + 1, videoResourcesPath.lastIndexOf("."));
        command.add(picturMediaPath + fileName + getdatatime + ".jpg");
        commandStart(command);
    }


    /**
     * 整个视频截图
     *
     * @param videoResourcesPath 视频文件的路径
     * @param fps                截图的速度。1则表示每秒截一张；0.1则表示每十秒一张；10则表示每秒截十张图片
     */
    public static void videoAllScreenshot(String videoResourcesPath, String fps) {
        /*//时间作为截图后的视频名
        String getdatatime = nowTime();*/
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(videoResourcesPath);
        command.add("-vf");
        command.add("fps=" + fps);
        String fileName = videoResourcesPath.substring(videoResourcesPath.lastIndexOf("\\") + 1, videoResourcesPath.lastIndexOf("."));
        command.add(picturMediaPath + fileName + "%d" + ".jpg");
        commandStart(command);
    }


    /**
     * 多图片+音频合并为视频
     *
     * @param pictureResourcesPath 图片文件路径(数字编号和后缀不要)。如：D:\ffmpegMedia\pictur\101-你也不必耿耿于怀1.jpg 和D:\ffmpegMedia\pictur\101-你也不必耿耿于怀2.jpg。只需传D:\ffmpegMedia\pictur\101-你也不必耿耿于怀
     * @param audioResourcesPath   音频文件的路径
     *  @param fps   帧率,每张图片的播放时间（数值越小则每张图停留的越长）。05.则两秒播放一张，1则一秒播放一张，10则一秒播放十张
     */
    public static void pictureAudioMerge(String pictureResourcesPath, String audioResourcesPath,String fps) {
        //时间作为截图后的视频名
        String getdatatime = nowTime();
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-threads");
        command.add("2");
        command.add("-y");
        command.add("-r");
        //帧率
        command.add(fps);
        command.add("-i");
        command.add(pictureResourcesPath+"%d.jpg");
        command.add("-i");
        command.add(audioResourcesPath);
        command.add("-absf");
        command.add("aac_adtstoasc");
        //-shortest会取视频或音频两者短的一个为准，多余部分则去除不合并
        command.add("-shortest");
        String fileName = pictureResourcesPath.substring(pictureResourcesPath.lastIndexOf("\\") + 1);
        command.add(saveMediaPath +"视频合成"+ fileName + getdatatime + ".mp4");
        commandStart(command);
    }


    /**
     * 绘制音频波形图保存.jpg后缀可改为png
     *
     * @param audioResourcesPath 音频文件的路径
     */
    public static void audioWaveform(String audioResourcesPath) {
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(audioResourcesPath);
        command.add("-filter_complex");
        command.add("\"showwavespic=s=1280*240\"");
        command.add("-frames:v");
        command.add("1");
        String fileName = audioResourcesPath.substring(audioResourcesPath.lastIndexOf("\\") + 1, audioResourcesPath.lastIndexOf("."));
        //jpg可换为png
        command.add(saveMediaPath + fileName + fileName + ".jpg");
        commandStart(command);
    }


    /**
     * 两个音频混缩合并为一个音频。
     *
     * @param audioResourcesPath1 音频1文件路径
     * @param audioResourcesPath1 音频2文件路径的
     */
    public static void mergeAudiosDouble(String audioResourcesPath1, String audioResourcesPath2) {
        //时间作为混缩后的音频名
        String getdatatime = nowTime();
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(audioResourcesPath1);
        command.add("-i");
        command.add(audioResourcesPath2);
        command.add("-filter_complex");
        command.add("amix=inputs=2:duration=longest");
        command.add(saveMediaPath + "音频混缩" + getdatatime + ".mp3");
        commandStart(command);
    }


    /**
     * 两个音频混缩合并为一个音频的不同声道（即一只耳机播放一个音频）。
     *
     * @param audioResourcesPath1 音频1文件路径
     * @param audioResourcesPath1 音频2文件路径的
     */
    public static void mergeAudiosSoundtrack(String audioResourcesPath1, String audioResourcesPath2) {
        //时间作为混缩后的音频名
        String getdatatime = nowTime();
        List<String> command = new ArrayList<>();
        command.add(ffmpeg);
        command.add("-i");
        command.add(audioResourcesPath1);
        command.add("-i");
        command.add(audioResourcesPath2);
        command.add("-filter_complex");
        command.add("\"amerge=inputs=2,pan=stereo|c0<c0+c1|c1<c2+c3\"");
        command.add(saveMediaPath + "音频混缩" + getdatatime + ".mp3");
        commandStart(command);
    }
    /**
     * 图片添加文本
     *
     * @param bufImg
     * @param subTitleContent
     * @return
     */

    public static BufferedImage addSubtitle(BufferedImage bufImg, String subTitleContent) {
        // 添加字幕时的时间
        Font font = new Font("微软雅黑", Font.BOLD, 32);
        //String timeContent = sdf.format(new Date());
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        Graphics2D graphics = bufImg.createGraphics();
        //graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        //设置图片背景
        //graphics.drawImage(bufImg, 0, 0, bufImg.getWidth(), bufImg.getHeight(), null);
        //设置左上方时间显示
        //graphics.setColor(Color.orange);
        //graphics.setFont(font);
        //graphics.drawString(timeContent, 0, metrics.getAscent());
        // 计算文字长度，计算居中的x点坐标
        int textWidth = metrics.stringWidth(subTitleContent);
        int widthX = (bufImg.getWidth() - textWidth) / 2;

        //画色块 字幕背景
        graphics.setColor(Color.BLUE);//这里可用设置字幕的背景色
        graphics.fillRoundRect(widthX-5,bufImg.getHeight() - 135,textWidth+10,45,5,5);

        graphics.setColor(Color.red);
        graphics.setFont(font);
        graphics.drawString(subTitleContent, widthX, bufImg.getHeight() - 100);
        //释放资源
        graphics.dispose();
        return bufImg;
    }

    /**
     * 获取当前时间，用于作为文件名
     */
    public static String nowTime() {
        DateTimeFormatter f3 = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS");
        LocalDate nowdata = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        return nowdata.atTime(nowTime).format(f3);
    }
}

