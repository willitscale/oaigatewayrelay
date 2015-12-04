package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands.Command;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Device;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Agent;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Feature;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.DND;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.HuntGroup;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Node;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Trunk;
import uk.co.n3tw0rk.oaigatewayrelay.events.acknowledgement.Confirmation;

/**
 * <strong>Query List Extended Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 28-12-2014
 */
public class QueryListExtended extends Command {
	/** Command */
	public final static String COMMAND = "_QX";

	public final static int ENTITY_OFFSET = 9;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex
     * 1 		Station List 		N/A 		<Extension> 				N/A
     * 								0 			<|Username|> 				1
     * 								1  			<|Description|> 			2
     * 								2  			<Attendant> 				4
     * 								3  			<Is_An_Adminstrator> 		8
     * 								4  			<Is_An_Attendant> 			10
     * 								5  			<Day_COS_Flags> 			20
     * 								6  			<Night_COS_Flags> 			40
     * 								7  			<Voice_Mail_Extension> 		80
     * 								8  			<Device_Type> 				100
     * 								9 			<Mailbox_Node_Number> 		200
     * 								10 			<Physical_Device_Type>   	400
     */
    public final static int LIST_TYPE_STATION_LIST = 0x01;

    public final static int MASK_STATION_LIST_USER = 0x001;
    public final static int MASK_STATION_LIST_DESC = 0x002;
    public final static int MASK_STATION_LIST_ATTEND = 0x004;
    public final static int MASK_STATION_LIST_IS_ADMIN = 0x008;
    public final static int MASK_STATION_LIST_IS_ATTEND = 0x010;
    public final static int MASK_STATION_LIST_DAY_FLAGS = 0x020;
    public final static int MASK_STATION_LIST_NIGHT_FLAGS = 0x040;
    public final static int MASK_STATION_LIST_VOICE_MAIL = 0x080;
    public final static int MASK_STATION_LIST_DEVICE_TYPE = 0x100;
    public final static int MASK_STATION_LIST_MAILBOX_NODE = 0x200;
    public final static int MASK_STATION_LIST_PHYSICAL_DEVICE = 0x400;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex
     * 2 		Trunk List 			N/A 		<Extension>					N/A
     *                              0 			<|Username|> 				1
     *                              1 			<|Description|> 			2
     *                              2 			<Answer_Supervision_Type> 	4
     */
    public final static int LIST_TYPE_TRUNK_LIST = 0x02;

    public final static int MASK_TRUNK_LIST_USER = 0x001;
    public final static int MASK_TRUNK_LIST_DESC = 0x002;
    public final static int MASK_TRUNK_LIST_ANS_SUPERVISION = 0x004;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex
     * 3 		Hunt Group List 	N/A 		<Extension> 				N/A
     *                              0 			<|Username|> 				1
     *                              1 			<|Description|> 			2
     *                              2 			<Hunt_Group_Type> 			4
     *                              3 			<Number_Of_Members> 		8
     *                              4 			<Mailbox_Node_Number> 		10
     */
    public final static int LIST_TYPE_HUNT_GROUP_LIST = 0x03;

    public final static int MASK_HUNT_GROUP_LIST_USER = 0x001;
    public final static int MASK_HUNT_GROUP_LIST_DESC = 0x002;
    public final static int MASK_HUNT_GROUP_LIST_HUNT_GROUP = 0x004;
    public final static int MASK_HUNT_GROUP_LIST_MEMBERS = 0x008;
    public final static int MASK_HUNT_GROUP_LIST_MAILBOX = 0x010;

    /** 
     * Val. 	Description 		Bit # 		Field 						Hex
     * 4 		Trunk Group List 	N/A 		<Extension>					N/A
     *                              0 			<|Username|> 				1
     *                              1 			<|Description|> 			2
     *                              2 			<Number_Of_Members> 		4
     */
    public final static int LIST_TYPE_TRUNK_GROUP_LIST = 0x04;

