package com.pinyu.miniprogram.global;

public class GlobalConstants {
	
	/**项目环境*/
	public static final String PROFILE_ACTIVE_TEST="test";//测试
	public static final String PROFILE_ACTIVE_DEV="dev";//正式

	/**菜单级别*/
	public static final Integer MENU_LEVEL_FIRST=1;//一级菜单（顶级菜单）
	public static final Integer MENU_LEVEL_SECOND=2;//二级菜单
	/**男女*/
	public static final Integer SEX_HIM=0;//男
	public static final Integer SEX_SHE=1;//女
	/**男女*/
	public static final Integer STATE_UN_ACTIVE=0;//禁用
	public static final Integer STATE_ACTIVE=1;//启用
	/**删除状态*/
	public static final Integer DELETE_STATE_UNDELETED=1; //默认 未删除
	public static final Integer DELETE_STATE_DELETED=2; //删除
	/**房源类型*/
	public static final Integer DISTRIBUTION_TYPE_FOCUS=1;//集中式房源
	public static final Integer DISTRIBUTION_TYPE_DISPERSIVE=2;//分散式房源
	/**审批状态*/
	public static final Integer APPROVAL_STATUS_ADOPT=1;//审批通过
	public static final Integer APPROVAL_STATUS_REFUSE=0;//审批拒绝（驳回）
	/**房屋用途*/
	public static final Integer BUILDING_TYPE_RESIDENCE=1;//住宅
	public static final Integer BUILDING_TYPE_BUSINESS=2;//商用
	 /**合同状态*/
	public static final Integer CONTRACT_STATUS_UNSIGNED =0;//未签合同
	public static final Integer CONTRACT_STATUS_SIGNED =1;//已签合同
	/**是否可以编辑*/
	public static final Integer MODIFIABLE =0;//可修改可编辑
	public static final Integer NON_MODIFIABLE =1;//不可修改不可编辑
	/**合同类型*/
	public static final String CONTRACT_LANDLORD ="landlord";//房东
	public static final String CONTRACT_TENANT ="tenant";//租客
	/**付款方式*/
	public static final Integer MONTH_PAYMENT=0;//月付
	public static final Integer QUARTERLY_PAYMENT=1;//季付
	public static final Integer HALF_YEAR_PAYMENT=2;//半年付
	public static final Integer YEAR_PAYMENT=3;//年付
	/**付款月数*/
	public static final Integer MONTH_PAYMENT_MONTH_NUNM=1;//月付
	public static final Integer QUARTERLY_PAYMENT_MONTH_NUNM=3;//季付
	public static final Integer HALF_YEAR_PAYMENT_MONTH_NUNM=6;//半年付
	public static final Integer YEAR_PAYMENT_MONTH_NUNM=12;//年付
	/**保洁类型*/
	public static final String DAILY_CLEANING="DAILY_CLEANING";//日常保洁
	public static final String DEEP_CLEANING="DEEP_CLEANING";//深度保洁
	public static final String PROFESSIONAL_REMOVAL_MITES="PROFESSIONAL_REMOVAL_MITES";//专业除螨
	public static final String CLEANING_CLEANING="CLEANING_CLEANING";//消杀保洁
	public static final String SINGLE_ITEM_CLEANING="SINGLE_ITEM_CLEANING";//单项保洁
	/**保洁维修*/
	public static final Integer CLEAINGING=1;//保洁
	public static final Integer REPAIR=2;//维修
	/**推荐房屋*/
	public static final Integer NOT_RECOMMENDED=0;//不推荐
	public static final Integer RECOMMENDED=1;//推荐
	/**房东租客*/
	public static final Integer MENBER_LANDLORD=4;//房东
	public static final Integer MENBER_TENANT=3;//租客
	
