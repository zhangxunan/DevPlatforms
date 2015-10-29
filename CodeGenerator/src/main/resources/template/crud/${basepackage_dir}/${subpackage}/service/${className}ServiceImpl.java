<#include "/macro.include"/>
<#include "/copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.service;


import com.zttx.sdk.core.GenericServiceApiImpl;
import com.zttx.sdk.utils.StringUtils;
import com.zttx.sdk.utils.CalendarUtils;
import com.zttx.sdk.utils.SerialnoUtils;
import com.zttx.sdk.exception.BusinessException;
import com.zttx.sdk.consts.CommonConst;
import ${basepackage}.${subpackage}.entity.${className};
import ${basepackage}.${subpackage}.mapper.${className}Mapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ${table.sqlRemark} 服务实现类
 * <p>File：${className}.java </p>
 * <p>Title: ${className} </p>
 * <p>Description:${className} </p>
 * <p>Copyright: Copyright (c) May 26, 2015</p>
 * <p>Company: 8637.com</p>
 * @author 章旭楠
 * @version 1.0
 */
@Service
public class ${className}ServiceImpl extends GenericServiceApiImpl<${className}> implements ${className}Service
{

    private ${className}Mapper ${classNameLower}Mapper;

    @Autowired(required = true)
    public ${className}ServiceImpl(${className}Mapper ${classNameLower}Mapper)
    {
        super(${classNameLower}Mapper);
        this.${classNameLower}Mapper = ${classNameLower}Mapper;
    }

    @Override
    public void save(${className} ${classNameLower}) throws BusinessException {
        if (StringUtils.isNotBlank(dealerShopEnvTemp.getRefrenceId()))
        {
            ${className} old${className} = ${classNameLower}Mapper.selectByPrimaryKey(${classNameLower}.getRefrenceId());
            if (old${className} == null) { throw new BusinessException(CommonConst.FAIL); }
            ${classNameLower}.setUpdateTime(CalendarUtils.getCurrentLong());
            ${classNameLower}Mapper.updateByPrimaryKeySelective(${classNameLower});
        }
        else
        {
            ${classNameLower}.setRefrenceId(SerialnoUtils.buildPrimaryKey());
            ${classNameLower}.setCreateTime(CalendarUtils.getCurrentLong());
            ${classNameLower}Mapper.insertSelective(${classNameLower});
        }
    }
}
