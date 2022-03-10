package com.example.demo1210.controller;


import com.example.demo1210.bean.DeptBean;
import com.example.demo1210.config.LogAnnotation;
import com.example.demo1210.entity.Dept;
import com.example.demo1210.result.R;
import com.example.demo1210.service.impl.DeptServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@SuppressWarnings("all")
@Slf4j
@Api
@CrossOrigin
@RestController
@RequestMapping("/dept")
public class DeptController {

    private final DeptServiceImpl deptServiceimpl;

    public DeptController(DeptServiceImpl deptServiceimpl) {
        this.deptServiceimpl = deptServiceimpl;
    }


//    /**
//     * 导出 Excel 表格
//     * @return
//     */
//    @GetMapping("/export")
//    public R<byte[]> exportData() {
//        // 1.这一步就是查询你要导出的数据
//        List<Dept> list = deptServiceimpl.list();
//        // 2.创建一个 POIUtils 工具类进行导出操作
//        return POIUtils.employee2Excel(list);
//    }



    @LogAnnotation(title = "分页列表DIY", tag = "分页列表")
    @ApiOperation("分页列表DIY")
    @PostMapping("/selecListPage")
    public R<List<Dept>> selectListPage(@RequestBody DeptBean params) {
        if (params == null) {
            R.argsNull();
        }
        return R.success(deptServiceimpl.selectListPage(params));
    }

    @CrossOrigin
    @LogAnnotation(title = "列表", tag = "列表")
    @GetMapping("/listNo")
    public R<List<Dept>> getList() {

        return R.success(deptServiceimpl.listNoParams());
    }

    @LogAnnotation(title = "列表map", tag = "列表map")
    @ApiOperation("列表map")
    @PostMapping("/list")
    public Object getList(@RequestBody Map<String, Object> param) {

        System.out.println("请求参数：" + param);

        Object list = deptServiceimpl.listP(param);
        System.out.println("list-->" + list);

        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("list", list);
        return map;
    }


    @Cacheable(key = "#id", cacheNames = "id", condition = "#id>3")
    @LogAnnotation(title = "根据", tag = "id")
    @ApiOperation("id")
    @GetMapping("/id")
    public R<Dept> getOneById(@RequestParam(value = "id") int id) {
        Dept dept = deptServiceimpl.getById(id);
        return R.success(dept);
    }

    @ApiOperation("deleByName")
    @DeleteMapping("/dele")
    public R<Integer> dele(@RequestParam(value = "dele") String name) {

        return R.success(deptServiceimpl.deleteByName(name));
    }

    @ApiOperation("up")
    @PutMapping("/up")
    public R<Integer> upde(String tel) {
        if (tel == null) {
            return R.argsNull();
        }
        return R.success(deptServiceimpl.updateTelByName(tel));
    }

    @LogAnnotation(title = "增加一个部门", tag = "增加")
    @ApiOperation("增加")
    @PostMapping("/add")
    public R<Integer> add(@RequestBody DeptBean deptBean) {
        if (deptBean == null) {
            return R.argsNull();
        }

        if (!deptBean.getUserName().isEmpty()) {
            //查重
            int check = deptServiceimpl.getOneByName(deptBean.getUserName());
            if (check > 0) {
                return R.fail("已存在相同用户名");
            }
        } else {
            return R.argsNull();
        }

        return R.success(deptServiceimpl.addDept(deptBean));
    }


}
