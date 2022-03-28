package wzz.digou.pojo;

import java.util.Date;

public class BulkConfig {
    private Integer id;//配置表的id

    private Integer shopid;//商店id

    private Integer pid;//商品id

    private Double bulkprice;//团购价格

    private Integer population;//成团人数

    private Integer status;//团购状态1开启，2关闭、失效 3完成

    private Date starttime;//团购开启时间

    private Date endtime;//团购结束时间

    /*非数据库字段*/
    private Product product;

    public BulkConfig() {
    }

    public BulkConfig(Integer shopid, Integer pid, Double bulkprice, Integer population, Integer status, Date starttime, Date endtime) {
        this.shopid = shopid;
        this.pid = pid;
        this.bulkprice = bulkprice;
        this.population = population;
        this.status = status;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Double getBulkprice() {
        return bulkprice;
    }

    public void setBulkprice(Double bulkprice) {
        this.bulkprice = bulkprice;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
