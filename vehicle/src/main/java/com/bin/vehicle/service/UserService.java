package com.bin.vehicle.service;

import com.bin.vehicle.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bintian
 * @since 2020-12-08
 */
public interface UserService extends IService<User> {

    String login(User user);

    Map<String, Object> getUserInfo(String token);
}
