package com.bin.vehicle.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bin.common.exception.VehicleException;
import com.bin.common.utils.JwtUtils;
import com.bin.vehicle.entity.User;
import com.bin.vehicle.mapper.UserMapper;
import com.bin.vehicle.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bintian
 * @since 2020-12-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public String login(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        User userInfo = this.getOne(wrapper);
        if(StringUtils.isEmpty(userInfo)) {
            throw new VehicleException("用户名不存在",20001);
        }
        if(!userInfo.getPassword().equals(user.getPassword())) {
            throw new VehicleException( "密码错误", 20001);
        }
        if(userInfo.getStatus() != 0) {
            throw new VehicleException("该账户已被禁止登录", 20001);
        }
        //登陆成功, 生成token
        String jwtToken = JwtUtils.getJwtToken(userInfo.getId(), userInfo.getUsername());
        return jwtToken;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {

        String username = JwtUtils.getUsernameByJwtToken(token);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", username);
        return map;
    }
}