	/**租客账户默认支付银行卡状态*/
	public static final Integer MEMBER_CARD_DEFAULT=1;//默认
	public static final Integer MEMBER_CARD_NON_DEFAULT=0;//非默认
	/**流程实例禁用-启用*/
	public static final Integer BPM_ACTIVE_YES=2;//启用
	public static final Integer BPM_ACTIVE_NO=1;//禁用
	/**订单交易类型*/
	public static final Integer WECAT_PAY=1;//微信
	public static final Integer ALI_PAY=2;//支付宝
	public static final Integer UNION_PAY=3;//银联
	/**订单类型 1房东账单2租客账单3保洁4维修5押金*/
	public static final Integer ORDER_TYPE_LANDLORD=1;//房东账单
	public static final Integer ORDER_TYPE_TENANT=2;//租客账单
	public static final Integer ORDER_TYPE_SERVER_CLEAINGING_=3;//保洁
	public static final Integer ORDER_TYPE_SERVER_REPAIR=4;//维修
	public static final Integer ORDER_TYPE_DEPOSIT=5;//押金
	
	/**消息模板code*/
	public static final String BILL_INFORMATION="0001"; //租客账单推送(租客端接受)
	public static final String ACCEPT_CANCEL_CLEANING="0002"; //保洁订单接受/取消(租客端接受)
	public static final String ACCEPT_CANCEL_REPAIR="0003"; //维修订单接受/取消(租客端接受)
	public static final String CLEANING_PAY="0004"; //保洁订单付款(租客端接受)
	public static final String REPAIR_PAY="0005"; //维修订单付款(租客端接受)
	public static final String SEEING_COMMENT="0006"; //约看评论反馈(租客端接受)
	public static final String REAL_NAME_AUTH="0007"; //实名认证(租客端接受)
	public static final String BINDING_BANK_CARD="0008"; //绑定银行卡(租客端接受)
	public static final String ASSIGN_SEEING="0009"; //指派约看管家(租客端接受)
	public static final String WAIT_SEE="0010"; //约看跟进(管理端接受)
	public static final String RENTER_CONTRACT_EXAMINE="0011"; //租客合同审核(管理端接受)
	public static final String RENTER_CONTRACT_SIGNING="0012"; //租客合同审核(租客端接受)
	public static final String CLEANING_COMMENT="0013"; //保洁评论反馈(租客端接受)
	public static final String REPAIR_COMMENT="0014"; //维修评论反馈(租客端接受)
	public static final String LANDLORD_CONTRACT_EXAMINE="0015"; //房东合同审核(管理端接受)
	public static final String LANDLORD_CONTRACT_SIGNING="0016"; //房东合同审核(租客端接受)
	public static final String HOUSE_RESOURCE_EXAMINE="0017"; //房源审核信息(管理端接受)
	public static final String BILL_INFORMATION_MESSAGE="0018"; //租客账单房租(短信)
	
	public static final Integer APP_RENTER=1; //租客端
	public static final Integer APP_HOUSEKEEPER=2; //管理端
	 
	
	/**
	 * 权限放行的路径
	 * @author admin
	 *
	 */
	public enum PermissionRelease {
		
		INDEXMAIN(99999, "/index/main/","首页",2),
	
		INDEX(1, "/index/","首页",1), INDEX_NOTAUTHENTICATION(2, "/index/notAuthentication/","无权限提示页",1),
		USER_UPDATEPWD(3,"/user/updatePwd/", "修改密码",1),INDEX_LOGOUT(4,"/index/logout/", "退出",0), 
		LOGIN(5, "/login/","登录",0),REGISTER(6, "/register/","注册",0), KAPTCHA(7, "/kaptcha/","验证码",0),
		TENANTBILLBACK(7, "/tenantBillBack/","代收结果通知",0),GENQRCDOE(7, "/login/genQRcode/","生成登录二维码",0)
		,LOGINQRCODE(8, "/login/loginQRcode/","二维码登录",0),MAINMENUSEARCH(9, "/menu/search/","主页菜单搜索框",1);
		private Integer id;
		private String url;
		private String desc;
		private Integer type;
		
		private PermissionRelease() {
		}

		private PermissionRelease(Integer id, String url, String desc,Integer type) {
			this.id = id;
			this.url = url;
			this.desc = desc;
			this.type = type;
		}

