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
     *
     * @link https://www.cnblogs.com/shenchanghui/p/7184101.html  参考链接
     */
   public void git(){
       System.out.println("测试git有无反应");
       System.out.println("再测试一次");
   }

}
