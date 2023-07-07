package com.catail.lib_commons.utils;

import android.os.Environment;

import com.catail.lib_commons.CommonsApplication;


public class SHELL_Config {
    public static final int PROJECT_CONTACT = 1;// 项目通讯录
    public static final int PROJECT_MEMBER = 100;// 成员
    public static final int DEVICE_LIST = 101;// 设备列表
    public static final int WHOLE = 11;// 全部
    public static final String LANGUAGE_KEY = "sysLanguageName";// 语言选择
    public static String PDF_CATALOG_PATH_2 = "https://service.globalbes.sg";// pdf路径

    //正式库
    public static final String SERVER_URLTEST = "https://service.globalbes.sg/dbcms/dbapi";//接口地址
    public static String UPLOAD_IMG = "https://service.globalbes.sg/appupload";// 图片上传地址
    public static String IMG_SHOW_URL = "https://service.globalbes.sg";// 图片显示地址
    public static String webBaseUrl = "http://service.globalbes.sg/"; //web页面//正式库

    //最新的测试库
//    public static final String SERVER_URLTEST = "http://t.cmstech.aoepos.cn/dbcms/dbapi";
//    public static String UPLOAD_IMG = "http://t.cmstech.aoepos.cn/appupload";// 图片上传地址
//    public static String IMG_SHOW_URL = "http://t.cmstech.aoepos.cn";// 图片显示地址
//    public static String webBaseUrl = "http://t.cmstech.aoepos.cn/";// web页面  测试库

    //ip测试地址. (2023.5.9号使用过)
//    public static final String SERVER_URLTEST = "http://47.100.64.238/dbcms/dbapi";
//    public static String UPLOAD_IMG = "http://47.100.64.238/appupload";// 图片上传地址
//    public static String IMG_SHOW_URL = "http://47.100.64.238";// 图片显示地址
//    public static String webBaseUrl = "http://47.100.64.238/";// web页面  测试库

//    https://47.100.64.238/dbcms/dbapi?cmd=

//    public static String googleLocationKey = "AIzaSyArMXBxCYSxExFMUJSCP1tkmdN_k4zh6Jk";//打包用这个
//    public static String googleLocationKey = "AIzaSyBpi67mVP6W4R2-p3T46WdO0Pq3YdhE5Ww";//测试用这个


    //web页面
    public static String CMS_RPT_DATA_CH = webBaseUrl + "htmlapi/show_ch.html";//中文页面
    public static String CMS_RPT_DATA_EN = webBaseUrl + "htmlapi/show_en.html";//英文页面

    public static String CMS_Version_Is_Introduced = "https://service.globalbes.sg/version/cms.html";//版本介绍的界面
    //    public static String CMS_Privacy_Policy = "https://www.cmstech.sg/site/policy.html";//版本介绍的界面
    public static String CMS_Privacy_Policy = "https://service.globalbes.sg/cms.html";//版本介绍的界面

    //TODO  下次改成大写的Policy
//    public static String CMS_Privacy_Policy = "https://www.cmstech.sg/site/policy.html";//版本介绍的界面

    // 图片
    public static final String DEVICE = "device";// 设备

    public static final String LOGIN_BEAN = "login_bean";// 用户登录成功后基本信息
    public static final String USERINFO = "userInfo";// 用户信息
    public static final String PTW_INFO = "pyw_basic_info";// ptw提交基本参数
    public static final String PROJECT_PERMISSION = "projectAndPermission";//项目保存的参数
    public static final String UserInProjectRole = "user_in_project_role";//用户在项目中的权限
    public static final String PTW_SAVEINFO = "pyw_basic_save_info";// ptw复制基本参数
    public static final String TBM_SAVEINFO = "tbm_basic_save_info";// tbm复制基本参数
    public static final String TBM_INFO = "tbm_basic_info";// TBM基本参数信息
    public static final String BDLocation_INFO = "bdlocation_info";//百度定位基本参数信息
    public static final String GoogleLocation_INFO = "googlelocation_info";//百度定位基本参数信息
    public static final String JIGUANGPush_SHOW = "jiguangpush_show";//极光推送提示
    //    public static final String PHOTO_SRC = Environment.getExternalStorageDirectory().toString() + "/CMS/";// 图片存储路径
//    public static final String PHOTO_SRC = CmsApplication.getContext().getExternalCacheDir() + "/PIC/";// 图片存储路径
    public static final String PHOTO_SRC = Environment.getExternalStorageDirectory().getPath() + "/Pictures/";// 图片存储路径
    //    public static final String CAMERA_PATH =Environment.getExternalStorageDirectory().getPath()+"/DCIM/Camera/";
    public static final String CAMERA_PATH = Environment.getExternalStorageDirectory().getPath() + "/Pictures/";