		public Integer getId() {
			return id;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public void setId(Integer id) {
			this.id = id;
		}
		
	}
	
	/**
	 * 日志分类
	 * @author admin
	 *
	 */
	public enum LogType {
	
		OPERATING(1, "OPERATING","用户操作日志"), SYS(2, "SYS","系统日志"),
		JTA(3,"JTA", "JTA日志"),QUARTZ(4,"QUARTZ", "定时任务");
		private Integer id;
		private String type;
		private String desc;
		
		private LogType() {
		}

		private LogType(Integer id, String type, String desc) {
			this.id = id;
			this.type = type;
			this.desc = desc;
		}

		public Integer getId() {
			return id;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	}
	
	/**
	 * 文件格式类型
	 * @author ypp
	 */
	public class FileType{
		/**PDF文件*/
		public static final String FILE_PDF ="PDF";
		/**图片格式*/
		public static final String IMAGE_BMP ="BMP";
		public static final String IMAGE_JPG ="JPG";
		public static final String IMAGE_JPEG ="JPEG";
		public static final String IMAGE_GIF ="GIF";
		public static final String IMAGE_PSD ="PSD";
		public static final String IMAGE_PNG ="PNG";
		public static final String IMAGE_TGA ="TGA";
		public static final String IMAGE_TIFF ="TIFF";

	}
	
	public enum UserCodeType {
		
		ADMIN(1, "ADMIN","超级管理员"),SYSADMIN(2, "SYSADMIN","系统管理员"),ROLEMANAGE(3,"ROLEMANAGER", "角色管理员"),
		
		PYGM(4,"PYGM", "品寓管家(APP管理员)"),
		
		ACCOUNTING(5, "ACCOUNTING","会计"),
		
		OPERATOR(6,"OPERATOR", "运营人员"),OPERATION_SUPERVISOR(7,"OPERATIONSUPERVISOR", "运营主管"),
		OPERATION_MANAGER(8,"OPERATIONMANAGER", "运营经理"),OPERATION_DIRECTOR(9,"OPERATIONDIRECTOR", "运营总监"),
		
		REGION(10,"REGION", "区域人员"),REGION_SUPERVISOR(11,"REGIONSUPERVISOR", "区域主管"),
		REGION_MANAGER(12,"PYGM", "区域经理"),REGION_DIRECTOR(13,"REGIONDIRECTOR", "区域总监"),
		
		SALESMAN(14,"SALESMAN", "业务员"),SALESMAN_SUPERVISOR(15,"SALESMANSUPERVISOR", "业务主管"),
		SALESMAN_MANAGER(16,"SALESMANMANAGER", "业务经理"),SALESMAN_DIRECTOR(17,"SALESMANDIRECTOR", "业务总监"),
		
		DESIGNER(18,"DESIGNER", "设计师"),DESIGNER_SUPERVISOR(19,"DESIGNERSUPERVISOR", "设计主管"),
		DESIGNER_MANAGER(20,"DESIGNERMANAGER", "设计经理"),DESIGNER_DIRECTOR(21,"DESIGNERDIRECTOR", "设计总监"),
		
		CUSTOMER_SERVICE(22,"CUSTOMERSERVICE", "客服专员"),CUSTOMER_SERVICE_SUPERVISOR(23,"CUSTOMERERVICESUPERVISOR", "客服主管"),
		CUSTOMER_SERVICE_MANAGER(24,"CUSTOMERSERVICEMANAGER", "客服经理"),CUSTOMER_SERVICE_DIRECTOR(25,"CUSTOMERSERVICEDIRECTOR", "客服总监"),
		
		CUSTOMER(26,"CUSTOMER", "客户专员"),CUSTOMER_SUPERVISOR(27,"CUSTOMERSUPERVISOR", "客户主管"),
		CUSTOMER_MANAGER(28,"CUSTOMERMANAGER", "客户经理"),CUSTOMER_DIRECTOR(29,"CUSTOMERDIRECTOR", "客户总监"),
		
