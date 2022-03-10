package com.example.demo1210.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 *
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@Getter
@Setter
@TableName("tb_dept")
@ColumnWidth(20)
@ApiModel(value = "Dept对象", description = "")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ExcelProperty
    @ApiModelProperty("部门名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("等级")
    private Integer levels;

    @ExcelProperty
    @ApiModelProperty("联系人")
    @TableField("user_name")
    private String userName;

    @ExcelProperty
    @ApiModelProperty("联系电话")
    @TableField("tel")
    private String tel;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("描述")
    @TableField("descr")
    private String descr;

    @TableField(value = "`gmt_create`", jdbcType = JdbcType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String gmtCreate;

    @TableField(value = "`gmt_modified`", jdbcType = JdbcType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String gmtModified;

    @ApiModelProperty("逻辑删除,0存在,1删除")
    @TableField("is_deleted")
    @TableLogic
    private Integer isDeleted;


}