    public final static int MASK_HUNT_TRUNK_LIST_USER = 0x001;
    public final static int MASK_HUNT_TRUNK_LIST_DESC = 0x002;
    public final static int MASK_HUNT_TRUNK_LIST_MEMBERS = 0x004;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 5 		Page Zone List 		N/A 		<Extension> 				N/A
     *                              0 			<|Username|>                1
     *                              1 			<|Description|>             2
     *                              2 			<Number_Of_Members>         4
     */
    public final static int LIST_TYPE_PAGE_ZONE_LIST = 0x05;

    public final static int MASK_PAGE_ZONE_LIST_USER = 0x001;
    public final static int MASK_PAGE_ZONE_LIST_DESC = 0x002;
    public final static int MASK_PAGE_ZONE_LIST_MEMBERS = 0x004;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 6        Page Port List      N/A         <Extension>                 N/A
     * 								0 			<|Username|>                1
     * 								1 			<|Description|>             2
     */
    public final static int LIST_TYPE_PAGE_PORT_LIST = 0x06;

    public final static int MASK_PAGE_PORT_LIST_USER = 0x001;
    public final static int MASK_PAGE_PORT_LIST_DESC = 0x002;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 7 		Unassociated Voice 	N/A 		<Mailbox_Number>			N/A
     *          Mailbox List
     *                              0           <|Username|>                1
     *                              1           <|Description|>             2
     */
    public final static int LIST_TYPE_VOICE_MAILBOX_LIST = 0x06;

    public final static int MASK_VOICE_MAILBOX_LIST_USER = 0x001;
    public final static int MASK_VOICE_MAILBOX_LIST_DESC = 0x002;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 8        Feature List        N/A         <Feature_Code>              N/A
     *                              0           <Feature_Number> (Logical)  1
     *                              1           <Feature_Name>              2
     *                              2           <Is_Administrator_Feature>  4
     *                              3           <Is_Directory_Feature>      8
     *                              4           <Is_Diagnostic_Feature>     10
     *                              5           <Is_Toggleable_Feature>     20
     */
    public final static int LIST_TYPE_FEATURE_LIST = 0x08;

    public final static int MASK_FEATURE_LIST_FEAT_NUM = 0x001;
    public final static int MASK_FEATURE_LIST_FEAT_NAME = 0x002;
    public final static int MASK_FEATURE_LIST_IS_ADMIN = 0x004;
    public final static int MASK_FEATURE_LIST_IS_DIR = 0x008;
    public final static int MASK_FEATURE_LIST_IS_DIAG = 0x010;
    public final static int MASK_FEATURE_LIST_IS_TOGGLE = 0x020;

    /** 
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 9        Speed-Dial Bin List N/A         <Bin_Number>                N/A
     *                               0          <Bin_Contents>              1
     *                               1          <|Bin_Name|>                2
     */
    public final static int LIST_TYPE_SPEED_DIAL_LIST = 0x09;

    public final static int MASK_SPEED_DIAL_LIST_CONTENTS = 0x001;
    public final static int MASK_SPEED_DIAL_LIST_NAME = 0x002;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 10       DND Message List    N/A         <DND_Message_Number>        N/A
     *                              0           <|DND_Message_Text|>        1
     */
    public final static int LIST_TYPE_DND_LIST = 0x0A;

    public final static int MASK_DND_LIST_MESSAGE = 0x001;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 11       Reminder Message    N/A         <Reminder_Message_Number>   N/A
     *          List 
     *                               0          <|Reminder_Message_Text|>   1
     */
    public final static int LIST_TYPE_REMINDER_LIST = 0x0B;

    public final static int MASK_REMINDER_LIST_MESSAGE = 0x001;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 12       Voice Mail          N/A         <Extension>                 N/A
     *          Application List
     *                              0           <|Username|>                1
     *                              1           <|Description|>             2
     *                              2           <Application_Type>          4
     */
    public final static int LIST_TYPE_VOICE_MAIL_APPLICATION_LIST = 0x0C;

