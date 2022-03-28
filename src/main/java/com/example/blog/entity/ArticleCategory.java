package com.example.blog.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.apache.ibatis.type.JdbcType;
import java.io.Serializable;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
/**
 * @author: 张童学
 * @description: 分类表 实体类
 * @date: 2022-03-25
 */
@Data
@TableName(value = "article_category")
public class ArticleCategory extends Model<ArticleCategory> implements Serializable {

    private static final long serialVersionUID = -202203251610460004L;

    /**
     * 分类ID
     */
    @JSONField(ordinal = 0)
    @TableId(value = "`id`", type = IdType.AUTO)
    private Integer id;
    /**
     * 分类名称
     */
    @JSONField(ordinal = 10)
    @TableField(value = "`name`", jdbcType = JdbcType.VARCHAR)
    private String name;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(deserialize = false, format = "yyyy-MM-dd HH:mm:ss", ordinal = 20)
    @TableField(value = "`create_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss", ordinal = 30)
    @TableField(value = "`update_time`", jdbcType = JdbcType.TIMESTAMP)
    private Date updateTime;
}
