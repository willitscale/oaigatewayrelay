package uk.co.n3tw0rk.oaigatewayrelay.data.structures;

import uk.co.n3tw0rk.oaigatewayrelay.abstraction.Structure;

/**
 * 
 * @author M00SEMARKTWO
 *
 */
public class Feature extends Structure {

	/** */
	protected String mCode;

	/** */
	protected String mFeatureNumber;

	/** */
	protected String mFeatureName;

	/** */
	protected int mIsAdministratorFeature;

	/** */
	protected int mIsDirectoryFeature;

	/** */
	protected int mIsDiagnosticFeature;

	/** */
	protected int mIsToggleableFeature;

	/**
	 * 
	 * @param key
	 */
	public Feature(String key) {
		super(key);
		this.mCode = key;
	}

	/**
	 * 
	 */
	@Override
	public String getKey() {
		return this.mCode;
	}

	/**
	 * 
	 * @param featureCode
	 * @return
	 */
	public Feature setCode(String code) {
		this.mCode = code;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getCode() {
		return mCode;
	}

	/**
	 * 
	 * @param featureNumber
	 * @return
	 */
	public Feature setFeatureNumber(String featureNumber) {
		mFeatureNumber = featureNumber;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getFeatureNumber() {
		return mFeatureNumber;
	}

	/**
	 * 
	 * @param featureName
	 * @return
	 */
	public Feature setFeatureName(String featureName) {
		mFeatureName = featureName;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public String getFeatureName() {
		return mFeatureName;
	}

	/**
	 * 
	 * @param isAdministratorFeature
	 * @return
	 */
	public Feature setIsAdministratorFeature(String isAdministratorFeature) {
		if (null == isAdministratorFeature) {
			return this;
		}

		return setIsAdministratorFeature(Integer
				.parseInt(isAdministratorFeature));
	}

	/**
	 * 
	 * @param isAdministratorFeature
	 * @return
	 */
	public Feature setIsAdministratorFeature(int isAdministratorFeature) {
		mIsAdministratorFeature = isAdministratorFeature;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getIsAdministratorFeature() {
		return mIsAdministratorFeature;
	}

	/**
	 * 
	 * @param isDirectoryFeature
	 * @return
	 */
	public Feature setIsDirectoryFeature(String isDirectoryFeature) {
		if (null == isDirectoryFeature) {
			return this;
		}

		return setIsDirectoryFeature(Integer.parseInt(isDirectoryFeature));
	}

	/**
	 * 
	 * @param isDirectoryFeature
	 * @return
	 */
	public Feature setIsDirectoryFeature(int isDirectoryFeature) {
		mIsDirectoryFeature = isDirectoryFeature;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getIsDirectoryFeature() {
		return mIsDirectoryFeature;
	}

	/**
	 * 
	 * @param isDiagnosticFeature
	 * @return
	 */
	public Feature setIsDiagnosticFeature(String isDiagnosticFeature) {
		if (null == isDiagnosticFeature) {
			return this;
		}

		return setIsDiagnosticFeature(Integer.parseInt(isDiagnosticFeature));
	}

	/**
	 * 
	 * @param isDiagnosticFeature
	 * @return
	 */
	public Feature setIsDiagnosticFeature(int isDiagnosticFeature) {
		mIsDiagnosticFeature = isDiagnosticFeature;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getIsDiagnosticFeature() {
		return mIsDiagnosticFeature;
	}

	/**
	 * 
	 * @param isToggleableFeature
	 * @return
	 */
	public Feature setIsToggleableFeature(String isToggleableFeature) {
		if (null == isToggleableFeature) {
			return this;
		}

		return setIsToggleableFeature(Integer.parseInt(isToggleableFeature));
	}

	/**
	 * 
	 * @param isToggleableFeature
	 * @return
	 */
	public Feature setIsToggleableFeature(int isToggleableFeature) {
		mIsToggleableFeature = isToggleableFeature;
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public int getIsToggleableFeature() {
		return mIsToggleableFeature;
	}

}