    public final static int MASK_VOICE_MAIL_APPLICATION_LIST_USER = 0x001;
    public final static int MASK_VOICE_MAIL_APPLICATION_LIST_DESC = 0x002;
    public final static int MASK_VOICE_MAIL_APPLICATION_LIST_APP_TYPE = 0x004;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 13       Private Networking  N/A         <Extension>                 N/A
     *          Trunk List
     *                              0           <|Username|>                1
     *                              1           <|Description|>             2
     */
    public final static int LIST_TYPE_PRIVATE_NETWORKING_TRUNK_LIST = 0x0D;

    public final static int MASK_PRIVATE_NETWORKING_TRUNK_LIST_USER = 0x001;
    public final static int MASK_PRIVATE_NETWORKING_TRUNK_LIST_DESC = 0x002;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 14       Private Networking  N/A         <Extension>                 N/A
     *          Trunk Group List
     *                              0           <|Username|>                1
     *                              1           <|Description|>             2
     *                              2           <Number_Of_Members>         4
     */
    public final static int LIST_TYPE_PRIVATE_NETWORKING_TRUNK_GROUP_LIST = 0x0E;

    public final static int MASK_PRIVATE_NETWORKING_TRUNK_GROUP_LIST_USER = 0x001;
    public final static int MASK_PRIVATE_NETWORKING_TRUNK_GROUP_LIST_DESC = 0x002;
    public final static int MASK_PRIVATE_NETWORKING_TRUNK_GROUP_LIST_MEMBERS = 0x004;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 15       Off-Node Device     N/A         <Node: Extension>           N/A
     *          List 
     *                              0           <Device_Type>               1
     *                              1           <|Username|>                2
     *                              2           <|Description|>             4
     *                              3           <Mailbox_Node_Number>       8
     */
    public final static int LIST_TYPE_OFF_NODE_DEVICE_LIST = 0x0F;

    public final static int MASK_OFF_NODE_DEVICE_LIST_DEV_TYPE = 0x001;
    public final static int MASK_OFF_NODE_DEVICE_LIST_USER = 0x002;
    public final static int MASK_OFF_NODE_DEVICE_LIST_DESC = 0x004;
    public final static int MASK_OFF_NODE_DEVICE_LIST_MAILBOX = 0x008;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 16       System COS Flag     N/A         <Flag_Number>               N/A
     *                              0           <|Description|>             1
     */
    public final static int LIST_TYPE_SYSTEM_COS_FLAG = 0x10;

    public final static int MASK_SYSTEM_COS_FLAG_DESC = 0x001;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex
     * 17       ACD Agent           N/A         <Agent_ID>                  N/A
     * 	                            0           <|Description|>             1
     */
    public final static int LIST_TYPE_ACD_AGENT = 0x11;

    public final static int MASK_ACD_AGENT_DESC = 0x01;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 18       Node Data           N/A         <Network_Node_Number>       N/A
     *                              0           <|Description|>             1
     *                              1           <Networking_Enabled/Disabled> 2
     *                              2           <Protocol_Version>          4
     *                              3           <KSU_SW_Version>            8
     *                              4           <Premium_Feature_Status>    10
     *                              5           <Country_Code>              20
     *                              6           <TCPIP_Indicator>           40
     *                              7           <Voice_Mail_Status>         80
     *                              8           <Max_Parties_in_Conference> 100
     */
    public final static int LIST_TYPE_NODE_DATA = 0x12;

    public final static int MASK_NODE_DATA_DESC = 0x001;
    public final static int MASK_NODE_DATA_NET_EN = 0x002;
    public final static int MASK_NODE_DATA_PROTOCOL = 0x004;
    public final static int MASK_NODE_DATA_KSU_SW = 0x008;
    public final static int MASK_NODE_DATA_PREM = 0x010;
    public final static int MASK_NODE_DATA_COUNTRY = 0x020;
    public final static int MASK_NODE_DATA_TCPIP = 0x040;
    public final static int MASK_NODE_DATA_VOICE_MAIL = 0x080;
    public final static int MASK_NODE_DATA_MAX_PARTIES = 0x100;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 19       Network Information N/A         <Network_Node_Number>       N/A
     *                              0           <|Node_Description|>        1
     *                              1           <|IP_Address|>              2
     *                              2           <TCP_Port>                  4
     *                              3           <|Redundant_IP_Address|>    8
     *                              4           <Redundant_TCP_Port>        10
     *                              5           <System_OAI_Sockets_Enabled> 20
     *                              6           <Max_Supported_System_OAI_Sockets> 40
     *                              7           <Protocol_Version>          80
     *                              8           <KSU_SW_Version>            100
     *                              9           <Premium_Feature_Status>    200
     */
    public final static int LIST_TYPE_NETWORK_INFORMATION = 0x13;

