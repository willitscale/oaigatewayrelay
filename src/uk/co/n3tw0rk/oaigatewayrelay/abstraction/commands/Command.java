package uk.co.n3tw0rk.oaigatewayrelay.abstraction.commands;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.OAIDataInterpolator;
import uk.co.n3tw0rk.oaigatewayrelay.abstraction.events.Event;
import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Agent;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.DND;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Device;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Feature;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.HuntGroup;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Node;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Trunk;
import uk.co.n3tw0rk.oaigatewayrelay.interfaces.OAIPacket;
import uk.co.n3tw0rk.oaigatewayrelay.utils.OAIToolkit;

/**
 * <strong>Command</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 23-11-2015
 */
public abstract class Command extends OAIDataInterpolator implements OAIPacket {
	protected int mInvokeID;

	protected Event mEvent;

	/**
	 * 
	 * @param event
	 * @return
	 */
	public Command setEvent(Event event) {
		this.mEvent = event;
		this.confirmation();
		return this;
	}

	/**
	 * 
	 * @param invokeID
	 * @return
	 */
	public Command setInvokeID(int invokeID) {
		this.mInvokeID = invokeID;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getInvokeID() {
		return this.mInvokeID;
	}

	/**
	 * 
	 * @return
	 */
	protected abstract String buildCommand();

	/**
	 * 
	 * @return
	 */
	public String getCommand() {
		return OAIToolkit.buildPBXString(this.buildCommand(), true);
	}

	/**
	 * 
	 * @return
	 */
	public boolean hasCompleted() {
		return true;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public int intPart(int index) {
		if (null == this.mEvent) {
			return -1;
		}

		return this.mEvent.getIntPart(index);
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public String part(int index) {
		if (null == this.mEvent) {
			return null;
		}

		return this.mEvent.getStringPart(index);
	}

	/**
	 * 
	 * @return
	 */
	public int parts() {
		if (null == this.mEvent) {
			return 0;
		}

		return this.mEvent.getPartsSize();
	}

	/**
	 * 
	 */
	public abstract void confirmation();
}
