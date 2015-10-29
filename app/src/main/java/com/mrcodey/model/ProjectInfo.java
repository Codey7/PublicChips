package com.mrcodey.model;

import java.util.ArrayList;

/**
 * 项目基本属性
 * Created by Mr.Codey on 2015/10/19.
 */
public class ProjectInfo
{
    private int id;// 项目ID
    private String name ;//项目名称
    private String title; //项目标题
    private String briefIntro;//项目简介
    public enum category{TEAM,FUND,TOOL};//项目类别
    private String sort;//项目分类
    private String sImgUrl;//项目小图
    private String bImgUrl;//项目大图
    private boolean mainpage;//是否是首页
    private String initName;//发起人名字
    private String initTime;// 发起时间
    private String initstartTime;//开始时间20414-2-23

    private String initoverTime;//over time
    private int supportNum;// 支持人数量
    private ArrayList<String> supName;//已支持人列表
    private ArrayList<String> praiseName;//点赞列表
    private int proStatus;//项目状态 0--已发起 1--在筹中 2-- 已结束 3--已取消
    private String details;//项目详情
    private String proLabel;// 项目标签

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getBriefIntro()
    {
        return briefIntro;
    }

    public void setBriefIntro(String briefIntro)
    {
        this.briefIntro = briefIntro;
    }

    public String getSort()
    {
        return sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
    }

    public String getsImgUrl()
    {
        return sImgUrl;
    }

    public void setsImgUrl(String sImgUrl)
    {
        this.sImgUrl = sImgUrl;
    }

    public boolean isMainpage()
    {
        return mainpage;
    }

    public void setMainpage(boolean mainpage)
    {
        this.mainpage = mainpage;
    }

    public String getbImgUrl()
    {
        return bImgUrl;
    }

    public void setbImgUrl(String bImgUrl)
    {
        this.bImgUrl = bImgUrl;
    }

    public String getInitName()
    {
        return initName;
    }

    public void setInitName(String initName)
    {
        this.initName = initName;
    }

    public String getInitTime()
    {
        return initTime;
    }

    public void setInitTime(String initTime)
    {
        this.initTime = initTime;
    }

    public String getInitstartTime()
    {
        return initstartTime;
    }

    public void setInitstartTime(String initstartTime)
    {
        this.initstartTime = initstartTime;
    }

    public String getInitoverTime()
    {
        return initoverTime;
    }

    public void setInitoverTime(String initoverTime)
    {
        this.initoverTime = initoverTime;
    }

    public int getSupportNum()
    {
        return supportNum;
    }

    public void setSupportNum(int supportNum)
    {
        this.supportNum = supportNum;
    }

    public ArrayList<String> getSupName()
    {
        return supName;
    }

    public void setSupName(ArrayList<String> supName)
    {
        this.supName = supName;
    }

    public ArrayList<String> getPraiseName()
    {
        return praiseName;
    }

    public void setPraiseName(ArrayList<String> praiseName)
    {
        this.praiseName = praiseName;
    }

    public int getProStatus()
    {
        return proStatus;
    }

    public void setProStatus(int proStatus)
    {
        this.proStatus = proStatus;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getProLabel()
    {
        return proLabel;
    }

    public void setProLabel(String proLabel)
    {
        this.proLabel = proLabel;
    }
}
