package com.rao.service;

import com.rao.pojo.dto.SaveCampusDTO;
import com.rao.pojo.vo.ListCampusVO;
import com.rao.pojo.vo.ListFacultyVO;
import com.rao.pojo.vo.PageCampusVO;
import com.rao.util.page.PageParam;
import com.rao.util.result.PageResult;

import java.util.List;

/**
 * 学校管理 service
 *
 * @author raojing
 * @date 2020/1/26 13:30
 */
public interface CampusService {

    /**
     * 分页查询学校列表
     *
     * @param pageParam
     * @return
     */
    PageResult<PageCampusVO> pageCampus(PageParam pageParam);

    /**
     * 新增学校
     *
     * @param saveCampusDTO
     * @return
     */
    String addCampus(SaveCampusDTO saveCampusDTO);

    /**
     * 修改学校
     *
     * @param id
     * @param saveCampusDTO
     * @return
     */
    String updateCampus(Long id, SaveCampusDTO saveCampusDTO);

    /**
     * 删除学校
     *
     * @param id
     */
    void deleteCampus(Long id);

    /**
     * 获取全部学校
     *
     * @return
     */
    List<ListCampusVO> allCampus();

    /**
     * 根据学校ID获取院系列表
     *
     * @param campusId
     * @return
     */
    List<ListFacultyVO> listFacultyByCampusId(Long campusId);
}
