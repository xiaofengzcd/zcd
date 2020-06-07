package com.zcd.git;

/**
 * /**
 *
 * @author zcd
 * @description: TODO
 * @date 2019/12/23 10:46
 */
public class GitTest {

    /**
     * 在项目文件上右击,git Bush Here
     * git相关命令:
     * git init  首次提交项目时初始化git
     * git add .   将文件添加到git上, "." 这个点目测是所有文件的意思
     * git add README.md   看样子是提交添加具体某个文件,但结果好像其它文件的修改也提交上去了...
     * git config --global user.email "1849493899@qq.com"  告诉git你是谁,一般第一次使用时需用到
     * git config --global user.name "xiaofengzcd"     global: 全球的,即国际通用的意思
     * git commit -m "给提交命名"
     * git remote add origin https://github.com/xiaofengzcd/zcd.git 将git连接到你的github地址
     * git push -u origin master   -u目测是提交到后面的某个具体枝干上,本人后面的项目更新直接 git push即可
     *
     * 所以我后面的更新流程就是 :
     * git add .
     * git commit -m "提交内容介绍"
     * git push
     * xiaofengzcd
     * wazl512zcd
     *
     *
     * @link https://www.cnblogs.com/shenchanghui/p/7184101.html  参考链接
     *
     *
     * 关于github被墙和push失败,有可能是代理的问题,网上一搜就是
     * 可使用以下命令:
     * git config --global http.proxy http://127.0.0.1:1080
     * git config --global https.proxy http://127.0.0.1:1080
     * 取消代理设置:
     * git config --global --unset http.proxy
     * git config --global --unset https.proxy
     *
     * 我踩过的坑:
     * 上面的方法不行,无需设置,需更改windows下的hosts文件 地址：C:\Windows\System32\Drivers\etc
     * 复制hosts文件到桌面,修改,再复制回原目录,替换
     * 新增以下:
     * #github
     * 192.30.253.112 github.com
     * 151.101.185.194 github.global.ssl.fastly.net
     *
     * 上面两个IP地址,可访问 http://github.com.ipaddress.com/
     * http://github.global.ssl.fastly.net.ipaddress.com/ 获得
     *
     * @link https://jingyan.baidu.com/article/11c17a2cfb88d6f446e39d82.html
     *
     */
   public void git(){
       System.out.println("测试git有无反应");
       System.out.println("再测试一次");
   }

}
