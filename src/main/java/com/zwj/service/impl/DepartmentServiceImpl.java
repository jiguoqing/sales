package com.zwj.service.impl;

import com.zwj.common.ConvertUtil;
import com.zwj.dao.DepartmentMapper;
import com.zwj.dao.dataobject.DepartmentDO;
import com.zwj.service.DepartmentService;
import com.zwj.service.model.DepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiguoqing on 2019/05/12.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  private DepartmentMapper departmentMapper;

  @Override
  public List<DepartmentVO> findAll() {
    List<DepartmentDO> departmentDOS = departmentMapper.findAll();
    return ConvertUtil.convertToVOList(departmentDOS, DepartmentVO.class);
  }

  @Override
  public void save(DepartmentVO department) {
    if (null == department.getId()) {
      departmentMapper.insert(department);
    } else {
      departmentMapper.update(department);
    }
  }

  @Override
  public void deleteById(Integer id) {
    departmentMapper.deleteById(id);
  }

  @Override
  public List<DepartmentVO> findByName(String name) {
    List<DepartmentDO> departmentDOS = departmentMapper.findByName(name);
    return ConvertUtil.convertToVOList(departmentDOS, DepartmentVO.class);
  }

  @Override
  public Map<Integer, DepartmentVO> findByIds(List<Integer> ids) {

    List<DepartmentDO> departmentDOS = departmentMapper.findByIds(ids);
    Map<Integer, DepartmentVO> result = new HashMap<>();
    if (CollectionUtils.isEmpty(departmentDOS)) {
      return result;
    }
    for (DepartmentDO departmentDO : departmentDOS) {
      result.put(departmentDO.getId(), ConvertUtil.convertToVO(departmentDO, DepartmentVO.class));
    }

    return result;
  }

  @Override
  public boolean isExist(DepartmentVO department) {
    DepartmentDO departmentDO = departmentMapper.isExist(department);
    return !(null == departmentDO);
  }
}
