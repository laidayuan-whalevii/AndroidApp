package com.ximalaya.ting.android.xmtrace;


/**
 * 下载配置文件的线程
 * Created by luhang on 2018/1/16.
 *
 * @author luhang
 */

public class PollingThread extends Thread {
    ConfigFileManager.DownloadInfo info;

    PollingThread(String threadName, ConfigFileManager.DownloadInfo downloadInfo) {
        super(threadName);
        this.info = downloadInfo;
    }

    @Override
    public void run() {
        if (!info.isRn) {

        } else {

        }

    }
}
