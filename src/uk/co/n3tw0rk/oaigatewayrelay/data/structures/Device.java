package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

public class Device extends Structure
{
	protected int mExtension;

	/**
	 * @see DeviceTypes
	 */
	protected int mDeviceType;
	protected int mDeviceClass;

	protected String mDescription;
	protected String mUsername;

	protected boolean mIsAdministrator;
	protected boolean mIsAttendant;

	protected int mAttendantExtension;
	protected int mDayCOSFlags;
	protected int mNightCOSFlags;
	protected int mVoiceMailExt;
	protected int mMailboxNodeNumber;
	protected int mStnSpeedDialBinData;
	protected int mPhysicalDeviceType;
	protected int mAccountCodeType;
	protected int mAccountCodeValidatedFlag;

	public Device setExtension( int extension )
	{
		this.mExtension = extension;
		return this;
	}
	
	public Device setExtension( String extension )
	{
		if( null == extension )
		{
			return this;
		}

		return this.setExtension( Integer.parseInt( extension ) );
	}
	
	public int getExtension()
	{
		return this.mExtension;
	}

	public Device setDeviceType( int deviceType )
	{
		this.mDeviceType = deviceType;
		return this;
	}
	
	public Device setDeviceType( String deviceType )
	{
		if( null == deviceType )
		{
			return this;
		}
		
		return this.setDeviceType( deviceType );
	}
	
	public int getDeviceType()
	{
		return this.mDeviceType;
	}

	public Device setDeviceClass( int deviceClass )
	{
		this.mDeviceClass = deviceClass;
		return this;
	}
	
	public Device setDeviceClass( String deviceClass )
	{
		if( null == deviceClass )
		{
			return this;
		}
		
		return this.setDeviceType( deviceClass );
	}
	
	public int getDeviceClass()
	{
		return this.mDeviceClass;
	}

	public Device setDescription( String description )
	{
		this.mDescription = description;
		return this;
	}
	
	public String getDescription()
	{
		return this.mDescription;
	}

	public Device setUsername( String username )
	{
		this.mUsername = username;
		return this;
	}
	
	public String getUsername()
	{
		return this.mUsername;
	}

	public Device setIsAdministrator( boolean isAdministrator )
	{
		this.mIsAdministrator = isAdministrator;
		return this;
	}
	
	public Device setIsAdministrator( int isAdministrator )
	{
		return this.setIsAdministrator( 1 == isAdministrator );
	}
	
	public Device setIsAdministrator( String isAdministrator )
	{
		if( null == isAdministrator )
		{
			return this;
		}
		
		return this.setIsAdministrator( 0 == "1".compareTo( isAdministrator ) );
	}
	
	public boolean getIsAdministrator()
	{
		return this.mIsAdministrator;
	}

	public Device setIsAttendant( boolean isAttendant )
	{
		this.mIsAttendant = isAttendant;
		return this;
	}
	
	public Device setIsAttendant( int isAttendant )
	{
		return this.setIsAttendant( 1 == isAttendant );
	}
	
	public Device setIsAttendant( String isAttendant )
	{
		if( null == isAttendant )
		{
			return this;
		}
		
		return this.setIsAttendant( 0 == "1".compareTo( isAttendant ) );
	}
	
	public boolean getIsAttendant()
	{
		return this.mIsAttendant;
	}

	public Device setAttendantExtension( int attendantExtension )
	{
		this.mAttendantExtension = attendantExtension;
		return this;
	}
	
	public Device setAttendantExtension( String attendantExtension )
	{
		if( null == attendantExtension )
		{
			return this;
		}

		return this.setAttendantExtension( Integer.parseInt( attendantExtension ) );
	}
	
	public int getAttendantExtension()
	{
		return this.mAttendantExtension;
	}

	public Device setDayCOSFlags( int dayCOSFlags )
	{
		this.mDayCOSFlags = dayCOSFlags;
		return this;
	}
	
