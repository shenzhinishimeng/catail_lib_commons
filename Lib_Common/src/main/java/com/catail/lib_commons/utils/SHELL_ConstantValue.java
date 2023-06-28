package com.catail.lib_commons.utils;

public class SHELL_ConstantValue {
    //这里面的值是我新定义的.因为之前的值他都放到网络请求的接口里面了.
    // 在之后的开发上面,我重新定义的存放

    //00系统模块
    public static String QueryMessageToRemind = "?cmd=CMSC0011";//查询消息提醒接口
    public static String ConfirmChangePassword = "?cmd=CMSC0006";//确认修改密码的接口
    public static String CheckPhoneIsExist = "?cmd=CMSC0007";//发送验证码验证手机的接口
    public static String getEmailUrl = "?cmd=CMSC0008";//获取人员设备证书过期发送邮件的url

    //01项目模块
    public static String QueryProjectList = "?cmd=CMSC0101";//查询项目列表
    public static String querySubConList = "?cmd=CMSC0102";//查询分包公司列表
    public static String QueryAlreadyAdmisstionPersonList = "?cmd=CMSC0104V2";//查询已入场的人员列表
    public static String querySubList = "?cmd=CMSC0106";//查询分包列表
    public static String queryCertRemindList = "?cmd=CMSC0110";//查询消息提醒的列表
    public static String queryCompanyList = "?cmd=CMSC0112";//查询公司列表
    public static String SetLocationPermission = "?cmd=CMSC0111";//获取设置位置的权限
    public static String QueryProjectRole = "?cmd=CMSC0113";//   登陆者在项目中的身份角色
    public  static String QueryUserInProjectList= SHELL_Config.SERVER_URLTEST+ "?cmd=CMSC0115";//查询登录用户可进行Health Declaration的项目列表


    public static String queryBIMAXModel = "?cmd=CMSC0121";//查询bimax 模型

    //02人员模块
    public static String PersonnelDetails = "?cmd=CMSC0203";//获取人员的相信信息
    public static String QueryRoleInProject = "?cmd=CMSC0212";//0212 查询用户在某一宗项目中的角色信息,
    public static String CertificateExpirationReminder = "?cmd=CMSC0216";//人员证书到期提醒的接口
    public static String QueryJurisdictionInProject = "?cmd=CMSC0215";//人员/设备入场查询审批权限
    public static String PersonForcedOut = "?cmd=CMSC0219";//人员入场出场审批-->强制退场

    public static String QueryPersonalInformation = "?cmd=CMSC0221";//查询登陆人基本信息及项目角色信息
    public static String SubmitAgree = "?cmd=CMSC0222";//设置项目下登陆人的LOA签名
    public static String QueryAdmissionMember = "?cmd=CMSC0223";//人员入场出场审批被拒绝列表
    //03设备模块
    public static String EquipmentCertificateExpirationReminder = "?cmd=CMSC0313";//设备证书到期提醒的接口
    public static String QueryProjectCertificate = "?cmd=CMSC0315";//项目下人员设备过期证书记录
    public static String QueryContractorCertificate = "?cmd=CMSC0316";//公司下人员设备过期证书记录
    public static String QueryAlreadyAdmisstionDeviceList = "?cmd=CMSC0317";//QueryDeviceList
    public static String QueryAlreadyAdmisstionDeviceList1 = "?cmd=CMSC0318";//QueryDeviceList
    public static String DeviceForceOut = "?cmd=CMSC0319";//设备入场出场审批-->强制退场
    public static String QueryAdmissionRejectedDevice="?cmd=CMSC0320";//设备入场出场审批被拒绝列表
    //04PTW模块
    public static String SubmitPtwList = "?cmd=CMSC0401";//提交PTW 添加申请
    public static String QueryPTWList = "?cmd=CMSC0402";//查询PTW列表
    public static String PTWDeviceList = "?cmd=CMSC0407";//PTW 查询设备列表
    public static String queryPTWType = "?cmd=CMSC0406";//查询PTW类型.
    public static String queryApprove = "?cmd=CMSC0411";//查询审批或者批准人
    public static String queryPTWLocation = "?cmd=CMSC0412";//查询工作区域
    public static String QueryApprove1 = "?cmd=CMSC0416";//查询审批或者批准人
    public static String QueryPTWDeclaration = "?cmd=CMSC0417";//查询声明
    public static String QueryPTWTypeRecordList = "?cmd=CMSC0418";// 查询相同位置相同时间是否有不同类型的PTW
    public static String QueryPTWListNextStepPerson = "?cmd=CMSC0419";// PTW 查询下一步的操作人.

