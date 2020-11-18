package com.halfsummer.modules.system.user.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.halfsummer.framework.aspectj.lang.annotation.Excel;
import com.halfsummer.framework.web.domain.BaseEntity;

/**
 * 系统用户对象 sys_user
 * 
 * @author halfsummer
 * @date 2020-11-18
 */
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 登录名 */
    @Excel(name = "登录名")
    private String loginName;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contactInformation;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;

    /** 排序 */
    @Excel(name = "排序")
    private String orderNum;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 上级领导 */
    @Excel(name = "上级领导")
    private Long upperLeader;

    /** 受雇日期 */
    @Excel(name = "受雇日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date hireDate;

    /** 盐值 */
    @Excel(name = "盐值")
    private String salt;

    /** 是否有效 */
    @Excel(name = "是否有效")
    private String isAvailable;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private String isDelete;

    /** 创建者名称 */
    @Excel(name = "创建者名称")
    private String createByName;

    /** 修改者姓名 */
    @Excel(name = "修改者姓名")
    private String updateByName;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getLoginName()
    {
        return loginName;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setContactInformation(String contactInformation)
    {
        this.contactInformation = contactInformation;
    }

    public String getContactInformation()
    {
        return contactInformation;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setOrderNum(String orderNum)
    {
        this.orderNum = orderNum;
    }

    public String getOrderNum()
    {
        return orderNum;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setUpperLeader(Long upperLeader)
    {
        this.upperLeader = upperLeader;
    }

    public Long getUpperLeader()
    {
        return upperLeader;
    }
    public void setHireDate(Date hireDate)
    {
        this.hireDate = hireDate;
    }

    public Date getHireDate()
    {
        return hireDate;
    }
    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public String getSalt()
    {
        return salt;
    }
    public void setIsAvailable(String isAvailable)
    {
        this.isAvailable = isAvailable;
    }

    public String getIsAvailable()
    {
        return isAvailable;
    }
    public void setIsDelete(String isDelete)
    {
        this.isDelete = isDelete;
    }

    public String getIsDelete()
    {
        return isDelete;
    }
    public void setCreateByName(String createByName)
    {
        this.createByName = createByName;
    }

    public String getCreateByName()
    {
        return createByName;
    }
    public void setUpdateByName(String updateByName)
    {
        this.updateByName = updateByName;
    }

    public String getUpdateByName()
    {
        return updateByName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("loginName", getLoginName())
            .append("password", getPassword())
            .append("contactInformation", getContactInformation())
            .append("address", getAddress())
            .append("sex", getSex())
            .append("deptId", getDeptId())
            .append("orderNum", getOrderNum())
            .append("avatar", getAvatar())
            .append("upperLeader", getUpperLeader())
            .append("hireDate", getHireDate())
            .append("salt", getSalt())
            .append("isAvailable", getIsAvailable())
            .append("isDelete", getIsDelete())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createByName", getCreateByName())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateByName", getUpdateByName())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
