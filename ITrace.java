package com.ximalaya.ting.android.xmtrace;

import androidx.annotation.IntDef;
import androidx.annotation.Nullable;

import java.util.Map;

/**
 * Created by luhang on 2019-05-20.
 *
 * @author LuHang
 * Email: luhang@ximalaya.com
 * Tel:15918812121
 */
public interface ITrace {  
    private int mAge;  
    String SERVICE_ID_PAGE_VIEW = "pageview";
    String SERVICE_ID_PAGE_EXIT = "pageExit";
    String SERVICE_ID_CLICK = "click";
    String SERVICE_ID_CLICK_BUTTON = "clickButton";
    String SERVICE_ID_SLIP_PAGE = "slipPage";
    String SERVICE_ID_APP_START = "startUp";  
    
    String TRACE_KEY_CURRENT_PAGE = "currPage"; // 当前页面
    String TRACE_KEY_PREV_PAGE = "prevPage"; // 前一页面
    String TRACE_KEY_CURRENT_MODULE = "currModule"; // 点击事件的 module
    String TRACE_KEY_PREV_MODULE = "prevModule"; // 页面事件的module
    String TRACE_KEY_PAGE_SHOW_NUM = "pageShowNum"; // 页面展示次数，在代码埋点中，恒定为1
    String TRACE_KEY_PAGE_DURATION_TIME = "durationTime"; // 页面停留时间
    String TRACE_KEY_USER_ID = "uid"; // 用户id

    int START_TYPE_COLD_START = 0x6; // 冷启动
    int START_TYPE_HOT_START = 0x7;  // 热启动

    @IntDef({START_TYPE_COLD_START, START_TYPE_HOT_START})
    @interface StartType {
    }

    ITrace appStart  ();

    ITrace appStart(@StartType int startType);

    ITrace pageView(int metaId, String currPage); // 页面展示事件

    ITrace pageView(int metaId, String currPage, Map<String, String> props);

    @Deprecated
    ITrace pageExit(int metaId, String currPage); // 页面离开事件

    @Deprecated
    ITrace pageExit(int metaId, String currPage, Map<String, String> props);

    ITrace pageExit2(int metaId); // 页面离开事件

    ITrace pageExit2(int metaId, Map<String, String> props);

    ITrace click(int metaId); // 点击事件

    ITrace click(int metaId, @Nullable String srcModule); // 点击事件 有

    ITrace click(int metaId, @Nullable String srcModule, @Nullable Map<String, String> props);

    ITrace clickButton(int metaId); // 点击不发生跳转页面的点击事件

    ITrace clickButton(int metaId, Map<String, String> props);

    ITrace slipPage(int metaId); // 滑动曝光埋点

    ITrace slipPage(int metaId, Map<String, String> props);

    ITrace srcModule(String value); // 设置来源模块

    ITrace setServiceId(String serviceId); // 自定义的ServiceId

    ITrace setMetaId(int metaId); //  埋点id

    ITrace setUserId(long uId); // 用户id

    ITrace setUserId(String key, long userId);

    ITrace addGRes(String name, Map<String, String> value); // 添加全局资源位

    ITrace put(String key, String value); // 设置单个埋点属性

    ITrace put(Map<String, String> props); // 批量设置埋点属性

    ITrace immediatelyUpload();
}