    public static String QueryD_TypePTWDeclaration="?cmd=CMSC0430";//查询用户是否有ptw发起权限，并返回ptw声明
    public static String PTWSubmitData="?cmd=CMSC0431";//PTW D类型上传参数
    public static String QueryPTWD_TypeList="?cmd=CMSC0432";//PTW D类型列表
    public static String QueryD_TypeActionList="?cmd=CMSC0435";//PTW 查询D类型节点状态


    //05TBM模块
//    public static String TBMList = "?cmd=CMSC0502";//TBM列表
    public static String TBMList = "?cmd=CMSC0502V2";//TBM列表
    public static String QueryTBMInfoList = SHELL_Config.SERVER_URLTEST+"?cmd=CMSC0505";//查询有该人员参加的TBM列表
    public static String SubmitTemperature =  SHELL_Config.SERVER_URLTEST+"?cmd=CMSC0506";//设置健康状态（start，end）
    public static String QueryHealthStatusAccordingToLanguage = SHELL_Config.SERVER_URLTEST+"?cmd=CMSC0507";//按语言查询健康状态选项
    public static String QueryLanguageLists = SHELL_Config.SERVER_URLTEST+"?cmd=CMSC0508";//查询有该人员参加的TBM列表



    //06安全检查模块
    public static String SafeCheckDetails = "?cmd=CMSC0603";// 安全检查 -->查看检查单详情
    public static String SafeCheckApplyQueryDevice = "?cmd=CMSC0609";//安全检查	 --添加设备,查询设备
    public static String SafeCheckApplyQueryTypeOfInspection = "?cmd=CMSC0610";//安全检查申请界面,获取type of Inspection
    public static String SafeCheckApplyQueryTypeOfFindings = "?cmd=CMSC0611";//安全检查申请界面,获取type of findings


    public static String SafecheckButtonOperate_Inspected = "?cmd=CMSC0613";//B类型检查组人员复核inspect
    public static String SafecheckButtonOperate_Reply = "?cmd=CMSC0614";//B类型总包分包之间reply
    public static String SafecheckButtonOperate_Close = "?cmd=CMSC0615";//B类型检查组人员关闭close

    //07培训会议模块
    public static String queryMeetingPerson = "?cmd=CMSC0706";//培训/会议,查询开会人员
    public static String queryTrainType = "?cmd=CMSC0707";//培训/会议,查询类型.
    public static String TrainingSubmit = "?cmd=CMSC0710";//培训界面提交的接口
    public static String TrainList = "?cmd=CMSC0712V2";//查询列表培训会议列表

    //08RA/SWP模块
    public static String RAList = "?cmd=CMSC0802";//获取RA列表		--非审批着只能查看审批完成和审批驳回的RA列表
    public static String RAQueryWorkType = "?cmd=CMSC0805";//风险评估/RA -->获取工种列表

    //09例行检查
    public static String RoutineInspectionSubmit = "?cmd=CMSC0901";//例行检查            --提交例行检查申请表
    public static String RoutineInspectionDeviceList = "?cmd=CMSC0902";// 例行检查      --查询检查单列表
    public static String RoutuneInspectionDeviceListOrNonDeviceListType = "?cmd=CMSC0905";//例行检查            --查询设备列表/非设备检查单类型
    public static String RoutineInspectionRoutineCheckType = "?cmd=CMSC0906";//例行检查              --获取例行检查类型
    public static String RoutineInspectionSafeConditionList = "?cmd=CMSC0907";//例行检查--查看某一例行检查类型的安全条件
    public static String RoutineInspectionType = "?cmd=CMSC0909";//例行检查               --查询检查单种类
    public static String QueryDiffrentChecklistType = "?cmd=CMSC0910";               //获取不同场景下可用的检查单种类
    public static String ChecklistSubmit = "?cmd=CMSC0911";//提交checklist
    public static String ChecklistSave = "?cmd=CMSC0912";//保存为草稿 checklist
    public static String ChecklistListDelRecord = "?cmd=CMSC0913";//checklist  列表删除记录
    public static String ChecklistListList = "?cmd=CMSC0914";//checklist列表

    //10 意外模块
    public static String AccidentApply = "?cmd=CMSC1001";//意外申请的提交的或者保存
    public static String AccidentApplyList = "?cmd=CMSC1002";//意外申请的列表
    public static String AccidentApplyInformation = "?cmd=CMSC1003";//查询驳回和保存本地的信息,可进行二次操作的信息
    public static String AccidentApproval = "?cmd=CMSC1004";// 意外详情界面  审批(通过或者拒绝)
    public static String AccidentApplyQueryAccidentPersonnel = "?cmd=CMSC1008";//意外申请界面查询意外人员
    public static String AccidentApplyQueryAccicentEquipmment = "?cmd=CMSC1009";//意外申请界面查询意外设备
    public static String AccidentType = "?cmd=CMSC1011";//查询意外类型

