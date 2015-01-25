package uk.co.n3tw0rk.oaigatewayrelay.websocket.constants;

public class OperationMap
{
	/** DEVICE EVENTS **/
	public static final String DEVICE_CONTROLLER = "DEVICE";

	public static final String DEVICE_LIST_ACTION = "LIST";
	public static final String DEVICE_COUNT_ACTION = "COUNT";
	public static final String DEVICE_DATA_ACTION = "DATA";
	public static final String DEVICE_MONITOR_ACTION = "MONITOR";
	public static final String DEVICE_COMMAND_ACTION = "COMMAND";
	public static final String DEVICE_INVALID_ACTION = "INVALID";

	/** NODE EVENTS **/
	public static final String NODE_CONTROLLER = "NODE";

	public static final String NODE_LIST_ACTION = "LIST";
	public static final String NODE_COUNT_ACTION = "COUNT";
	public static final String NODE_DATA_ACTION = "DATA";
	public static final String NODE_MONITOR_ACTION = "MONITOR";
	public static final String NODE_COMMAND_ACTION = "COMMAND";
	public static final String NODE_INVALID_ACTION = "INVALID";

	/** AGENT EVENTS **/
	public static final String AGENT_CONTROLLER = "AGENT";

	/** CALL EVENTS **/
	public static final String CALL_CONTROLLER = "CALL";

	/** GATEWAY EVENTS **/
	public static final String GATEWAY_CONTROLLER = "GATEWAY";

	/** TRUNKS EVENTS **/
	public static final String TRUNKS_CONTROLLER = "TRUNKS";

	/** HUNT GROUPS EVENTS **/
	public static final String HUNT_GROUPS_CONTROLLER = "HUNT_GROUPS";
}
