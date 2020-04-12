package com.rao.controller;

import com.rao.pojo.vo.ListCampusVO;
import com.rao.pojo.vo.ListFacultyVO;
import com.rao.service.CampusService;
import com.rao.util.result.ResultMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学校controller-C端接口
 *
 * @author raojing
 * @date 2020/4/11 23:49
 */
@RestController
@RequestMapping("/api/campus")
public class CampusApiController {

    @Resource
    private CampusService campusService;

    /**
     * 获取全部的学校
     *
     * @return
     */
    @GetMapping()
    public ResultMessage<List<ListCampusVO>> allCampus() {
        List<ListCampusVO> listCampus = campusService.allCampus();
        return ResultMessage.success(listCampus).message("获取学校成功");
    }

    /**
     * 根据学校ID获取院系列表
     *
     * @param campusId
     * @return
     */
    @GetMapping("/faculty/{campus_id}")
    public ResultMessage listFaculty(@PathVariable("campus_id") Long campusId) {
        List<ListFacultyVO> listFaculty = campusService.listFacultyByCampusId(campusId);
        return ResultMessage.success(listFaculty).message("获取院系成功");
    }

}
