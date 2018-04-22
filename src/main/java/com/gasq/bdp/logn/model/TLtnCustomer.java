package com.gasq.bdp.logn.model;

import java.util.Date;

public class TLtnCustomer extends ParamsObject{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer companyId;

    private Integer chuFuZhen;

    private String customername;

    private String phonenumb;

    private Integer therapeutist;

    private String createuser;

    private String updateuser;

    private Date createtime;

    private Date updatetime;

    private Date importtime;

    private String importuser;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getChuFuZhen() {
        return chuFuZhen;
    }

    public void setChuFuZhen(Integer chuFuZhen) {
        this.chuFuZhen = chuFuZhen;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    public String getPhonenumb() {
        return phonenumb;
    }

    public void setPhonenumb(String phonenumb) {
        this.phonenumb = phonenumb == null ? null : phonenumb.trim();
    }

    public Integer getTherapeutist() {
        return therapeutist;
    }

    public void setTherapeutist(Integer therapeutist) {
        this.therapeutist = therapeutist;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getImporttime() {
        return importtime;
    }

    public void setImporttime(Date importtime) {
        this.importtime = importtime;
    }

    public String getImportuser() {
        return importuser;
    }

    public void setImportuser(String importuser) {
        this.importuser = importuser == null ? null : importuser.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}