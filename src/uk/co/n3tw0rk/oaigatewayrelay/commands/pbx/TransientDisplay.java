package uk.co.n3tw0rk.oaigatewayrelay.commands.pbx;

/**
 * 
 * @author M00SEMARKTWO

TRANSIENT DISPLAY – _TD
USE: Places a transient display, up to 32 characters (not including formatting tokens), onto a keyset.
NOTE: The All Transient Display flag (System\Devices and Feature Codes\Stations\Local\<station>\Flags)
in Database Programming must be set to Yes for this command to work. This command
is not designed to work with analog keysets.
PREMIUM FEATURE: Third-Party Call Control
SYNTAX: _TD,<InvokeID>,<Affected_Ext>,<Transient_Display_Type>,
<Info_Display_String><CR>
Where:
• Affected_Ext: Indicates a keyset or single-line set.
NOTE: Although some single-line sets do not have displays, this command can send
transient tones to these devices connected to a call. Only the warning and acknowledge
tones generate sound on a single-line set.
• Info_Display_String: Specifies the text to be displayed on lines 1 and 2 of the keyset
display. This string must be delimited by the vertical slash ( | ), and it can only contain
letters, numbers, symbols, and the %E, %C, %L, and %R formatting tokens (see
page 211).
• Transient_Display_Type: Indicates the type of transient display control requested. Each
transient display type has the following features:
— No Tone (0): Specifies text with no tone.
NOTE: This type does not clear a tone that is currently playing.
— Warning (1): Includes text with a reorder burst tone. This is not played if a constant
tone is playing that is NOT one of the following: NO_TONE, CHIME, TICKTONE,
MUSIC_ON_HOLD, REMOTE_NODE_MUSIC_ON_HOLD.
— Reminder (2): Specifies text with a reminder burst tone. This tone is ignored if the
keysets are ringing.
— Acknowledge (3): Includes text with a confirmation burst tone. This is not played
if a constant tone is playing that is NOT one of the following: NO_TONE, CHIME,
TICKTONE, MUSIC_ON_HOLD, REMOTE_NODE_MUSIC_ON_HOLD.
• Display_Control_Type: Specifies the type of Display Control requested (1 = full connected
control, which is the only value currently available).
CONFIRMATION: <Sequence_Number>,CF,_TD,<InvokeID>,<Outcome>,<Affected_Ext><CR><LF>
COMMON FAILURE
OUTCOME VALUES: Request Incompatible With Object (3): The <Affected_Ext> is a valid extension, but it is not
a station device.
Invalid_Device_Identifier (9): The <Affected_Ext> device is invalid or blank.
Value Out of Range (31): The <Transient_Display_Type> parameter is invalid, or the
<Info_Display_String> is missing, not delimited by vertical slashes ( | ), or contains illegal
tokens.
Generic_State_Incompatibility (15): The <Affected_Ext> is offline.
DESKTOP OAI: None
EXAMPLES: Put up a “You just got a voice mail” transient, no-tone message on extension 1000.
_TD,2,1000,0,|%CYou just got%E%Ca voice mail|
003,CF,_TD,2,0,1000
Put up a “Phone system set to reset in 5min” transient warning message on extension 1004.
_TD,3,1004,1,|Phone system set%Eto reset in 5min|
004,CF,_TD,3,0,1004
Put up a “Sam says: Hello Bob” transient acknowledge message on extension 1002.
_TD,1,1002,3,|%LSam says:%EHello Bob%R|
005,CF,_TD,1,0,1002

 */
public class TransientDisplay {

}