	public Device setDayCOSFlags( String dayCOSFlags )
	{
		if( null == dayCOSFlags )
		{
			return this;
		}

		return this.setDayCOSFlags( Integer.parseInt( dayCOSFlags ) );
	}
	
	public int getDayCOSFlags()
	{
		return this.mDayCOSFlags;
	}

	public Device setNightCOSFlags( int nightCOSFlags )
	{
		this.mNightCOSFlags = nightCOSFlags;
		return this;
	}
	
	public Device setNightCOSFlags( String nightCOSFlags )
	{
		if( null == nightCOSFlags )
		{
			return this;
		}

		return this.setNightCOSFlags( Integer.parseInt( nightCOSFlags ) );
	}
	
	public int getNightCOSFlags()
	{
		return this.mNightCOSFlags;
	}

	public Device setVoiceMailExt( int voiceMailExt )
	{
		this.mVoiceMailExt = voiceMailExt;
		return this;
	}
	
	public Device setVoiceMailExt( String voiceMailExt )
	{
		if( null == voiceMailExt )
		{
			return this;
		}

		return this.setVoiceMailExt( Integer.parseInt( voiceMailExt ) );
	}
	
	public int getVoiceMailExt()
	{
		return this.mVoiceMailExt;
	}

	public Device setMailboxNodeNumber( int mailboxNodeNumber )
	{
		this.mMailboxNodeNumber = mailboxNodeNumber;
		return this;
	}
	
	public Device setMailboxNodeNumber( String mailboxNodeNumber )
	{
		if( null == mailboxNodeNumber )
		{
			return this;
		}

		return this.setMailboxNodeNumber( Integer.parseInt( mailboxNodeNumber ) );
	}
	
	public int getMailboxNodeNumber()
	{
		return this.mMailboxNodeNumber;
	}

	public Device setStnSpeedDialBinData( int stnSpeedDialBinData )
	{
		this.mStnSpeedDialBinData = stnSpeedDialBinData;
		return this;
	}
	
	public Device setStnSpeedDialBinData( String stnSpeedDialBinData )
	{
		if( null == stnSpeedDialBinData )
		{
			return this;
		}

		return this.setStnSpeedDialBinData( Integer.parseInt( stnSpeedDialBinData ) );
	}
	
	public int getStnSpeedDialBinData()
	{
		return this.mStnSpeedDialBinData;
	}

	public Device setPhysicalDeviceType( int physicalDeviceType )
	{
		this.mPhysicalDeviceType = physicalDeviceType;
		return this;
	}
	
	public Device setPhysicalDeviceType( String physicalDeviceType )
	{
		if( null == physicalDeviceType )
		{
			return this;
		}

		return this.setPhysicalDeviceType( Integer.parseInt( physicalDeviceType ) );
	}
	
	public int getPhysicalDeviceType()
	{
		return this.mPhysicalDeviceType;
	}

	public Device setAccountCodeType( int accountCodeType )
	{
		this.mAccountCodeType = accountCodeType;
		return this;
	}
	
	public Device setAccountCodeType( String accountCodeType )
	{
		if( null == accountCodeType )
		{
			return this;
		}

		return this.setAccountCodeType( Integer.parseInt( accountCodeType ) );
	}
	
	public int getAccountCodeType()
	{
		return this.mAccountCodeType;
	}

	public Device setAccountCodeValidatedFlag( int accountCodeValidatedFlag )
	{
		this.mAccountCodeValidatedFlag = accountCodeValidatedFlag;
		return this;
	}
	
	public Device setAccountCodeValidatedFlag( String accountCodeValidatedFlag )
	{
		if( null == accountCodeValidatedFlag )
		{
			return this;
		}

		return this.setAccountCodeValidatedFlag( Integer.parseInt( accountCodeValidatedFlag ) );
	}

	public int getAccountCodeValidatedFlag()
	{
		return this.mAccountCodeValidatedFlag;
	}
}
