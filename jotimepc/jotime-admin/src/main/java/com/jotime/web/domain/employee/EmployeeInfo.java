package com.jotime.web.domain.employee;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 员工信息对象 employee_info
 *
 * @author ruoyi
 * @date 2021-11-24
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工信息内码 */
    private Long id;

    /** 员工编码 */
    @Excel(name = "员工工号")
    private String employeeCode;

    /** 员工姓名 */
    @Excel(name = "姓名")
    private String employeeName;

    /** 部门id */
    @Excel(name = "部门")
    private Long deptId;

    /** 车间ID */
//    @Excel(name = "车间ID")
    private Long workshopId;

    /** 班组id */
    @Excel(name = "分组")
    private Long groupId;

    /** 职务 */
    @Excel(name = "职位")
    private Integer positionalTitles;

    /** 性别1 男 2 女 3未知 */
    @Excel(name = "性别1 男 2 女 3未知")
    private Integer sex;

    /** 入职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date joinDate;

    /** 在职状态  0在职 1离职 2产假 */
    @Excel(name = "在职状态 0在职 1离职 2产假")
    private Integer jobStatus;

    /** 工龄 */
    @Excel(name = "工龄")
    private BigDecimal lengthService;

    /** 年龄 */
    @Excel(name = "年龄")
    private BigDecimal age;

    /** 婚姻01 未婚 02 已婚 03 未知 */
    @Excel(name = "婚姻01 未婚 02 已婚 03 未知")
    private String marriage;

    /** 学历00实习 01 小学 02初中 03高中 04 大专 05本科 06 硕士 07博士 */
    @Excel(name = "学历00实习 01 小学 02初中 03高中 04 大专 05本科 06 硕士 07博士")
    private String education;

    /** 民族 */
    @Excel(name = "民族")
    private String nationality;

    /** 政治面貌01 中国共产党 02中国预备党员 03 共青团员 04 民革党员 05 民盟盟员 06 民建会员 07 民进会员 08 农工党党员 09 致公党党员 10 九三学社社员 11 台盟盟员 12 无党派人士 13 群众 */
    @Excel(name = "政治面貌01 中国共产党 02中国预备党员 03 共青团员 04 民革党员 05 民盟盟员 06 民建会员 07 民进会员 08 农工党党员 09 致公党党员 10 九三学社社员 11 台盟盟员 12 无党派人士 13 群众")
    private String politicalStatus;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String nativePlace;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 户口所在地 */
    @Excel(name = "户口所在地")
    private String homePlace;

    /** 实际居住地 */
    @Excel(name = "实际居住地")
    private String address;

    /** 寄送地址 */
    @Excel(name = "寄送地址")
    private String mailingAddress;

    /** 合同开始 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "劳动合同开始 ", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractEffective;

    /** 合同结束 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "劳动合同结束", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractExpiration;

    /** 手机号 */
    @Excel(name = "联系方式")
    private String mobileNumber;

    /** 毕业学校 */
    @Excel(name = "毕业学校")
    private String graduateSchool;

    /** 专业 */
    @Excel(name = "专业")
    private String specialty;

    /** 毕业时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "毕业时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date graduationDate;

    /** 职称 */
    @Excel(name = "职称")
    private String professional;

    /** 语言/技能 */
    @Excel(name = "语言/技能")
    private String skills;

    /** 离职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离职时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dimissionDate;

    /** 离职原因 */
    @Excel(name = "离职原因")
    private String leaveReason;

    /** 离职原因描述 */
    @Excel(name = "离职原因描述")
    private String reasonDec;


    /** 职位 */
//    @Excel(name = "职位")
    private Long positionId;

    /** 入职承诺书 Y 已签  N 未签 */
//    @Excel(name = "入职承诺书 Y 已签  N 未签")
    private String letterCommitment;

    /** 保密廉洁协议 Y 已签  N 未签 */
//    @Excel(name = "保密廉洁协议 Y 已签  N 未签")
    private String confidentialityAgreement;

    /** 附件 */
//    @Excel(name = "附件")
    private String attachmentUrl;

    /** 是否有签字模板,1没有2有 */
//    @Excel(name = "是否有签字模板,1没有2有")
    private Integer isSignatureTemplate;

    /** 状态,1禁用2正常 */
//    @Excel(name = "状态,1禁用2正常")
    private Integer status;

    /** 备注 */
//    @Excel(name = "备注")
    private String note;

    /** 创建者 */
//    @Excel(name = "创建者")
    private String createBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;

    /** 更新者 */
