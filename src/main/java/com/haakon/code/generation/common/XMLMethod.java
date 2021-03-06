package com.haakon.code.generation.common;

import java.security.Key;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.haakon.code.generation.domain.ColumnInfo;
import com.haakon.code.generation.domain.TableInfo;

public final class XMLMethod {

	/**
	 * XML Save
	 * @param info
	 * @return
	 * @since 2018年3月24日上午10:43:56
	 */
	public static String xmlFindOne(TableInfo info, List<ColumnInfo> columns) {
		StringBuilder builder = new StringBuilder();
		builder.append(KeyWords.Tab).append("<!-- 根据ID查询对象 -->").append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append("<select id=\"findOne\" resultMap=\"BaseResultMap\">")
		.append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append(KeyWords.Tab)
		.append("select * from ")
		.append(info.getTableName())
		.append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append(KeyWords.Tab)
		.append(" where ");
		int i = 1;
		for(ColumnInfo column: columns) {
			if(i%5 == 0) {
				builder.append(KeyWords.NEWLINE).append(KeyWords.Tab).append(KeyWords.Tab).append(KeyWords.Tab);
			}
			if(StringUtils.equalsIgnoreCase(column.getColumnKey(), KeyWords.KEY_PRIMARY)) {
				builder.append(" and ").append(column.getColumnName()).append(KeyWords.EQUAL)
						.append("#{").append(JavaBeanHandler.attrName(column.getColumnName(), false)).append("}");
			}
			i++;
		}
		builder.append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append("</select>")
		.append(KeyWords.NEWLINE);
		return StringUtils.replace(builder.toString(), "where  and", "where");
	}
	
	/**
	 * XML Delete
	 * @param info
	 * @return
	 * @since 2018年3月24日上午10:43:56
	 */
	public static String xmlDelete(TableInfo info, List<ColumnInfo> columns) {
		StringBuilder builder = new StringBuilder();
		builder.append(KeyWords.Tab).append("<!-- 根据ID删除对象 -->").append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append("<delete id=\"delete\">")
		.append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append(KeyWords.Tab)
		.append("delete from ")
		.append(info.getTableName())
		.append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append(KeyWords.Tab)
		.append(" where ");
		for(ColumnInfo column: columns) {
			if(StringUtils.equalsIgnoreCase(column.getColumnKey(), KeyWords.KEY_PRIMARY)) {
				builder.append(" and ").append(column.getColumnName()).append(KeyWords.EQUAL)
						.append("#{").append(JavaBeanHandler.attrName(column.getColumnName(), false)).append("}");
			}
		}
		builder.append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append("</delete>")
		.append(KeyWords.NEWLINE);
		return StringUtils.replace(builder.toString(), "where  and", "where");
	}
	
	/**
	 * XML save
	 * @param info
	 * @return
	 * @since 2018年3月24日上午10:43:56
	 */
	public static String xmlSave(TableInfo info, List<ColumnInfo> columns) {
		StringBuilder builder = new StringBuilder();
		builder.append(KeyWords.Tab).append("<!-- Save对象 -->").append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append("<insert id=\"save\" "+getPrimaryKey(columns)+" parameterType=\"")
//		.append(JavaBeanHandler.domainClassName(info.getTableName()))
		.append(JavaBeanHandler.domainPackage()).append(KeyWords.DOT)
		.append(JavaBeanHandler.className(info.getTableName(), ""))
		.append("\">")
		.append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append(KeyWords.Tab)
		.append("insert into ")
		.append(info.getTableName())
		.append("(");
		int i = 1;
		for(ColumnInfo column: columns) {
			if(i%5 == 0) {
				builder.append(KeyWords.NEWLINE).append(KeyWords.Tab).append(KeyWords.Tab).append(KeyWords.Tab);
			}
//			if(!column.isPrimaryKey()) {
				builder.append(column.getColumnName()).append(",");
//			}
			i++;
		}
		i = 1;
		builder.append(")")
		.append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append(KeyWords.Tab)
		.append("values (");
//		.append(KeyWords.NEWLINE)
//		.append(KeyWords.Tab).append(KeyWords.Tab);
		for(ColumnInfo column: columns) {
			if(i%5 == 0) {
				builder.append(KeyWords.NEWLINE).append(KeyWords.Tab).append(KeyWords.Tab).append(KeyWords.Tab);
			}
//			if(!column.isPrimaryKey()) {
				builder.append("#{").append(JavaBeanHandler.attrName(column.getColumnName(), false))
//						.append(",jdbcType=").append(column.getDataType())//数据库中数据类型
						.append("},");
//			}
			i++;
		}
		
		builder.append(")").append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append("</insert>")
		.append(KeyWords.NEWLINE);
		return StringUtils.replace(builder.toString(), ",)", ")");
	}
	
	/**
	 * 获取主键
	 * @param columns
	 * @since 2018年3月24日下午1:41:43
	 */
	private static String getPrimaryKey(List<ColumnInfo> columns){
		for(ColumnInfo column: columns) {
			if(column.isPrimaryKey()) {
				return "useGeneratedKeys=\"true\" keyProperty=\""+JavaBeanHandler.attrName(column.getColumnName(), false)+"\"";
			}
		}
		return "";
	}
	
	/**
	 * XML update.sql
	 * @param info
	 * @param columns
	 * @return
	 * @since 2018年3月24日下午1:12:49
	 */
	public static String xmlUpdate(TableInfo info, List<ColumnInfo> columns) {
		StringBuilder builder = new StringBuilder();
		builder.append(KeyWords.Tab).append("<!-- Update对象 -->").append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append("<update id=\"update\" parameterType=\"")
//		.append(JavaBeanHandler.domainClassName(info.getTableName()))
		.append(JavaBeanHandler.domainPackage()).append(KeyWords.DOT)
		.append(JavaBeanHandler.className(info.getTableName(), ""))
		.append("\">")
		.append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append(KeyWords.Tab)
		.append("update ").append(info.getTableName()).append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append(KeyWords.Tab).append("set");
		
		for(ColumnInfo column: columns) {
			if(!StringUtils.equalsIgnoreCase(column.getColumnKey(), KeyWords.KEY_PRIMARY)) {
				builder.append(KeyWords.NEWLINE).append(KeyWords.Tab).append(KeyWords.Tab).append(KeyWords.Tab).append(column.getColumnName()).append(" = ")
				.append("#{").append(JavaBeanHandler.attrName(column.getColumnName(), false)).append("},");
			}
		}
		
		builder.append(" where ");
		for(ColumnInfo column: columns) {
			if(StringUtils.equalsIgnoreCase(column.getColumnKey(), KeyWords.KEY_PRIMARY)) {
				builder.append(" and ").append(column.getColumnName()).append(KeyWords.EQUAL)
						.append("#{").append(JavaBeanHandler.attrName(column.getColumnName(), false)).append("}");
			}
		}
		builder.append(KeyWords.NEWLINE)
		.append(KeyWords.Tab).append("</update>")
		.append(KeyWords.NEWLINE);
		return StringUtils.replace(builder.toString(), ", where  and", "\r\n\t\twhere");
	}
}
