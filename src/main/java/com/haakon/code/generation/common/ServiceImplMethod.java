package com.haakon.code.generation.common;

import com.haakon.code.generation.domain.ColumnInfo;
import com.haakon.code.generation.domain.TableInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.List;

public class ServiceImplMethod {

    /**
     * Save Method
     * @return
     * 2018年4月2日上午10:00:59
     */
    public static String serviceSave(TableInfo info, String importMapper){
        StringBuilder builder = new StringBuilder();
        builder.append(KeyWords.Tab).append("/**")
        .append(KeyWords.NEWLINE)
        .append(KeyWords.Tab).append("* 保存对象")
        .append(KeyWords.NEWLINE)
        .append(KeyWords.Tab).append("* ").append("@author haakon")
        .append(KeyWords.NEWLINE)
        .append(KeyWords.Tab).append("* ").append("@since ").append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"))
        .append(KeyWords.NEWLINE)
        .append(KeyWords.Tab).append("*/")
        .append(KeyWords.NEWLINE)
        .append(KeyWords.Tab).append(KeyWords.OVERRIDER)
        .append(KeyWords.NEWLINE)
        .append(KeyWords.Tab).append(KeyWords.PUBLIC).append(" int save(")
        .append(JavaBeanHandler.domainClassName(info.getTableName()))
        .append(" info) {").append(KeyWords.NEWLINE)
        .append(KeyWords.Tab).append(KeyWords.Tab)
        .append(KeyWords.RETURN).append(StringUtils.uncapitalize(importMapper))
        .append(KeyWords.DOT).append("save")
        .append("(info)").append(KeyWords.SEMICOLON).append(KeyWords.NEWLINE)
        .append(KeyWords.Tab).append("}").append(KeyWords.NEWLINE);
        return builder.toString();
    }

    /**
     * Update Method
     * @return
     * 2018年4月2日上午10:00:59
     */
    public static String serviceUpdate(TableInfo info, String importMapper){
        StringBuilder builder = new StringBuilder();
        builder.append(KeyWords.Tab).append("/**")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("* 修改对象")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("* ").append("@author haakon")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("* ").append("@since ").append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"))
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("*/")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append(KeyWords.OVERRIDER)
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append(KeyWords.PUBLIC).append(" int update(")
                .append(JavaBeanHandler.domainClassName(info.getTableName()))
                .append(" info) {").append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append(KeyWords.Tab)
                .append(KeyWords.RETURN).append(StringUtils.uncapitalize(importMapper))
                .append(KeyWords.DOT).append("update")
                .append("(info)").append(KeyWords.SEMICOLON).append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("}").append(KeyWords.NEWLINE);
        return builder.toString();
    }

    /**
     * Delete Method
     * @return
     * 2018年4月2日上午10:00:59
     */
    public static String serviceDelete(TableInfo info, String importMapper){
        StringBuilder builder = new StringBuilder();
        builder.append(KeyWords.Tab).append("/**")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("* 删除对象")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("* ").append("@author haakon")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("* ").append("@since ").append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"))
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("*/")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append(KeyWords.OVERRIDER)
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append(KeyWords.PUBLIC).append(" int delete(")
                .append(JavaBeanHandler.domainClassName(info.getTableName()))
                .append(" info) {").append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append(KeyWords.Tab)
                .append(KeyWords.RETURN).append(StringUtils.uncapitalize(importMapper))
                .append(KeyWords.DOT).append("delete")
                .append("(info)").append(KeyWords.SEMICOLON).append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("}").append(KeyWords.NEWLINE);
        return builder.toString();
    }

    /**
     * find Method
     * @return
     * 2018年4月2日上午10:00:59
     */
    public static String serviceFindOne(TableInfo info, String importMapper){
        StringBuilder builder = new StringBuilder();
        builder.append(KeyWords.Tab).append("/**")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("* 根据ID查询对象")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("* ").append("@author haakon")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("* ").append("@since ").append(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"))
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("*/")
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append(KeyWords.OVERRIDER)
                .append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append(KeyWords.PUBLIC).append(KeyWords.SPACE)
                .append(JavaBeanHandler.domainClassName(info.getTableName())).append(" findOne(")
                .append(JavaBeanHandler.domainClassName(info.getTableName()))
                .append(" info) {").append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append(KeyWords.Tab)
                .append(KeyWords.RETURN).append(StringUtils.uncapitalize(importMapper))
                .append(KeyWords.DOT).append("findOne")
                .append("(info)").append(KeyWords.SEMICOLON).append(KeyWords.NEWLINE)
                .append(KeyWords.Tab).append("}").append(KeyWords.NEWLINE);
        return builder.toString();
    }

}
