package cn.ha5fun.seckill;

import cn.ha5fun.seckill.utils.MD5Utils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
/**
 * @author chen
 * @Company ha5fun.com
 * @Description test
 * @Date 2020/12/24 7:03 下午
 * @Version 1.0.0
 */
public class testclass<T> {

    private static Logger logger = LoggerFactory.getLogger(testclass.class);

    private static final String YOUDAO_URL_UPLOAD = "https://openapi.youdao.com/file_trans/upload";

    private static final String YOUDAO_URL_QUERY = "https://openapi.youdao.com/file_trans/query";

    private static final String YOUDAO_URL_DOWNLOAD = "https://openapi.youdao.com/file_trans/download";

    private static final String APP_KEY = "2bb564d0942a21d1";

    private static final String APP_SECRET = "m2Rpuzw3Y1ffJK2ERqzqsWIMjJIrgDer";

//    public static void main(String[] args) throws IOException {
//        upload();
//        query();
//        download();
//    }
    @Test
    public void upload() throws IOException {
//        System.out.printf();
        Map<String,String> params = new HashMap<String,String>();
        String q = loadAsBase64("/Users/chencong/Downloads/a23-qadah.pdf");
        String salt = "chensitong";
        String curtime = String.valueOf(System.currentTimeMillis() / 1000);
        String signStr = APP_KEY + truncate(q) + salt + curtime + APP_SECRET;
        String sign = getDigest(signStr);
        params.put("q", q);
        params.put("fileName", "a23-qadah.pdf");
        params.put("fileType", "pdf");
        params.put("langFrom", "en");
        params.put("langTo", "zh-CHS");
        params.put("appKey", APP_KEY);
        params.put("salt", salt);
        params.put("curtime", curtime);
        params.put("sign", sign);
        params.put("docType", "json");
        params.put("signType", "v3");
        String result = requestForHttp(YOUDAO_URL_UPLOAD, params);
        /** 处理结果 */
        System.out.println(result);
    }
    @Test
    public void query() throws IOException {
        Map<String,String> params = new HashMap<String,String>();
        String flownumber = "B7D06002E9E9438B86AA393FCEC90C9F";
        String salt = "chensitong";
        String curtime = String.valueOf(System.currentTimeMillis() / 1000);
        String signStr = APP_KEY + truncate(flownumber) + salt + curtime + APP_SECRET;
        String sign = getDigest(signStr);
        params.put("flownumber", flownumber);
        params.put("appKey", APP_KEY);
        params.put("salt", salt);
        params.put("curtime", curtime);
        params.put("sign", sign);
        params.put("docType", "json");
        params.put("signType", "v3");
        String result = requestForHttp(YOUDAO_URL_QUERY, params);
        /** 处理结果 */
        System.out.println(result);
    }
    @Test
    public void download() throws IOException {
        Map<String,String> params = new HashMap<String,String>();
        String flownumber = "B7D06002E9E9438B86AA393FCEC90C9F";
        String salt = "chensitong";
        String curtime = String.valueOf(System.currentTimeMillis() / 1000);
        Long changeTime = (System.currentTimeMillis() / 1000)+20 ;

        String signStr = APP_KEY + truncate(flownumber) + salt + changeTime.toString() + APP_SECRET;
        String sign = getDigest(signStr);
        System.out.println(System.currentTimeMillis());
        System.out.println(curtime);
        System.out.println(changeTime+20);
        System.out.println(flownumber);
        System.out.println(sign);
        params.put("flownumber", flownumber);
        params.put("downloadFileType", "文件下载类型");
        params.put("appKey", APP_KEY);
        params.put("salt", salt);
        params.put("curtime", curtime);
        params.put("sign", sign);
        params.put("docType", "json");
        params.put("signType", "v3");
//        String result = requestForHttp(YOUDAO_URL_DOWNLOAD, params);
//        /** 处理结果 */
//        System.out.println(result);
    }
    public static String requestForHttp(String url,Map<String,String> params) throws IOException {
        String result = "";
        System.out.println();
        /** 创建HttpClient */
        CloseableHttpClient httpClient = HttpClients.createDefault();

        /** httpPost */
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
        Iterator<Map.Entry<String,String>> it = params.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> en = it.next();
            String key = en.getKey();
            String value = en.getValue();
            paramsList.add(new BasicNameValuePair(key,value));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(paramsList,"UTF-8"));
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try{
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity,"UTF-8");
            EntityUtils.consume(httpEntity);
        }finally {
            try{
                if(httpResponse!=null){
                    httpResponse.close();
                }
            }catch(IOException e){
                logger.info("## release resouce error ##" + e);
            }
        }
        return result;
    }
    /**
     * 生成加密字段
     */
    public static String getDigest(String string) {
        if (string == null) {
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] btInput = string.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest mdInst = MessageDigest.getInstance("SHA-256");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String loadAsBase64(String imgFile)
    {//将文件转化为字节数组字符串，并对其进行Base64编码处理

        File file = new File(imgFile);
        if(!file.exists()){
            logger.error("文件不存在");
            return null;
        }
        InputStream in = null;
        byte[] data = null;
        //读取文件字节数组
        try
        {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        return Base64.getEncoder().encodeToString(data);//返回Base64编码过的字节数组字符串
    }

    public static String truncate(String q) {
        if (q == null) {
            return null;
        }
        int len = q.length();
        String result;
        return len <= 20 ? q : (q.substring(0, 10) + len + q.substring(len - 10, len));
    }




//    @Aspect
//    @Component //必须加上这个注解，否则spring无法注入
//    @Slf4j
//    public class ValidatedAspect {
//        @Pointcut("execution(public * com.privatecloud.privatecloudwlw.controller..*.*Valid*(..))")
//        public void validatedAspect(){}
//
//        @Around("validatedAspect()")//对方法进行拦截---返回类型看方法的返回类型 可以设置Object spring会自动判断
//        public ResponseEntity trackInfo(ProceedingJoinPoint pjp) throws Throwable {
//            Object[] args = pjp.getArgs();
//            //规定最后一位就是拦截的绑定效验类
//            BindingResult bindingResult=(BindingResult) args[args.length-1];
//            String errorStr="";
//            //表单验证检测
//            if (bindingResult.hasErrors()) {
//                bindingResult.getFieldErrors();
//                List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//                for (FieldError error : fieldErrors) {
//                    errorStr=error.getField()+":"+error.getDefaultMessage()+" "+errorStr;
//                }
//                return new ResponseEntity(errorStr,HttpStatus.BAD_REQUEST);
//            }
//            //所有验证通过
//            ResponseEntity result=(ResponseEntity)pjp.proceed();
//            return result;
//        }
    public List<Object> test(Object... objects){
        List<Object> any = new ArrayList<>();
        any.addAll(Arrays.asList(objects));
        return any;
    }
    @Test
    public void UUIDUtils() {
        System.out.println();
    }
    @Test
    public void test1(){
        List<Object> test = test("abcd", "bcfrfe", "dasdasd");

    }

}
