package com.example.blog.bean;
import lombok.Data;


/**
 * @author: 张童学
 * @description: 友链表 参数类
 * @date: 2022-03-25
 */

@Data
public class TbFriendlinkParams {
    /**
     * 当前页面
     */
    private Integer currentPage;
    /**
     * 每页条数
     */
    private Integer pageSize;
}