    public static String AccidentHandlingCreateForm = "?cmd=CMSC1021";//意外/事件申请（编辑）B类型
    public static String AccidentHandlingSubmitForm = "?cmd=CMSC1022";//意外/事件提交 B类型
    public static String AccidentHandlingDelListItem = "?cmd=CMSC1023";//意外/事件删除 B类型
    public static String AccidentHandlingList = "?cmd=CMSC1024";// 查询意外事件列表 B类型
    public static String AccidentHandlingDetails = "?cmd=CMSC1025";//查询意外事故详情 B类型
    public static String AccidentHandlingApproveOrReject = "?cmd=CMSC1026";//审批批准或者拒绝

    //11QAQC模块,新流程
    public static String QAQCApplySubmit = "?cmd=CMSC1101";//提交基本信息
    public static String QAQCFormList = "?cmd=CMSC1102";//查询form单子列表
    public static String QAQCFormDetails = "?cmd=CMSC1103";//查询检查单详情
    public static String QAQCFormClosed = "?cmd=CMSC1104";//RE 关闭检查单
    public static String QADelQAchecklistItem = "?cmd=CMSC1105";//QA 列表删除item
    public static String QAQCApplyEdit = "?cmd=CMSC1106";//没有检查单的QA流程单编辑：申请人可编辑


    public static String QAQCSubmitChecklistForm = "?cmd=CMSC1111";//提交新的检查单
    public static String QAQCChecklistDetailsData = "?cmd=CMSC1112";//检查单详情
    public static String QAQCChecklistDetailsSubmitData = "?cmd=CMSC1113";//检查单提交 申请人 submit
    public static String QAQCChecklistDetailsSubmitinspectData = "?cmd=CMSC1114";//检查单审批 RTO inspected
    public static String QAQCChecklistDetailsSubmitApproveData = "?cmd=CMSC1115";//检查单审批 RE approve
    public static String QAQCchecklistDetailsREInspectData = "?cmd=CMSC1116";//RE-inspect
    public static String QAQCchecklistDetailsTemp = "?cmd=CMSC1117";//查询流程记录的form_data

    public static String QAQCConditionList = "?cmd=CMSC1121";//QA/QC B类型的条件
    public static String QAQCTypeList = "?cmd=CMSC1122";//QA/QC获取检查单类型及名称 二级

    public static String QAQCChecklistDetailsInspectData = "?cmd=CMSC1131";//检查单审批 inspect
    public static String QAQCChecklistDetailsReSubmitData = "?cmd=CMSC1132";//检查单审批退回 re-submit
    public static String QAQCChecklistDetailsApproveData = "?cmd=CMSC1133";//检查单批准 approve
    public static String QAQCChecklistDetailsReInspectData = "?cmd=CMSC1134";//检查单批准退回 re-inspect
    public static String QAQCDetailsDelChecklistItem = "?cmd=CMSC1135";//删除未提交的checklist

    //12QA模块
    public static String QA_A_Apply = "?cmd=CMSC1201";//QA提交数据接口
    public static String QA_A_List = "?cmd=CMSC1202";//QA列表接口
    public static String QA_A_DetailsDatas = "?cmd=CMSC1203";//QA查询详情接口
    public static String QA_A_reply = "?cmd=CMSC1204";//QA回复接口
    public static String QA_A_TypeList = "?cmd=CMSC1205";//QA类型列表接口
    public static String QA_A_ConditionList = "?cmd=CMSC1206";//QA安全条件
    public static String QA_A_WorkLocation = "?cmd=CMSC1207";//QA工作区域
    public static String QA_A_PersonInCharge = "?cmd=CMSC1208";//QA负责人
    public static String QA_A_ChecklistApply = "?cmd=CMSC1209";//QA-Checklist提交数据到临时列表
    public static String QA_A_ChecklistList = "?cmd=CMSC1210";//QA-Checklist查询临时检查单列表
    public static String QA_A_checklistDetails = "?cmd=CMSC1211";//QA-Checklist临时检查单详情
    public static String QA_A_checklistSaveData = "?cmd=CMSC1212";//QA-Checklist保存数据到临时列表
    public static String QA_A_checklistDetails1 = "?cmd=CMSC1213";//QA-Checklist查询正式的数据
    public static String QA_A_delQAchecklistList = "?cmd=CMSC1214";//QA-Checklist删除临时的数据
    public static String QA_A_QuerySafetyLeavel = "?cmd=CMSC1215";//QA查询安全等级

