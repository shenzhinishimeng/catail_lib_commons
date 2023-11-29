package com.catail.lib_commons.bean;

import java.io.Serializable;

public class ProjectAndPermissionBean implements Serializable {
    private String group_id;
    private String group_type;

    private String qa_clt_review;    //—qa-checklist 是否显示review选项：0不显示；1显示；
    private String qa_task_showtime;//qa_task_showtime 1显示；0不显示


    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getGroup_type() {
        return group_type;
    }

    public void setGroup_type(String group_type) {
        this.group_type = group_type;
    }

    public String getQa_clt_review() {
        return qa_clt_review;
    }

    public void setQa_clt_review(String qa_clt_review) {
        this.qa_clt_review = qa_clt_review;
    }

    public String getQa_task_showtime() {
        return qa_task_showtime;
    }

    public void setQa_task_showtime(String qa_task_showtime) {
        this.qa_task_showtime = qa_task_showtime;
    }

}
