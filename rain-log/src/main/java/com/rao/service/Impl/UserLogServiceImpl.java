package com.rao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rao.dao.UserLoginLogoutLogDao;
import com.rao.pojo.dto.UserLoginLogoutLogDTO;
import com.rao.pojo.entity.UserLoginLogoutLog;
import com.rao.pojo.vo.UserLoginLogoutLogVO;
import com.rao.service.UserLogService;
import com.rao.util.common.CopyUtil;
import com.rao.util.page.PageParam;
import com.rao.util.result.PageResult;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : hudelin
 * @className :UserLogServiceImpl
 * @description :用户日志服务类接口
 * @date: 2020-01-13 14:45
 */
@Service
public class UserLogServiceImpl implements UserLogService {

    @Resource
    private UserLoginLogoutLogDao userLoginLogoutLogDao;

    @Override
    public PageResult<UserLoginLogoutLogVO> getLoginLogout(PageParam pageParam, UserLoginLogoutLogDTO userLoginLogoutLogDTO) {
        PageHelper.startPage(pageParam.getPageNumber(), pageParam.getPageSize());

        //添加查询条件
        Example example = new Example(UserLoginLogoutLog.class);
        example.createCriteria().andEqualTo("userId", userLoginLogoutLogDTO.getUserId());
        example.and().andEqualTo("userType",userLoginLogoutLogDTO.getAccountType());

        List<UserLoginLogoutLog> systemUserList = userLoginLogoutLogDao.selectByExample(example);
        PageInfo pageInfo = PageInfo.of(systemUserList);
        // 封装视图模型
        List<UserLoginLogoutLogVO> logoutLogVOList = CopyUtil.transToObjList(systemUserList, UserLoginLogoutLogVO.class);
        return PageResult.build(pageInfo.getTotal(), logoutLogVOList);
    }
}
