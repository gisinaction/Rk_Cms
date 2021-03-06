package com.rekoe.cms;

//https://github.com/howe/
/**
 * cd D:\MongoDB
　　> mongod --dbpath D:\MongoDB\data 

git@github.com:Rekoe/rkCms.git
 */
import org.nutz.extras.mvc.JSONPViewMaker;
import org.nutz.extras.mvc.init.MyUrlMappingImpl;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.LoadingBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.UrlMappingBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.impl.NutLoading;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
import org.nutz.mvc.view.FreemarkerViewMaker;
import org.nutz.mvc.view.JPEGViewMaker;
import org.nutz.web.ajax.AjaxViewMaker;

import com.rekoe.cms.filter.AuthorityFilter;

@Modules(scanPackage=true)
@UrlMappingBy(MyUrlMappingImpl.class)
@LoadingBy(NutLoading.class)
@Ok("ioc:json")
@Fail("ioc:json")
@IocBy(type=ComboIocProvider.class,args={
	"*org.nutz.ioc.loader.json.JsonLoader","ioc/",
	"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","com.rekoe.cms"})
@Filters({
	@By(type=AuthorityFilter.class)
})
@Localization("msg")
@Encoding(input="UTF-8",output="UTF-8")
@SetupBy(StartSetup.class)
@Views({FreemarkerViewMaker.class,JPEGViewMaker.class,JSONPViewMaker.class,AjaxViewMaker.class})
public class MainModule {
	
}
