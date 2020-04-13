package com.rao.controller;

import com.rao.annotation.BeanValid;
import com.rao.pojo.dto.PageFacultyDTO;
import com.rao.pojo.dto.SaveFacultyDTO;
import com.rao.pojo.vo.PageFacultyVO;
import com.rao.service.FacultyService;
import com.rao.util.page.PageParam;
import com.rao.util.result.PageResult;
import com.rao.util.result.ResultMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 院系管理
 *
 * @author raojing
 * @date 2020/1/26 13:22
 */
@RestController
@RequestMapping("/manager/faculty")
public class ManagerFacultyController {

    @Resource
    private FacultyService facultyService;

    /**
     * 院系列表
     *
     * @return
     */
    @PostMapping("/list")
    public ResultMessage<PageResult<PageFacultyVO>> list(@RequestBody PageParam pageParam, @RequestBody PageFacultyDTO pageFacultyDTO) {
        PageResult<PageFacultyVO> pageResult = facultyService.pageFaculty(pageParam, pageFacultyDTO);
        return ResultMessage.success(pageResult).message("查询院系列表成功");
    }

    /**
     * 新增院系
     *
     * @param saveFacultyDTO
     * @return
     */
    @PostMapping()
    public ResultMessage<String> add(@BeanValid @RequestBody SaveFacultyDTO saveFacultyDTO) {
        String facultyId = facultyService.addFaculty(saveFacultyDTO);
        return ResultMessage.success(facultyId).message("新增院系成功");
    }

    /**
     * 修改院系
     *
     * @param id
     * @param saveFacultyDTO
     * @return
     */
    @PutMapping("/{id}")
    public ResultMessage<String> update(@PathVariable("id") Long id,
                                      @BeanValid @RequestBody SaveFacultyDTO saveFacultyDTO) {
        String facultyId = facultyService.updateFaculty(id, saveFacultyDTO);
        return ResultMessage.success(facultyId).message("修改院系成功");
    }

    /**
     * 删除院系
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable("id") Long id) {
        facultyService.delete(id);
        return ResultMessage.success().message("删除院系成功");
    }

}
