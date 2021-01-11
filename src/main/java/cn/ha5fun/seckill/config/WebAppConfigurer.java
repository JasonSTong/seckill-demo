package cn.ha5fun.seckill.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
 
	
	@Bean
    public HttpMessageConverter responseBodyConverter(){
		//解决返回值中文乱码
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		WebMvcConfigurer.super.configureMessageConverters(converters);
		/**
		 * 1.先定义一个convert转换消息的对象
		 * 2.添加fastjson的配置信息，比如：是否要格式化返回的json数据
		 * 3.在convertzhong 添加配置信息
		 * 4.将convert添加到converters当中
		 */
		//1.先定义一个convert转换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//2.添加fastjson的配置信息，比如：是否要格式化返回的json数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		//处理中文乱码问题(不然出现中文乱码)
		List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastMediaTypes);

		//3.在convertzhong 添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		//4.将convert添加到converters当中
		converters.add(fastConverter);
	}
}