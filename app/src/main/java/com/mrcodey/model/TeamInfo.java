package com.mrcodey.model;

/**
 * Created by Mr.Codey on 2015/9/8.
 */
public class TeamInfo
{
    private String imgUrl;//team图片
    private String teamName;//team名字

    private String teamIntro;//team简介

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    public String getTeamIntro()
    {
        return teamIntro;
    }

    public void setTeamIntro(String teamIntro)
    {
        this.teamIntro = teamIntro;
    }
}
