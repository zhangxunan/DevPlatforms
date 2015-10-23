import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

<#include "/macro.include"/>
<#include "/copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basepackage}.${subpackage}.service.${className}Service;
import ${basepackage}.${subpackage}.entity.${className};
import com.zttx.sdk.exception.BusinessException;
import com.zttx.sdk.core.GenericController;
import com.zttx.sdk.bean.JsonMessage;
import com.zttx.sdk.bean.PaginateResult;
import com.zttx.sdk.bean.Pagination;
import com.zttx.sdk.consts.CommonConst;


/**
 * ${table.sqlRemark} 控制器
 * <p>File：${className}Controller.java </p>
 * <p>Title: ${className}Controller </p>
 * <p>Description:${className}Controller </p>
 * <p>Copyright: Copyright (c) May 26, 2015 </p>
 * <p>Company: 8637.com</p>
 * @author 章旭楠
 * @version 1.0
 */
@Controller
@RequestMapping("/${subpackage}/${classNameLower}")
public class ${className}Controller extends GenericController
{
    @Autowired(required = true)
    private ${className}Service ${classNameLower}Service;

    /**
    * 页面跳转
    */
    @RequestMapping(value = "/index")
    public String index()
    {
        return "/${subpackage}/${classNameLower}/index";
    }

    /**
     * 分页列表查询
     * @param pagination 分页参数
     * @param ${classNameLower}Filter 过滤参数
     * @return {@link JsonMessage}
     */
    @ResponseBody
    @RequestMapping("/data")
    public JsonMessage dataList(Pagination pagination, ${className} ${classNameLower}Filter)
    {
        ${classNameLower}Filter.setPage(pagination);
        PaginateResult<${className}> result = new PaginateResult<>(${classNameLower}Filter.getPage(), ${classNameLower}Service.findList(${classNameLower}Filter));
        return this.getJsonMessage(CommonConst.SUCCESS, result);
    }

    /**
     * 保存信息
     * @param ${classNameLower} 信息
     * @return {@link JsonMessage}
     * @throws BusinessException 异常
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonMessage save(${className} ${classNameLower}) throws BusinessException
    {
        JsonMessage jsonMessage = super.getJsonMessage(CommonConst.SUCCESS);
        if (beanValidator(jsonMessage, ${classNameLower}))
        {
            ${classNameLower}Service.save(${classNameLower});
        }
        return jsonMessage;
    }

    /**
     * 删除
     * @param refrenceId 主键id
     * @return {@link JsonMessage}
     */
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public JsonMessage delete(String refrenceId)
    {
        ${classNameLower}Service.delete(refrenceId);
        return super.getJsonMessage(CommonConst.SUCCESS);
    }

    /**
     * 查看信息
     * @param refrenceId 主键id
     * @return {@link JsonMessage}
     */
    @ResponseBody
    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public JsonMessage view(String refrenceId)
    {
        ${className} ${classNameLower} = ${classNameLower}Service.selectByPrimaryKey(refrenceId);
        if (null == ${classNameLower}) { return super.getJsonMessage(CommonConst.FAIL); }
        return super.getJsonMessage(CommonConst.SUCCESS, ${classNameLower});
    }
}
