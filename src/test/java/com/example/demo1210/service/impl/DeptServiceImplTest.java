package com.example.demo1210.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 张童学
 * @version 1.0
 * @date 2022/1/24 9:59
 * @describe
 */
class DeptServiceImplTest {

    @Autowired
    DeptServiceImpl deptService;

    @Test
    void listNoParams() {
        System.out.println(deptService.listNoParams());
    }
}
