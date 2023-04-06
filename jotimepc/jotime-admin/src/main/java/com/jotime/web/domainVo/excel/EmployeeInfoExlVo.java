package com.jotime.web.domainVo.excel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jotime.common.annotation.Excel;
import com.jotime.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 员工信息对象 employee_info
 *
 * @author ruoyi
 * @date 2021-11-24
 */
public class EmployeeInfoExlVo extends BaseEntity
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

    /** 部门 */
    @Excel(name = "部门",width = 13)
    private String deptName;

    /** 分组 */
    @Excel(name = "分组")
    private String groupName;

    /** 职务 */
    @Excel(name = "职位",width = 10)
    private String positionCode;

    /** 性别1 男 2 女 3未知 */
    @Excel(name = "性别1男 2女 3未知")
    private String sex;

    /** 入厂时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入厂时间 yyyy-MM-dd", width = 20, dateFormat = "yyyy-MM-dd")
    private Date joinDate;

    /** 在职状态  0:正常 1:离职 */
    @Excel(name = "在职状态 0在职 1离职 2产假 ",width = 30)
    private String jobStatus;

    /** 工龄 */
    @Excel(name = "工龄")
    private BigDecimal lengthService;

    /** 年龄 */
    @Excel(name = "年龄")
    private BigDecimal age;

    /** 婚姻01 未婚 02 已婚 03 未知 */
    @Excel(name = "婚姻 01未婚  02已婚  03未知")
    private String marriage;

    /** 学历01 小学 02初中 03高中 04 大专 05本科 06 硕士 07博士 */
    @Excel(name = "学历 01 小学 02初中 03高中 04 大专 05本科 06 硕士 07博士")
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
    @Excel(name = "劳动合同开始 yyyy-MM-dd", width = 20, dateFormat = "yyyy-MM-dd")
    private Date contractEffective;

    /** 合同结束 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "劳动合同结束 yyyy-MM-dd", width = 20, dateFormat = "yyyy-MM-dd")
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

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    /** 离职时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dimissionDate;

    /** 离职原因 01-被用人单位解除 02-双方协商一致解除 03-本人意愿解除 04-退休 05-其他*/
    @Excel(name = "离职原因 01被用人单位解除 02双方协商一致解除 03本人意愿解除 04退休 05其他")
    private String leaveReason;

    /** 离职原因描述 */
    @Excel(name = "离职原因描述")
    private String reasonDec;

    /** 语言/技能 */
    @Excel(name = "语言/技能")
    private String skills;

    /** 邮箱 */
//    @Excel(name = "邮箱")
    private String email;

    /** 车间ID */
//    @Excel(name = "车间编号")
    private String workshopCode;

    /** 职位 */
//    @Excel(name = "职位")
    private Long positionId;

    /** 岗位名称 */
//    @Excel(name = "职称")
    private String postName;


    /** 入职承诺书 Y 已签  N 未签 */
//    @Excel(name = "入职承诺书 已签  未签")
    private String letterCommitment;

    /** 保密廉洁协议 Y 已签  N 未签 */
//    @Excel(name = "保密廉洁协议 已签  未签")
    private String confidentialityAgreement;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkshopCode() {
        return workshopCode;
    }

    public void setWorkshopCode(String workshopCode) {
        this.workshopCode = workshopCode;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
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

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDimissionDate() {
        return dimissionDate;
    }

    public void setDimissionDate(Date dimissionDate) {
        this.dimissionDate = dimissionDate;
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

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
