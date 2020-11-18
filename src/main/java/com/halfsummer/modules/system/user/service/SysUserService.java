package com.halfsummer.modules.system.user.service;

import java.util.List;
import com.halfsummer.framework.web.result.DataGridResultInfo;
import com.halfsummer.framework.web.result.ResultInfo;
import com.halfsummer.modules.system.user.domain.SysUser;
import com.halfsummer.modules.system.user.vo.SysUserVo;

/**
 * 系统用户Service接口
 * 
 * @author halfsummer
 * @date 2020-11-18
 */
public interface SysUserService
{
    /**
     * 查询系统用户
     * 
     * @param id 系统用户ID
     * @return 系统用户
     */
    public SysUser selectSysUserById(Long id);

    /**
     * 查询系统用户列表
     * 
     * @param sysUserVo 系统用户
     * @return 系统用户集合
     */
    public List<SysUser> selectSysUserList(SysUserVo sysUserVo);

    /**
     * 查询系统用户表格
     *
     * @param sysUserVo 系统用户
     * @return
     */
    public DataGridResultInfo tableList(SysUserVo sysUserVo);

    /**
     * 新增系统用户
     * 
     * @param sysUserVo 系统用户
     * @return 结果
     */
    public ResultInfo insertSysUser(SysUserVo sysUserVo);

    /**
     * 修改系统用户
     * 
     * @param sysUserVo 系统用户
     * @return 结果
     */
    public ResultInfo updateSysUser(SysUserVo sysUserVo);

    /**
     * 批量删除系统用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public ResultInfo deleteSysUserByIds(String ids);

    /**
     * 删除系统用户信息
     * 
     * @param id 系统用户ID
     * @return 结果
     */
    public int deleteSysUserById(Long id);

}
