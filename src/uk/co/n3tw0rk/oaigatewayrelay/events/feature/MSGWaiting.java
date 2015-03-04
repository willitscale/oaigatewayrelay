package uk.co.n3tw0rk.oaigatewayrelay.events.feature;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Feature;

/**
 * <strong>General Information Class</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 04-03-2015
 * 
 * @see SYSTEM OAI SPECIFICATIONS MANUAL – Issue 9.0, April 2005 - Page 54
 * 
 * 	MSG WAITING – MW
 * 
 * 	USE: 
 * 		Occurs when a new message has been left or a message has been canceled at a station. The
 * 		<Mailbox> parameter applies only to voice mail devices leaving/canceling messages. It is possible
 * 		to have multiple voice mailboxes use the same device for notification (i.e., multiple mailboxes
 * 		can light the message lamp at the same station).
 * 
 * 	MONITOR TYPE: 
 * 		Device
 * 
 * 	SYNTAX: 
 * 		MW,<Resync_Code>,<Mon_Cross_Ref_ID>,<Device_Receiving_Message>,
 * 		<Device_Leaving_Message>,<Mailbox>,<Number_Of_Messages>,
 * 		<On/Off><CR><LF>
 * 
 * 	Where:
 * 		• Device_Receiving_Message: Identifies the extension number of the device whose message
 * 			waiting indication has changed.
 * 		• Device_Leaving_Message: Indicates the extension number of the device that left the
 * 			message.
 * 		• Mailbox: Identifies the mailbox where the message was left if voice mail was used.
 * 		• Number_Of_Messages: Indicates the number of messages left by the
 * 			<Device_Leaving_Message>. If blank, the Message Waiting indication is disabled.
 * 		• On/Off: Indicates the state of the message waiting indication (1 = Enabled; 0 = Disabled).
 * 
 * 	EXAMPLES: 
 * 		Extension 106 leaves a message at extension 105.
 * 		001,MW,,<MON105>,105,106,,1,1
 * 		Extension 106 cancels a message at extension 105.
 * 		001,MW,,<MON105>,105,106,,,0
 */
public class MSGWaiting extends Feature
{
	public final static String EVENT = "MW";
	
	protected int mDeviceReceivingMessage;
	protected int mDeviceLeavingMessage;
	protected int mMailbox;
	protected int mNumberOfMessages;
	protected int mOnOff;
	
	public MSGWaiting( String event )
	{
		super( event );
	}

	public MSGWaiting( String[] eventParts )
	{
		super( eventParts );
	}
	
	public MSGWaiting setDeviceReceivingMessage( int deviceReceivingMessage )
	{
		this.mDeviceReceivingMessage = deviceReceivingMessage;
		return this;
	}
	
	public int getDeviceReceivingMessage()
	{
		return this.mDeviceReceivingMessage;
	}
	
	public MSGWaiting setDeviceLeavingMessage( int deviceLeavingMessage )
	{
		this.mDeviceLeavingMessage = deviceLeavingMessage;
		return this;
	}
	
	public int getDeviceLeavingMessage()
	{
		return this.mDeviceLeavingMessage;
	}
	
	public MSGWaiting setMailbox( int mailbox )
	{
		this.mMailbox = mailbox;
		return this;
	}
	
	public int getMailbox()
	{
		return this.mMailbox;
	}
	
	public MSGWaiting setNumberOfMessages( int numberOfMessages )
	{
		this.mNumberOfMessages = numberOfMessages;
		return this;
	}
	
	public int getNumberOfMessages()
	{
		return this.mNumberOfMessages;
	}
	
	public MSGWaiting setOnOff( int onOff )
	{
		this.mOnOff = onOff;
		return this;
	}
	
	public int getOnOff()
	{
		return this.mOnOff;
	}

	/**
	 * 0 <SEQUENCE_NUMBER>
	 * 1 <EVENT>
	 * 2 <Resync_Code>
	 * 3 <Mon_Cross_Ref_ID>
	 * 4 <Device_Receiving_Message>
	 * 5 <Device_Leaving_Message>
	 * 6 <Mailbox>
	 * 7 <Number_Of_Messages>
	 * 8 <On/Off>
	 */
	@Override
	protected void parseEvent()
	{
		super.parseEvent();
		this.setDeviceReceivingMessage( this.getIntPart( 4 ) );
		this.setDeviceLeavingMessage( this.getIntPart( 5 ) );
		this.setMailbox( this.getIntPart( 6 ) );
		this.setNumberOfMessages( this.getIntPart( 7 ) );
		this.setOnOff( this.getIntPart( 8 ) );
	}

	@Override
	public void process()
	{
	}
	
}
