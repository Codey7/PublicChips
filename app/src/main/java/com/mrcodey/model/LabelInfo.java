package com.mrcodey.model;

import java.util.ArrayList;

/**
 * Created by Mr.Codey on 2015/10/26.
 * 项目标签表
 */
public class LabelInfo
{
    private String proLabel;//项目标签
    private String labelName;// 标签名字

    private String minImgUrl;//标签图片小
    private String maxImgUrl;//标签图片大
    private String labelDetail;//标签说明
    private ArrayList<ProjectInfo> proList;// 项目列表

    public String getProLabel()
    {
        return proLabel;
    }

    public void setProLabel(String proLabel)
    {
        this.proLabel = proLabel;
    }

    public String getLabelName()
    {
        return labelName;
    }

    public void setLabelName(String labelName)
    {
        this.labelName = labelName;
    }

    public String getMinImgUrl()
    {
        return minImgUrl;
    }

    public void setMinImgUrl(String minImgUrl)
    {
        this.minImgUrl = minImgUrl;
    }

    public String getMaxImgUrl()
    {
        return maxImgUrl;
    }

    public void setMaxImgUrl(String maxImgUrl)
    {
        this.maxImgUrl = maxImgUrl;
    }

    public String getLabelDetail()
    {
        return labelDetail;
    }

    public void setLabelDetail(String labelDetail)
    {
        this.labelDetail = labelDetail;
    }

    public ArrayList<ProjectInfo> getProList()
    {
        return proList;
    }

    public void setProList(ArrayList<ProjectInfo> proList)
    {
        this.proList = proList;
    }
}