    public final static int MASK_NETWORK_INFORMATION_NODE_DESC = 0x001;
    public final static int MASK_NETWORK_INFORMATION_IP = 0x002;
    public final static int MASK_NETWORK_INFORMATION_TCP = 0x004;
    public final static int MASK_NETWORK_INFORMATION_REDUNDANT_IP = 0x008;
    public final static int MASK_NETWORK_INFORMATION_REDUNDANT_TCP = 0x010;
    public final static int MASK_NETWORK_INFORMATION_SOCKETS_ENABLED = 0x020;
    public final static int MASK_NETWORK_INFORMATION_MAX_SOCKETS = 0x040;
    public final static int MASK_NETWORK_INFORMATION_PROTOCOL = 0x080;
    public final static int MASK_NETWORK_INFORMATION_KSU_SW = 0x100;
    public final static int MASK_NETWORK_INFORMATION_PREM = 0x200;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 20       IPRC and            N/A         <Extension>                 N/A
     *          IP Connections
     *                              0           <|Username|>                1
     *                              1           <|Description|>             2
     */
    public final static int LIST_TYPE_IPRC_AND_IP_CONNECTIONS = 0x14;

    public final static int MASK_IPRC_AND_IP_CONNECTIONS_USER = 0x001;
    public final static int MASK_IPRC_AND_IP_CONNECTIONS_DESC = 0x002;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 21       User                N/A         <Main_Extension>            N/A
     *                              0           <|First_Name|>              1
     *                              1           <|Last_Name|>               2
     *                              2           <|Email_Address|>           4
     *                              3           <|Login|>                   8
     *                              4           <Is_Personal_Call_Routing_Enabled> 10
     *                              5           <Mobile_Email_Address>      20
     */
    public final static int LIST_TYPE_USER = 0x15;

    public final static int MASK_USER_FIRST_NAME = 0x001;
    public final static int MASK_USER_LAST_NAME = 0x002;
    public final static int MASK_USER_EMAIL_ADDRESS = 0x004;
    public final static int MASK_USER_LOGIN = 0x008;
    public final static int MASK_USER_IS_PER_ROUTING = 0x010;
    public final static int MASK_USER_MOB_EMAIL = 0x020;

    /**
     * Val. 	Description 		Bit # 		Field 						Hex   
     * 22       Assistant List      N/A         <Extension>                 N/A
     *                              0           <|Username|>                1
     *                              1           <|Description|>             2
     *                              2           <Device_Type>               4
     */
    public final static int LIST_TYPE_ASSISTANT_LIST = 0x16;

    public final static int MASK_ASSISTANT_LIST_USER = 0x001;
    public final static int MASK_ASSISTANT_LIST_DESC = 0x002;
    public final static int MASK_ASSISTANT_LIST_DEV_TYPE = 0x004;

	/** Affected Extension */
	protected int mAffectedExt = 0;

	/** List Type */
	protected int mListType = 0;

	/** Entity Field Mask */
	protected int mEntityFieldMask = 0;

	/** Response Mode */
	protected int mResponseMode = 1;

	/** Response Size */
	protected int mResponseSize = 1;

