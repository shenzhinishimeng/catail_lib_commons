package com.catail.lib_commons.bean;

import java.io.Serializable;

public class ProjectAndPermissionBean implements Serializable {
    private String project_id;
    private String project_name;

    private String app_id;//SAF正常显示, EPSS  只显示人员/设备, 人员设备提醒功能.
    private String is_lite;//0完整版；1Lite版；
    private String contractor_id;

    private String acci_mode;//意外的类型
    private String ins_mode;//安全检查的类型
    private String ptw_mode;//ptw的类型
    private String tbm_mode;//tbm的类型
    private String train_mode;//培训的类型

    private String location_require;//需要位置采集 PTW
    private String tbm_declare; //tbm 声明 要不要显示

    private String camera_only; //图片是否只显示拍照
    private String ptw_assess_photo; //PTW审批是否只可以添加拍照


    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getIs_lite() {
        return is_lite;
    }

    public void setIs_lite(String is_lite) {
        this.is_lite = is_lite;
    }

    public String getAcci_mode() {
        return acci_mode;
    }

    public void setAcci_mode(String acci_mode) {
        this.acci_mode = acci_mode;
    }

    public String getIns_mode() {
        return ins_mode;
    }

    public void setIns_mode(String ins_mode) {
        this.ins_mode = ins_mode;
    }

    public String getPtw_mode() {
        return ptw_mode;
    }

    public void setPtw_mode(String ptw_mode) {
        this.ptw_mode = ptw_mode;
    }

    public String getTbm_mode() {
        return tbm_mode;
    }

    public void setTbm_mode(String tbm_mode) {
        this.tbm_mode = tbm_mode;
    }

    public String getTrain_mode() {
        return train_mode;
    }

    public void setTrain_mode(String train_mode) {
        this.train_mode = train_mode;
    }

    public String getLocation_require() {
        return location_require;
    }

    public void setLocation_require(String location_require) {
        this.location_require = location_require;
    }

    public String getTbm_declare() {
        return tbm_declare;
    }

    public void setTbm_declare(String tbm_declare) {
        this.tbm_declare = tbm_declare;
    }


    public String getContractor_id() {
        return contractor_id;
    }

    public void setContractor_id(String contractor_id) {
        this.contractor_id = contractor_id;
    }

    public String getCamera_only() {
        return camera_only;
    }

    public void setCamera_only(String camera_only) {
        this.camera_only = camera_only;
    }

    public String getPtw_assess_photo() {
        return ptw_assess_photo;
    }

    public void setPtw_assess_photo(String ptw_assess_photo) {
        this.ptw_assess_photo = ptw_assess_photo;
    }
}
