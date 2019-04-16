package cn.zifangsky.common;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.apache.commons.lang3.StringUtils;

import cn.zifangsky.license.LicenseCheckModel;
import cn.zifangsky.license.LicenseCreatorParam;

public class LicenseUtils {
	
	public static LicenseCreatorParam processLicenseCreatorParam(Class resourceClass,List<String> macAddressList){
		LicenseCreatorParam param = new LicenseCreatorParam();
		Properties prop = new Properties();
		InputStream in = resourceClass.getResourceAsStream("/license-config.properties");
		try{
			prop.load(in);
			//获取生成证书参数
			if(StringUtils.isBlank(param.getSubject())){
				param.setSubject(prop.getProperty("license.subject"));
			}
			if(StringUtils.isBlank(param.getPrivateAlias())){
				param.setPrivateAlias(prop.getProperty("license.privateAlias"));
			}
			if(StringUtils.isBlank(param.getKeyPass())){
				param.setKeyPass(prop.getProperty("license.keyPass"));
			}
			if(StringUtils.isBlank(param.getStorePass())){
				param.setStorePass(prop.getProperty("license.storePass"));
			}
			if(StringUtils.isBlank(param.getLicensePath())){
				param.setLicensePath(prop.getProperty("license.licensePath"));
			}
			if(StringUtils.isBlank(param.getPrivateKeysStorePath())){
				param.setPrivateKeysStorePath(prop.getProperty("license.privateKeysStorePath"));
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				param.setIssuedTime(sdf.parse(prop.getProperty("license.issuedTime")));
				param.setExpiryTime(sdf.parse(prop.getProperty("license.expiryTime")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(StringUtils.isBlank(param.getConsumerType())){
				param.setConsumerType(prop.getProperty("license.consumerType"));
			}
			if(param.getConsumerAmount()!=null){
				param.setConsumerAmount(Integer.valueOf(prop.getProperty("license.consumerAmount")));
			}
			//自定义检验参数
			LicenseCheckModel checkModel = new LicenseCheckModel();
			checkModel.setMacAddress(macAddressList);
			param.setLicenseCheckModel(checkModel);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}finally {
				try {
					if(in!=null){
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return param;
	}
}