	/**
	 * 
	 * @param affectedExt
	 * @return
	 */
	public QueryListExtended setAffectedExt(int affectedExt) {
		this.mAffectedExt = affectedExt;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getAffectedExt() {
		return this.mAffectedExt;
	}

	/**
	 * 
	 * @param listType
	 * @return
	 */
	public QueryListExtended setListType(int listType) {
		this.mListType = listType;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getListType() {
		return this.mListType;
	}

	/**
	 * 
	 * @param entityFieldMask
	 * @return
	 */
	public QueryListExtended setEntityFieldMask(int entityFieldMask) {
		this.mEntityFieldMask = entityFieldMask;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getEntityFieldMask() {
		return this.mEntityFieldMask;
	}

	/**
	 * 
	 * @param responseMode
	 * @return
	 */
	public QueryListExtended setResponseMode(int responseMode) {
		this.mResponseMode = responseMode;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getResponseMode() {
		return this.mResponseMode;
	}

	/**
	 * 
	 * @param responseSize
	 * @return
	 */
	public QueryListExtended setResponseSize(int responseSize) {
		this.mResponseSize = responseSize;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getResponseSize() {
		return this.mResponseSize;
	}

	/**
	 * 
	 */
	@Override
	public String buildCommand() {
		// _QX,<InvokeID>,<Affected_Ext>,<List_Type>,<Entity_Field_Mask>,
		// <Response_Mode>,<Response_Size><CR>

		String command = COMMAND + "," + this.getInvokeID() + ",";

		// Affected_Ext
		// Specifies the system node, using the Node: format (e.g., 1:), any
		// valid
		// extension on the system node, or it can be blank.
		if (0 < this.getAffectedExt()) {
			command += this.getAffectedExt();
		}
		command += ",";

		// List_Type
		// Indicates the type of list being queried
		if (0 < this.getListType()) {
			command += this.getListType();
		}
		command += ",";

		// Entity_Field_Mask
		// Returns a list of entities where each entity may contain several
		// fields
		// of information.
		if (0 < this.getEntityFieldMask()) {
			command += Integer.toHexString(this.getEntityFieldMask());
		}

		// Response_Mode
		// Single Message Mode (1): The entire list is sent in a single message.
		// Multiple Message Mode (2): The list is generated in item groups.
		command += "," + this.getResponseMode();

		// Response_Size
		// Defines the maximum number of elements, up to the maximum number
		// of system extensions, to be included in a response.
		command += "," + this.getResponseSize();

		return command;
	}

	/**
	 * 
	 */
	public boolean hasCompleted() {
		return (this.mEvent instanceof Confirmation);
	}

	/**
	 * 
	 */
	@Override
	public void confirmation() {
		if (!(this.mEvent instanceof Confirmation)) {
			return;
		}

		int offset = ENTITY_OFFSET;
		int segments = segmentCount();
		int count = segmentCount() * entityCount();

		for (int i = offset; i < offset + count; i += segments) {
			switch (ListType()) {
			// 1 Station List
			case LIST_TYPE_STATION_LIST: {
				parseStation(i);
				break;
			}

			// 2 Trunk List
			case LIST_TYPE_TRUNK_LIST: {
				parseTrunk(i);
				break;
			}

			// 3 Hunt Group List
			case LIST_TYPE_HUNT_GROUP_LIST: {
				parseHuntGroup(i);
				break;
			}

			// 8 Feature List
			case LIST_TYPE_FEATURE_LIST: {
				parseFeature(i);
				break;
			}

			// 10 DND Message List
			case LIST_TYPE_DND_LIST: {
				parseDND(i);
				break;
			}

			// 17 ACD Agent List
			case LIST_TYPE_ACD_AGENT: {
				parseAgent(i);
				break;
			}

			// 18 Node Data
			case LIST_TYPE_NODE_DATA: {
				parseNodes(i);
				break;
			}
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public int ListType() {
		return intPart(5);
	}

	/**
	 * 
	 * @return
	 */
	public int entityFieldMask() {
		return Integer.valueOf(part(6), 16).intValue();
	}

	/**
	 * 
	 * @return
	 */
	public int msgIndicator() {
		return intPart(7);
	}

	/**
	 * 
	 * @return
	 */
	public int entityCount() {
		return intPart(8);
	}

	/**
	 * 
	 * @return
	 */
	public int segmentCount() {
		return (parts() - ENTITY_OFFSET) / entityCount();
	}

	/**
	 * 
	 * @param index
	 */
	public void parseFeature(int index) {
		String featureCode = part(index++);

		Feature feature = getFeature(featureCode);

		int mask = entityFieldMask();

		if (MASK_FEATURE_LIST_FEAT_NUM == (MASK_FEATURE_LIST_FEAT_NUM & mask)) {
			feature.setFeatureNumber(part(index++));
		}

		if (MASK_FEATURE_LIST_FEAT_NAME == (MASK_FEATURE_LIST_FEAT_NAME & mask)) {
			feature.setFeatureName(part(index++));
		}

		if (MASK_FEATURE_LIST_IS_ADMIN == (MASK_FEATURE_LIST_IS_ADMIN & mask)) {
			feature.setIsAdministratorFeature(intPart(index++));
		}

		if (MASK_FEATURE_LIST_IS_DIR == (MASK_FEATURE_LIST_IS_DIR & mask)) {
			feature.setIsDirectoryFeature(intPart(index++));
		}

		if (MASK_FEATURE_LIST_IS_DIAG == (MASK_FEATURE_LIST_IS_DIAG & mask)) {
			feature.setIsDiagnosticFeature(intPart(index++));
		}

		if (MASK_FEATURE_LIST_IS_TOGGLE == (MASK_FEATURE_LIST_IS_TOGGLE & mask)) {
			feature.setIsToggleableFeature(intPart(index++));
		}
	}

	/**
	 * 
	 * @param index
	 */
	public void parseDND(int index) {
		String dnd = part(index++);

		DND model = getDND(dnd);

		int mask = entityFieldMask();

		if (MASK_DND_LIST_MESSAGE == (MASK_DND_LIST_MESSAGE & mask)) {
			model.setMessageText(part(index++));
		}
	}

	/**
	 * 
	 * @param index
	 */
	public void parseHuntGroup(int index) {
		String huntGroupID = part(index++);

		HuntGroup huntGroup = getHuntGroup(huntGroupID);

		int mask = entityFieldMask();

		if (MASK_HUNT_GROUP_LIST_USER == (MASK_HUNT_GROUP_LIST_USER & mask)) {
			huntGroup.setUsername(part(index++));
		}

		if (MASK_HUNT_GROUP_LIST_DESC == (MASK_HUNT_GROUP_LIST_DESC & mask)) {
			huntGroup.setDescription(part(index++));
		}

		if (MASK_HUNT_GROUP_LIST_HUNT_GROUP == (MASK_HUNT_GROUP_LIST_HUNT_GROUP & mask)) {
			huntGroup.setGroupType(intPart(index++));
		}

		if (MASK_HUNT_GROUP_LIST_MEMBERS == (MASK_HUNT_GROUP_LIST_MEMBERS & mask)) {
			huntGroup.setNumberOfMembers(intPart(index++));
		}

		if (MASK_HUNT_GROUP_LIST_MAILBOX == (MASK_HUNT_GROUP_LIST_MAILBOX & mask)) {
			huntGroup.setMailboxNodeNumber(intPart(index++));
		}
	}

	/**
	 * 
	 * @param index
	 */
	public void parseAgent(int index) {
		String agentID = part(index++);

		Agent agent = getAgent(agentID);

		int mask = entityFieldMask();

		if (MASK_ACD_AGENT_DESC == (MASK_ACD_AGENT_DESC & mask)) {
			agent.setDescription(part(index++));
		}
	}

	/**
	 * 
	 * @param index
	 */
	public void parseStation(int index) {
		String extension = part(index++);

		Device device = getDevice(extension);

		int mask = entityFieldMask();

		if (MASK_STATION_LIST_USER == (MASK_STATION_LIST_USER & mask)) {
			device.setUsername(part(index++));
		}

		if (MASK_STATION_LIST_DESC == (MASK_STATION_LIST_DESC & mask)) {
			device.setDescription(part(index++));
		}

		if (MASK_STATION_LIST_ATTEND == (MASK_STATION_LIST_ATTEND & mask)) {
			device.setAttendantExtension(intPart(index++));
		}

		if (MASK_STATION_LIST_IS_ADMIN == (MASK_STATION_LIST_IS_ADMIN & mask)) {
			device.setIsAdministrator(intPart(index++));
		}

		if (MASK_STATION_LIST_IS_ATTEND == (MASK_STATION_LIST_IS_ATTEND & mask)) {
			device.setIsAttendant(intPart(index++));
		}

		if (MASK_STATION_LIST_DAY_FLAGS == (MASK_STATION_LIST_DAY_FLAGS & mask)) {
			device.setDayCOSFlags(intPart(index++));
		}

		if (MASK_STATION_LIST_NIGHT_FLAGS == (MASK_STATION_LIST_NIGHT_FLAGS & mask)) {
			device.setNightCOSFlags(intPart(index++));
		}

		if (MASK_STATION_LIST_VOICE_MAIL == (MASK_STATION_LIST_VOICE_MAIL & mask)) {
			device.setVoiceMailExt(intPart(index++));
		}

		if (MASK_STATION_LIST_DEVICE_TYPE == (MASK_STATION_LIST_DEVICE_TYPE & mask)) {
			device.setDeviceType(intPart(index++));
		}

		if (MASK_STATION_LIST_MAILBOX_NODE == (MASK_STATION_LIST_MAILBOX_NODE & mask)) {
			device.setMailboxNodeNumber(intPart(index++));
		}

		if (MASK_STATION_LIST_PHYSICAL_DEVICE == (MASK_STATION_LIST_PHYSICAL_DEVICE & mask)) {
			device.setPhysicalDeviceType(intPart(index++));
		}
	}

	/**
	 * 
	 * @param index
	 */
	public void parseTrunk(int index) {
		String extension = part(index++);

		Trunk trunk = getTrunk(extension);

		int mask = entityFieldMask();

		if (MASK_TRUNK_LIST_USER == (MASK_TRUNK_LIST_USER & mask)) {
			trunk.setUsername(part(index++));
		}

		if (MASK_TRUNK_LIST_DESC == (MASK_TRUNK_LIST_DESC & mask)) {
			trunk.setDescription(part(index++));
		}

		if (MASK_TRUNK_LIST_ANS_SUPERVISION == (MASK_TRUNK_LIST_ANS_SUPERVISION & mask)) {
			trunk.setAnswerSupervisionType(intPart(index++));
		}
	}

	/**
	 * 
	 * @param index
	 */
	public void parseNodes(int index) {
		String nodeNumber = part(index++);

		Node node = getNode(nodeNumber);

		int mask = entityFieldMask();

		if (MASK_NODE_DATA_DESC == (MASK_NODE_DATA_DESC & mask)) {
			node.setDescription(part(index++));
		}

		if (MASK_NODE_DATA_NET_EN == (MASK_NODE_DATA_NET_EN & mask)) {
			node.setNetworkingEnabledDisabled(intPart(index++));
		}

		if (MASK_NODE_DATA_PROTOCOL == (MASK_NODE_DATA_PROTOCOL & mask)) {
			node.setProtocolVersion(part(index++));
		}

		if (MASK_NODE_DATA_KSU_SW == (MASK_NODE_DATA_KSU_SW & mask)) {
			node.setKSUSWVersion(part(index++));
		}

		if (MASK_NODE_DATA_PREM == (MASK_NODE_DATA_PREM & mask)) {
			node.setPremiumFeatureStatus(intPart(index++));
		}

		if (MASK_NODE_DATA_COUNTRY == (MASK_NODE_DATA_COUNTRY & mask)) {
			node.setCountryCode(intPart(index++));
		}

		if (MASK_NODE_DATA_TCPIP == (MASK_NODE_DATA_TCPIP & mask)) {
			node.setTCPIPIndicator(intPart(index++));
		}

		if (MASK_NODE_DATA_VOICE_MAIL == (MASK_NODE_DATA_VOICE_MAIL & mask)) {
			node.setVoiceMailStatus(intPart(index++));
		}

		if (MASK_NODE_DATA_MAX_PARTIES == (MASK_NODE_DATA_MAX_PARTIES & mask)) {
			node.setMaxPartiesInConference(intPart(index++));
		}
	}
}
