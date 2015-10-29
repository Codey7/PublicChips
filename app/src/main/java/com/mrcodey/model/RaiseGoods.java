package com.mrcodey.model;

/**
 * Created by Mr.Codey on 2015/10/26.
 * 筹物
 */
public class RaiseGoods
{
    private int id;//项目编号 所有项目id统一
    private String details;// 物品说明
    private String alredyGoods;//已筹物品
    private String goodsPeo;//已筹物的人
    private int goodsNum;//已筹物的数目
    private String address;//物品提交地址

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public String getAlredyGoods()
    {
        return alredyGoods;
    }

    public void setAlredyGoods(String alredyGoods)
    {
        this.alredyGoods = alredyGoods;
    }

    public String getGoodsPeo()
    {
        return goodsPeo;
    }

    public void setGoodsPeo(String goodsPeo)
    {
        this.goodsPeo = goodsPeo;
    }

    public int getGoodsNum()
    {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