    //↑↑↑↑↑↑↑↑↑↑↑↑上面的接口可能会不用了,替换成下面的↑↑↑↑↑↑↑↑↑↑
    public static String QA_B_ConditionList = "?cmd=CMSC1220";//QA/QC B类型的条件
    public static String QATypeList = "?cmd=CMSC1221";//QA/QC获取检查单类型及名称 二级
    public static String QAChecklistApplyTempSubmit = "?cmd=CMSC1222";//QA/QC新建检查单（存至临时检查单）
    public static String QAChecklistList = "?cmd=CMSC1223";//QA/QC 查询验收单列表
    public static String QAChecklistDetails = "?cmd=CMSC1224";//QA/QC 检查单详情
    public static String QAChecklistTempSave = "?cmd=CMSC1225";//QA/QC 编辑临时检查单
    public static String QAChecklistDeleteItem = "?cmd=CMSC1226";//QA/QC 删除QA-Checklist临时列表
    public static String QAQCApply = "?cmd=CMSC1230";//QA/QC 申请提交数据接口
    public static String QAQCChecklistList = "?cmd=CMSC1231";//获取检查单流程申请列表
    public static String QAQCChecklistDeatails = "?cmd=CMSC1232";//获取检查单流程申请详情
    public static String QAQCDetailsData = "?cmd=CMSC1233";//流程中检查单详情
    public static String QAQCDetailsApproved = "?cmd=CMSC1234";//流程中检查单流程审批
    public static String QAQCDetailsEditSubmitData = "?cmd=CMSC1235";//流程中详情页面检查单流程修改提交

    //91 模块   新作的意外和事故的模块
    //A_H 是Accident Handling 的缩写
    public static String A_H_Group = "?cmd=CMSC9103";//查询表单GROUP列表
    public static String A_H_ChildItem = "?cmd=CMSC9104";//查询分组下ITEM


    //90 统计模块
    public static String StatisticList = "?cmd=CMSC9002";//统计列表
    public static String StatisticFunctionDetails = "?cmd=CMSC9003";//统计功能的各模块功能详情

    //VR功能
    public static String getVRURL = "?cmd=CMSC0109";//获取VR URL

    //Test
    public static String test = "?cmd=CMSC9900";//test

    /*******************************
     * 下面是各个界面的常量
     ****************************************/
    public static int takePhotoCode = 0x1081;//拍照的requestCode和resultCode
    public static int ElectronicSignatureNecessaryCode = 0x0001;//电子签名必须的requestCode和resultCode
    public static int PhotoSelctionCode = 0x1003;  //拍照列表的的requestCode和resultCode
    public static int PicEditor = 0x1004;//编辑图片的requestCode和resultCode
    public static int SelectedFiles = 0x1005;//培训/会议选择文档的requestCode和resultCode
    public static int SafeCheckQA_Person = 0X1006;//违规人员	 --安全检查页面二维码扫描的requestCode 和resultCode
    public static int SafeCheckQA_Equipment = 0X1007;//违规设备       --安全检查页面二维码扫描的requestCode 和resultCode
    public static int ImageEditorCode = 0x1010;//图片编辑的的requestCode和resultCode
    public static int ImagePdfEditorCode = 0x1011;//图片编辑的的requestCode和resultCode
    public static int AllFilter = 0x1020;//各个模块筛选的requestCode和resultCode
    public static int FilterCalendarDate = 0x1021;//筛选模块中选择日历时间的requestCode和resultCode
    public static int selectPhotoFromAlbum = 0x1100;//从相册选择的照片的requestCode
    public static int QAAddQAChecklist = 0x1101;//添加QA-Checklist检查单
    public static int QAQCAddChecklist = 0x1102;//QA/QC添加QA-Checklist的requestCode和resultCode
    public static int choosePDFFromFile = 0x1030;//选择文件从本地
    public static int choosePDFPhotoImg = 0x1031;//选择文件从本地
    public static int chooseNetPDFPhotoImg = 0x1032;//选择网络选择pdf文档转换成本地图片,选择后添加
    public static int TrainingAddChecklist = 0x1070;//培训添加checklist的requestCode和resultCode
    public static int BIMAXModeSelected = 0x1080;//BIMAX模型选择的requestCode和resultCode
    public static int BIMAXModelUpdate = 0x1081;//BIMAX模型修改的requestCode和resultCode
    public static int QAQCAddChecklistForm = 0x1090;//QAQC 申请界面编辑checklist 表单的 requestCode和resultCode
    public static int QAQCSubmitChecklistFormCode = 0x1110;//QAQC提交checklist表单的requestCode和resultCode
    public static int QAQCChecklistApprovedCode = 0x1120;//QAQC checklist审批批准的requestCode 和resultCode
    public static int AppointmentSignCode = 0x0222;//appointment 界面签名的requestCode和resultCode
    public static int PTWSelectedApproveCode = 0x0416;//PTW 选择审批者requestCode和resultCode
    public static int ChecklistDeviceCode = 0x9011; //checklist 申请界面扫码设备 创建checklist Code

