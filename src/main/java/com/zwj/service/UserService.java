package com.zwj.service;

import com.zwj.service.model.UserVO;

/**
 * Created by 计国清 on 2019/05/12.
 */
public interface UserService {

  void save(UserVO user);

  UserVO find(UserVO user);
}