    public static final String PDF_DIRECT_PATH = CommonsApplication.getContext().getExternalCacheDir().toString() + "/Flie/";


    public static final String CSDModelFilePath = Environment.getExternalStorageDirectory().toString() + "/CSD/Model/";//CSD 模型路径
    //2023年1月11日, 与arissa 和俞自由沟通后, 拍照,编辑,相册选择图片后的照片可以存在相册中, 签字,下载后的图片存在APP中, 用户不可见.
    //赋值bimax+ 程序的地址.
    public static final String SDStorageCacheInspectionPic = CommonsApplication.getContext().getExternalCacheDir() + "/Pic";

    public static int COPY_TAG = -1;// 0:PTW 1:TBM
    public static boolean PTW_COPY_TAG = false;// PTW复制标志
    public static boolean PTW_PASTE = false;// PTW粘贴
    public static boolean TBM_COPY_TAG = false;// TBM复制标志
    public static boolean TBM_PASTE = false;// TBM粘贴

    public static String UPLOAD_FACE = "";
    public static boolean upload_img = false;// 图片上传状态 false ：失败 true：成功
    public static String CODEPHONE = "https://sms.yunpian.com/v2/sms/single_send.json";// 短信密码找回验证
    // 应用图标
//    public static int[] drawable = {
//            R.drawable.project_list,
//            R.drawable.project_contact,
//            R.drawable.project_member,
//            R.drawable.project_device,
//            R.drawable.member_entrance,
//            R.drawable.device_entrance,
//            R.drawable.ptw_apply,
//            R.drawable.tbm_apply,
//            R.drawable.attendance_record,
//            R.drawable.work_time,
//            R.drawable.payroll,
//            R.drawable.safe_checked,
//            R.drawable.risk_assessment,
//            R.drawable.train,
//            R.drawable.message,
//            R.drawable.database,
//            R.drawable.metting,
//            R.drawable.accident_treatment,
//            R.drawable.security_progrom,
//            R.drawable.personnel_equipment_certificate,
//            R.drawable.database
////			R.drawable.train,
////			R.drawable.safe_checked
//    };
    // Class Name
//    public static Class[] className = {
//            MailListActivity.class,
//            MailListActivity.class,
//            AdmissionActivity.class,
//            AdmissionActivity.class,
//            AdmissionActivity.class,
//            AdmissionActivity.class,
//            PTWListActivity.class,
//            TBMListActivity.class,
//            TBMListActivity.class,
//            TBMListActivity.class,
//            TBMListActivity.class,
//            TBMListActivity.class,
//            TBMListActivity.class,
//            TrainListActivity.class,
//            TBMListActivity.class,
//            TBMListActivity.class,
//            TBMListActivity.class,
//            TBMListActivity.class,
//            SafeCheckListActivity.class,
//            PersonnelRquipmentCertificateReminder2Activity.class,
//            RAActivity1.class,
//            RoutineInspectionListActivity1.class,
//            Fileplatform.class
//    };
    public static final String[] img = {"bmp", "jpg", "png", "jpeg", "gif"};

    public static String YunPianApikey = "f579becad5fb0555e182e35fcbc8d98e"; // 云片短信的apikey

    public static final String SDStorage = Environment.getExternalStorageDirectory().toString();//SD卡的路径


    public static final String SDStorageCacheDir = CommonsApplication.getContext().getExternalCacheDir() + "";


}
