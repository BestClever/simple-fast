package com.halfsummer.modules.system.user.service.impl;

import java.util.List;
import com.halfsummer.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.halfsummer.common.enums.CommonEnum;
import com.halfsummer.framework.web.result.PageWrapper;
import com.halfsummer.framework.web.result.ResultDataUtil;
import com.halfsummer.framework.web.result.DataGridResultInfo;
import com.halfsummer.framework.web.result.ResultInfo;
import com.halfsummer.common.utils.DateUtils;
import com.halfsummer.common.utils.Convert;
import com.halfsummer.modules.system.user.mapper.SysUserMapper;
import com.halfsummer.modules.system.user.domain.SysUser;
import com.halfsummer.modules.system.user.vo.SysUserVo;
import com.halfsummer.modules.system.user.service.SysUserService;
/**
 * 系统用户Service业务层处理
 *
 * @author halfsummer
 * @date 2020-11-18
 */
@Service
public class SysUserServiceImpl implements SysUserService
{
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询系统用户
     *
     * @param id 系统用户ID
     * @return 系统用户
     */
    @Override
    public SysUser selectSysUserById(Long id)
    {
        return sysUserMapper.selectSysUserById(id);
    }

    /**
     * 查询系统用户列表
     *
     * @param sysUserVo 系统用户
     * @return 系统用户
     */
    @Override
    public List<SysUser> selectSysUserList(SysUserVo sysUserVo){
        return sysUserMapper.selectSysUserList(sysUserVo);
    }

    /**
     * 查询系统用户表格
     *
     * @param sysUserVo 系统用户
     * @return
     */
    @Override
    public DataGridResultInfo tableList(SysUserVo sysUserVo)
    {
        PageHelper.startPage(sysUserVo.getPage(),sysUserVo.getLimit());
        List<SysUser> sysUserList = sysUserMapper.selectSysUserList(sysUserVo);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserList);
        PageWrapper pageWrapper = new PageWrapper();
        pageWrapper.setList(pageInfo.getList());
        pageWrapper.setTotal(pageInfo.getTotal());
        return ResultDataUtil.createQueryResult(pageWrapper);
    }

    /**
     * 新增系统用户
     *
     * @param sysUserVo 系统用户
     * @return 结果
     */
    @Override
    public ResultInfo insertSysUser(SysUserVo sysUserVo){
        sysUserVo.setCreateTime(DateUtils.getNowDate());
        int result = sysUserMapper.insertSysUser(sysUserVo);
        if(result < 0){
            ResultDataUtil.throwExcepion(CommonEnum.SAVE_FAILURE);
        }
        return ResultDataUtil.createSuccess(CommonEnum.SAVE_SUCESS);
    }

    /**
     * 修改系统用户
     *
     * @param sysUserVo 系统用户
     * @return 结果
     */
    @Override
    public ResultInfo updateSysUser(SysUserVo sysUserVo){
        sysUserVo.setUpdateTime(DateUtils.getNowDate());
        int result = sysUserMapper.updateSysUser(sysUserVo);
        if(result < 0){
            ResultDataUtil.throwExcepion(CommonEnum.UPDATE_FAILURE);
        }
        return ResultDataUtil.createSuccess(CommonEnum.UPDATE_SUCESS);
    }

    /**
     * 删除系统用户对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public ResultInfo deleteSysUserByIds(String ids)
    {
        int result = sysUserMapper.deleteSysUserByIds(Convert.toStrArray(ids));
        if(result < 0){
            ResultDataUtil.throwExcepion(CommonEnum.DELETE_FAILURE);
        }
        return ResultDataUtil.createSuccess(CommonEnum.DELETE_SUCESS);
    }

    /**
     * 删除系统用户信息
     *
     * @param id 系统用户ID
     * @return 结果
     */
    @Override
    public int deleteSysUserById(Long id)
    {
        return sysUserMapper.deleteSysUserById(id);
    }
}
