package com.halfsummer.modules.system.user.controller;

import java.util.List;
import com.halfsummer.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.halfsummer.framework.web.result.DataGridResultInfo;
import com.halfsummer.framework.web.result.ResultInfo;
import com.halfsummer.common.utils.reflect.ReflectUtils;
import com.halfsummer.modules.system.user.domain.SysUser;
import com.halfsummer.modules.system.user.vo.SysUserVo;
import com.halfsummer.modules.system.user.service.SysUserService;

/**
 * 系统用户Controller
 *
 * @author halfsummer
 * @date 2020-11-18
 */
@Controller
@RequestMapping(value="/system/user")
public class SysUserController{

    private String prefix = "system/user";

    @Autowired
    private SysUserService sysUserService;

    /**
    * 访问主页
    */
    @GetMapping()
    public String user(){
        return prefix + "/user";
    }

    /**
     * 新增系统用户
     */
    @GetMapping("/add")
    public String add(){
       return prefix + "/add";
    }

    /**
     * 修改系统用户
     */
    @GetMapping("/edit")
    public String edit(){
        return prefix + "/edit";
    }



    /**
     * 查询系统用户列表
     */
    @GetMapping("/list")
    @ResponseBody
    public DataGridResultInfo tableList(SysUserVo sysUserVo){
        return  sysUserService.tableList(sysUserVo);
    }

    /**
     * 导出系统用户列表
     */
    @PostMapping("/export")
    @ResponseBody
    public ResultInfo export(SysUserVo sysUserVo){
        List<SysUser> list = sysUserService.selectSysUserList(sysUserVo);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportExcel(list, "user");
    }



    /**
     * 新增保存系统用户
     */
    @PostMapping("/add")
    @ResponseBody
    public ResultInfo addSave(SysUserVo sysUserVo){
        return sysUserService.insertSysUser(sysUserVo);
    }



    /**
     * 修改保存系统用户
     */
    @PostMapping("/save")
    @ResponseBody
    public ResultInfo save(SysUserVo sysUserVo){
        return sysUserService.updateSysUser(sysUserVo);
    }

    /**
     * 删除系统用户
     */
    @PostMapping("/remove")
    @ResponseBody
    public ResultInfo remove(String ids){
        return sysUserService.deleteSysUserByIds(ids);
    }

}
