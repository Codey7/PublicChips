package com.mrcodey.model;

/**
 * 提现记录的model
 * Created by Mr.Codey on 2015/10/28.
 */
public class WithDrawInfo
{
    private String date;//提现日期
    private String time;//提现时间
    private String headUrl;//头像url

    private float money;//提钱的数目
    private String name;//项目名称
    private String status;//提现状态

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getHeadUrl()
    {
        return headUrl;
    }

    public void setHeadUrl(String headUrl)
    {
        this.headUrl = headUrl;
    }

    public float getMoney()
    {
        return money;
    }

    public void setMoney(float money)
    {
        this.money = money;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
