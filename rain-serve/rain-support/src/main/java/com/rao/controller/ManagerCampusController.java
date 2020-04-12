package com.rao.controller;

import com.rao.pojo.dto.SaveCampusDTO;
import com.rao.pojo.vo.PageCampusVO;
import com.rao.service.CampusService;
import com.rao.util.page.PageParam;
import com.rao.util.result.PageResult;
import com.rao.util.result.ResultMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 学校管理
 *
 * @author raojing
 * @date 2020/1/26 13:24
 */
@RestController
@RequestMapping("/manager/campus")
public class ManagerCampusController {

    @Resource
    private CampusService campusService;

    /**
     * 学校列表
     *
     * @param pageParam
     * @return
     */
    @PostMapping("/list")
    public ResultMessage<PageResult<PageCampusVO>> list(@RequestBody PageParam pageParam) {
        PageResult<PageCampusVO> pageCampusList = campusService.pageCampus(pageParam);
        return ResultMessage.success(pageCampusList).message("获取学校列表成功");
    }

    /**
     * 新增学校
     *
     * @param saveCampusDTO
     * @return
     */
    @PostMapping()
    public ResultMessage add(@RequestBody SaveCampusDTO saveCampusDTO) {
        String campusId = campusService.addCampus(saveCampusDTO);
        return ResultMessage.success(campusId).message("新增学校成功");
    }

    /**
     * 修改学校
     *
     * @param id
     * @param saveCampusDTO
     * @return
     */
    @PutMapping("/{id}")
    public ResultMessage update(@PathVariable("id") Long id, @RequestBody SaveCampusDTO saveCampusDTO) {
        String campusId = campusService.updateCampus(id, saveCampusDTO);
        return ResultMessage.success(campusId).message("修改学校成功");
    }

    /**
     * 删除学校
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResultMessage delete(@PathVariable("id") Long id) {
        campusService.deleteCampus(id);
        return ResultMessage.success().message("删除学校成功");
    }

}