package com.example.demo1210.controller;


import com.example.demo1210.bean.DeptBean;
import com.example.demo1210.config.LogAnnotation;
import com.example.demo1210.entity.Dept;
import com.example.demo1210.result.ResultResponseBody;
import com.example.demo1210.service.impl.DeptServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
@RestController
@RequestMapping("/dept")
public class DeptController {

    private final DeptServiceImpl deptServiceimpl;

    public DeptController(DeptServiceImpl deptServiceimpl) {
        this.deptServiceimpl = deptServiceimpl;
    }

    @LogAnnotation(title = "分页", tag = "获取分页")
    @ApiOperation("分页")
    @PostMapping("/listPage")
    public ResultResponseBody<List<Dept>> getListPage(@RequestBody DeptBean deptBean) {
        return ResultResponseBody.ok(deptServiceimpl.deptList(deptBean));
    }

    @LogAnnotation(title = "列表", tag = "获取列表")
    @ApiOperation("列表")
    @PostMapping("/list")
    public Object getList(@RequestBody Map<String, Object> param) {

        System.out.println("请求参数：" + param);

        Object list = deptServiceimpl.listP(param);
        System.out.println("list-->"+list);

        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("list", list);
        return map;
    }


    @Cacheable(key = "#id", cacheNames = "id", condition = "#id>3")
    @LogAnnotation(title = "根据", tag = "id")
    @ApiOperation("id")
    @GetMapping("/id")
    public ResultResponseBody<Dept> getOneById(@RequestParam(value = "id") int id) {
        Dept dept = deptServiceimpl.getById(id);
        return ResultResponseBody.ok(dept);
    }

    @ApiOperation("Did")
    @PostMapping("/Did")
    public ResultResponseBody<Dept> selectCountByDId(@RequestParam(value = "ids") Set<Integer> ids) {
        return ResultResponseBody.ok(deptServiceimpl.selectCountByOrgId(ids));
    }

    @ApiOperation("deleByName")
    @DeleteMapping("/dele")
    public ResultResponseBody<Dept> dele(@RequestParam(value = "dele") String name) {
        return ResultResponseBody.ok("删除ok", deptServiceimpl.deleteByName(name));
    }

    @ApiOperation("up")
    @PutMapping("/up")
    public ResultResponseBody<Dept> upde(@RequestParam(value = "tel") String tel) {
        return ResultResponseBody.ok("ok", deptServiceimpl.updateTelByName(tel));
    }

    @LogAnnotation(title = "增加一个部门", tag = "增加")
    @ApiOperation("增加")
    @PostMapping("/add")
    public ResultResponseBody<Dept> add(@RequestBody DeptBean deptBean) {

        return ResultResponseBody.ok(deptServiceimpl.addDept(deptBean));
    }

}
