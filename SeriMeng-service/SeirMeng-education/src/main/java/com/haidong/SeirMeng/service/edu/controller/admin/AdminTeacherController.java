package com.haidong.SeirMeng.service.edu.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.haidong.SeirMeng.service.base.result.R;
import com.haidong.SeirMeng.service.base.model.BaseController;
import com.haidong.SeirMeng.service.edu.entity.Teacher;
import com.haidong.SeirMeng.service.edu.entity.query.TeacherQuery;
import com.haidong.SeirMeng.service.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Xiehd
 * @email xiehdwork@163.com
 * @date 2021/12/26 0026 0:10
 */
@RestController// Controller+ResponseBody (默认返回是json字符串，json对于时间时区的设置需要注意)
@RequestMapping("/admin/edu/teacher")
@Api(tags = "讲师管理模块")
public class AdminTeacherController extends BaseController {

    @Autowired
    TeacherService teacherService;

    /**
    * 条件查询：
    * 1-service层中进行查新
    * 2-实现类中只需要使用BaseMapper即可进行条件查询
    * 3-田间查询的条件封装不仅不要条件Bean还需要new QueryWapper
    * Day02-007
    **/

    @ApiOperation(value = "搜索所有讲师")
    @GetMapping("/list")
    public R getTeachers(){
        List<Teacher> list = teacherService.list();
        return R.ok().data("items",list).message("获取讲师列表成功");
    }

    @ApiOperation("删除指定讲师")
    @DeleteMapping("/remove/{id}")
    public R removeById(@ApiParam(value = "讲师ID", required = true) @PathVariable String id){
        boolean b = teacherService.removeById(id);
        if(b){
            return R.ok().message(" 删除成功");
        }else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("分页讲师列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
                      @ApiParam("讲师列表查询对象") TeacherQuery teacherQuery){

        IPage<Teacher> pageModel = teacherService.selectPage(page, limit, teacherQuery);
        return  R.ok().data("pageModel", pageModel);
    }

    @ApiOperation("更新讲师")
    @PutMapping("update")
    public R updateById(@ApiParam(value = "讲师对象", required = true) @RequestBody Teacher teacher){
        boolean result = teacherService.updateById(teacher);
        if(result){
            return R.ok().message("修改成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("新增讲师")
    @PostMapping("save")
    public R save(@ApiParam(value = "讲师对象", required = true) @RequestBody Teacher teacher){
        boolean result = teacherService.save(teacher);
        if (result) {
            return R.ok().message("添加成功");
        } else {
            return R.error().message("添加失败");
        }
    }

    @ApiOperation("根据id获取讲师信息")
    @GetMapping("get/{id}")
    public R getById(@ApiParam(value = "讲师ID", required = true) @PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        if(teacher != null){
            return R.ok().data("item", teacher);
        }else{
            return R.error().message("数据不存在");
        }
    }



}

