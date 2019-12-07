package com.yingnuo.domain;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/12/6
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Ann {
    private int ann_id;
    private String ann_name;
    private String ann_content;

    public int getAnn_id() {
        return ann_id;
    }

    public void setAnn_id(int ann_id) {
        this.ann_id = ann_id;
    }

    public String getAnn_name() {
        return ann_name;
    }

    public void setAnn_name(String ann_name) {
        this.ann_name = ann_name;
    }

    public String getAnn_content() {
        return ann_content;
    }

    public void setAnn_content(String ann_content) {
        this.ann_content = ann_content;
    }

    @Override
    public String toString() {
        return "Ann{" +
                "ann_id=" + ann_id +
                ", ann_name='" + ann_name + '\'' +
                ", ann_content='" + ann_content + '\'' +
                '}';
    }
}