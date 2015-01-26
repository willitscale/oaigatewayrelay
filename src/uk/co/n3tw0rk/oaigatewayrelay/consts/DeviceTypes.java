package uk.co.n3tw0rk.oaigatewayrelay.consts;

public class DeviceTypes
{
	/** 0 - Keyset Station Device */
	public static final int DEVICE_TYPE_KEYSET = 0x00;

	/** 1 - Single-Line Station Device */
	public static final int DEVICE_TYPE_SINGLE_LINE = 0x01;

	/** 2 - ACD/Hunt Group */
	public static final int DEVICE_TYPE_HUNT_GROUP = 0x02;

	/** 3 - Loop Start Trunk */
	public static final int DEVICE_TYPE_LOOP_START_TRUNK = 0x03;

	/** 4 - Loop Start Trunk w/Caller ID */
	public static final int DEVICE_TYPE_LOOP_START_TRUNK_CALLER = 0x04;

	/** 5 - Ground Start Trunk */
	public static final int DEVICE_TYPE_GROUP_START_TRUNK = 0x05;

	/** 6 - Ground Start Trunk w/Caller ID */
	public static final int DEVICE_TYPE_GROUP_START_TRUNK_CALLER = 0x06;

	/** 7 - DID Trunk */
	public static final int DEVICE_TYPE_DID_TRUNK = 0x07;

	/** 8 - E&M Trunk */
	public static final int DEVICE_TYPE_EM_TRUNK = 0x08;

	/** 9 - ISDN Trunk – Basic or Primary Rate */
	public static final int DEVICE_TYPE_ISDN_TRUNK = 0x09;

	/** 10 - Trunk Group */
	public static final int DEVICE_TYPE_TRUNK_GROUP = 0x0A;

	/** 11 - Operator */
	public static final int DEVICE_TYPE_OPERATOR = 0x0B;

	/** 12 - Voice Mail */
	public static final int DEVICE_TYPE_VOICE_MAIL = 0x0C;

	/** 13 - Other */
	public static final int DEVICE_TYPE_OTHER = 0x0D;

	/** 26 - B-Channel Station */
	public static final int DEVICE_TYPE_B_CHANNEL = 0x1A;

	/** 28 - MFC/R2 Trunk */
	public static final int DEVICE_TYPE_MFC_R2 = 0x1C;

	/** 29 -  Modem (Axxess only) */
	public static final int DEVICE_TYPE_MODEM = 0x1D;

	/** 31 - MGCP Endpoint */
	public static final int DEVICE_TYPE_MGCP_ENDPOINT = 0x1F;

	/** 32 - MGCP Gateway and Endpoint */
	public static final int DEVICE_TYPE_MGCP_GATEWAY_ENDPOINT = 0x20;

	/** 33 - SIP Trunk */
	public static final int DEVICE_TYPE_SIP_TRUNK = 0x21;
}
