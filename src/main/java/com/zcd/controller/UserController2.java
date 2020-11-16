package com.zcd.controller;

import com.zcd.abstracts.AbstractBaseController;
import com.zcd.base.BaseEntity;
import com.zcd.dto.BaseResult;
import com.zcd.model.TbUser;
import com.zcd.model.User;
import com.zcd.service.IUserService;
import com.zcd.service.ShopService;
import com.zcd.service.TbUserService;
import com.zcd.util.VerifyCodeUtils;
import com.zcd.zcdutil.JsonUtilzcd;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.enterprise.deploy.spi.DeploymentConfiguration;

 /**
      * @author zcd
      * @description: description
      * @create 2020/10/27
      */
@RestController
@RequestMapping("/user2")
public class UserController2 extends AbstractBaseController<TbUser, TbUserService> {

     @Autowired
     private IUserService userService;

    @RequestMapping("/test")
    public String test(){
        return JsonUtilzcd.getJson("CESHI");
    }

    /**
     * 保存用户信息
     *
     * @param tbUser
     * @return
     */

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @Override
    public String save(@RequestParam(defaultValue = "",required = false) TbUser tbUser, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(tbUser);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return JsonUtilzcd.getJson(baseResult);
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
           return JsonUtilzcd.getJson(baseResult.getStatus());
        }
    }


     /**
      * 我这里name 传英文字符串的话,是可以正常查询的,但如果name是中文的字符串,
      * 查出来的结果是个中括号,debug显示list里size为0,但是却不为null,
      * (如果是null的话,结果会是提示没这个人)
      * 初步得出结论,
      * 1.英文行,中文不行
      * 解决: url=jdbc:mysql://localhost:3306/zcx?useUnicode=true&characterEncoding
      * =utf8&characterSetResults=utf8
      * 原项目里的jdbc.properties文件里缺失关于字符编码的配置(坑逼啊!)
      *
      *
      * 2.即便查不到,这个list为空好像也不为null,暂且使用user.size() == 0作为判断条件代替
      *
      * list为空和null的区别,参考下面链接,这里虽然没查到东西,但list还是在的
      * 因此可用 isEmpty 或者 size等方法判断
      * @link https://www.cnblogs.com/linjiaxin/p/6104214.html
      *
      */

     //手动输入地址访问
     @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
     public String login( @RequestParam(defaultValue = "root",required = false) String username,
                          @RequestParam(defaultValue = "123456",required = false) String password,
                          @RequestParam(defaultValue = "",required = false) String verifyCode
     ){
         String verificationCode = VerifyCodeUtils.generateVerifyCode(5);
         User user = userService.login(username,password,verifyCode);
         System.out.println(user);
         System.out.println(verificationCode);

         if(user == null){
             return JsonUtilzcd.getJson("用户名或者密码错误");
         }
         else if(!verifyCode.equals(verificationCode)){
             return JsonUtilzcd.getJson("验证码错误");
         }
         else {
             return JsonUtilzcd.getJson("登录成功");
         }


     }


     @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
     public String getVerifyCode(){
         return JsonUtilzcd.getJson(VerifyCodeUtils.generateVerifyCode(5));
     }



     /**
          * @author zcd
          * @description: 仅做测试shiro用
          * @create 2020/10/27
          */
    @RequestMapping("/login")
    public String login( String username ,  String password, Model model){

        username = "root";
        password = "123456";
        //获取当前用户
        final Subject subject = SecurityUtils.getSubject();

        //封装用户数据
        final UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try{
            subject.login(token); // 执行登陆方法,若果没问题即代表ok
            return JsonUtilzcd.getJson("成功");
        }catch (UnknownAccountException e){
            return JsonUtilzcd.getJson("失败");
        }


    }


    @Override
    public String list() {
        return null;
    }

    @Override
    public String form() {
        return null;
    }



    @Override
    public BaseResult delete(String ids) {
        return null;
    }

    @Override
    public String detail() {
        return null;
    }
}