//    @Excel(name = "更新者")
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateTime;

    /** 邮箱 */
//    @Excel(name = "邮箱")
    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    private String email;


    @TableField(exist = false)
    private List<String> userIds;

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setEmployeeCode(String employeeCode)
    {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeCode()
    {
        return employeeCode;
    }
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setWorkshopId(Long workshopId)
    {
        this.workshopId = workshopId;
    }

    public Long getWorkshopId()
    {
        return workshopId;
    }
    public void setPositionId(Long positionId)
    {
        this.positionId = positionId;
    }

    public Long getPositionId()
    {
        return positionId;
    }
    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setJoinDate(Date joinDate)
    {
        this.joinDate = joinDate;
    }

    public Date getJoinDate()
    {
        return joinDate;
    }

    public Date getContractEffective() {
        return contractEffective;
    }

    public void setContractEffective(Date contractEffective) {
        this.contractEffective = contractEffective;
    }

    public Date getContractExpiration() {
        return contractExpiration;
    }

    public void setContractExpiration(Date contractExpiration) {
        this.contractExpiration = contractExpiration;
    }

    public Date getDimissionDate() {
        return dimissionDate;
    }

    public void setDimissionDate(Date dimissionDate) {
        this.dimissionDate = dimissionDate;
    }

    public void setJobStatus(Integer jobStatus)
    {
        this.jobStatus = jobStatus;
    }

    public Integer getJobStatus()
    {
        return jobStatus;
    }
    public void setAttachmentUrl(String attachmentUrl)
    {
        this.attachmentUrl = attachmentUrl;
    }

    public String getAttachmentUrl()
    {
        return attachmentUrl;
    }
    public void setIsSignatureTemplate(Integer isSignatureTemplate)
    {
        this.isSignatureTemplate = isSignatureTemplate;
    }

    public Integer getIsSignatureTemplate()
    {
        return isSignatureTemplate;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setNote(String note)
    {
        this.note = note;
    }

    public String getNote()
    {
        return note;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLetterCommitment() {
        return letterCommitment;
    }

    public void setLetterCommitment(String letterCommitment) {
        this.letterCommitment = letterCommitment;
    }

    public String getConfidentialityAgreement() {
        return confidentialityAgreement;
    }

    public void setConfidentialityAgreement(String confidentialityAgreement) {
        this.confidentialityAgreement = confidentialityAgreement;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public BigDecimal getLengthService() {
        return lengthService;
    }

    public void setLengthService(BigDecimal lengthService) {
        this.lengthService = lengthService;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHomePlace() {
        return homePlace;
    }

    public void setHomePlace(String homePlace) {
        this.homePlace = homePlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getReasonDec() {
        return reasonDec;
    }

    public void setReasonDec(String reasonDec) {
        this.reasonDec = reasonDec;
    }

    public Integer getPositionalTitles() {
        return positionalTitles;
    }

    public void setPositionalTitles(Integer positionalTitles) {
        this.positionalTitles = positionalTitles;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "id=" + id +
                ", employeeCode='" + employeeCode + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", deptId=" + deptId +
                ", workshopId=" + workshopId +
                ", groupId=" + groupId +
                ", positionId=" + positionId +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", lengthService=" + lengthService +
                ", age=" + age +
                ", marriage='" + marriage + '\'' +
                ", nationality='" + nationality + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", idCard='" + idCard + '\'' +
                ", birthday=" + birthday +
                ", homePlace='" + homePlace + '\'' +
                ", address='" + address + '\'' +
                ", mailingAddress='" + mailingAddress + '\'' +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", specialty='" + specialty + '\'' +
                ", graduationDate=" + graduationDate +
                ", professional='" + professional + '\'' +
                ", joinDate=" + joinDate +
                ", dimissionDate=" + dimissionDate +
                ", leaveReason='" + leaveReason + '\'' +
                ", reasonDec='" + reasonDec + '\'' +
                ", contractEffective=" + contractEffective +
                ", contractExpiration=" + contractExpiration +
                ", skills='" + skills + '\'' +
                ", positionalTitles=" + positionalTitles +
                ", education='" + education + '\'' +
                ", letterCommitment='" + letterCommitment + '\'' +
                ", confidentialityAgreement='" + confidentialityAgreement + '\'' +
                ", jobStatus=" + jobStatus +
                ", attachmentUrl='" + attachmentUrl + '\'' +
                ", isSignatureTemplate=" + isSignatureTemplate +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", userIds=" + userIds +
                '}';
    }
}
