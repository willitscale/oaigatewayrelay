package uk.co.n3tw0rk.oaigatewayrelay.abstraction;

import uk.co.n3tw0rk.oaigatewayrelay.controllers.SystemController;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Agent;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Call;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.DND;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Device;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Feature;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.HuntGroup;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Node;
import uk.co.n3tw0rk.oaigatewayrelay.data.structures.Trunk;

/**
 * <strong>OAI Data Interpolator</strong>
 * 
 * @author James Lockhart <james@n3tw0rk.co.uk>
 * @version 1.0
 * @since 24-11-2015
 */
public abstract class OAIDataInterpolator {

	/**
	 * 
	 * @param extension
	 * @return
	 */
	public Device getDevice(String extension) {
		return SystemController.instance().getDevices().getStructure(extension);
	}

	/**
	 * 
	 * @param agentID
	 * @return
	 */
	public Agent getAgent(String agentID) {
		return SystemController.instance().getAgents().getStructure(agentID);
	}

	/**
	 * 
	 * @param featureCode
	 * @return
	 */
	public Feature getFeature(String featureCode) {
		return SystemController.instance().getFeatures()
				.getStructure(featureCode);
	}

	/**
	 * 
	 * @param dndCode
	 * @return
	 */
	public DND getDND(String dndCode) {
		return SystemController.instance().getDNDs().getStructure(dndCode);
	}

	/**
	 * 
	 * @param huntGroup
	 * @return
	 */
	public HuntGroup getHuntGroup(String huntGroupID) {
		return SystemController.instance().getHuntGroups()
				.getStructure(huntGroupID);
	}

	/**
	 * 
	 * @param nodeNumber
	 * @return
	 */
	public Node getNode(String nodeNumber) {
		return SystemController.instance().getNodes().getStructure(nodeNumber);
	}

	/**
	 * 
	 * @param extension
	 * @return
	 */
	public Trunk getTrunk(String extension) {
		return SystemController.instance().getTrunks().getStructure(extension);
	}

	/**
	 * 
	 * @param callID
	 * @return
	 */
	public Call getCall(String callID) {
		return SystemController.instance().getCalls().getStructure(callID);
	}

	/**
	 * 
	 * @param callID
	 * @return
	 */
	public Call popCall(String callID) {
		return SystemController.instance().getCalls().pop(callID);
	}
}