		FINANCE(30,"FINANCE", "财务专员"),FINANCE_SUPERVISOR(31,"FINANCESUPERVISOR", "财务主管"),
		FINANCE_MANAGER(32,"FINANCEMANAGER", "财务经理"),FINANCE_DIRECTOR(33,"FINANCEDIRECTOR", "财务总监"),
		
		ZH_FINANCE(34,"ZHFINANCE", "中海财务专员"),ZH_FINANCE_SUPERVISOR(35,"ZHFINANCESUPERVISOR", "中海财务主管"),
		ZH_FINANCE_MANAGER(36,"ZHFINANCEMANAGER", "中海财务经理"),ZH_FINANCE_DIRECTOR(37,"ZHFINANCEDIRECTOR", "中海财务总监"),
		
		DEFAULT(38, "DEFAULT","普通人员");
		
		private Integer typeId;
		private String code;
		private String desc;

		private UserCodeType() {
		}

		private UserCodeType(Integer typeId, String code, String desc) {
			this.typeId = typeId;
			this.code = code;
			this.desc = desc;
		}

		public Integer getTypeId() {
			return typeId;
		}

		public void setTypeId(Integer typeId) {
			this.typeId = typeId;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	public enum ButtonPosition {
		HEAD_TOP_NAVIGATION(1, "HEADTOPNAVIGATION", "顶部按钮"), DATA_LINE(2, "DATALINE", "数据行按钮"),INFO_MODAL(3, "INFO_MODAL", "弹窗按钮");
		private Integer typeId;
		private String identification;
		private String desc;

		private ButtonPosition() {
		}

		private ButtonPosition(Integer typeId, String identification, String desc) {
			this.typeId = typeId;
			this.identification = identification;
			this.desc = desc;
		}

		public Integer getTypeId() {
			return typeId;
		}

		public void setTypeId(Integer typeId) {
			this.typeId = typeId;
		}

		public String getIdentification() {
			return identification;
		}

		public void setIdentification(String identification) {
			this.identification = identification;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

	}

	public enum PermissionCode {
		ADD(1, "ADD", "添加"), EDIT(2, "EDIT", "编辑"), DELETE(3, "DELETE", "删除"), 
		SEARCH(4,"SEARCH", "查询"), EXPORT(5, "EXPORT", "导出"), IMPORT(6, "IMPORT", "导入"), 
		APPROVAL(7,"APPROVAL", "审核"), UPLOAD(8, "UPLOAD", "上传"), RESET(9, "RESET","重置"), 
		BATCH_DELETE(10, "BATCHDELETE", "批量删除"), BATCH_UPDATE(11, "BATCHUPDATE","批量更新"),
		BATCH_ADD(12, "BATCHADD", "批量添加"),SHOW(13,"SHOW","查看"),
		SHOW_TEMPLATE(14,"SHOWTEMPLATE","查看模板"),HISTORY_TEMPLATE(15,"HISTORYTEMPLATE","历史模板"),
		UPLOAD_TEMPLATE(16,"UPLOADTEMPLATE","上传模板"),DOWNLOAD(17,"DOWNLOAD","下载"),
		
		CONTRACT_ADDED(18,"CONTRACTADDED","已添加合同"),CONTRACT_APPROVAL(19,"CONTRACTAPPROVAL","合同审核通过"),
		SHELVES(20,"SHELVES","上架"),SALE(21,"SALE","下架"),
		BATCH_SHELVES(22,"BATCHSHELVES","批量上架"),BATCH_SALE(23,"BATCHSALE","批量下架"),
		CONTRACT_APPROVAL_REJECT(24,"CONTRACTAPPROVALREJECT","合同审核驳回"),
		CONTRACT_APPROVAL_INVALID(25,"CONTRACTAPPROVALINVALID","合同审核作废"),
		APPROVAL_ADOPT(26,"APPROVALADOPT","审核通过"),APPROVAL_REJECT(27,"APPROVALREJECT","审核驳回"),
		INVALID(28,"INVALID","作废"),ADOPT(29,"ADOPT","通过"),
		REJECT(30,"REJECT","驳回"),SHOW_PERMISSION(31,"SHOWPERMISSION","查看权限"),
		DETAIL(32,"DETAIL","查看详情"),REFRESH(33,"REFRESH","刷新");

		private Integer typeId;
		private String code;
		private String desc;

		private PermissionCode() {
		}

		private PermissionCode(Integer typeId, String code, String desc) {
			this.typeId = typeId;
			this.code = code;
			this.desc = desc;
		}

		public Integer getTypeId() {
			return typeId;
		}

		public void setTypeId(Integer typeId) {
			this.typeId = typeId;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

	}
	
	/**
	 * @author renxr
	 * 性别
	 */
	public enum SexStatus {
		MALE(0, "男"), FEMALE(1, "女");
		private Integer status;
		private String desc;

		private SexStatus() {
		}
		
		private SexStatus(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}
		
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	public enum Confim {
		YES("yes", "是"), NO("no", "否");
		private String name;
		private String desc;

		private Confim() {
		}
		
		private Confim(String name, String desc) {
			this.name = name;
			this.desc = desc;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
		
	}
	
	/**
	 * @author renxr
	 * 是否已租入
	 */
	public enum IsRented {
		NOT_RENTING(0, "未租"), ALREADY_RENTED(1, "已租");
		private Integer status;
		private String desc;

		private IsRented() {
		}
		
		private IsRented(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}
		
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	 * @author renxr
	 * 是否验证通过
	 */
	public enum ValidateFlag {
		UNVERIFIED(0, "未验证"), VERIFY_THROUGH(1, "验证通过"), VALIDATION_NOT_PASSED(2, "验证不通过");
		private Integer status;
		private String desc;

		private ValidateFlag() {
		}
		
		private ValidateFlag(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}
		
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	 * @author renxr
	 * 是否实名认证
	 */
	public enum IsRealAuth {
		NON_REAL_AUTH(0, "否"), REAL_AUTH(1, "是");
		private Integer status;
		private String desc;

		private IsRealAuth() {
		}
		
		private IsRealAuth(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}
		
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	 * @author renxr
	 * 是否加入黑名单
	 */
	public enum IsBlacked {
		NO_BLACKLIST(0, "未加入黑名单"), BLACKLIST_HAS_BEEN(1, "已加入黑名单");
		private Integer status;
		private String desc;

		private IsBlacked() {
		}
		
		private IsBlacked(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}
		
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**
	 * @author ypp
	 * 用户状态
	 */
	public enum UserStatus {
		ACTIVED(1, "启用"), UNACTIVED(-1, "禁用");
		private Integer status;
		private String desc;

		private UserStatus() {
		}

		private UserStatus(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

	}
	
	/**
	 * 付款方式
	 */
	public enum PayMethod{
		MONTH_PAYMENT(0, "MONTH_PAYMENT","月付"), QUARTERLY_PAYMENT(1, "QUARTERLY_PAYMENT","季付"),
		HALF_YEAR_PAYMENT(2,"HALF_YEAR_PAYMENT", "半年付"), YEAR_PAYMENT(3,"YEAR_PAYMENT", "年付");
		private Integer id;
		private String code;
		private String desc;
		
		private PayMethod() {
		}

		private PayMethod(Integer id, String code, String desc) {
			this.id = id;
			this.code = code;
			this.desc = desc;
		}

		public Integer getId() {
			return id;
		}

		public void setTypeId(Integer id) {
			this.id = id;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	
	/**
	 * 
	 * @author ypp
	 *	房源朝向
	 */
	public enum HouseResourceCrientation {
		
		EAST(1, "EAST","东"), WEST(2, "WEST","西"),NORTH(3,"NORTH", "北"),SOUTH(4,"SOUTH", "南"),
		NORTHEAST(1, "NORTHEAST","东北"), SOUTHEAST(2, "SOUTHEAST","东南"),
		NORTHWEST(3,"NORTHWEST", "西北"),SOUTHWEST(4,"SOUTHWEST", "西南");
		private Integer id;
		private String code;
		private String desc;

		private HouseResourceCrientation() {
		}
		private HouseResourceCrientation(Integer id, String code, String desc) {
			this.id = id;
			this.code = code;
			this.desc = desc;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	 * @author ypp
	 *	房源出租方式
	 */
	public enum HouseResourceRentingStyle {
		WHOLE_RENT(1, "WHOLE_RENT","整租"), JOINT_RENT(2, "JOINT_RENT","合租");
		private Integer id;
		private String code;
		private String desc;
		
		private HouseResourceRentingStyle() {
		}
		private HouseResourceRentingStyle(Integer id, String code, String desc) {
			this.id = id;
			this.code = code;
			this.desc = desc;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	/**
	 * @author ypp
	 *	楼层类型
	 */
	public enum HouseResourceStoreyType {
		LOWFLOOR(1, "LOWFLOOR","低楼层"), MIDDLEFLOOR(2, "MIDDLEFLOOR","中楼层"),HIGHFLOOR(3, "HIGHFLOOR","高楼层");
		private Integer id;
		private String code;
		private String desc;
		
		private HouseResourceStoreyType() {
		}
		private HouseResourceStoreyType(Integer id, String code, String desc) {
			this.id = id;
			this.code = code;
			this.desc = desc;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	 * @author ypp
	 * 房源类型’hardcover’,精装修 ’rinsing’,清水房 ’simplicity’简装修，'reform'：改造
	 */
	public enum HomeType{
		HARDCOVER(1, "hardcover","精装修"), RINSING(2, "rinsing","清水房"),SIMPLICITY(3, "simplicity","简装修") ,REFORM(4, "reform","改造");
		private Integer id;
		private String code;
		private String desc;
		
		private HomeType() {
		}
		private HomeType(Integer id, String code, String desc) {
			this.id = id;
			this.code = code;
			this.desc = desc;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	/***
	 * @author ypp
	 * 房源类型
	 */
	public enum HouseResourceHouseType{
		OLD(1, "OLD","老旧房"), ROUGH(2, "ROUGH","毛坯房");
		private Integer id;
		private String code;
		private String desc;
		
		private HouseResourceHouseType() {
		}
		private HouseResourceHouseType(Integer id, String code, String desc) {
			this.id = id;
			this.code = code;
			this.desc = desc;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	/***
	 * @author ypp
	 * 装修状态
	 */
	public static class HouseResourceProcessStatus{
		public static final Integer NEED_DECORATION =0;//需要装修设计
		public static final Integer DECORATIONING =1;//装修中
		public static final Integer DECORATION_FINISH =2;//装修已完成
	}

	/**
	 * @author renxr
	 * 合同状态
	 */
	public enum ContractStatus {
		BE_SINGNED_UP(1, "待签约"), IN_REVIEW(2, "审核中"), REJECT(3, "驳回"), REVIEW_PASS(4, "审核通过"), 
		SIGNED_CONTRACT(6, "已签约"), EXPIRED(9, "已过期"), TO_VOID(10, "作废");
		private Integer status;
		private String desc;

		private ContractStatus() {
		}
		
		private ContractStatus(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}
		
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}	
	
	/**
	 * @author renxr
	 * 房源审核
	 */
	public enum HouseExamine {
		TO_BE_AUDITED(1, "待审核"), EXAMINE_PASS(2, "审核通过"), EXAMINE_REJECT(3, "驳回"), ALREADY_ASSIGNED(4, "已指派");
		private Integer status;
		private String desc;

		private HouseExamine() {
		}
		
		private HouseExamine(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}
		
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}	
	
	/**
	 * @author renxr
	 * 租金推送
	 */
	public enum PushPayrent {
		NO_PUSH_TO_PAYRENT(0, "未推送交租"), HAS_BEEN_PUSHED_PAYRENT(1, "已推送交租");
		private Integer status;
		private String desc;

		private PushPayrent() {
		}
		
		private PushPayrent(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}
		
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	 * @author renxr
	 * 交付定金/总金额 支付状态
	 */
	public enum PayMoneyStatus {
		UNDELIVERED(0, "未支付"), ALREADY_DELIVERED(1, "已支付"),DELIVERED_FAIL(2, "支付失败");
		private Integer status;
		private String desc;

		private PayMoneyStatus() {
		}
		
		private PayMoneyStatus(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}
		
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	 * @author renxr
	 * 保洁维修订单状
	 */
	public enum CleanRepairStatus {
		SUBMISSION(1, "已提交"), BEEN_CANCELLED(2, "已取消"), PENDING_PAYMENT(3, "待付款"), 
		COMPLETED(4, "已付款"), RECEIPT(5, "已接单"), BEEN_EVALUATED(6, "已评价");
		private Integer status;
		private String desc;

		private CleanRepairStatus() {
		}
		
		private CleanRepairStatus(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}
		
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	 * @author renxr
	 * 房屋状态
	 */
	public enum HomeStatus {
		NOT_SHELF(0, "未上架"), ALREADY_SHELF(1, "已上架"), ALREADY_RENTED(2, "已出租"), 
		ALREADY_DOWN(3, "已下架"), TO_PERFECTED_INFORMATION(4, "信息待完善");
		private Integer status;
		private String desc;

		private HomeStatus() {
		}
		
		private HomeStatus(Integer status, String desc) {
			this.status = status;
			this.desc = desc;
		}
		
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	/**
	 * 房东账单状态
	 * @author admin
	 *
	 */
	public enum HrLandlordOrderState {
	
		APPROVAL(1, "APPROVAL","未发送"), IN_SIDE_APPROVALING(2, "IN_SIDE_APPROVALING","内部审核中"),
		IN_SIDE_APPROVAL_REFUSE(3,"IN_SIDE_APPROVAL_REFUSE", "内部审核未通过"), 
		OUT_SIDE_APPROVALING(4,"OUT_SIDE_APPROVALING", "外部审核中"), OUT_SIDE_APPROVALING_REFUSE(5, "OUT_SIDE_APPROVALING_REFUSE","外部审核未通过"), 
		PAYING(6, "PAYING","付款中"), PAYED(7, "PAYED","已付款"), PENDING_PAYMENT(8, "PENDING_PAYMENT","待付款");
		private Integer id;
		private String code;
		private String desc;
		
		private HrLandlordOrderState() {
		}

		private HrLandlordOrderState(Integer id, String code, String desc) {
			this.id = id;
			this.code = code;
			this.desc = desc;
		}

		public Integer getId() {
			return id;
		}

		public void setTypeId(Integer id) {
			this.id = id;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	/**
	 * 房东合同物管费承担
	 * @author admin
	 *
	 */
	public static class CtLandlordContractTube {
		/**装修期*/
		public static final Integer RENOVATION_LANDLORD_TUBE_TRUE=1;//房东承担
		public static final Integer RENOVATION_LANDLORD_TUBE_FALSE=2;//房东不承担
		/**空置期*/
		public static final Integer VACANT_LANDLORD_TUBE_TRUE=1;//房东承担
		public static final Integer VACANT_LANDLORD_TUBE_FALSE=2;//房东不承担
		
	}
	/**
	 * 房东账单
	 * @author admin
	 *
	 */
	public static class HrLandlordOrder {
		/**装修期*/
		public static final Integer FEE_TYPE_RENOVATION=1;//装修期物管费
		public static final Integer FEE_TYPE_VACANT=2;//空置期物管费
		public static final Integer FEE_TYPE_RENT=3;//租金（包含物管费）
		
	}
	
	/**
	 * 约看签约状态
	 * @author renxr
	 *
	 */
	public static class LookSigningType {
		public static final Integer BE_SINGNED_UP=1;//待签约
		public static final Integer EXPIRED=2;//已废弃（已过期）
	}
		
}
