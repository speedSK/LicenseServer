package cn.zifangsky.license;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

/**
 * License生成类需要的参数
 *
 * @author zifangsky
 * @date 2018/4/19
 * @since 1.0.0
 */
public class LicenseCreatorParam implements Serializable {

    private static final long serialVersionUID = -7793154252684580872L;
    /**
     * 证书subject
     */
    @Value("${license.subject}")
    private String subject;

    /**
     * 密钥别称
     */
    @Value("${license.privateAlias}")
    private String privateAlias;

    /**
     * 密钥密码（需要妥善保管，不能让使用者知道）
     */
    @Value("${license.keyPass}")
    private String keyPass;

    /**
     * 访问秘钥库的密码
     */
    @Value("${license.storePass}")
    private String storePass;

    /**
     * 证书生成路径
     */
    @Value("${license.licensePath}")
    private String licensePath;

    /**
     * 密钥库存储路径
     */
    @Value("${license.privateKeysStorePath}")
    private String privateKeysStorePath;

    /**
     * 证书生效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Value("${license.issuedTime}")
    private Date issuedTime = new Date();

    /**
     * 证书失效时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Value("${license.expiryTime}")
    private Date expiryTime;

    /**
     * 用户类型
     */
    @Value("${license.consumerType}")
    private String consumerType = "user";

    /**
     * 用户数量
     */
    @Value("${license.consumerAmount}")
    private Integer consumerAmount = 1;

    /**
     * 描述信息
     */
    @Value("${license.description}")
    private String description = "";

    /**
     * 额外的服务器硬件校验信息
     */
    private LicenseCheckModel licenseCheckModel;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPrivateAlias() {
        return privateAlias;
    }

    public void setPrivateAlias(String privateAlias) {
        this.privateAlias = privateAlias;
    }

    public String getKeyPass() {
        return keyPass;
    }

    public void setKeyPass(String keyPass) {
        this.keyPass = keyPass;
    }

    public String getStorePass() {
        return storePass;
    }

    public void setStorePass(String storePass) {
        this.storePass = storePass;
    }

    public String getLicensePath() {
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    public String getPrivateKeysStorePath() {
        return privateKeysStorePath;
    }

    public void setPrivateKeysStorePath(String privateKeysStorePath) {
        this.privateKeysStorePath = privateKeysStorePath;
    }

    public Date getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(Date issuedTime) {
        this.issuedTime = issuedTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getConsumerType() {
        return consumerType;
    }

    public void setConsumerType(String consumerType) {
        this.consumerType = consumerType;
    }

    public Integer getConsumerAmount() {
        return consumerAmount;
    }

    public void setConsumerAmount(Integer consumerAmount) {
        this.consumerAmount = consumerAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LicenseCheckModel getLicenseCheckModel() {
        return licenseCheckModel;
    }

    public void setLicenseCheckModel(LicenseCheckModel licenseCheckModel) {
        this.licenseCheckModel = licenseCheckModel;
    }

    @Override
    public String toString() {
        return "LicenseCreatorParam{" +
                "subject='" + subject + '\'' +
                ", privateAlias='" + privateAlias + '\'' +
                ", keyPass='" + keyPass + '\'' +
                ", storePass='" + storePass + '\'' +
                ", licensePath='" + licensePath + '\'' +
                ", privateKeysStorePath='" + privateKeysStorePath + '\'' +
                ", issuedTime=" + issuedTime +
                ", expiryTime=" + expiryTime +
                ", consumerType='" + consumerType + '\'' +
                ", consumerAmount=" + consumerAmount +
                ", description='" + description + '\'' +
                ", licenseCheckModel=" + licenseCheckModel +
                '}';
    }
}
