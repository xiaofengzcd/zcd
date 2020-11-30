package com.zcd.controller;


import com.zcd.model.User;

import com.zcd.service.UserService;
import com.zcd.util.VerifyCodeUtils;
import com.zcd.zcdutil.JsonUtilzcd;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
*
 * @author zcd
 * @description: description
 * @create 2020/10/27
*/
@RestController
@RequestMapping("/user2")
public class UserController2
 {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(){
        return JsonUtilzcd.getJson("CESHI");
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
//http://localhost:8080/maven02_war_exploded/user2/login?username=root&password=123456&verifyCode=LDWCT
     @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
 public String login( @RequestParam(defaultValue = "root",required = false) String username,
                      @RequestParam(defaultValue = "123456",required = false) String password,
                      @RequestParam(defaultValue = "",required = false) String verifyCode
 ){
     //String verificationCode = VerifyCodeUtils.generateVerifyCode(5);
     User user = userService.login(username,password,verifyCode);
     System.out.println(user);
     //      System.out.println(verificationCode);

     if(user == null){
         return JsonUtilzcd.getJson("用户名或者密码错误");
     }
     else if(!verifyCode.equals(user.getVerifyCode())){
         return JsonUtilzcd.getJson("验证码错误");
     }
     else {
         return JsonUtilzcd.getJson("登录成功");
     }
 }

@RequestMapping(value = "/getVerifyCode",produces = "application/json;charset=utf-8")
    public String getVerifyCode(){
        final String verificationCode = VerifyCodeUtils.generateVerifyCode(5);
        userService.updateByVerifyCode(verificationCode);
        return JsonUtilzcd.getJson(verificationCode);
    }


     @RequestMapping(value = "/add",produces = "application/json;charset=utf-8")
     public String add(
                        @RequestParam(required = false) User user
     ) throws FileNotFoundException {
         user = new User();
         user.setUsername("王二小");
         user.setPassword("root");
         user.setAge(22);

         if(user != null && !user.getUsername().equals("")
                 && !user.getPassword().equals("")
                 && user.getAge()!= null) {


              //网上的说法是不要把图片放数据库,把图片存服务器上 ,然后数据库存图片地址
             /*File file = new File("C:\\Users\\Administrator\\Desktop\\demo.png");
             FileInputStream input = new FileInputStream(file);
             user.setHeadImage(input);*/
             user.setVerifyCode("LDWCT");


           //  我这里原先是想着获取用户的信息然后传到mapper里去查询的,,结果一直跑不通,后来参考别人的代码
             //发现其实传个user对象就行了, mapper那里是能获取到用户的信息的
             // 前面跑不通的原因我估计是 mapper的参数类型是user 而我传的是具体的用户信息,定义的是string和int
             userService.insert(user /*user.getUsername(), user.getPassword(), user.getAge(), user.getVerifyCode()*/);
             System.out.println(user);
             return JsonUtilzcd.getJson("添加成功");
         }else {
             return JsonUtilzcd.getJson("添加失败");
         }
         //      System.out.println(verificationCode);

     }


/**
     * @author zcd
     * @description: 仅做测试shiro用
     * @create 2020/10/27
     */

    @RequestMapping("/login3")
    public String login3( String username ,  String password, Model model){

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

     /**
      * 保存用户信息
      *@description:
      * spring boot 报错 nested exception is java.lang.NoClassDefFoundError: javax/el/ELManager
      * 删除tomcat目录下面 lib文件中的el-api.jar文件，重启服务即可
      * 项目一直报bean注入失败,导致项目无法启动,将此段代码注释后仍旧是报注入失败,并导致旧有可运行的代码无法正常运行
      * 不十分清楚原因何在,总之删掉tomcat的el-api.jar文件后,旧有代码可正常运行(一直正常运行的index.jsp挂掉了~~~~)
      * 暂且注释掉该段代码,换个方向发展
      * jsp挂掉,目测是 el-api.jar被删掉,里面的el表达式挂掉
      * 不难看出是依赖冲突了,但至于为何以前不冲突,现在冲突,最近也没添加什么依赖
      * 正解: (不用删tomcat的el jar包)添加依赖,降低hibernate版本和新增el-api依赖
      * 将删除的代码还原,依旧报bean注入失败,将代码注释,依旧报错,删除,就不报了,可能是xml文件还会加载,搞不清楚
     <dependency>
     <groupId>org.hibernate</groupId>
     <artifactId>hibernate-validator</artifactId>
     <version>5.1.0.Final</version>
     </dependency>
     <dependency>
     <groupId>javax.el</groupId>
     <artifactId>javax.el-api</artifactId>
     <version>2.2.4</version>
     </dependency>
      *
      * @param tbUser
      * @author zcd
      * @create 2020/11/24
      */
/*@RequestMapping(value = "save", method = RequestMethod.POST)
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
    }*/


 }