    public static int GPSLocationServiceCode = 0x1200;//获取GPS 定位权限的请求码和结果码
    public static int TBMFilterListData = 0x1201;//TBM 筛选后,从详情界面点击确定
    public static int PTWFilterListData = 0x1202;//TBM 筛选后,从详情界面点击确定
    public static int PTWApplyChecklist = 0x4001;//PTW添加checklist
    public static int TBMAccidentInfoCode = 0x4002;//TBM 添加accident info
    public static int AccidentHandlingTypeCode = 0x9001;//意外和事故request_Code
    public static int AccidentHandlingMSTypeResultCode = 0x9002;//意外和事故MS 类型的 resultCode
    public static int AccidentHandlingTTypeResultCode = 0x9003;//意外和事故T 类型的 resultCode
    public static int AccidentHandlingATypeResultCode = 0x9004;//意外和事故A 类型的 resultCode
    public static int AccidentHandlingPTypeResultCode = 0x9005;//意外和事故P 类型的 resultCode
    public static int AccidentHandlingGTypeResultCode = 0x9006;//意外和事故G 类型的 resultCode
    public static int AccidentHandlingDTypeResultCode = 0x9007;//意外和事故D 类型的 resultCode
    public static int AccidentHandlingSTypeResultCode = 0x9008;//意外和事故S 类型的 resultCode

    public static int A_H_AccInfoRequestCode = 0x9050;//意外事故 acc类型的 request和resultbean
    public static int A_H_INCInfoRequestCode = 0x9051;//意外事故 inc类型的 request和resultbean
    public static int A_H_Add_CustomCode = 0x9052;//意外事故 添加人员 request和resultbean


    public static int AccidentHandlingGTypeAddItemCoode = 0x9100;//意外和事故 P类型的添加Item 的resultCode

    public static String PhotoSelectionGroupPosition = "photoselectiongroupposition";//选择照片分组position
    public static String PTWTYPEBEN = "ptwtypeben";//存储ptw申请界面 PTW申请类型的中英文
    public static String AccidentApplyBean = "accidentapplybean";// 意外申请的bean,要存储到本地
    public static String AccidentApplyEditorInformation = "accidentapplyeditorinformation";//意外申请界面  保存本地信息  (在已经编辑过一次 点击保存之后  或者驳回之后)
    public static String TOAST_BG = "toast_bg";//出场人员     Toast 背景
    public static String listPos = "listPos";// 各个列表的索引 ------这个是用来处理,当用户从列表界面跳转到详情界面,再返回详情界面时出现界面会刷新的问题
    public static String TBM_List_Page = "tbm_list_page";// tbm 列表的page
    public static String BDLocation = "";//百度定位的地点
    public static String ThambStr = "thumb_";//插入的缩略图的前缀

    public static String ProjectAndPermissionsDatabaseIndex = "1";

    public static int CopyWeChatImageSelector = 0x9999;//仿微信图片选择的request_Code和Result_Code

    public static int PTWApplyCode = 0x0301;//PTW 申请的Code
    public static String ptw_flag = "1";//0默认打开 1 PTW提交打开
    public static String tbm_flag = "1";////0默认打开 1 TBM提交打开


    public static String all_ptw_listPos = "all_ptw_list_pos";// 各个列表的索引 ------这个是用来处理,当用户从列表界面跳转到详情界面,再返回详情界面时出现界面会刷新的问题
    public static String all_ptw_List_Page = "all_ptw_list_page";// PTW all页面 列表的page
    public static String me_ptw_listPos = "me_ptw_list_pos";// 各个列表的索引 ------这个是用来处理,当用户从列表界面跳转到详情界面,再返回详情界面时出现界面会刷新的问题
    public static String me_ptw_List_Page = "me_ptw_list_page";// PTW all页面 列表的page

    public static final int personalAuit = 0;// 人员审核
    public static final int equipmentAudit = 1;// 设备审核
}
