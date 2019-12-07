package com.yingnuo.domain;

public class VipRule {
    private int id;
    private int max_point;
    private int is_rank;
    private Double rebate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMax_point() {
        return max_point;
    }

    public void setMax_point(int max_point) {
        this.max_point = max_point;
    }

    public int getIs_rank() {
        return is_rank;
    }

    public void setIs_rank(int is_rank) {
        this.is_rank = is_rank;
    }

    public Double getRebate() {
        return rebate;
    }

    public void setRebate(Double rebate) {
        this.rebate = rebate;
    }

    @Override
    public String toString() {
        return "VipRule{" +
                "id=" + id +
                ", max_point=" + max_point +
                ", is_rank=" + is_rank +
                ", rebate=" + rebate +
                '}';
    }
}