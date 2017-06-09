package com.beini.controller.shiro;

import com.beini.bean.Leader;
import com.beini.service.LeaderService;
import com.beini.utils.BLog;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by beini on 2017/6/9.
 */
public class ShiroDbRealm extends AuthorizingRealm {

    @Autowired
    private LeaderService leaderService;
    public static final String SESSION_USER_KEY = "gray";

    /**
     * 构造函数，设置安全的初始化信息
     */
    public ShiroDbRealm() {
        super();
        BLog.d("--->ShiroDbRealm");
        setAuthenticationTokenClass(UsernamePasswordToken.class);
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        BLog.d("--->doGetAuthorizationInfo");
        Leader leader = (Leader) SecurityUtils.getSubject().getSession().getAttribute(ShiroDbRealm.SESSION_USER_KEY);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole(leader.getRole().trim());
        return info;
    }

    /**
     * 认证回调函数，登录信息和用户验证信息验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        BLog.d("--->AuthenticationInfo");
        // 把token转换成Leader对象
        Leader userLogin = tokenToUser((UsernamePasswordToken) authenticationToken);
        // 验证用户是否可以登录
        List<Leader> ui = leaderService.doUserLogin(userLogin);
        BLog.d(" ---------> ui.size()=="+ui.size());
        if (ui.size() == 0) {
            return null; // 异常处理，找不到数据
        }
        BLog.d("   可以登录 ");
        // 设置session
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute(ShiroDbRealm.SESSION_USER_KEY, ui);
        //当前 Realm 的 name
        String realmName = this.getName();
        //登陆的主要信息: 可以是一个实体类的对象, 但该实体类的对象一定是根据 token 的 username 查询得到的.
//      Object principal = ui.getUsername();
        Object principal = authenticationToken.getPrincipal();
        return new SimpleAuthenticationInfo(principal, userLogin.getPassword(), realmName);
    }

    private Leader tokenToUser(UsernamePasswordToken authcToken) {
        Leader leader = new Leader();
        leader.setName(authcToken.getUsername());
        leader.setPassword(String.valueOf(authcToken.getPassword()));
        return leader;
    }

    /**
     * get set
     */
    public LeaderService getLeaderService() {
        return leaderService;
    }

    public void setLeaderService(LeaderService leaderService) {
        this.leaderService = leaderService;
    }
}
